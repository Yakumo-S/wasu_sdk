package com.wasu.model.v202010.car;

import com.wasu.model.v202010.FieldExt;
import com.wasu.http.IccResponse;

/**
 * 车辆详情查询结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-05 09:59:11
 */
public class BrmCarQueryResponse extends IccResponse {
  private CarQueryData data;

  public CarQueryData getData() {
    return data;
  }

  public void setData(CarQueryData data) {
    this.data = data;
  }

  public static class CarQueryData {
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
    private FieldExt fieldExt;

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

    public FieldExt getFieldExt() {
      return fieldExt;
    }

    public void setFieldExt(FieldExt fieldExt) {
      this.fieldExt = fieldExt;
    }

    @Override
    public String toString() {
      return "CarQueryData{"
          + "carCode='"
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
          + ", fieldExt="
          + fieldExt
          + '}';
    }
  }
}
