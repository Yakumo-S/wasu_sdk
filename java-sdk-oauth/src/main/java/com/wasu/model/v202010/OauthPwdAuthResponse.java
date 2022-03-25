package com.wasu.model.v202010;

import com.wasu.http.IotResponse;
import com.wasu.http.IotTokenResponse;

/**
 * 密码认证授权
 *
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthPwdAuthResponse extends IotResponse {
  private IotTokenResponse.IccToken data;

  public IotTokenResponse.IccToken getData() {
    return data;
  }

  public void setData(IotTokenResponse.IccToken data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "OauthPwdAuthResponse{" + "data=" + data + '}';
  }

  public static class IccToken {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Long expires_in;
    private String scope;
    private String userId;
    private String magicId;
    private Long remainderDays;

    public String getAccess_token() {
      return access_token;
    }

    public void setAccess_token(String access_token) {
      this.access_token = access_token;
    }

    public String getToken_type() {
      return token_type;
    }

    public void setToken_type(String token_type) {
      this.token_type = token_type;
    }

    public String getRefresh_token() {
      return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
      this.refresh_token = refresh_token;
    }

    public Long getExpires_in() {
      return expires_in;
    }

    public void setExpires_in(Long expires_in) {
      this.expires_in = expires_in;
    }

    public String getScope() {
      return scope;
    }

    public void setScope(String scope) {
      this.scope = scope;
    }

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getMagicId() {
      return magicId;
    }

    public void setMagicId(String magicId) {
      this.magicId = magicId;
    }

    public Long getRemainderDays() {
      return remainderDays;
    }

    public void setRemainderDays(Long remainderDays) {
      this.remainderDays = remainderDays;
    }

    @Override
    public String toString() {
      return "IccToken{"
          + "access_token='"
          + access_token
          + '\''
          + ", token_type='"
          + token_type
          + '\''
          + ", refresh_token='"
          + refresh_token
          + '\''
          + ", expires_in="
          + expires_in
          + ", scope='"
          + scope
          + '\''
          + ", userId='"
          + userId
          + '\''
          + ", magicId='"
          + magicId
          + '\''
          + ", remainderDays="
          + remainderDays
          + '}';
    }
  }
}
