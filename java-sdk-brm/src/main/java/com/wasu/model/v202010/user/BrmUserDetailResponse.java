package com.wasu.model.v202010.user;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmUserDetailResponse extends IccResponse {
  private UserDetailData data;

  public UserDetailData getData() {
    return data;
  }

  public void setData(UserDetailData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "OauthCheckTokenResponse{" + "data=" + data + '}';
  }

  public static class UserDetailData {

    private Long id;
    private String loginName;
    private String userName;
    private int isReuse;
    private Long personId;
    private String ownerCode;
    private int isOnline;
    private List<String> roleIdList;
    private String isGuide;
    private int isInitialPassword;
    private int privacyProtection;
    private String facePath;
    private String completeImgUrl;
    private boolean passwordStrength;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getLoginName() {
      return loginName;
    }

    public void setLoginName(String loginName) {
      this.loginName = loginName;
    }

    public String getUserName() {
      return userName;
    }

    public void setUserName(String userName) {
      this.userName = userName;
    }

    public int getIsReuse() {
      return isReuse;
    }

    public void setIsReuse(int isReuse) {
      this.isReuse = isReuse;
    }

    public Long getPersonId() {
      return personId;
    }

    public void setPersonId(Long personId) {
      this.personId = personId;
    }

    public String getOwnerCode() {
      return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
      this.ownerCode = ownerCode;
    }

    public int getIsOnline() {
      return isOnline;
    }

    public void setIsOnline(int isOnline) {
      this.isOnline = isOnline;
    }

    public List<String> getRoleIdList() {
      return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
      this.roleIdList = roleIdList;
    }

    public String getIsGuide() {
      return isGuide;
    }

    public void setIsGuide(String isGuide) {
      this.isGuide = isGuide;
    }

    public int getIsInitialPassword() {
      return isInitialPassword;
    }

    public void setIsInitialPassword(int isInitialPassword) {
      this.isInitialPassword = isInitialPassword;
    }

    public int getPrivacyProtection() {
      return privacyProtection;
    }

    public void setPrivacyProtection(int privacyProtection) {
      this.privacyProtection = privacyProtection;
    }

    public String getFacePath() {
      return facePath;
    }

    public void setFacePath(String facePath) {
      this.facePath = facePath;
    }

    public String getCompleteImgUrl() {
      return completeImgUrl;
    }

    public void setCompleteImgUrl(String completeImgUrl) {
      this.completeImgUrl = completeImgUrl;
    }

    public boolean isPasswordStrength() {
      return passwordStrength;
    }

    public void setPasswordStrength(boolean passwordStrength) {
      this.passwordStrength = passwordStrength;
    }

    @Override
    public String toString() {
      return "CheckTokenData{"
          + "id="
          + id
          + ", loginName='"
          + loginName
          + '\''
          + ", userName='"
          + userName
          + '\''
          + ", isReuse="
          + isReuse
          + ", personId="
          + personId
          + ", ownerCode='"
          + ownerCode
          + '\''
          + ", isOnline="
          + isOnline
          + ", roleIdList="
          + roleIdList
          + ", isGuide='"
          + isGuide
          + '\''
          + ", isInitialPassword="
          + isInitialPassword
          + ", privacyProtection="
          + privacyProtection
          + ", facePath='"
          + facePath
          + '\''
          + ", completeImgUrl='"
          + completeImgUrl
          + '\''
          + ", passwordStrength="
          + passwordStrength
          + '}';
    }
  }
}
