package com.wasu.http;

import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.http.HttpResponse;
import com.wasu.hutool.json.JSONUtil;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.icc.exception.ClientException;
import com.wasu.icc.exception.ServerException;
import com.wasu.handle.TokenHandleSingle;
import com.wasu.profile.GrantType;
import com.wasu.profile.IccProfile;
import com.wasu.unmarshaller.JsonUnmashaller;
import com.wasu.unmarshaller.Unmarshaller;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class DefaultClient extends AbstractIClient {
  private static final Log logger = LogFactory.get();

  private TokenHandleSingle tokenHandleSingle;
  private Unmarshaller unmarshaller;

  public DefaultClient() throws ClientException {
    IccProfile.getInstance().init();
    tokenHandleSingle = TokenHandleSingle.getInstance();
    unmarshaller = new JsonUnmashaller();
  }

  /**
   * 客户端认证
   *
   * @param host 服务地址
   * @param clientId 客户端ID
   * @param clientSecret 客户端秘钥
   * @throws ClientException 客户端异常
   */
  public DefaultClient(String host, String clientId, String clientSecret) throws ClientException {
    init(host, clientId, clientSecret);
  }
  /**
   * 密码认证
   *
   * @param host 服务地址
   * @param username 用户名
   * @param password 密码
   * @param pwdClientId 客户端ID
   * @param pwdClientSecret 客户端秘钥
   * @throws ClientException 客户端异常
   */
  public DefaultClient(
      String host, String username, String password, String pwdClientId, String pwdClientSecret)
      throws ClientException {
    init(host, username, password, pwdClientId, pwdClientSecret);
  }

  private void init(String host, String clientId, String clientSecret) {
    init(host, null, null, clientId, clientSecret, GrantType.client_credentials);
  }

  private void init(
      String host, String username, String password, String pwdClientId, String pwdClientSecret) {
    init(host, username, password, pwdClientId, pwdClientSecret, GrantType.password);
  }

  private void init(
      String host,
      String username,
      String password,
      String pwdClientId,
      String pwdClientSecret,
      GrantType grantType) {
    // 当前已初始化，且host有变更
    if (IccProfile.inited && !IccProfile.host.equals(host)) {
      // 清空刷新tokenMap
      TokenHandleSingle.getInstance().getTokenMap().clear();
    }
    IccProfile.host = host;
    IccProfile.grantType = grantType;
    switch (grantType) {
      case password:
        IccProfile.pwdClientSecret = pwdClientSecret;
        IccProfile.pwdClientId = pwdClientId;
        break;
      case client_credentials:
        IccProfile.clientId = pwdClientId;
        IccProfile.clientSecret = pwdClientSecret;
        break;
      default:
    }
    IccProfile.password = password;
    IccProfile.username = username;
    IccProfile.inited = Boolean.FALSE;
    IccProfile.getInstance().init();
    tokenHandleSingle = TokenHandleSingle.getInstance();
    unmarshaller = new JsonUnmashaller();
  }

  @Override
  public String doAction(IccHttpHttpRequest request) throws ClientException, ServerException {
    IccHttpHttpRequest iccHttpRequest = signRequest(request);
    String httpResult = iccHttpRequest.execute();
    logger.debug("response httpResult =[{}]", httpResult);
    return httpResult;
  }

  @Override
  public <T extends IccResponse> T doAction(IccHttpHttpRequest request, Class<T> tClass)
      throws ClientException, ServerException {
    IccHttpHttpRequest iccHttpRequest = signRequest(request);
    HttpResponse httpResult = iccHttpRequest.executeResponse();
    String result = httpResult.body();
    logger.debug("response httpResult =[{}]", result);
    T t = unmarshal(tClass, result);
    /** 返回原字符串,回填result字段 */
    t.setResult(result);
    if (!t.isSuccess()) {
      logger.warn("url=[{}] ,response=[{}]", request.getUrl(), result);
    }
    return t;
  }

  @Override
  public synchronized IccTokenResponse.IccToken getAccessToken(GrantType grantType) {
    /** false 不续缓存的生存时间 */
    IccTokenResponse.IccToken token = tokenHandleSingle.getTokenCache(grantType.name());
    if (token != null) {
      return token;
    }
    token = tokenHandleSingle.refreshToken(grantType);

    return token;
  }

  @Override
  public IccTokenResponse.IccToken getAccessToken() {
    return getAccessToken(IccProfile.grantType);
  }

  @Override
  IccHttpHttpRequest signRequest(IccHttpHttpRequest request) {
    if (request.isNeedAuth()) {
      IccTokenResponse.IccToken token = getAccessToken(IccProfile.grantType);

      request.header("Authorization", "bearer " + (token != null ? token.getAccess_token() : ""));
      // 密码鉴权类型设置User-Id请求头
      if (IccProfile.grantType.equals(GrantType.password)) {
        request.header(
            "User-Id", (token != null ? token.getUserId() : IccProfile.CONFIG_CLIENT_USERID));
      }
      if (IccProfile.grantType.equals(GrantType.client_credentials)) {
        // 默认设置请求UserId
        if (IccProfile.CONFIG_CLIENT_USERID_ENABLE) {
          request.header("User-Id", IccProfile.CONFIG_CLIENT_USERID);
        }
      }
    }
    /**
     * bodyParameters优先级大于body
     *
     * <p>1、从request.body(""),json字符串
     *
     * <p>2、request.bodyParameters，map类型
     */
    if (request.getBodyParameters().size() > 0 && StrUtil.isBlank(request.getBody())) {
      request.body(JSONUtil.toJsonStr(request.getBodyParameters()));
    }

    return request;
  }

  @Override
  public <T extends IccResponse> T unmarshal(Class<T> clasz, String content)
      throws ClientException {
    return unmarshaller.unmarshal(clasz, content);
  }
}
