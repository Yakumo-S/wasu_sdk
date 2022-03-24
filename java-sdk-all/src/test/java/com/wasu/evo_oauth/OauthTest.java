package com.wasu.evo_oauth;

import com.wasu.hutool.http.Method;
import com.wasu.icc.exception.ClientException;
import com.wasu.handle.TokenHandleSingle;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.model.v202010.GeneralRequest;
import com.wasu.model.v202010.GeneralResponse;
import com.wasu.model.v202010.OauthLogoutRequest;
import com.wasu.model.v202010.OauthLogoutResponse;
import com.wasu.model.v202010.OauthRefreshTokenRequest;
import com.wasu.model.v202010.OauthRefreshTokenResponse;
import com.wasu.profile.GrantType;
import com.wasu.profile.IccProfile;
import com.wasu.ExtentUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

/**
 * API文档-鉴权中心单元用例
 *
 * @author 232676
 * @since 1.0.0 2021/1/11 14:52
 */
public class OauthTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-oauth";

  @BeforeAll
  static void beforeClass() {}

  @AfterAll
  static void afterClass() {}

  boolean isSupport() {
    try {
      IClient iClient = new DefaultClient();
      return IccProfile.systemVersionMap.containsKey(SYSTEM_NAME);
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 鉴权中心->用户密码认证->获取公钥
   *
   * <p>接口编号 oauth_001
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/evo-oauth/1.0.0/oauth/public-key
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("获取公钥")
  @Tag("鉴权中心")
  @EnabledIf("isSupport")
  public void oauth_001_public_key() throws ClientException {
    String url = "/evo-apigw/evo-oauth/1.0.0/oauth/public-key";
    String body = "";
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET, Boolean.FALSE);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    Assertions.assertTrue(response.isSuccess());
  }
  /**
   * 鉴权中心->用户密码认证->认证
   *
   * <p>接口编号 oauth_002
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-oauth/1.0.0/oauth/extend/token
   *
   * <p>备注补充 此处使用SDK替代调用,省略公钥加密逻辑，结果相同
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("密码鉴权认证")
  @Tag("鉴权中心")
  @EnabledIf("isSupport")
  public void oauth_002_password_token() throws ClientException {
    String url = "/evo-apigw/evo-oauth/1.0.0/oauth/extend/token";
    String body = "";
    IClient iClient =
        new DefaultClient(
            IccProfile.host,
            IccProfile.username,
            IccProfile.password,
            IccProfile.pwdClientId,
            IccProfile.pwdClientSecret);
    Assertions.assertNotNull((iClient.getAccessToken(GrantType.password)));
  }
  /**
   * 鉴权中心->用户密码认证->刷新认证信息
   *
   * <p>接口编号 oauth_003
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-oauth/1.0.0/oauth/extend/refresh/token
   *
   * <p>备注补充 此处使用SDK替代调用,结果相同
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("刷新认证信息")
  @Tag("鉴权中心")
  @EnabledIf("isSupport")
  public void oauth_003_refresh_token() throws ClientException {
    String url = "/evo-apigw/evo-oauth/1.0.0/oauth/extend/refresh/token";
    String body = "";

    // 第一步、产生token
    IClient iClient =
        new DefaultClient(
            IccProfile.host,
            IccProfile.username,
            IccProfile.password,
            IccProfile.pwdClientId,
            IccProfile.pwdClientSecret);
    //    Assertions.assertNotNull((iClient.getAccessToken(GrantType.password)));
    //    System.out.println(JSONUtil.toJsonStr(iClient.getAccessToken(GrantType.password)));
    // 第二步、刷新token

    OauthRefreshTokenRequest refreshTokenRequest = new OauthRefreshTokenRequest();
    refreshTokenRequest.setClient_id(IccProfile.pwdClientId);
    refreshTokenRequest.setClient_secret(IccProfile.pwdClientSecret);
    refreshTokenRequest.setGrant_type(GrantType.refresh_token.name());
    refreshTokenRequest.setRefresh_token(
        iClient.getAccessToken(GrantType.password).getRefresh_token());

    OauthRefreshTokenResponse refreshTokenResponse =
        iClient.doAction(refreshTokenRequest, refreshTokenRequest.getResponseClass());
    printLog(refreshTokenRequest, refreshTokenResponse);
    Assertions.assertTrue(refreshTokenResponse.isSuccess());
  }
  /**
   * 鉴权中心->用户密码认证->客户端认证信息
   *
   * <p>接口编号 oauth_004
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-oauth/oauth/token
   *
   * <p>备注补充 此处使用SDK替代调用,结果相同
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("客户端认证")
  @Tag("鉴权中心")
  @EnabledIf("isSupport")
  public void oauth_004_client_token() throws ClientException {
    String url = "/evo-apigw/evo-oauth/oauth/token";
    String body = "";
    // 注意!注意!注意!  该接口数据提交格式是form-data
    IClient iClient =
        new DefaultClient(IccProfile.host, IccProfile.clientId, IccProfile.clientSecret);
    Assertions.assertNotNull((iClient.getAccessToken(GrantType.client_credentials)));
  }
  /**
   * 鉴权中心->用户密码认证->注销认证信息
   *
   * <p>接口编号 oauth_005
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/evo-oauth/1.0.0/oauth/logout
   *
   * <p>备注补充 此处使用SDK替代调用,结果相同
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("注销认证信息")
  @Tag("鉴权中心")
  @EnabledIf("isSupport")
  public void oauth_005_logout_token() throws ClientException {
    String url = "/evo-apigw/evo-oauth/1.0.0/oauth/logout";
    String body = "";
    // 分四步来
    // 第一步：密码认证；
    // 第二步：注销密码认证；
    // 第三步：客户端认证；
    // 第四步：注销客户端认证
    // -----------------分隔符--------------------------------
    // 开始密码认证和注销
    IClient iClient =
        new DefaultClient(
            IccProfile.host,
            IccProfile.username,
            IccProfile.password,
            IccProfile.pwdClientId,
            IccProfile.pwdClientSecret);
    Assertions.assertNotNull((iClient.getAccessToken(GrantType.password)));
    OauthLogoutRequest pwdOauthLogoutRequest = new OauthLogoutRequest();
    OauthLogoutResponse pwdOauthLogoutResponse =
        iClient.doAction(pwdOauthLogoutRequest, pwdOauthLogoutRequest.getResponseClass());
    printLog(pwdOauthLogoutRequest, pwdOauthLogoutResponse);

    Assertions.assertTrue(pwdOauthLogoutResponse.isSuccess());
    // 开始客户端认证和注销

    // 注意!注意!注意!  该接口数据提交格式是form-data
    iClient = new DefaultClient(IccProfile.host, IccProfile.clientId, IccProfile.clientSecret);
    Assertions.assertNotNull((iClient.getAccessToken(GrantType.client_credentials)));
    OauthLogoutRequest clientOauthLogoutRequest = new OauthLogoutRequest();
    OauthLogoutResponse clientOauthLogoutResponse =
        iClient.doAction(clientOauthLogoutRequest, clientOauthLogoutRequest.getResponseClass());
    printLog(clientOauthLogoutRequest, clientOauthLogoutResponse);
    Assertions.assertTrue(clientOauthLogoutResponse.isSuccess());
  }

  @BeforeEach
  public void before() throws ClientException {
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }
}
