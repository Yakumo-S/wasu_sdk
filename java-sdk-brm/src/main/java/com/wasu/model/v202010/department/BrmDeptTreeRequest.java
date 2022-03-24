package com.wasu.model.v202010.department;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 部门树查询
 *
 * @author 232676
 * @since 1.0.0 2020/11/6 09:22
 */
public class BrmDeptTreeRequest extends AbstractIccRequest<BrmDeptTreeResponse> {

  private String name;
  private Long parentId;
  private Integer checkStat;
  private String showPersonNode;
  private String showCascadeNode;
  private Long personIdentityId;
  private List<Integer> needCheckDepartmentIdList;
  public BrmDeptTreeRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEPT_TREE_POST), Method.POST);
    // 设置个空置,防止服务端报 Required request body is missing
    putBodyParameter("name", "");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    putBodyParameter("name", name);
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
    putBodyParameter("parentId", parentId);
  }

  public Integer getCheckStat() {
    return checkStat;
  }

  public void setCheckStat(Integer checkStat) {
    this.checkStat = checkStat;
    putBodyParameter("checkStat", checkStat);
  }

  public String getShowPersonNode() {
    return showPersonNode;
  }

  public void setShowPersonNode(String showPersonNode) {
    this.showPersonNode = showPersonNode;
    putBodyParameter("showPersonNode", showPersonNode);
  }

  public String getShowCascadeNode() {
    return showCascadeNode;
  }

  public void setShowCascadeNode(String showCascadeNode) {
    this.showCascadeNode = showCascadeNode;
    putBodyParameter("showCascadeNode", showCascadeNode);
  }

  public Long getPersonIdentityId() {
    return personIdentityId;
  }

  public void setPersonIdentityId(Long personIdentityId) {
    this.personIdentityId = personIdentityId;
    putBodyParameter("personIdentityId", personIdentityId);
  }

  public List<Integer> getNeedCheckDepartmentIdList() {
    return needCheckDepartmentIdList;
  }

  public void setNeedCheckDepartmentIdList(List<Integer> needCheckDepartmentIdList) {
    this.needCheckDepartmentIdList = needCheckDepartmentIdList;
    putBodyParameter("needCheckDepartmentIdList", needCheckDepartmentIdList);
  }

  @Override
  public Class<BrmDeptTreeResponse> getResponseClass() {
    return BrmDeptTreeResponse.class;
  }
}
