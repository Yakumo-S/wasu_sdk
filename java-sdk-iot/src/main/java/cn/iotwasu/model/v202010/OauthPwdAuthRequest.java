package cn.iotwasu.model.v202010;

import cn.iotwasu.constant.OauthConstant;
import cn.iotwasu.http.AbstractIccRequest;
import cn.iotwasu.hutool.http.Method;
import cn.iotwasu.iot.exception.ClientException;

/**
 * 密码认证授权
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
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
