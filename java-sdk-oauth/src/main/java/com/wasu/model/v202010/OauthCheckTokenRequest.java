package com.wasu.model.v202010;

import com.wasu.hutool.http.Method;
import com.wasu.icc.exception.ClientException;
import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;

/**
 * 校验token，无需鉴权
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthCheckTokenRequest extends AbstractIccRequest<OauthCheckTokenResponse> {

  private String token;

  public OauthCheckTokenRequest() throws ClientException {
    super(OauthConstant.url(OauthConstant.OAUTH_URL_CHECK_TOKEN_POST), Method.POST, Boolean.FALSE);
  }

  @Override
  public Class<OauthCheckTokenResponse> getResponseClass() {
    return OauthCheckTokenResponse.class;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
    httpRequest.form("token", token);
  }
}
