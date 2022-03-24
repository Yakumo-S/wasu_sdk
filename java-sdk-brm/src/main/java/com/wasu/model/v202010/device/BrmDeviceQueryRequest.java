package com.wasu.model.v202010.device;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 设备详情查询
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmDeviceQueryRequest extends AbstractIccRequest<BrmDeviceQueryResponse> {

  public BrmDeviceQueryRequest(String deviceCode) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEVICE_DETAIL_GET, deviceCode), Method.GET);
  }

  @Override
  public Class<BrmDeviceQueryResponse> getResponseClass() {
    return BrmDeviceQueryResponse.class;
  }
}
