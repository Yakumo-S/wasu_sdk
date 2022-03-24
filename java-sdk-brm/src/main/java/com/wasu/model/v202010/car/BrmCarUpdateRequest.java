package com.wasu.model.v202010.car;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.model.v202010.FieldExt;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 车辆新增
 *
 * @author 232676
 * @since 1.0.0 2020/11/6 10:00
 */
public class BrmCarUpdateRequest extends AbstractIccRequest<BrmCarUpdateResponse> {

  /** 部门ID */
  private Long departmentId;
  /***
   * 车牌
   */
  private String carNum;
  /** 车辆编号 若子系统同步到brm则由子系统生成，管理端新增则由brm生成uuid */
  private String carCode;
  /** 车牌颜色 */
  private String carNumColor;
  /** 汽车类型 */
  private String carType;
  /** 汽车品牌 */
  private String carBrand;
  /** 部门名称 */
  private String departmentName;
  /** 车主ID */
  private Long ownerId;
  /** 子系统服务名 */
  private String service;
  /** 车辆删除限制 子系统使用 对车辆删除限制 1为增加限制 2为删除限制 */
  private Integer deleteAuth;
  /** 车辆修改限制 子系统使用 对车辆修改限制 1为增加限制 2为删除限制 */
  private Integer updateAuth;
  /** 自定义字段 自定义字段信息 */
  private FieldExt fieldExt;

  public BrmCarUpdateRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CAR_UPDATE_PUT), Method.PUT);
  }

  private BrmCarUpdateRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CAR_UPDATE_PUT), Method.PUT);
    this.departmentId = builder.departmentId;
    this.carNum = builder.carNum;
    this.carCode = builder.carCode;
    putBodyParameter("departmentId", departmentId);
    putBodyParameter("carNum", carNum);
    putBodyParameter("carCode", carCode);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmCarUpdateResponse> getResponseClass() {
    return BrmCarUpdateResponse.class;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    putBodyParameter("departmentId", departmentId);
  }

  public String getCarNum() {
    return carNum;
  }

  public void setCarNum(String carNum) {
    this.carNum = carNum;
    putBodyParameter("carNum", carNum);
  }

  public String getCarCode() {
    return carCode;
  }

  public void setCarCode(String carCode) {
    this.carCode = carCode;
    putBodyParameter("carCode", carCode);
  }

  public String getCarNumColor() {
    return carNumColor;
  }

  public void setCarNumColor(String carNumColor) {
    this.carNumColor = carNumColor;
    putBodyParameter("carNumColor", carNumColor);
  }

  public String getCarType() {
    return carType;
  }

  public void setCarType(String carType) {
    this.carType = carType;
    putBodyParameter("carType", carType);
  }

  public String getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(String carBrand) {
    this.carBrand = carBrand;
    putBodyParameter("carBrand", carBrand);
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
    putBodyParameter("departmentName", departmentName);
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
    putBodyParameter("ownerId", ownerId);
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
    putBodyParameter("service", service);
  }

  public Integer getDeleteAuth() {
    return deleteAuth;
  }

  public void setDeleteAuth(Integer deleteAuth) {
    this.deleteAuth = deleteAuth;
    putBodyParameter("deleteAuth", deleteAuth);
  }

  public Integer getUpdateAuth() {
    return updateAuth;
  }

  public void setUpdateAuth(Integer updateAuth) {
    this.updateAuth = updateAuth;
    putBodyParameter("updateAuth", updateAuth);
  }

  public FieldExt getFieldExt() {
    return fieldExt;
  }

  public void setFieldExt(FieldExt fieldExt) {
    this.fieldExt = fieldExt;
    putBodyParameter("fieldExt", fieldExt);
  }

  public static class Builder {
    /** 部门ID */
    private Long departmentId;
    /** 车牌 */
    private String carNum;

    private String carCode;

    public Builder carCode(String carCode) {
      this.carCode = carCode;
      return this;
    }

    public Builder carNum(String carNum) {
      this.carNum = carNum;
      return this;
    }

    public Builder departmentId(Long departmentId) {
      this.departmentId = departmentId;
      return this;
    }

    public BrmCarUpdateRequest build() throws ClientException {
      return new BrmCarUpdateRequest(this);
    }
  }
}
