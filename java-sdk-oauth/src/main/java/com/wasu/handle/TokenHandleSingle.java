package com.wasu.handle;

import com.wasu.hutool.core.thread.NamedThreadFactory;
import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.http.Method;
import com.wasu.hutool.json.JSONUtil;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.icc.common.ErrorConstants;
import com.wasu.icc.exception.ClientException;
import com.wasu.icc.exception.ServerException;
import com.wasu.constant.OauthConstant;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IccHttpHttpRequest;
import com.wasu.http.IccTokenResponse;
import com.wasu.http.IccTokenResponse.IccToken;
import com.wasu.model.v202010.BrmKeepAliveRequest;
import com.wasu.model.v202010.BrmKeepAliveResponse;
import com.wasu.model.v202010.OauthPublicKeyResponse;
import com.wasu.model.v202010.OauthRefreshTokenRequest;
import com.wasu.model.v202010.OauthRefreshTokenResponse;
import com.wasu.profile.GrantType;
import com.wasu.profile.IccProfile;
import com.wasu.icc.util.BeanUtil;
import com.wasu.icc.util.SignUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

/**
 * 单例，获取access_token,刷新access_token，登录状态保活
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class TokenHandleSingle {
  private static final Log logger = LogFactory.get();

  /** access_token 首次获取状态 */
  private static final AtomicBoolean TOKEN_INITED = new AtomicBoolean(Boolean.FALSE);
  /** token刷新间隔 30s */
  private static final long FRESH_TOKEN_INTERVAL = 30 * 1000;
  /** 线程刷新token和保活 */
  private final ScheduledExecutorService REFRESH_TOKEN_SCHEDULED =
      newSingleThreadScheduledExecutor(new NamedThreadFactory("Icc-Refresh-Token", true));
  /** 密码和客户端认证存储Map */
  private final Map<String, IccTokenResponse.IccToken> tokenMap = new ConcurrentHashMap<>();

  public Map<String, IccTokenResponse.IccToken> getTokenMap() {
    return tokenMap;
  }
  /** 定时任务刷新token */
  private TokenHandleSingle() {
    REFRESH_TOKEN_SCHEDULED.scheduleWithFixedDelay(
        new Runnable() {
          @Override
          public void run() {
            try {
              refreshTokenAndKeepAlive();
            } catch (Throwable t) { // Defensive fault tolerance
              logger.error("Unexpected error occur at token refresh, cause: " + t.getMessage(), t);
            }
          }
        },
        FRESH_TOKEN_INTERVAL,
        FRESH_TOKEN_INTERVAL,
        TimeUnit.MILLISECONDS);
  }

  public static synchronized TokenHandleSingle getInstance() {
    return SingletonHolder.INSTANCE;
  }

  public synchronized IccTokenResponse.IccToken refreshToken(GrantType grantType) {

    IccTokenResponse.IccToken token = null;
    try {
      switch (grantType) {
        case password:
          token = password();
          break;
        case client_credentials:
          token = clientCredentials();
          break;
        default:
      }
    } catch (ClientException e) {
      logger.error("get token failure");
    }
    /** 设置已首次加载，线程可以开始刷新或保活token */
    if (!TOKEN_INITED.get() && token != null) {
      TOKEN_INITED.set(Boolean.TRUE);
    }
    return token;
  }

  /**
   * 密码认证获取token
   *
   * @return IccTokenResponse.IccToken
   * @throws ClientException 客户端异常
   * @throws ServerException 服务端异常
   */
  private IccTokenResponse.IccToken password() throws ClientException, ServerException {
    IccHttpHttpRequest pubRequest =
        new IccHttpHttpRequest(
            OauthConstant.url(OauthConstant.OAUTH_URL_PUBLIC_KEY_GET), Method.GET);
    String pubBody = pubRequest.execute();
    OauthPublicKeyResponse keyResp = BeanUtil.toBean(pubBody, OauthPublicKeyResponse.class);
    if (keyResp.getData() == null) {
      logger.error("get public key faiure [{}]", OauthConstant.OAUTH_URL_PUBLIC_KEY_GET);
      throw new ServerException("get public key faiure");
    }
    Map<String, Object> map = new HashMap<>();
    map.put("grant_type", "password");
    map.put("username", IccProfile.username);
    map.put("password", SignUtil.encryptRSA(IccProfile.password, keyResp.getData().getPublicKey()));
    /*web_client*/
    map.put("client_id", IccProfile.pwdClientId);
    /*web_client*/
    map.put("client_secret", IccProfile.pwdClientSecret);
    map.put("public_key", keyResp.getData().getPublicKey());
    IccHttpHttpRequest pr =
        new IccHttpHttpRequest(
            OauthConstant.url(OauthConstant.OAUTH_URL_PWD_AUTH_POST),
            Method.POST,
            JSONUtil.toJsonStr(map));
    String prBody = pr.execute();
    IccTokenResponse token = BeanUtil.toBean(prBody, IccTokenResponse.class);
    if (token == null || !token.isSuccess()) {
      logger.error(
          " auth failure [{}] reason [{}]",
          OauthConstant.url(OauthConstant.OAUTH_URL_PWD_AUTH_POST),
          token == null ? "" : token.getErrMsg());
      throw new ClientException(
          "GrantType [password] username=["
              + IccProfile.username
              + "],password=["
              + IccProfile.password
              + "] get access_token failure");
    }
    IccTokenResponse.IccToken iccToken = token.getData();
    /** 设置存活时间ttl,其中 expires_in 单位是秒 */
    iccToken.setTtl(System.currentTimeMillis() + (iccToken.getExpires_in() * 1000));

    tokenMap.put(enGrantKeyName(GrantType.password.name()), iccToken);
    return iccToken;
  }

  /**
   * 客户端认证获取token
   *
   * @return IccTokenResponse.IccToken
   * @throws ClientException 客户端异常
   * @throws ServerException 服务端异常
   */
  private IccTokenResponse.IccToken clientCredentials() throws ClientException, ServerException {
    Map<String, Object> map = new HashMap<>();
    map.put("grant_type", "client_credentials");
    map.put("client_id", IccProfile.clientId);
    map.put("client_secret", IccProfile.clientSecret);
    /** 客户端校验数据使用form表单形式 */
    IccHttpHttpRequest cr =
        new IccHttpHttpRequest(OauthConstant.url(OauthConstant.OAUTH_URL_CLIENT_AUTH), Method.POST);
    cr.form(map);
    String crBody = cr.execute();
    IccTokenResponse token = BeanUtil.toBean(crBody, IccTokenResponse.class);
    if (token == null) {
      logger.error(
          "client auth failure [{}] reason [{}]",
          OauthConstant.url(OauthConstant.OAUTH_URL_CLIENT_AUTH),
          token == null ? "" : token.getErrMsg());
      throw new ClientException("client auth failure" + (token == null ? "" : token.getErrMsg()));
    }
    IccTokenResponse.IccToken iccToken = new IccToken();
    iccToken.setAccess_token(token.getAccess_token());
    iccToken.setExpires_in(token.getExpires_in());
    iccToken.setScope(token.getScope());
    iccToken.setToken_type(token.getToken_type());
    /** expires_in 单位是秒 */
    iccToken.setTtl(System.currentTimeMillis() + (iccToken.getExpires_in() * 1000));
    tokenMap.put(enGrantKeyName(GrantType.client_credentials.name()), iccToken);
    return iccToken;
  }

  /**
   * 从缓存获取token
   *
   * @param grantType 授权类型
   * @return IccTokenResponse.IccToken
   */
  public IccTokenResponse.IccToken getTokenCache(String grantType) {
    return tokenMap.get(enGrantKeyName(grantType));
  }

  /**
   * 刷新token
   *
   * @param grantType 授权类型
   * @param refreshToken 刷新fresh_token
   * @return IccTokenResponse.IccToken
   */
  public IccTokenResponse.IccToken refreshToken(GrantType grantType, String refreshToken) {
    try {
      IClient iClient = new DefaultClient();
      // 刷新token
      OauthRefreshTokenRequest refreshTokenRequest = new OauthRefreshTokenRequest();
      if (grantType.equals(GrantType.password)) {
        refreshTokenRequest.setClient_id(IccProfile.pwdClientId);
        refreshTokenRequest.setClient_secret(IccProfile.pwdClientSecret);
        refreshTokenRequest.setGrant_type(GrantType.refresh_token.name());
        refreshTokenRequest.setRefresh_token(refreshToken);
        OauthRefreshTokenResponse refreshTokenResponse =
            iClient.doAction(refreshTokenRequest, refreshTokenRequest.getResponseClass());
        if (refreshTokenResponse.isSuccess()) {
          OauthRefreshTokenResponse.IccReFreshToken freshToken = refreshTokenResponse.getData();
          IccTokenResponse.IccToken iccToken = new IccTokenResponse.IccToken();
          iccToken.setTtl(System.currentTimeMillis() + (freshToken.getExpires_in() * 1000));
          iccToken.setAccess_token(freshToken.getAccess_token());
          iccToken.setExpires_in(freshToken.getExpires_in());
          iccToken.setMagicId(freshToken.getMagicId());
          iccToken.setUserId(freshToken.getUserId());
          iccToken.setToken_type(freshToken.getToken_type());
          iccToken.setRefresh_token(freshToken.getRefresh_token());
          iccToken.setScope(freshToken.getScope());
          return iccToken;
        }
      }
      /*客户端没有fresh_token 字段，无法调用刷新token接口，故只能重新获取*/
      if (grantType.equals(GrantType.client_credentials)) {
        return clientCredentials();
      }

    } catch (ClientException e) {
      logger.error(
          "fresh token error , grantType=[{}],freshToken=[{}]", grantType.name(), refreshToken);
    }
    return null;
  }

  private void refreshTokenAndKeepAlive() {
    if (TOKEN_INITED.get() && tokenMap.size() > 0) {
      for (Map.Entry<String, IccTokenResponse.IccToken> entry : tokenMap.entrySet()) {
        IccTokenResponse.IccToken token = entry.getValue();
        Long currentTime = System.currentTimeMillis();
        /** 如果时间还剩120s，则刷新token */
        if (token.getTtl() - currentTime <= 120 * 1000) {
          GrantType grantType = deGrantType(entry.getKey());
          token = refreshToken(grantType, token.getRefresh_token());
          if (token != null) {
            tokenMap.put(entry.getKey(), token);
            logger.info("refresh token success, [{}],token=[{}]", entry.getKey(), token);
          }
        }
      }
      keepalive();
    }
  }

  /** 保活接口 */
  private void keepalive() {
    try {
      IClient iClient = new DefaultClient();
      if (IccProfile.inited) {
        for (Map.Entry<String, IccTokenResponse.IccToken> entry : tokenMap.entrySet()) {
          if (GrantType.client_credentials == deGrantType(entry.getKey())) {
            continue;
          }
          IccTokenResponse.IccToken token = entry.getValue();
          BrmKeepAliveRequest request = new BrmKeepAliveRequest();
          request.setMagicId(token.getMagicId());
          // [password] 密码认证，使用web
          request.setClientType(OauthConstant.ClientType.WEB.getClientType());
          BrmKeepAliveResponse brmKeepAliveResponse =
              iClient.doAction(request, request.getResponseClass());
          if (brmKeepAliveResponse.isSuccess()) {
            logger.debug("evo-brm [{}] keeplive success", entry.getKey());
          } else {
            // token失效了，重新获取token
            if (ErrorConstants.OAUTH_INVALID_TOKEN.equalsIgnoreCase(
                brmKeepAliveResponse.getCode())) {
              logger.info("[{}] token invalid , get new token", entry.getKey());
              // 移除缓存，重新获取
              tokenMap.remove(entry.getKey());
              refreshToken(deGrantType(entry.getKey()));
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      logger.error("keepalive error = {}", e);
    }
  }

  private String enGrantKeyName(String grantType) {
    return grantType + StrUtil.COLON + IccProfile.host;
  }

  private GrantType deGrantType(String grantKeyName) {
    return GrantType.valueOf(grantKeyName.substring(0, grantKeyName.indexOf(StrUtil.COLON)));
  }

  private static class SingletonHolder {
    private static final TokenHandleSingle INSTANCE = new TokenHandleSingle();
  }
}
