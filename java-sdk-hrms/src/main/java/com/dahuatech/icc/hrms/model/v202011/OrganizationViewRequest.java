package com.dahuatech.icc.hrms.model.v202011;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * @author 232676
 * @since 1.0.0 2020/11/2 16:51
 */
public class OrganizationViewRequest extends AbstractIccRequest<OrganizationViewResponse> {

  public OrganizationViewRequest(String orgCode) throws ClientException {
    super(HrmsConstant.url(HrmsConstant.BRM_URL_BLOCK_VIEW_REST_GET, orgCode), Method.GET);
  }

  @Override
  public Class<OrganizationViewResponse> getResponseClass() {
    return OrganizationViewResponse.class;
  }
}
