package com.wasu.model.v202010.department;

import com.wasu.http.IccResponse;

/**
 * 部门新增返回结果
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeptAddResponse extends IccResponse {
  private DeptAddData data;

  public DeptAddData getData() {
    return data;
  }

  public void setData(DeptAddData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmDeptAddResponse{" + "data=" + data + '}';
  }

  public static class DeptAddData {
    private Long id;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "DeptAddData{" + "id=" + id + '}';
    }
  }
}
