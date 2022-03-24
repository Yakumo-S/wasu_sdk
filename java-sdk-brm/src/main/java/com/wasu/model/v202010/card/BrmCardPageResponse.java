package com.wasu.model.v202010.card;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 部门分页查询结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-03 09:59:11
 */
public class BrmCardPageResponse extends IccResponse {
  private CardPageData data;
  private int currentPage;
  private int totalPage;
  private int pageSize;
  private int totalRows;

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

  public CardPageData getData() {
    return data;
  }

  public void setData(CardPageData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmCardPageResponse{"
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

  public static class CardPageData {
    private List<BrmCardPageDetail> pageData;

    public List<BrmCardPageDetail> getPageData() {
      return pageData;
    }

    public void setPageData(List<BrmCardPageDetail> pageData) {
      this.pageData = pageData;
    }

    @Override
    public String toString() {
      return "CardPageData{" + "pageData=" + pageData + '}';
    }
  }
}
