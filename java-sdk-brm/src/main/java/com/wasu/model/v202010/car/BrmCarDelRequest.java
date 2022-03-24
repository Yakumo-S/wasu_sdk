package com.wasu.model.v202010.car;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 车辆删除（可批量）
 *
 * @author 232676
 * @since 1.0.0 2020/11/6 10:00
 */
public class BrmCarDelRequest extends AbstractIccRequest<BrmCarDelResponse> {

  /** 车牌号数组 */
  private List<String> carNumList;
  /** 车辆编号数组 */
  private List<String> carCodeList;
  /** 子系统服务名 */
  private String service;

  private BrmCarDelRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CAR_DELETE_POST), Method.POST);
    this.carNumList = builder.carNumList;
    this.carCodeList = builder.carCodeList;
    putBodyParameter("carCodeList", carCodeList);
    putBodyParameter("carNumList", carNumList);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmCarDelResponse> getResponseClass() {
    return BrmCarDelResponse.class;
  }

  public List<String> getCarNumList() {
    return carNumList;
  }

  public void setCarNumList(List<String> carNumList) {
    this.carNumList = carNumList;
    putBodyParameter("carNumList", carNumList);
  }

  public List<String> getCarCodeList() {
    return carCodeList;
  }

  public void setCarCodeList(List<String> carCodeList) {
    this.carCodeList = carCodeList;
    putBodyParameter("carCodeList", carCodeList);
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
    putBodyParameter("service", service);
  }

  public static class Builder {
    /** 车牌号数组 */
    private List<String> carNumList;
    /** 车辆编号数组 */
    private List<String> carCodeList;

    public Builder carNumList(List<String> carNumList) {
      this.carNumList = carNumList;
      return this;
    }

    public Builder carCodeList(List<String> carCodeList) {
      this.carCodeList = carCodeList;
      return this;
    }

    public BrmCarDelRequest build() throws ClientException {
      return new BrmCarDelRequest(this);
    }
  }
}
