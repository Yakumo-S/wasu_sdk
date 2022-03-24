package com.wasu.model.v202010.department;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 生成ID返回结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-05 09:59:11
 */
public class BrmDeptGenIdResponse extends IccResponse {
  private DeptPageData data;

  public DeptPageData getData() {
    return data;
  }

  public void setData(DeptPageData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmDeptGenIdResponse{" + "data=" + data + '}';
  }

  public static class DeptPageData {
    private List<Long> idList;

    public List<Long> getIdList() {
      return idList;
    }

    public void setIdList(List<Long> idList) {
      this.idList = idList;
    }

    @Override
    public String toString() {
      return "DeptPageData{" + "idList=" + idList + '}';
    }
  }
}
