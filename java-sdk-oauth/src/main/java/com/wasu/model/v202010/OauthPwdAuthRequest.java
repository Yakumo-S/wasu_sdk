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
  private String public_key;

  public OauthPwdAuthRequest() throws ClientException {
    super(OauthConstant.url(OauthConstant.OAUTH_URL_PWD_AUTH_POST), Method.POST, Boolean.FALSE);
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
    putBodyParameter("grant_type", grant_type);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
    putBodyParameter("username", username);
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
    putBodyParameter("password", password);
  }

  public String getClient_id() {
    return client_id;
  }

  public void setClient_id(String client_id) {
    this.client_id = client_id;
    putBodyParameter("client_id", client_id);
  }

  public String getClient_secret() {
    return client_secret;
  }

  public void setClient_secret(String client_secret) {
    this.client_secret = client_secret;
    putBodyParameter("client_secret", client_secret);
  }

  public String getPublic_key() {
    return public_key;
  }

  public void setPublic_key(String public_key) {
    this.public_key = public_key;
    putBodyParameter("public_key", public_key);
  }
}
