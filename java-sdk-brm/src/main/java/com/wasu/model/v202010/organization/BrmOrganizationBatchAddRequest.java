package com.wasu.model.v202010.organization;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 组织批量新增，必填字段使用Builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/3 11:22
 */
public class BrmOrganizationBatchAddRequest
    extends AbstractIccRequest<BrmOrganizationBatchAddResponse> {

  /** 服务唯一编码 */
  private String service;

  private List<OrgBath> orgList;

  private BrmOrganizationBatchAddRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_ORGAN_BATCH_ADD_POST), Method.POST);
    this.orgList = builder.orgList;
    putBodyParameter("orgList", orgList);
  }

  public static BrmOrganizationBatchAddRequest.Builder builder() {
    return new BrmOrganizationBatchAddRequest.Builder();
  }

  @Override
  public Class<BrmOrganizationBatchAddResponse> getResponseClass() {
    return BrmOrganizationBatchAddResponse.class;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    putBodyParameter("service", service);
    this.service = service;
  }

  public List<OrgBath> getOrgList() {
    return orgList;
  }

  public void setOrgList(List<OrgBath> orgList) {
    putBodyParameter("orgList", orgList);
    this.orgList = orgList;
  }

  @Override
  public String toString() {
    return "BrmOrganizationBatchAddRequest{"
        + "service='"
        + service
        + '\''
        + ", orgList="
        + orgList
        + '}';
  }

  public static class OrgBath {

    /** 组织名称 */
    private String orgName;
    /** 组织类型唯一编码 */
    private String orgType;

    private OperateLock operateLock;
    /*--------以上必填-----*/
    /** 上级组织编码 */
    private String orgPreCode;
    /** 组织唯一标识码 */
    private String orgSn;
    /** 省 */
    private String province;
    /** 城市 */
    private String city;
    /** 县/小区 */
    private String county;
    /** 0：设置组织可以绑定用户， 1 ：锁定组织不可绑定用户 */
    private int forbidBindUser;

    public String getOrgName() {
      return orgName;
    }

    public void setOrgName(String orgName) {
      this.orgName = orgName;
    }

    public String getOrgType() {
      return orgType;
    }

    public void setOrgType(String orgType) {
      this.orgType = orgType;
    }

    public OperateLock getOperateLock() {
      return operateLock;
    }

    public void setOperateLock(OperateLock operateLock) {
      this.operateLock = operateLock;
    }

    public String getOrgPreCode() {
      return orgPreCode;
    }

    public void setOrgPreCode(String orgPreCode) {
      this.orgPreCode = orgPreCode;
    }

    public String getOrgSn() {
      return orgSn;
    }

    public void setOrgSn(String orgSn) {
      this.orgSn = orgSn;
    }

    public String getProvince() {
      return province;
    }

    public void setProvince(String province) {
      this.province = province;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getCounty() {
      return county;
    }

    public void setCounty(String county) {
      this.county = county;
    }

    public int getForbidBindUser() {
      return forbidBindUser;
    }

    public void setForbidBindUser(int forbidBindUser) {
      this.forbidBindUser = forbidBindUser;
    }
  }

  public static class Builder {
    private List<OrgBath> orgList;

    public Builder orgList(List<OrgBath> orgList) {
      this.orgList = orgList;
      return this;
    }

    public BrmOrganizationBatchAddRequest build() throws ClientException {
      return new BrmOrganizationBatchAddRequest(this);
    }
  }
}
