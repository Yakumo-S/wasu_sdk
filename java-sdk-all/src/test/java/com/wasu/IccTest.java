//package com.dahuatech.icc.test;
//
//import com.dahuatech.icc.exception.ClientException;
//import com.dahuatech.icc.oauth.handle.TokenHandleSingle;
//import com.dahuatech.icc.oauth.http.DefaultClient;
//import com.dahuatech.icc.oauth.http.IClient;
//import com.dahuatech.icc.oauth.http.IccTokenResponse;
//import com.dahuatech.icc.oauth.model.v202010.*;
//import com.dahuatech.icc.oauth.profile.GrantType;
//import com.dahuatech.icc.oauth.profile.IccProfile;
//import com.dahuatech.icc.util.SignUtil;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.extension.TestWatcher;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
///**
// * @author 232676
// * @since 2020/10/21 16:39
// */
//@ExtendWith(IccTest.class)
//public class IccTest implements TestWatcher {
//  /*-------------这是一条分割线--------------------------------------*/
//  //  @Test
//  //  public void token() throws ClientException {
//  //    IClient iClient =
//  //        new DefaultClient("10.35.183.106", "system", "dahua2020", "web_client", "web_client");
//  //
//  //    GeneralRequest generalRequest =
//  //        new GeneralRequest("/evo-apigw/admin/API/EVO/distribution/getAvailableServers",
//  // Method.GET);
//  //    GeneralResponse generalResponse =
//  //        iClient.doAction(generalRequest, generalRequest.getResponseClass());
//  //  }
//  //  /*-------------这是一条分割线--------------------------------------*/
//  //  @Test
//  //  public void general() throws ClientException {
//  //    IClient iClient =
//  //        new DefaultClient("10.35.183.106", "system", "dahua2020", "web_client", "web_client");
//  //
//  //    GeneralRequest generalRequest =
//  //        new GeneralRequest("/evo-apigw/admin/API/EVO/distribution/getAvailableServers",
//  // Method.GET);
//  //    GeneralResponse generalResponse =
//  //        iClient.doAction(generalRequest, generalRequest.getResponseClass());
//  //  }
//
//  /*-------------这是一条分割线--------------------------------------*/
//  @Test
//  public void authPwd() throws ClientException {
//    IClient iClient = new DefaultClient();
//
//    OauthPublicKeyRequest publicKeyRequest = new OauthPublicKeyRequest();
//    OauthPublicKeyResponse publicKey =
//        iClient.doAction(publicKeyRequest, publicKeyRequest.getResponseClass());
//    String pey = publicKey.getData().getPublicKey();
//    System.out.println("获得公钥  " + publicKey.getData().getPublicKey());
//
//    OauthPwdAuthRequest request = new OauthPwdAuthRequest();
//    request.setClient_id(IccProfile.pwdClientId);
//    request.setClient_secret(IccProfile.pwdClientSecret);
//    request.setGrant_type(GrantType.password.name());
//    request.setUsername(IccProfile.username);
//    request.setPassword(SignUtil.encryptRSA(IccProfile.password, pey));
//    request.setPublic_key(pey);
//    OauthPwdAuthResponse response = iClient.doAction(request, request.getResponseClass());
//    assertTrue(response.isSuccess());
//  }
//
//  /**
//   * 校验token
//   *
//   * @throws ClientException
//   */
//  @Test
//  public void checkTokenTest() throws ClientException {
//    IClient iClient = new DefaultClient();
//
//    OauthPublicKeyRequest publicKeyRequest = new OauthPublicKeyRequest();
//    OauthPublicKeyResponse publicKey =
//        iClient.doAction(publicKeyRequest, publicKeyRequest.getResponseClass());
//    assertTrue(publicKey.isSuccess());
//
//    String pey = publicKey.getData().getPublicKey();
//    System.out.println("获得公钥  " + publicKey.getData().getPublicKey());
//
//    OauthPwdAuthRequest request = new OauthPwdAuthRequest();
//    request.setClient_id(IccProfile.pwdClientId);
//    request.setClient_secret(IccProfile.pwdClientSecret);
//    request.setGrant_type(GrantType.password.name());
//    request.setUsername(IccProfile.username);
//    request.setPassword(SignUtil.encryptRSA(IccProfile.password, pey));
//    request.setPublic_key(pey);
//    // String response = iClient.doAction(request);
//    OauthPwdAuthResponse response = iClient.doAction(request, request.getResponseClass());
//    OauthCheckTokenRequest checkTokenRequest = new OauthCheckTokenRequest();
//    checkTokenRequest.setToken(response.getData().getAccess_token());
//    OauthCheckTokenResponse checkTokenResponse =
//        iClient.doAction(checkTokenRequest, checkTokenRequest.getResponseClass());
//    assertTrue(checkTokenResponse.isSuccess());
//  }
//
//  /**
//   * 刷新token
//   *
//   * @throws ClientException
//   */
//  @Test
//  public void refreshTokenTest() throws ClientException {
//    IClient iClient = new DefaultClient();
//    // 获胜公钥
//    OauthPublicKeyRequest publicKeyRequest = new OauthPublicKeyRequest();
//    OauthPublicKeyResponse publicKey =
//        iClient.doAction(publicKeyRequest, publicKeyRequest.getResponseClass());
//    String pey = publicKey.getData().getPublicKey();
//    assertTrue(publicKey.isSuccess());
//
//    // 生成access_token
//    OauthPwdAuthRequest request = new OauthPwdAuthRequest();
//    request.setClient_id(IccProfile.pwdClientId);
//    request.setClient_secret(IccProfile.pwdClientSecret);
//    request.setGrant_type(GrantType.password.name());
//    request.setUsername(IccProfile.username);
//    request.setPassword(SignUtil.encryptRSA(IccProfile.password, pey));
//    request.setPublic_key(pey);
//    OauthPwdAuthResponse response = iClient.doAction(request, request.getResponseClass());
//
//    assertTrue(response.isSuccess());
//
//    // 刷新token
//    OauthRefreshTokenRequest refreshTokenRequest = new OauthRefreshTokenRequest();
//    refreshTokenRequest.setClient_id(IccProfile.pwdClientId);
//    refreshTokenRequest.setClient_secret(IccProfile.pwdClientSecret);
//    refreshTokenRequest.setGrant_type(GrantType.refresh_token.name());
//    refreshTokenRequest.setRefresh_token(response.getData().getRefresh_token());
//
//    OauthRefreshTokenResponse refreshTokenResponse =
//        iClient.doAction(refreshTokenRequest, refreshTokenRequest.getResponseClass());
//
//    assertTrue(refreshTokenResponse.isSuccess());
//  }
//
//  /**
//   * 注销授权信息
//   *
//   * @throws ClientException
//   */
//  @Test
//  public void logoutTest() throws ClientException {
//    IClient iClient = new DefaultClient();
//    // 获胜公钥
//    OauthPublicKeyRequest publicKeyRequest = new OauthPublicKeyRequest();
//    OauthPublicKeyResponse publicKey =
//        iClient.doAction(publicKeyRequest, publicKeyRequest.getResponseClass());
//    String pey = publicKey.getData().getPublicKey();
//    assertTrue(publicKey.isSuccess());
//
//    // 生成access_token
//    OauthPwdAuthRequest request = new OauthPwdAuthRequest();
//    request.setClient_id(IccProfile.pwdClientId);
//    request.setClient_secret(IccProfile.pwdClientSecret);
//    request.setGrant_type(GrantType.password.name());
//    request.setUsername(IccProfile.username);
//    request.setPassword(SignUtil.encryptRSA(IccProfile.password, pey));
//    request.setPublic_key(pey);
//    OauthPwdAuthResponse response = iClient.doAction(request, request.getResponseClass());
//
//    assertTrue(response.isSuccess());
//
//    // 注销授权信息
//    OauthLogoutRequest oauthLogoutRequest = new OauthLogoutRequest();
//
//    OauthLogoutResponse oauthLogoutResponse =
//        iClient.doAction(oauthLogoutRequest, oauthLogoutRequest.getResponseClass());
//
//    assertTrue(oauthLogoutResponse.isSuccess());
//  }
//
//  /**
//   * 单例token
//   *
//   * @throws ClientException
//   */
//  @Test
//  public void tokenMapTest() throws ClientException {
//    String key = "127.0.0.1";
//    TokenHandleSingle.getInstance().getTokenMap().put(key, new IccTokenResponse.IccToken());
//    assertFalse(TokenHandleSingle.getInstance().getTokenMap().isEmpty());
//
//    assertTrue(TokenHandleSingle.getInstance().getTokenMap().containsKey(key));
//    TokenHandleSingle.getInstance().getTokenMap().clear();
//    assertTrue(TokenHandleSingle.getInstance().getTokenMap().isEmpty());
//  }
//}
