package com.wasu.model.v202010.department;

import com.wasu.http.IccResponse;

/**
 * 部门详情查询结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-05 09:59:11
 */
public class BrmDeptQueryResponse extends IccResponse {
  private DeptPageData data;

  public DeptPageData getData() {
    return data;
  }

  public void setData(DeptPageData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmDeptQueryResponse{" + "data=" + data + '}';
  }

  public static class DeptPageData {
    private Long id;
    private Long parentId;
    private String name;
    private String memo;
    private int sort;
    private String service;

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

    public String getService() {
      return service;
    }

    public void setService(String service) {
      this.service = service;
    }

    @Override
    public String toString() {
      return "DeptPageData{"
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
          + ", service='"
          + service
          + '\''
          + '}';
    }
  }
}
