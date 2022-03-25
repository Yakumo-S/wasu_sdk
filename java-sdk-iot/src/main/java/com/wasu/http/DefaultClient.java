package com.wasu.http;

import com.wasu.handle.TokenHandleSingle;
import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.http.HttpResponse;
import com.wasu.hutool.json.JSONUtil;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.iot.exception.ClientException;
import com.wasu.iot.exception.ServerException;
import com.wasu.profile.GrantType;
import com.wasu.profile.IotProfile;
import com.wasu.unmarshaller.JsonUnmashaller;
import com.wasu.unmarshaller.Unmarshaller;

/**
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class DefaultClient extends AbstractIClient {

  private static final Log logger = LogFactory.get();

  private TokenHandleSingle tokenHandleSingle;
  private Unmarshaller unmarshaller;

  public DefaultClient() throws ClientException {
    IotProfile.getInstance().init();
    tokenHandleSingle = TokenHandleSingle.getInstance();
    unmarshaller = new JsonUnmashaller();
  }

  /**
   * 客户端认证
   *
   * @param host         服务地址
   * @param clientId     客户端ID
   * @param clientSecret 客户端秘钥
   * @throws ClientException 客户端异常
   */
  public DefaultClient(String host, String clientId, String clientSecret) throws ClientException {
    init(host, clientId, clientSecret);
  }

  /**
   * 密码认证
   *
   * @param host            服务地址
   * @param username        用户名
   * @param password        密码
   * @param pwdClientId     客户端ID
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
    if (IotProfile.inited && !IotProfile.host.equals(host)) {
      // 清空刷新tokenMap
      TokenHandleSingle.getInstance().getTokenMap().clear();
    }
    IotProfile.host = host;
    IotProfile.grantType = grantType;
    switch (grantType) {
      case password:
        IotProfile.pwdClientSecret = pwdClientSecret;
        IotProfile.pwdClientId = pwdClientId;
        break;
      case client_credentials:
        IotProfile.clientId = pwdClientId;
        IotProfile.clientSecret = pwdClientSecret;
        break;
      default:
    }
    IotProfile.password = password;
    IotProfile.username = username;
    IotProfile.inited = Boolean.FALSE;
    IotProfile.getInstance().init();
    tokenHandleSingle = TokenHandleSingle.getInstance();
    unmarshaller = new JsonUnmashaller();
  }

  @Override
  public String doAction(IotHttpRequest request) throws ClientException, ServerException {
    IotHttpRequest iotHttpRequest = signRequest(request);
    String httpResult = iotHttpRequest.execute();
    logger.debug("response httpResult =[{}]", httpResult);
    return httpResult;
  }

  @Override
  public <T extends IotResponse> T doAction(IotHttpRequest request, Class<T> tClass)
      throws ClientException, ServerException {
    IotHttpRequest iotHttpRequest = signRequest(request);
    HttpResponse httpResult = iotHttpRequest.executeResponse();
    String result = httpResult.body();
    logger.debug("response httpResult =[{}]", result);
    T t = unmarshal(tClass, result);
    /** 返回原字符串,回填result字段 */
    t.setResult(result);
//    if (!t.isSuccess()) {
//      logger.warn("url=[{}] ,response=[{}]", request.getUrl(), result);
//    }
    return t;
  }

  @Override
  public synchronized IotTokenResponse getAccessToken(GrantType grantType) {
    /** false 不续缓存的生存时间 */
    IotTokenResponse token = tokenHandleSingle.getTokenCache(grantType.name());
    if (token != null) {
      return token;
    }
    token = tokenHandleSingle.refreshToken(grantType);

    return token;
  }

  @Override
  public IotTokenResponse getAccessToken() {
    return getAccessToken(IotProfile.grantType);
  }

  @Override
  IotHttpRequest signRequest(IotHttpRequest request) {
    if (request.isNeedAuth()) {
      IotTokenResponse token = getAccessToken(IotProfile.grantType);

      request.header("Authorization", "bearer " + (token != null ? token.getAccess_token() : ""));
      if (IotProfile.grantType.equals(GrantType.client_credentials)) {
        // 默认设置请求UserId
        if (IotProfile.CONFIG_CLIENT_USERID_ENABLE) {
          request.header("User-Id", IotProfile.CONFIG_CLIENT_USERID);
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
  public <T extends IotResponse> T unmarshal(Class<T> clasz, String content)
      throws ClientException {
    return unmarshaller.unmarshal(clasz, content);
  }
}
