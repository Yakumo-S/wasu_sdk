package com.wasu.model.v202010.organization;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 组织全量同步，必填字段使用Builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/3 11:22
 */
public class BrmOrganizationSyncRequest extends AbstractIccRequest<BrmOrganizationSyncResponse> {

  private Long maxRangeId;
  private String orgPreCode;
  private int pageSize;
  private int pageNum;

  private BrmOrganizationSyncRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_ORGAN_PAGE_GET), Method.GET);
    this.maxRangeId = builder.maxRangeId;
    form("maxRangeId", maxRangeId);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmOrganizationSyncResponse> getResponseClass() {
    return BrmOrganizationSyncResponse.class;
  }

  public Long getMaxRangeId() {
    return maxRangeId;
  }

  public void setMaxRangeId(Long maxRangeId) {
    this.maxRangeId = maxRangeId;
    form("maxRangeId", maxRangeId);
  }

  public String getOrgPreCode() {
    return orgPreCode;
  }

  public void setOrgPreCode(String orgPreCode) {
    this.orgPreCode = orgPreCode;
    form("orgPreCode", orgPreCode);
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    form("pageSize", pageSize);
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    form("pageNum", pageNum);
  }

  public static class Builder {
    private Long maxRangeId;

    public Builder maxRangeId(Long maxRangeId) {
      this.maxRangeId = maxRangeId;
      return this;
    }

    public BrmOrganizationSyncRequest build() throws ClientException {
      return new BrmOrganizationSyncRequest(this);
    }
  }
}
