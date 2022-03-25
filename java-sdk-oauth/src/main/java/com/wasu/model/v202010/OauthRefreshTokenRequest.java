package com.wasu.model.v202010;

import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;
import com.wasu.hutool.http.Method;
import com.wasu.iot.exception.ClientException;

/**
 * 刷新token，无需鉴权
 *
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthRefreshTokenRequest extends AbstractIccRequest<OauthRefreshTokenResponse> {

  private String grant_type;
  private String client_id;
  private String client_secret;
  private String refresh_token;

  public OauthRefreshTokenRequest() throws ClientException {
    super(
        OauthConstant.url(OauthConstant.OAUTH_URL_REFRESH_TOKEN_POST), Method.POST, Boolean.FALSE);
  }

  @Override
  public Class<OauthRefreshTokenResponse> getResponseClass() {
    return OauthRefreshTokenResponse.class;
  }

  public String getGrant_type() {
    return grant_type;
  }

  public void setGrant_type(String grant_type) {
    this.grant_type = grant_type;
    putBodyParameter("grant_type", grant_type);
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

  public String getRefresh_token() {
    return refresh_token;
  }

  public void setRefresh_token(String refresh_token) {
    this.refresh_token = refresh_token;
    putBodyParameter("refresh_token", refresh_token);
  }
}
