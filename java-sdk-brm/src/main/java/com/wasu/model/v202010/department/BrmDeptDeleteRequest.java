package com.wasu.model.v202010.department;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 组织删除,method=delete，必填字段使用Builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/3 11:22
 */
public class BrmDeptDeleteRequest extends AbstractIccRequest<BrmDeptDeleteResponse> {

  /** 部门Id */
  private Long id;
  /** 服务名 */
  private String service;

  private BrmDeptDeleteRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEPT_DEL_DELETE), Method.DELETE);
    this.id = builder.id;
    this.service = builder.service;
    putBodyParameter("service", service);
    putBodyParameter("id", id);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmDeptDeleteResponse> getResponseClass() {
    return BrmDeptDeleteResponse.class;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  @Override
  public String toString() {
    return "BrmDeptDeleteRequest{" + "id=" + id + ", service='" + service + '\'' + '}';
  }

  public static class Builder {
    /** 部门Id */
    private Long id;
    /** 服务名 */
    private String service;

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder service(String service) {
      this.service = service;
      return this;
    }

    @Override
    public String toString() {
      return "Builder{" + "id=" + id + ", service='" + service + '\'' + '}';
    }

    public BrmDeptDeleteRequest build() throws ClientException {
      return new BrmDeptDeleteRequest(this);
    }
  }
}
