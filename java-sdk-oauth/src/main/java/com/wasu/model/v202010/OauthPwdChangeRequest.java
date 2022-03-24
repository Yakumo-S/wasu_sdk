package com.wasu.model.v202010;

import com.wasu.hutool.http.Method;
import com.wasu.icc.exception.ClientException;
import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;

/**
 * 密码修改
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthPwdChangeRequest extends AbstractIccRequest<OauthPwdChangeResponse> {
  /** 登录用户名 */
  private String loginName;
  /** + 新密码（需RSA加密） */
  private String loginPass;
  /** 旧密码（需RSA加密） */
  private String oldLoginPass;
  /** 公钥 */
  private String public_key;

  public OauthPwdChangeRequest() throws ClientException {
    super(OauthConstant.url(OauthConstant.OAUTH_URL_PWD_CHANGE_POST), Method.POST, Boolean.TRUE);
  }

  @Override
  public Class<OauthPwdChangeResponse> getResponseClass() {
    return OauthPwdChangeResponse.class;
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

  public String getOldLoginPass() {
    return oldLoginPass;
  }

  public void setOldLoginPass(String oldLoginPass) {
    this.oldLoginPass = oldLoginPass;
    putBodyParameter("oldLoginPass", oldLoginPass);
  }

  public String getPublic_key() {
    return public_key;
  }

  public void setPublic_key(String public_key) {
    this.public_key = public_key;
    putBodyParameter("public_key", public_key);
  }
}
