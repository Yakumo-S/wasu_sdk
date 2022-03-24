package com.dahuatech.icc.hrms.model.v202011.block;

import com.dahuatech.icc.oauth.http.IccResponse;

/**
 * @author 232676
 * @since 1.0.0 2020/11/2 16:07
 */
public class BlockAddResponse extends IccResponse {
  /** 小区ID */
  private String data;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BlockAddResponse{" + "data='" + data + '\'' + '}';
  }
}
