package com.wasu.model.v202010;

import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;
import com.wasu.hutool.http.Method;
import com.wasu.iot.exception.ClientException;

/**
 * 鉴权公钥
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthPublicKeyRequest extends AbstractIccRequest<OauthPublicKeyResponse> {

  public OauthPublicKeyRequest() throws ClientException {
    super(OauthConstant.url(OauthConstant.OAUTH_URL_PUBLIC_KEY_GET), Method.GET, Boolean.FALSE);
  }

  @Override
  public Class<OauthPublicKeyResponse> getResponseClass() {
    return OauthPublicKeyResponse.class;
  }
}
