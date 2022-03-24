package com.wasu.model.v202010.car;

import com.wasu.model.v202010.FieldExt;
import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 车辆全量数据同步结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-05 09:59:11
 */
public class BrmCarSyncResponse extends IccResponse {
  private CarPageList data;
  private int currentPage;
  private int totalPage;
  private int pageSize;
  private int totalRows;

  public CarPageList getData() {
    return data;
  }

  public void setData(CarPageList data) {
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
    return "BrmCarSyncResponse{" + "data=" + data + '}';
  }

  public static class CarPageList {
    private List<CarSyncData> pageData;

    public List<CarSyncData> getPageData() {
      return pageData;
    }

    public void setPageData(List<CarSyncData> pageData) {
      this.pageData = pageData;
    }
  }

  public static class CarSyncData {
    private Long id;
    private String carCode;
    private String carNum;
    private String carNumColor;
    private String carType;
    private String carBrand;
    private String carColor;
    private Long ownerId;
    private String ownerName;
    private String ownerPhone;
    private Long departmentId;
    private String departmentName;
    private int listType;
    private FieldExt pageFieldExt;

    public String getCarCode() {
      return carCode;
    }

    public void setCarCode(String carCode) {
      this.carCode = carCode;
    }

    public String getCarNum() {
      return carNum;
    }

    public void setCarNum(String carNum) {
      this.carNum = carNum;
    }

    public String getCarNumColor() {
      return carNumColor;
    }

    public void setCarNumColor(String carNumColor) {
      this.carNumColor = carNumColor;
    }

    public String getCarType() {
      return carType;
    }

    public void setCarType(String carType) {
      this.carType = carType;
    }

    public String getCarBrand() {
      return carBrand;
    }

    public void setCarBrand(String carBrand) {
      this.carBrand = carBrand;
    }

    public String getCarColor() {
      return carColor;
    }

    public void setCarColor(String carColor) {
      this.carColor = carColor;
    }

    public Long getOwnerId() {
      return ownerId;
    }

    public void setOwnerId(Long ownerId) {
      this.ownerId = ownerId;
    }

    public String getOwnerName() {
      return ownerName;
    }

    public void setOwnerName(String ownerName) {
      this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
      return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
      this.ownerPhone = ownerPhone;
    }

    public Long getDepartmentId() {
      return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
      this.departmentId = departmentId;
    }

    public String getDepartmentName() {
      return departmentName;
    }

    public void setDepartmentName(String departmentName) {
      this.departmentName = departmentName;
    }

    public int getListType() {
      return listType;
    }

    public void setListType(int listType) {
      this.listType = listType;
    }

    public FieldExt getPageFieldExt() {
      return pageFieldExt;
    }

    public void setPageFieldExt(FieldExt pageFieldExt) {
      this.pageFieldExt = pageFieldExt;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "CarSyncData{"
          + "id="
          + id
          + ", carCode='"
          + carCode
          + '\''
          + ", carNum='"
          + carNum
          + '\''
          + ", carNumColor='"
          + carNumColor
          + '\''
          + ", carType='"
          + carType
          + '\''
          + ", carBrand='"
          + carBrand
          + '\''
          + ", carColor='"
          + carColor
          + '\''
          + ", ownerId="
          + ownerId
          + ", ownerName='"
          + ownerName
          + '\''
          + ", ownerPhone='"
          + ownerPhone
          + '\''
          + ", departmentId="
          + departmentId
          + ", departmentName='"
          + departmentName
          + '\''
          + ", listType="
          + listType
          + ", pageFieldExt="
          + pageFieldExt
          + '}';
    }
  }
}
