package com.wasu.model.v202010;

import com.wasu.http.IotResponse;

/**
 * 密码认证授权
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public class OauthRefreshTokenResponse extends IotResponse {

  private String access_token;
  private String refresh_token;
  private Long expires_in;
  private String scope;
  private String token_type;

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

  public String getRefresh_token() {
    return refresh_token;
  }

  public void setRefresh_token(String refresh_token) {
    this.refresh_token = refresh_token;
  }

  public Long getExpires_in() {
    return expires_in;
  }

  public void setExpires_in(Long expires_in) {
    this.expires_in = expires_in;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public String getToken_type() {
    return token_type;
  }

  public void setToken_type(String token_type) {
    this.token_type = token_type;
  }

  @Override
  public String toString() {
    return "OauthRefreshTokenResponse{" +
        "access_token='" + access_token + '\'' +
        ", refresh_token='" + refresh_token + '\'' +
        ", expires_in=" + expires_in +
        ", scope='" + scope + '\'' +
        ", token_type='" + token_type + '\'' +
        '}';
  }
}
