package com.wasu.model.v202010.card;

import com.wasu.http.IccResponse;

/**
 * 卡片详情结果
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmCardQueryResponse extends IccResponse {
  private BrmCardDetail data;

  public BrmCardDetail getData() {
    return data;
  }

  public void setData(BrmCardDetail data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmCardQueryResponse{" + "data=" + data + '}';
  }
}
