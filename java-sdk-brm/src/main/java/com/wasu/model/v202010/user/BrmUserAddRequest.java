package com.wasu.model.v202010.user;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 用户详情查看
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmUserAddRequest extends AbstractIccRequest<BrmUserAddResponse> {

  /** 登录用户名 */
  private String loginName;
  /** 所属组织编码 */
  private String ownerCode;
  /** 0 不复用 1 复用 */
  private Integer isReuse;
  /** 关联人员ID */
  private Long personId;
  /** 用户关联角色 */
  private List<Long> roleIdList;

  private BrmUserAddRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_USER_ADD_POST), Method.POST);
    this.loginName = builder.loginName;
    this.ownerCode = builder.ownerCode;
    this.isReuse = builder.isReuse;
    this.personId = builder.personId;
    this.roleIdList = builder.roleIdList;
    putBodyParameter("loginName", loginName);
    putBodyParameter("ownerCode", ownerCode);
    putBodyParameter("isReuse", isReuse);
    putBodyParameter("personId", personId);
    putBodyParameter("roleIdList", roleIdList);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmUserAddResponse> getResponseClass() {
    return BrmUserAddResponse.class;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
    putBodyParameter("loginName", loginName);
  }

  public String getOwnerCode() {
    return ownerCode;
  }

  public void setOwnerCode(String ownerCode) {
    this.ownerCode = ownerCode;
    putBodyParameter("ownerCode", ownerCode);
  }

  public Integer getIsReuse() {
    return isReuse;
  }

  public void setIsReuse(Integer isReuse) {
    this.isReuse = isReuse;
    putBodyParameter("isReuse", isReuse);
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
    putBodyParameter("personId", personId);
  }

  public List<Long> getRoleIdList() {
    return roleIdList;
  }

  public void setRoleIdList(List<Long> roleIdList) {
    this.roleIdList = roleIdList;
    putBodyParameter("roleIdList", roleIdList);
  }

  @Override
  public String toString() {
    return "BrmUserAddRequest{" +
            "loginName='" + loginName + '\'' +
            ", ownerCode='" + ownerCode + '\'' +
            ", isReuse=" + isReuse +
            ", personId=" + personId +
            ", roleIdList=" + roleIdList +
            '}';
  }

  public static class Builder {
    /** 登录用户名 */
    private String loginName;
    /** 所属组织编码 */
    private String ownerCode;
    /** 0 不复用 1 复用 */
    private Integer isReuse;
    /** 关联人员ID */
    private Long personId;
    /** 用户关联角色 */
    private List<Long> roleIdList;

    public Builder loginName(String loginName) {
      this.loginName = loginName;
      return this;
    }

    public Builder ownerCode(String ownerCode) {
      this.ownerCode = ownerCode;
      return this;
    }

    public Builder personId(Long personId) {
      this.personId = personId;
      return this;
    }

    /**
     * 是否复用
     *
     * @param isReuse 0不复用，1复用
     * @return Builder
     */
    public Builder isReuse(Integer isReuse) {
      this.isReuse = isReuse;
      return this;
    }

    public Builder roleIdList(List<Long> roleIdList) {
      this.roleIdList = roleIdList;
      return this;
    }

    public BrmUserAddRequest build() throws ClientException {
      return new BrmUserAddRequest(this);
    }
  }
}
