package com.wasu.model.v202010.card;

import com.wasu.http.IccResponse;

/**
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmCardAddResponse extends IccResponse {
  private IdResponse data;

  public IdResponse getData() {
    return data;
  }

  public void setData(IdResponse data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmCardAddResponse{" + "data=" + data + '}';
  }
}
