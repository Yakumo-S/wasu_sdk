package com.wasu.model.v202010.person;

import com.wasu.http.IccResponse;

/**
 * 人员详情结果
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonQueryResponse extends IccResponse {
  private PersonData data;

  public PersonData getData() {
    return data;
  }

  public void setData(PersonData data) {
    this.data = data;
  }
}
