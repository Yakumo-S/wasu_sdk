package com.wasu.constant;

import com.wasu.profile.IotProfile;

/**
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public class OauthConstant {

  /**
   * 模块名称
   */
  public static final String SYSTEM_NAME = "evo-oauth";


  /**
   * 客户端认证鉴权
   */
  public static final String OAUTH_URL_CLIENT_AUTH = "/oauth/token";
  /**
   * 刷新token地址
   */
  public static final String OAUTH_URL_REFRESH_TOKEN_POST =
      "/oauth/token";

  public static String version = "1.0.0";
  private static boolean initVersionFromBrm = Boolean.FALSE;

  /**
   * @param url 请求地址
   * @return 返回带版本号的url
   */
  public static String url(String url) {
    return IotProfile.URL_SCHEME + url;
  }

  /**
   * 客户端类型
   */
  public enum ClientType {
    /**
     * WEB
     */
    WEB(1),
    /**
     * 客户端
     */
    CLIENT(2),
    /**
     * App 客户端
     */
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
