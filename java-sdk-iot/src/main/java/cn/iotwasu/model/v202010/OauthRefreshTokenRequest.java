package cn.iotwasu.model.v202010;

import cn.iotwasu.constant.OauthConstant;
import cn.iotwasu.http.AbstractIccRequest;
import cn.iotwasu.hutool.http.Method;
import cn.iotwasu.iot.exception.ClientException;

/**
 * 刷新token，无需鉴权
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public class OauthRefreshTokenRequest extends AbstractIccRequest<OauthRefreshTokenResponse> {

  private String grant_type;
  private String client_id;
  private String client_secret;
  private String refresh_token;
  private String access_token;

  public OauthRefreshTokenRequest() throws ClientException {
    super(
        OauthConstant.url(OauthConstant.OAUTH_URL_REFRESH_TOKEN_POST), Method.POST, Boolean.TRUE);
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
    form("grant_type", grant_type);
  }

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
    form("access_token", grant_type);
    form("scope", "all");

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

  public String getRefresh_token() {
    return refresh_token;
  }

  public void setRefresh_token(String refresh_token) {
    this.refresh_token = refresh_token;
    form("refresh_token", refresh_token);
  }
}
