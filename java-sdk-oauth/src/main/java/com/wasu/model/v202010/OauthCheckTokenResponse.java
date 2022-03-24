package com.wasu.model.v202010;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthCheckTokenResponse extends IccResponse {
  private CheckTokenData data;

  public CheckTokenData getData() {
    return data;
  }

  public void setData(CheckTokenData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "OauthCheckTokenResponse{" + "data=" + data + '}';
  }

  public static class CheckTokenData {
    /** 心跳token */
    private String magicId;

    private String user_name;
    /** 全新作用域，垂直越权在网关做，目前都为"*" */
    private List<String> scope;
    /** 是否活动状态 */
    private boolean active;

    private Long exp;
    private String userId;
    private String client_id;

    public String getMagicId() {
      return magicId;
    }

    public void setMagicId(String magicId) {
      this.magicId = magicId;
    }

    public String getUser_name() {
      return user_name;
    }

    public void setUser_name(String user_name) {
      this.user_name = user_name;
    }

    public List<String> getScope() {
      return scope;
    }

    public void setScope(List<String> scope) {
      this.scope = scope;
    }

    public boolean isActive() {
      return active;
    }

    public void setActive(boolean active) {
      this.active = active;
    }

    public Long getExp() {
      return exp;
    }

    public void setExp(Long exp) {
      this.exp = exp;
    }

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getClient_id() {
      return client_id;
    }

    public void setClient_id(String client_id) {
      this.client_id = client_id;
    }

    @Override
    public String toString() {
      return "CheckTokenData{"
          + "magicId='"
          + magicId
          + '\''
          + ", user_name='"
          + user_name
          + '\''
          + ", scope="
          + scope
          + ", active="
          + active
          + ", exp="
          + exp
          + ", userId='"
          + userId
          + '\''
          + ", client_id='"
          + client_id
          + '\''
          + '}';
    }
  }
}
