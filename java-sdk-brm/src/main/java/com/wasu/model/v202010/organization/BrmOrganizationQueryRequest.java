package com.wasu.model.v202010.organization;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 组织详情
 *
 * @author 232676
 * @since 1.0.0 2020/11/3 11:22
 */
public class BrmOrganizationQueryRequest extends AbstractIccRequest<BrmOrganizationQueryResponse> {

  public BrmOrganizationQueryRequest(String orgCode) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_ORGAN_QUERY_GET, orgCode), Method.GET);
  }

  @Override
  public Class<BrmOrganizationQueryResponse> getResponseClass() {
    return BrmOrganizationQueryResponse.class;
  }
}
