package com.wasu.model.v202010.organization;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 组织删除,method=delete，必填字段使用Builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/3 11:22
 */
public class BrmOrganizationDeleteRequest
    extends AbstractIccRequest<BrmOrganizationDeleteResponse> {

  /** 组织编码数组 */
  private List<String> orgCodes;

  private BrmOrganizationDeleteRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_ORGAN_DEL_DELETE), Method.DELETE);
    this.orgCodes = builder.orgCodes;
    putBodyParameter("orgCodes", orgCodes);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmOrganizationDeleteResponse> getResponseClass() {
    return BrmOrganizationDeleteResponse.class;
  }

  public List<String> getOrgCodes() {
    return orgCodes;
  }

  public void setOrgCodes(List<String> orgCodes) {
    this.orgCodes = orgCodes;
  }

  public static class Builder {
    /** 组织编码数组 */
    private List<String> orgCodes;

    public Builder orgCodes(List<String> orgCodes) {
      this.orgCodes = orgCodes;
      return this;
    }

    public BrmOrganizationDeleteRequest build() throws ClientException {
      return new BrmOrganizationDeleteRequest(this);
    }
  }
}
