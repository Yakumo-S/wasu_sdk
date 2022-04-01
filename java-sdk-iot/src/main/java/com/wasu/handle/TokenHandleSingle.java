package com.wasu.handle;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

import com.wasu.constant.OauthConstant;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IotHttpRequest;
import com.wasu.http.IotTokenResponse;
import com.wasu.hutool.core.thread.NamedThreadFactory;
import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.http.Method;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.iot.exception.ClientException;
import com.wasu.iot.exception.ServerException;
import com.wasu.iot.util.BeanUtil;
import com.wasu.model.v202010.OauthRefreshTokenRequest;
import com.wasu.model.v202010.OauthRefreshTokenResponse;
import com.wasu.profile.GrantType;
import com.wasu.profile.IotProfile;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 单例，获取access_token,刷新access_token，登录状态保活
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public class TokenHandleSingle {

  private static final Log logger = LogFactory.get();

  /**
   * access_token 首次获取状态
   */
  private static final AtomicBoolean TOKEN_INITED = new AtomicBoolean(Boolean.FALSE);
  /**
   * token刷新间隔 30s
   */
  private static final long FRESH_TOKEN_INTERVAL = 15 * 1000;
  /**
   * 线程刷新token和保活
   */
  private final ScheduledExecutorService REFRESH_TOKEN_SCHEDULED =
      newSingleThreadScheduledExecutor(new NamedThreadFactory("Icc-Refresh-Token", true));
  /**
   * 密码和客户端认证存储Map
   */
  private final Map<String, IotTokenResponse> tokenMap = new ConcurrentHashMap<>();

  public Map<String, IotTokenResponse> getTokenMap() {
    return tokenMap;
  }

  /**
   * 定时任务刷新token
   */
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

  public synchronized IotTokenResponse refreshToken(GrantType grantType) {

    IotTokenResponse token = null;
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
  private IotTokenResponse password() throws ClientException, ServerException {
    Map<String, Object> map = new HashMap<>();
    map.put("grant_type", "password");
    map.put("username", IotProfile.username);
    map.put("password", IotProfile.password);
    /*web_client*/
    map.put("client_id", "web");
    /*web_client*/
    map.put("client_secret", "web");
    map.put("scope", "all");

    IotHttpRequest pr =
        new IotHttpRequest(
            OauthConstant.url(OauthConstant.OAUTH_URL_CLIENT_AUTH),
            Method.POST);
    pr.form(map);
    String prBody = pr.execute();
    IotTokenResponse token = BeanUtil.toBean(prBody, IotTokenResponse.class);
    if (token == null || StrUtil.isBlank(token.getAccess_token())) {
      logger.error(
          " auth failure [{}] reason [{}]",
          OauthConstant.url(OauthConstant.OAUTH_URL_CLIENT_AUTH),
          token == null ? "" : "");
      throw new ClientException(
          "GrantType [password] username=["
              + IotProfile.username
              + "],password=["
              + IotProfile.password
              + "] get access_token failure");
    }
    IotTokenResponse iotToken = token;
    /** 设置存活时间ttl,其中 expires_in 单位是秒 */
    iotToken.setTtl(System.currentTimeMillis() + (iotToken.getExpires_in() * 1000));

    tokenMap.put(enGrantKeyName(GrantType.password.name()), iotToken);
    return iotToken;
  }

  /**
   * 客户端认证获取token
   *
   * @return IccTokenResponse.IccToken
   * @throws ClientException 客户端异常
   * @throws ServerException 服务端异常
   */
  private IotTokenResponse clientCredentials() throws ClientException, ServerException {
    Map<String, Object> map = new HashMap<>();
    map.put("grant_type", "client_credentials");
    map.put("client_id", IotProfile.clientId);
    map.put("client_secret", IotProfile.clientSecret);
    /** 客户端校验数据使用form表单形式 */
    IotHttpRequest cr =
        new IotHttpRequest(OauthConstant.url(OauthConstant.OAUTH_URL_CLIENT_AUTH), Method.POST);
    cr.form(map);
    String crBody = cr.execute();
    IotTokenResponse token = BeanUtil.toBean(crBody, IotTokenResponse.class);
    if (token == null) {
      logger.error(
          "client auth failure [{}] reason [{}]",
          OauthConstant.url(OauthConstant.OAUTH_URL_CLIENT_AUTH),
          token == null ? "" : "");
      throw new ClientException("client auth failure" + (token == null ? "" : ""));
    }
    IotTokenResponse iotToken = new IotTokenResponse();
    iotToken.setAccess_token(token.getAccess_token());
    iotToken.setExpires_in(token.getExpires_in());
    iotToken.setScope(token.getScope());
    iotToken.setToken_type(token.getToken_type());
    /** expires_in 单位是秒 */
    iotToken.setTtl(System.currentTimeMillis() + (iotToken.getExpires_in() * 1000));
    tokenMap.put(enGrantKeyName(GrantType.client_credentials.name()), iotToken);
    return iotToken;
  }

  /**
   * 从缓存获取token
   *
   * @param grantType 授权类型
   * @return IccTokenResponse.IccToken
   */
  public IotTokenResponse getTokenCache(String grantType) {
    return tokenMap.get(enGrantKeyName(grantType));
  }

  /**
   * 刷新token
   *
   * @param grantType    授权类型
   * @param refreshToken 刷新fresh_token
   * @return IccTokenResponse.IccToken
   */
  public IotTokenResponse refreshToken(GrantType grantType,String accessToken, String refreshToken) {
    try {
      IClient iClient = new DefaultClient();
      // 刷新token
      OauthRefreshTokenRequest refreshTokenRequest = new OauthRefreshTokenRequest();
      if (grantType.equals(GrantType.password)) {
        refreshTokenRequest.setClient_id("web");
        refreshTokenRequest.setClient_secret("web");
        refreshTokenRequest.setGrant_type(GrantType.refresh_token.name());
        refreshTokenRequest.setRefresh_token(refreshToken);
        refreshTokenRequest.setAccess_token(accessToken);
        OauthRefreshTokenResponse refreshTokenResponse =
            iClient.doAction(refreshTokenRequest, refreshTokenRequest.getResponseClass());
        IotTokenResponse iotToken = new IotTokenResponse();
        iotToken.setTtl(System.currentTimeMillis() + (refreshTokenResponse.getExpires_in() * 1000));
        iotToken.setAccess_token(refreshTokenResponse.getAccess_token());
        iotToken.setExpires_in(refreshTokenResponse.getExpires_in());
        iotToken.setToken_type(refreshTokenResponse.getToken_type());
        iotToken.setRefresh_token(refreshTokenResponse.getRefresh_token());
        iotToken.setScope(refreshTokenResponse.getScope());
        return iotToken;
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
      for (Map.Entry<String, IotTokenResponse> entry : tokenMap.entrySet()) {
        IotTokenResponse token = entry.getValue();
        Long currentTime = System.currentTimeMillis();
        /** 如果时间还剩120s，则刷新token */
        if (token.getTtl() - currentTime <= 600 * 1000) {
          GrantType grantType = deGrantType(entry.getKey());
          token = refreshToken(grantType,token.getAccess_token(), token.getRefresh_token());
          if (token != null) {
            tokenMap.put(entry.getKey(), token);
            logger.info("refresh token success, [{}],token=[{}]", entry.getKey(), token);
          }
        }
      }
    }
  }


  private String enGrantKeyName(String grantType) {
    return grantType + StrUtil.COLON + IotProfile.host;
  }

  private GrantType deGrantType(String grantKeyName) {
    return GrantType.valueOf(grantKeyName.substring(0, grantKeyName.indexOf(StrUtil.COLON)));
  }

  private static class SingletonHolder {

    private static final TokenHandleSingle INSTANCE = new TokenHandleSingle();
  }
}
