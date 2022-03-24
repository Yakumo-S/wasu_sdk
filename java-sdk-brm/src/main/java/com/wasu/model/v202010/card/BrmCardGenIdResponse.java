package com.wasu.model.v202010.card;

import com.wasu.http.IccResponse;

/**
 * 生成ID返回结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-05 09:59:11
 */
public class BrmCardGenIdResponse extends IccResponse {
  private IdResponse data;

  public IdResponse getData() {
    return data;
  }

  public void setData(IdResponse data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmCardGenIdResponse{" + "data=" + data + '}';
  }
}
