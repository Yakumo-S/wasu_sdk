package com.wasu.model.v202010.department;

import com.wasu.http.IccResponse;

/**
 * 部门更新返回结果
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmDeptUpdateResponse extends IccResponse {
  private OrganUpdateData data;

  @Override
  public String toString() {
    return "BrmDeptUpdateResponse{" + "data=" + data + '}';
  }

  public OrganUpdateData getData() {
    return data;
  }

  public void setData(OrganUpdateData data) {
    this.data = data;
  }

  public static class OrganUpdateData {
    private Long id;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "OrganUpdateData{" + "id=" + id + '}';
    }
  }
}
