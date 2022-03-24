package com.wasu.model.v202010.car;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 车辆分页查询
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmCarPageRequest extends AbstractIccRequest<BrmCarPageResponse> {

  private int pageNum;
  private int pageSize;
  private String sort;
  /** . 车牌列表 列表最大支持500 */
  private List<String> carNumList;
  /** 车牌颜色列表 列表最大支持500 */
  private List<String> carNumColorList;
  /** 车辆编号列表 列表最大支持500 */
  private List<String> carCodeList;
  /** 车辆归属车主ID列表 列表最大支持500 */
  private List<String> ownerIdList;
  /** 汽车颜色列表 列表最大支持500 */
  private List<String> carColorList;
  /** 车辆类型列表 列表最大支持500 */
  private List<String> carTypeList;
  /** 车辆品牌列表 列表最大支持500 */
  private List<String> carBrandList;
  /** 车辆归属主部门id */
  private Long departmentId;
  /** includeSubDepartmentFlag */
  private boolean includeSubDepartmentFlag;

  public BrmCarPageRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CAR_PAGE_POST), Method.POST);
    putBodyParameter("pageNum", 1);
    putBodyParameter("pageSize", 10);
  }

  @Override
  public Class<BrmCarPageResponse> getResponseClass() {
    return BrmCarPageResponse.class;
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    putBodyParameter("pageNum", pageNum);
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    putBodyParameter("pageSize", pageSize);
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
    putBodyParameter("sort", sort);
  }

  public List<String> getCarNumList() {
    return carNumList;
  }

  public void setCarNumList(List<String> carNumList) {
    this.carNumList = carNumList;
    putBodyParameter("carNumList", carNumList);
  }

  public List<String> getCarNumColorList() {
    return carNumColorList;
  }

  public void setCarNumColorList(List<String> carNumColorList) {
    this.carNumColorList = carNumColorList;
    putBodyParameter("carNumColorList", carNumColorList);
  }

  public List<String> getCarCodeList() {
    return carCodeList;
  }

  public void setCarCodeList(List<String> carCodeList) {
    this.carCodeList = carCodeList;
    putBodyParameter("carCodeList", carCodeList);
  }

  public List<String> getOwnerIdList() {
    return ownerIdList;
  }

  public void setOwnerIdList(List<String> ownerIdList) {
    this.ownerIdList = ownerIdList;
    putBodyParameter("ownerIdList", ownerIdList);
  }

  public List<String> getCarColorList() {
    return carColorList;
  }

  public void setCarColorList(List<String> carColorList) {
    this.carColorList = carColorList;
    putBodyParameter("carColorList", carColorList);
  }

  public List<String> getCarTypeList() {
    return carTypeList;
  }

  public void setCarTypeList(List<String> carTypeList) {
    this.carTypeList = carTypeList;
    putBodyParameter("carTypeList", carTypeList);
  }

  public List<String> getCarBrandList() {
    return carBrandList;
  }

  public void setCarBrandList(List<String> carBrandList) {
    this.carBrandList = carBrandList;
    putBodyParameter("carBrandList", carBrandList);
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    putBodyParameter("departmentId", departmentId);
  }

  public boolean isIncludeSubDepartmentFlag() {
    return includeSubDepartmentFlag;
  }

  public void setIncludeSubDepartmentFlag(boolean includeSubDepartmentFlag) {
    this.includeSubDepartmentFlag = includeSubDepartmentFlag;
    putBodyParameter("includeSubDepartmentFlag", includeSubDepartmentFlag);
  }
}
