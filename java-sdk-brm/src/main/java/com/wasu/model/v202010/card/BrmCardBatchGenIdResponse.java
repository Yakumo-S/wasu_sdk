package com.wasu.model.v202010.card;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 生成ID返回结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-05 09:59:11
 */
public class BrmCardBatchGenIdResponse extends IccResponse {
  private IdsResponse data;

  @Override
  public String toString() {
    return "BrmCardBatchGenIdResponse{" + "data=" + data + '}';
  }

  public IdsResponse getData() {
    return data;
  }

  public void setData(IdsResponse data) {
    this.data = data;
  }

  public static class IdsResponse {
    private List<Long> idList;

    public List<Long> getIdList() {
      return idList;
    }

    public void setIdList(List<Long> idList) {
      this.idList = idList;
    }

    @Override
    public String toString() {
      return "IdsResponse{" + "idList=" + idList + '}';
    }
  }
}
