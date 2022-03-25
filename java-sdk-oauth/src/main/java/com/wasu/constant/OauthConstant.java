package com.wasu.constant;

import com.wasu.profile.IotProfile;

/**
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthConstant {

  /** 模块名称 */
  public static final String SYSTEM_NAME = "evo-oauth";
  /** 获取鉴权公钥请求地址 */
  public static final String OAUTH_URL_PUBLIC_KEY_GET = "/evo-apigw/evo-oauth/%s/oauth/public-key";
  /** 密码认证请求地址 */
  public static final String OAUTH_URL_PWD_AUTH_POST = "/evo-apigw/evo-oauth/%s/oauth/extend/token";
  /** 刷新token地址 */
  public static final String OAUTH_URL_REFRESH_TOKEN_POST =
      "/evo-apigw/evo-oauth/%s/oauth/extend/refresh/token";
  /** 校验token地址 */
  public static final String OAUTH_URL_CHECK_TOKEN_POST = "/evo-apigw/evo-oauth/oauth/check_token";
  /** 客户端认证鉴权 */
  public static final String OAUTH_URL_CLIENT_AUTH = "/oauth/token";
  /** 注销授权信息 */
  public static final String OAUTH_URL_LOGOUT_GET = "/evo-apigw/evo-oauth/%s/oauth/logout";
  /** 密码重置 */
  public static final String OAUTH_URL_PWD_RESET_PUT =
      "/evo-apigw/evo-oauth/%s/oauth/reset/password";
  /** 验证密码 */
  public static final String OAUTH_URL_PWD_CHECK_POST =
      "/evo-apigw/evo-oauth/%s/oauth/check/password";
  /** 密码修改 */
  public static final String OAUTH_URL_PWD_CHANGE_POST =
      "/evo-apigw/evo-oauth/%s/oauth/change/password";
  /** 保活(特殊情况，这里放在oauth模块) */
  public static final String BRM_URL_KEEP_ALIVE_POST = "/evo-apigw/evo-brm/%s/user/keepalive";

  public static String version = "1.0.0";
  private static boolean initVersionFromBrm = Boolean.FALSE;

  public static String brmUrl(String url) {
    String brmName = "evo-brm";
    String brmVersion = "1.0.0";
    // 加载远程版本信息
    if (!initVersionFromBrm && IotProfile.systemVersionMap.containsKey(brmName)) {
      brmVersion = IotProfile.systemVersionMap.get(brmName);
      initVersionFromBrm = true;
    }
    return String.format(IotProfile.URL_SCHEME + url, brmVersion);
  }

  /**
   * @param url 请求地址
   * @return 返回带版本号的url
   */
  public static String url(String url) {
    // 加载远程版本信息
    if (!initVersionFromBrm && IotProfile.systemVersionMap.containsKey(SYSTEM_NAME)) {
      version = IotProfile.systemVersionMap.get(SYSTEM_NAME);
      initVersionFromBrm = true;
    }
    return String.format(IotProfile.URL_SCHEME + url, version);
  }

  /** 客户端类型 */
  public enum ClientType {
    /** WEB */
    WEB(1),
    /** 客户端 */
    CLIENT(2),
    /** App 客户端 */
    APP(3);

    private int clientType;

    ClientType(int clientType) {
      this.clientType = clientType;
    }

    public int getClientType() {
      return clientType;
    }
  }
}
