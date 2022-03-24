package com.wasu.model.v202010.organization;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 组织分页查询
 *
 * @author 232676
 * @since 1.0.0 2020/11/3 11:22
 */
public class BrmOrganizationSubSysPageRequest
    extends AbstractIccRequest<BrmOrganizationSubSysPageResponse> {

  private String orgPreCode;
  /**
   * 是否包含所有下级节点
   *
   * <p>0 不包含 1 包含，orgPreCode不为空时有效
   */
  private String containerLower;
  /**
   * 组织类型列表
   *
   * <p>参考组织类型字典
   */
  private String orgTypes;
  /** 组织编码列表 */
  private String orgCodes;
  /** 组织唯一标识码列表 */
  private String orgSns;

  private int pageNum;
  private int pageSize;
  /** 按照组织名称模糊 */
  private String searchKey;

  public BrmOrganizationSubSysPageRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_ORGAN_PAGE_LIST_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
    putBodyParameter("searchKey", "");
  }

  @Override
  public Class<BrmOrganizationSubSysPageResponse> getResponseClass() {
    return BrmOrganizationSubSysPageResponse.class;
  }

  public String getOrgPreCode() {
    return orgPreCode;
  }

  public void setOrgPreCode(String orgPreCode) {
    this.orgPreCode = orgPreCode;
    putBodyParameter("orgPreCode", orgPreCode);
  }

  public String getContainerLower() {
    return containerLower;
  }

  public void setContainerLower(String containerLower) {
    this.containerLower = containerLower;
    putBodyParameter("containerLower", containerLower);
  }

  public String getOrgTypes() {
    return orgTypes;
  }

  public void setOrgTypes(String orgTypes) {
    this.orgTypes = orgTypes;
    putBodyParameter("orgTypes", orgTypes);
  }

  public String getOrgCodes() {
    return orgCodes;
  }

  public void setOrgCodes(String orgCodes) {
    this.orgCodes = orgCodes;
    putBodyParameter("orgCodes", orgCodes);
  }

  public String getOrgSns() {
    return orgSns;
  }

  public void setOrgSns(String orgSns) {
    this.orgSns = orgSns;
    putBodyParameter("orgSns", orgSns);
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

  @Override
  public String toString() {
    return "BrmOrganizationPageRequest{"
        + "orgPreCode='"
        + orgPreCode
        + '\''
        + ", containerLower='"
        + containerLower
        + '\''
        + ", orgTypes='"
        + orgTypes
        + '\''
        + ", orgCodes='"
        + orgCodes
        + '\''
        + ", orgSns='"
        + orgSns
        + '\''
        + ", pageNum="
        + pageNum
        + ", pageSize="
        + pageSize
        + ", searchKey='"
        + searchKey
        + '\''
        + '}';
  }
}
