package com.wasu.model.v202010.department;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 部门分页查询结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-03 09:59:11
 */
public class BrmDeptPageResponse extends IccResponse {
  private DeptPageData data;
  private int currentPage;
  private int totalPage;
  private int pageSize;
  private int totalRows;

  public DeptPageData getData() {
    return data;
  }

  public void setData(DeptPageData data) {
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

  public static class DeptPageData {
    private List<DeptPageList> pageData;

    public List<DeptPageList> getPageData() {
      return pageData;
    }

    public void setPageData(List<DeptPageList> pageData) {
      this.pageData = pageData;
    }

    @Override
    public String toString() {
      return "DeptPageList{" + "pageData=" + pageData + '}';
    }
  }

  public static class DeptPageList {
    private Long id;
    private Long parentId;
    private String name;
    private String memo;
    private int sort;
    private String parentIds;
    private String domainId;
    private String departmentSn;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Long getParentId() {
      return parentId;
    }

    public void setParentId(Long parentId) {
      this.parentId = parentId;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getMemo() {
      return memo;
    }

    public void setMemo(String memo) {
      this.memo = memo;
    }

    public int getSort() {
      return sort;
    }

    public void setSort(int sort) {
      this.sort = sort;
    }

    public String getParentIds() {
      return parentIds;
    }

    public void setParentIds(String parentIds) {
      this.parentIds = parentIds;
    }

    public String getDomainId() {
      return domainId;
    }

    public void setDomainId(String domainId) {
      this.domainId = domainId;
    }

    public String getDepartmentSn() {
      return departmentSn;
    }

    public void setDepartmentSn(String departmentSn) {
      this.departmentSn = departmentSn;
    }

    @Override
    public String toString() {
      return "DeptPageList{"
          + "id="
          + id
          + ", parentId="
          + parentId
          + ", name='"
          + name
          + '\''
          + ", memo='"
          + memo
          + '\''
          + ", sort="
          + sort
          + ", parentIds='"
          + parentIds
          + '\''
          + ", domainId='"
          + domainId
          + '\''
          + ", departmentSn='"
          + departmentSn
          + '\''
          + '}';
    }
  }
}
