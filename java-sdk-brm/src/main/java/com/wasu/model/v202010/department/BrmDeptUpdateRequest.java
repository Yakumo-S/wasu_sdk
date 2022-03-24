package com.wasu.model.v202010.department;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 部门更新-PUT方法，必填字段使用Builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeptUpdateRequest extends AbstractIccRequest<BrmDeptUpdateResponse> {

  private Long id;
  private Long parentId;
  private String name;
  private String memo;
  private DeptOperateLock depOperateLock;
  /** 服务唯一编码 */
  private String service;

  private BrmDeptUpdateRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEPT_UPDATE_PUT), Method.PUT);
    this.id = builder.id;
    this.parentId = builder.parentId;
    this.name = builder.name;
    putBodyParameter("parentId", parentId);
    putBodyParameter("name", name);
    putBodyParameter("id", id);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmDeptUpdateResponse> getResponseClass() {
    return BrmDeptUpdateResponse.class;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
    putBodyParameter("id", id);
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

  public DeptOperateLock getDepOperateLock() {
    return depOperateLock;
  }

  public void setDepOperateLock(DeptOperateLock depOperateLock) {
    this.depOperateLock = depOperateLock;
    putBodyParameter("depOperateLock", depOperateLock);
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
    putBodyParameter("service", service);
  }

  @Override
  public String toString() {
    return "BrmDeptUpdateRequest{"
        + "id="
        + id
        + ", parentId="
        + parentId
        + ", name='"
        + name
        + '\''
        + ", memo='"
        + memo
        + '\''
        + ", depOperateLock="
        + depOperateLock
        + ", service='"
        + service
        + '\''
        + '}';
  }

  public static class Builder {
    private Long id;
    private Long parentId;
    private String name;

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder parentId(Long parentId) {
      this.parentId = parentId;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public BrmDeptUpdateRequest build() throws ClientException {
      return new BrmDeptUpdateRequest(this);
    }
  }
}
