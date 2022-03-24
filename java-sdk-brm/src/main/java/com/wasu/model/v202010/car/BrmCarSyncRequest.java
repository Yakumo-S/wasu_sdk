package com.wasu.model.v202010.car;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 车辆全量数据同步
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmCarSyncRequest extends AbstractIccRequest<BrmCarSyncResponse> {

  private int pageSize;
  private int pageNum;
  private String sort;
  private String sortType;
  private String searchKey;
  private List<String> carNumColor;
  private List<String> carBrand;
  private List<String> carColor;
  private List<String> carType;

  public BrmCarSyncRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CAR_SYNC_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
    putBodyParameter("searchKey", "");
  }

  @Override
  public Class<BrmCarSyncResponse> getResponseClass() {
    return BrmCarSyncResponse.class;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    putBodyParameter("pageSize", pageSize);
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    putBodyParameter("pageNum", pageNum);
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
    putBodyParameter("pageNum", pageNum);
  }

  public String getSortType() {
    return sortType;
  }

  public void setSortType(String sortType) {
    this.sortType = sortType;
    putBodyParameter("sortType", sortType);
  }

  public String getSearchKey() {
    return searchKey;
  }

  public void setSearchKey(String searchKey) {
    this.searchKey = searchKey;
    putBodyParameter("searchKey", searchKey);
  }

  public List<String> getCarNumColor() {
    return carNumColor;
  }

  public void setCarNumColor(List<String> carNumColor) {
    this.carNumColor = carNumColor;
    putBodyParameter("carNumColor", carNumColor);
  }

  public List<String> getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(List<String> carBrand) {
    this.carBrand = carBrand;
    putBodyParameter("carBrand", carBrand);
  }

  public List<String> getCarColor() {
    return carColor;
  }

  public void setCarColor(List<String> carColor) {
    this.carColor = carColor;
    putBodyParameter("carColor", carColor);
  }

  public List<String> getCarType() {
    return carType;
  }

  public void setCarType(List<String> carType) {
    this.carType = carType;
    putBodyParameter("carType", carType);
  }
}
