package com.wasu.http;

/**
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class IotTokenResponse extends IotResponse {
  private IccToken data;

  public IccToken getData() {
    return data;
  }

  public void setData(IccToken data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "IccTokenResponse{" + "Data=" + access_token + '}';
  }
  private String access_token;
  private String token_type;
  private String refresh_token;
  private Long expires_in;
  private String scope;
  private String userId;
  private String magicId;
  private Long remainderDays;
  private Long ttl;

  public Long getTtl() {
    return ttl;
  }

  public void setTtl(Long ttl) {
    this.ttl = ttl;
  }

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


  public static class IccToken {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Long expires_in;
    private String scope;
    private String userId;
    private String magicId;
    private Long remainderDays;
    private Long ttl;

    public Long getTtl() {
      return ttl;
    }

    public void setTtl(Long ttl) {
      this.ttl = ttl;
    }

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
          + ", ttl="
          + ttl
          + '}';
    }
  }
}
