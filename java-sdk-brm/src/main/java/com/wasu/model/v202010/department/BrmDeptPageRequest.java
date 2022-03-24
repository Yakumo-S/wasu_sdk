package com.wasu.model.v202010.department;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 部门分页查询
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeptPageRequest extends AbstractIccRequest<BrmDeptPageResponse> {

  private Long parentId;
  private String containerLower;
  private List<Long> departmentIds;
  private List<String> departmentSns;
  private int pageNum;
  private int pageSize;
  private String searchKey;

  public BrmDeptPageRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEPT_PAGE_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
    putBodyParameter("searchKey", "");
  }

  @Override
  public Class<BrmDeptPageResponse> getResponseClass() {
    return BrmDeptPageResponse.class;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
    putBodyParameter("parentId", parentId);
  }

  public String getContainerLower() {
    return containerLower;
  }

  public void setContainerLower(String containerLower) {
    this.containerLower = containerLower;
    putBodyParameter("containerLower", containerLower);
  }

  public List<Long> getDepartmentIds() {
    return departmentIds;
  }

  public void setDepartmentIds(List<Long> departmentIds) {
    this.departmentIds = departmentIds;
    putBodyParameter("departmentIds", departmentIds);
  }

  public List<String> getDepartmentSns() {
    return departmentSns;
  }

  public void setDepartmentSns(List<String> departmentSns) {
    this.departmentSns = departmentSns;
    putBodyParameter("departmentSns", departmentSns);
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    putBodyParameter("pageNum", pageNum);
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    putBodyParameter("pageSize", pageSize);
  }

  public String getSearchKey() {
    return searchKey;
  }

  public void setSearchKey(String searchKey) {
    this.searchKey = searchKey;
    putBodyParameter("searchKey", searchKey);
  }
}
