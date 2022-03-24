package com.wasu.model.v202010.organization;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 组织新增，必填字段使用Builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/3 11:22
 */
public class BrmOrganizationAddRequest extends AbstractIccRequest<BrmOrganizationAddResponse> {

  /** 组织名称 */
  private String orgName;
  /** 组织类型唯一编码 */
  private String orgType;

  private OperateLock operateLock;
  /** 上级组织编码 */
  private String orgPreCode;
  /** 组织唯一标识码 */
  private String orgSn;
  /*--------以上必填-----*/
  /** 省 */
  private String province;
  /** 城市 */
  private String city;
  /** 县/小区 */
  private String county;
  /** 0：设置组织可以绑定用户， 1 ：锁定组织不可绑定用户 */
  private int forbidBindUser;
  /** 服务唯一编码 */
  private String service;

  private BrmOrganizationAddRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_ORGAN_ADD_POST), Method.POST);
    this.orgName = builder.orgName;
    this.orgPreCode = builder.orgPreCode;
    this.orgType = builder.orgType;
    this.operateLock = builder.operateLock;
    putBodyParameter("orgName", orgName);
    putBodyParameter("orgType", orgType);
    putBodyParameter("operateLock", operateLock);
    putBodyParameter("orgPreCode", orgPreCode);
  }

  public static BrmOrganizationAddRequest.Builder builder() {
    return new BrmOrganizationAddRequest.Builder();
  }

  @Override
  public Class<BrmOrganizationAddResponse> getResponseClass() {
    return BrmOrganizationAddResponse.class;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    putBodyParameter("orgName", orgName);
    this.orgName = orgName;
  }

  public String getOrgPreCode() {
    return orgPreCode;
  }

  public void setOrgPreCode(String orgPreCode) {
    putBodyParameter("orgPreCode", orgPreCode);
    this.orgPreCode = orgPreCode;
  }

  public String getOrgSn() {
    return orgSn;
  }

  public void setOrgSn(String orgSn) {
    putBodyParameter("orgSn", orgSn);
    this.orgSn = orgSn;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    putBodyParameter("province", province);
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    putBodyParameter("city", city);
    this.city = city;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    putBodyParameter("county", county);
    this.county = county;
  }

  public int getForbidBindUser() {
    return forbidBindUser;
  }

  public void setForbidBindUser(int forbidBindUser) {
    putBodyParameter("forbidBindUser", forbidBindUser);
    this.forbidBindUser = forbidBindUser;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    putBodyParameter("service", service);
    this.service = service;
  }

  public String getOrgType() {
    return orgType;
  }

  public void setOrgType(String orgType) {
    putBodyParameter("orgType", orgType);
    this.orgType = orgType;
  }

  public OperateLock getOperateLock() {
    return operateLock;
  }

  public void setOperateLock(OperateLock operateLock) {
    putBodyParameter("operateLock", operateLock);
    this.operateLock = operateLock;
  }

  public static class Builder {
    private String orgName;
    private String orgPreCode;
    private String orgType;
    private OperateLock operateLock;

    public Builder orgName(String orgName) {
      this.orgName = orgName;
      return this;
    }

    public Builder orgPreCode(String orgPreCode) {
      this.orgPreCode = orgPreCode;
      return this;
    }

    public Builder orgType(String orgType) {
      this.orgType = orgType;
      return this;
    }

    public Builder operateLock(OperateLock operateLock) {
      this.operateLock = operateLock;
      return this;
    }

    public BrmOrganizationAddRequest build() throws ClientException {
      return new BrmOrganizationAddRequest(this);
    }
  }
}
