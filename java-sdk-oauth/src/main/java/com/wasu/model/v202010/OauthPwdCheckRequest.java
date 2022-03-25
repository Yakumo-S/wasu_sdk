package com.wasu.model.v202010;

import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;
import com.wasu.hutool.http.Method;
import com.wasu.iot.exception.ClientException;

/**
 * 密码验证，需鉴权
 *
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthPwdCheckRequest extends AbstractIccRequest<OauthPwdCheckResponse> {
  /** 用户名 */
  private String loginName;
  /** 登录密码，需RSA加密 */
  private String loginPass;
  /** 公钥 */
  private String public_key;

  public OauthPwdCheckRequest() throws ClientException {
    super(OauthConstant.url(OauthConstant.OAUTH_URL_PWD_CHECK_POST), Method.POST, Boolean.TRUE);
  }

  @Override
  public Class<OauthPwdCheckResponse> getResponseClass() {
    return OauthPwdCheckResponse.class;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
    putBodyParameter("loginName", loginName);
  }

  public String getLoginPass() {
    return loginPass;
  }

  public void setLoginPass(String loginPass) {
    this.loginPass = loginPass;
    putBodyParameter("loginPass", loginPass);
  }

  public String getPublic_key() {
    return public_key;
  }

  public void setPublic_key(String public_key) {
    this.public_key = public_key;
    putBodyParameter("public_key", public_key);
  }
}
