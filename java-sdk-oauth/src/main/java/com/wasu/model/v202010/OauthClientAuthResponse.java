package com.wasu.model.v202010;

import com.wasu.http.IotResponse;

/**
 * 客户端认证授权
 *
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthClientAuthResponse extends IotResponse {
  private IccClientToken data;

  public IccClientToken getData() {
    return data;
  }

  public void setData(IccClientToken data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "OauthClientAuthResponse{" + "data=" + data + '}';
  }

  public static class IccClientToken {
    private String access_token;
    private String token_type;
    private Long expires_in;
    private String scope;
    private String magicId;

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

    public String getMagicId() {
      return magicId;
    }

    public void setMagicId(String magicId) {
      this.magicId = magicId;
    }

    @Override
    public String toString() {
      return "IccClientToken{"
          + "access_token='"
          + access_token
          + '\''
          + ", token_type='"
          + token_type
          + '\''
          + ", expires_in="
          + expires_in
          + ", scope='"
          + scope
          + '\''
          + ", magicId='"
          + magicId
          + '\''
          + '}';
    }
  }
}
