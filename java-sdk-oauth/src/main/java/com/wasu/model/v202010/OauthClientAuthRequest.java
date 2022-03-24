package com.wasu.model.v202010;

import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;
import com.wasu.hutool.http.Method;
import com.wasu.iot.exception.ClientException;

/**
 * 客户端认证授权，方法GET和POST，数据使用form
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthClientAuthRequest extends AbstractIccRequest<OauthClientAuthResponse> {
  /** 授权类型，固定值：client_credentials */
  private String grant_type;
  /** 客户端client_id */
  private String client_id;
  /** 客户端client_secret */
  private String client_secret;

  public OauthClientAuthRequest() throws ClientException {
    super(OauthConstant.url(OauthConstant.OAUTH_URL_CLIENT_AUTH), Method.POST, Boolean.FALSE);
  }

  @Override
  public Class<OauthClientAuthResponse> getResponseClass() {
    return OauthClientAuthResponse.class;
  }

  public String getGrant_type() {
    return grant_type;
  }

  public void setGrant_type(String grant_type) {
    this.grant_type = grant_type;
    form("grant_type", grant_type);
  }

  public String getClient_id() {
    return client_id;
  }

  public void setClient_id(String client_id) {
    this.client_id = client_id;
    form("client_id", client_id);
  }

  public String getClient_secret() {
    return client_secret;
  }

  public void setClient_secret(String client_secret) {
    this.client_secret = client_secret;
    form("client_secret", client_secret);
  }
}
