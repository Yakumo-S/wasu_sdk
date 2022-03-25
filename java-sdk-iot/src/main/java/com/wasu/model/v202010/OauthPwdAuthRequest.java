package com.wasu.model.v202010;

import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;
import com.wasu.hutool.http.Method;
import com.wasu.iot.exception.ClientException;

/**
 * 密码认证授权
 *
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthPwdAuthRequest extends AbstractIccRequest<OauthPwdAuthResponse> {

  private String grant_type;
  private String username;
  private String password;
  private String client_id;
  private String client_secret;

  public OauthPwdAuthRequest() throws ClientException {
    super(OauthConstant.url(OauthConstant.OAUTH_URL_CLIENT_AUTH), Method.POST, Boolean.FALSE);
  }

  @Override
  public Class<OauthPwdAuthResponse> getResponseClass() {
    return OauthPwdAuthResponse.class;
  }

  public String getGrant_type() {
    return grant_type;
  }

  public void setGrant_type(String grant_type) {
    this.grant_type = grant_type;
    form("grant_type", grant_type);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
    form("username", username);
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
    form("password", password);
  }

}
