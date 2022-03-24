package com.wasu.model.v202010.device;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 设备分页查询结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-03 09:59:11
 */
public class BrmDevicePageResponse extends IccResponse {
  private DevicePageData data;
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

  public DevicePageData getData() {
    return data;
  }

  public void setData(DevicePageData data) {
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

  public static class DevicePageData {
    private List<BrmDevice> pageData;

    public List<BrmDevice> getPageData() {
      return pageData;
    }

    public void setPageData(List<BrmDevice> pageData) {
      this.pageData = pageData;
    }

    @Override
    public String toString() {
      return "CardPageData{" + "pageData=" + pageData + '}';
    }
  }
}
