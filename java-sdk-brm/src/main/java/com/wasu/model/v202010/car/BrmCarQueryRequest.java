package com.wasu.model.v202010.car;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 部门新增
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmCarQueryRequest extends AbstractIccRequest<BrmCarQueryResponse> {

  public BrmCarQueryRequest(String carCode) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CAR_DETAIL_REST_GET, carCode), Method.GET);
  }

  @Override
  public Class<BrmCarQueryResponse> getResponseClass() {
    return BrmCarQueryResponse.class;
  }
}
