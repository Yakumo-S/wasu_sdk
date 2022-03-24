package com.wasu.model.v202010.department;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 部门新增，必填字段使用Builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeptAddRequest extends AbstractIccRequest<BrmDeptAddResponse> {

  private Long parentId;
  private String name;
  private String memo;
  private String service;
  private DeptOperateLock depOperateLock;

  private BrmDeptAddRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEPT_ADD_POST), Method.POST);
    this.parentId = builder.parentId;
    this.name = builder.name;
    putBodyParameter("parentId", parentId);
    putBodyParameter("name", name);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmDeptAddResponse> getResponseClass() {
    return BrmDeptAddResponse.class;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
    putBodyParameter("parentId", parentId);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    putBodyParameter("name", name);
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
    putBodyParameter("memo", memo);
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
    putBodyParameter("service", service);
  }

  public DeptOperateLock getDepOperateLock() {
    return depOperateLock;
  }

  public void setDepOperateLock(DeptOperateLock depOperateLock) {
    this.depOperateLock = depOperateLock;
    putBodyParameter("depOperateLock", depOperateLock);
  }

  public static class Builder {
    private Long parentId;
    private String name;

    public Builder parentId(Long parentId) {
      this.parentId = parentId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public BrmDeptAddRequest build() throws ClientException {
      return new BrmDeptAddRequest(this);
    }
  }
}
