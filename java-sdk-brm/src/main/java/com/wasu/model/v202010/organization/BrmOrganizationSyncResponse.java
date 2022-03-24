package com.wasu.model.v202010.organization;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 组织查询
 *
 * @author 232676
 * @since 1.0.0 2020-11-03 09:59:11
 */
public class BrmOrganizationSyncResponse extends IccResponse {
  private OrgPageData data;
  private int currentPage;
  private int totalPage;
  private int pageSize;
  private int totalRows;

  public OrgPageData getData() {
    return data;
  }

  public void setData(OrgPageData data) {
    this.data = data;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getTotalRows() {
    return totalRows;
  }

  public void setTotalRows(int totalRows) {
    this.totalRows = totalRows;
  }

  @Override
  public String toString() {
    return "BrmOrganizationPageResponse{"
        + "data="
        + data
        + ", currentPage="
        + currentPage
        + ", totalPage="
        + totalPage
        + ", pageSize="
        + pageSize
        + ", totalRows="
        + totalRows
        + '}';
  }

  public static class OrgPageData {
    private List<OrganPageList> pageData;

    public List<OrganPageList> getPageData() {
      return pageData;
    }

    public void setPageData(List<OrganPageList> pageData) {
      this.pageData = pageData;
    }

    @Override
    public String toString() {
      return "OrgPageData{" + "pageData=" + pageData + '}';
    }
  }

  public static class OrganPageList {
    private String service;
    private String id;
    private String orgCode;
    private String orgName;
    private String orgType;
    private int sort;
    private int forbidBindUser;

    public String getService() {
      return service;
    }

    public void setService(String service) {
      this.service = service;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getOrgCode() {
      return orgCode;
    }

    public void setOrgCode(String orgCode) {
      this.orgCode = orgCode;
    }

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

    public int getSort() {
      return sort;
    }

    public void setSort(int sort) {
      this.sort = sort;
    }

    public int getForbidBindUser() {
      return forbidBindUser;
    }

    public void setForbidBindUser(int forbidBindUser) {
      this.forbidBindUser = forbidBindUser;
    }

    @Override
    public String toString() {
      return "OrganQueryData{"
          + "service='"
          + service
          + '\''
          + ", id='"
          + id
          + '\''
          + ", orgCode='"
          + orgCode
          + '\''
          + ", orgName='"
          + orgName
          + '\''
          + ", orgType='"
          + orgType
          + '\''
          + ", sort="
          + sort
          + ", forbidBindUser="
          + forbidBindUser
          + '}';
    }
  }
}
