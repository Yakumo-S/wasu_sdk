package com.wasu.model.v202010.person;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 车辆全量数据同步结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-05 09:59:11
 */
public class BrmPersonSyncResponse extends IccResponse {
  private PersonPageList data;
  private int currentPage;
  private int totalPage;
  private int pageSize;
  private int totalRows;

  public PersonPageList getData() {
    return data;
  }

  public void setData(PersonPageList data) {
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
    return "BrmPersonSyncResponse{"
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

  public static class PersonPageList {
    private List<PersonData> pageData;

    public List<PersonData> getPageData() {
      return pageData;
    }

    public void setPageData(List<PersonData> pageData) {
      this.pageData = pageData;
    }
  }
}
