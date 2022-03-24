package com.wasu.model.v202010.organization;

import com.wasu.http.IccResponse;

/**
 * 组织查询
 *
 * @author 232676
 * @since 1.0.0 2020-11-03 09:59:11
 */
public class BrmOrganizationQueryResponse extends IccResponse {
  private OrganQueryData data;

  public OrganQueryData getData() {
    return data;
  }

  public void setData(OrganQueryData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmOrganizationQueryResponse{" + "data=" + data + '}';
  }

  public static class OrganQueryData {
    /** 主键ID */
    private Long id;
    /** 组织编码 */
    private String orgCode;
    /** 组织类型编码 */
    private String orgType;
    /** 组织唯一标识码 */
    private String orgSn;

    private int sort;
    private String province;
    private String city;
    private String country;
    /** 禁止关联用户 */
    private int forbidBindUser;
    /** 禁止绑定用户的服务 */
    private String forbidBindService;

    private String service;
    private String parentCode;
    private String domainId;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getOrgCode() {
      return orgCode;
    }

    public void setOrgCode(String orgCode) {
      this.orgCode = orgCode;
    }

    public String getOrgType() {
      return orgType;
    }

    public void setOrgType(String orgType) {
      this.orgType = orgType;
    }

    public String getOrgSn() {
      return orgSn;
    }

    public void setOrgSn(String orgSn) {
      this.orgSn = orgSn;
    }

    public int getSort() {
      return sort;
    }

    public void setSort(int sort) {
      this.sort = sort;
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

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public int getForbidBindUser() {
      return forbidBindUser;
    }

    public void setForbidBindUser(int forbidBindUser) {
      this.forbidBindUser = forbidBindUser;
    }

    public String getForbidBindService() {
      return forbidBindService;
    }

    public void setForbidBindService(String forbidBindService) {
      this.forbidBindService = forbidBindService;
    }

    public String getService() {
      return service;
    }

    public void setService(String service) {
      this.service = service;
    }

    public String getParentCode() {
      return parentCode;
    }

    public void setParentCode(String parentCode) {
      this.parentCode = parentCode;
    }

    public String getDomainId() {
      return domainId;
    }

    public void setDomainId(String domainId) {
      this.domainId = domainId;
    }

    @Override
    public String toString() {
      return "OrganQueryData{"
          + "id="
          + id
          + ", orgCode='"
          + orgCode
          + '\''
          + ", orgType='"
          + orgType
          + '\''
          + ", orgSn='"
          + orgSn
          + '\''
          + ", sort="
          + sort
          + ", province='"
          + province
          + '\''
          + ", city='"
          + city
          + '\''
          + ", country='"
          + country
          + '\''
          + ", forbidBindUser="
          + forbidBindUser
          + ", forbidBindService='"
          + forbidBindService
          + '\''
          + ", service='"
          + service
          + '\''
          + ", parentCode='"
          + parentCode
          + '\''
          + ", domainId='"
          + domainId
          + '\''
          + '}';
    }
  }
}
