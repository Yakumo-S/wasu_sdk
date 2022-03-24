package com.wasu.model.v202010.device;

import com.wasu.http.IccResponse;

/**
 * 设备详情查看结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-03 09:59:11
 */
public class BrmDeviceQueryResponse extends IccResponse {
  private BrmDevice data;

  public BrmDevice getData() {
    return data;
  }

  public void setData(BrmDevice data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmDeviceQueryResponse{" + "data=" + data + '}';
  }
}
