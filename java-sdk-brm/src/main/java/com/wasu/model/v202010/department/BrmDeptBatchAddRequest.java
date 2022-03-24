package com.wasu.model.v202010.department;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 批量添加部门，必填字段使用builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/3 11:22
 */
public class BrmDeptBatchAddRequest extends AbstractIccRequest<BrmDeptBatchAddResponse> {

  /** 批量添加部门信息 */
  private List<DeptInfo> departmentList;

  private BrmDeptBatchAddRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEPT_BATCH_ADD_POST), Method.POST);
    this.departmentList = builder.departmentList;
    putBodyParameter("departmentList", departmentList);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmDeptBatchAddResponse> getResponseClass() {
    return BrmDeptBatchAddResponse.class;
  }

  public List<DeptInfo> getDepartmentList() {
    return departmentList;
  }

  public void setDepartmentList(List<DeptInfo> departmentList) {
    this.departmentList = departmentList;
  }

  @Override
  public String toString() {
    return "BrmDeptBatchAddRequest{" + "departmentList=" + departmentList + '}';
  }

  public static class DeptInfo {
    private Long id;
    private Long parentId;
    private String name;
    private String memo;
    private DeptOperateLock depOperateLock;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Long getParentId() {
      return parentId;
    }

    public void setParentId(Long parentId) {
      this.parentId = parentId;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getMemo() {
      return memo;
    }

    public void setMemo(String memo) {
      this.memo = memo;
    }

    public DeptOperateLock getDepOperateLock() {
      return depOperateLock;
    }

    public void setDepOperateLock(DeptOperateLock depOperateLock) {
      this.depOperateLock = depOperateLock;
    }
  }

  public static class Builder {
    private List<DeptInfo> departmentList;

    public Builder departmentList(List<DeptInfo> departmentList) {
      this.departmentList = departmentList;
      return this;
    }

    public BrmDeptBatchAddRequest build() throws ClientException {
      return new BrmDeptBatchAddRequest(this);
    }
  }
}
