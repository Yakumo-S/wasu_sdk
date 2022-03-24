package com.wasu.model.v202010.person;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 人员删除
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonDelRequest extends AbstractIccRequest<BrmPersonDelResponse> {

  private List<Long> ids;

  private BrmPersonDelRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_DEL_POST), Method.POST);
    this.ids = builder.ids;
    putBodyParameter("ids", ids);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmPersonDelResponse> getResponseClass() {
    return BrmPersonDelResponse.class;
  }

  public List<Long> getIds() {
    return ids;
  }

  public void setIds(List<Long> ids) {
    this.ids = ids;
    putBodyParameter("ids", ids);
  }

  public static class Builder {
    private List<Long> ids;

    public Builder ids(List<Long> ids) {
      this.ids = ids;
      return this;
    }

    public BrmPersonDelRequest build() throws ClientException {
      return new BrmPersonDelRequest(this);
    }
  }
}
