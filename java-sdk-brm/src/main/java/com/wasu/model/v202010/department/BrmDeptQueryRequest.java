package com.wasu.model.v202010.department;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 部门详情
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeptQueryRequest extends AbstractIccRequest<BrmDeptQueryResponse> {

  public BrmDeptQueryRequest(Long deptId) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEPT_DETAIL_REST_GET, deptId), Method.GET);
  }

  @Override
  public Class<BrmDeptQueryResponse> getResponseClass() {
    return BrmDeptQueryResponse.class;
  }
}
