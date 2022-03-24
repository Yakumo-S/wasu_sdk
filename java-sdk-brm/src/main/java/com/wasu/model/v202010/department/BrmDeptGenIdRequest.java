package com.wasu.model.v202010.department;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 部门ID生成
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeptGenIdRequest extends AbstractIccRequest<BrmDeptGenIdResponse> {

  public BrmDeptGenIdRequest(Integer count) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEPT_BATCH_GEN_ID_GET), Method.GET);
    form("count", count);
  }

  @Override
  public Class<BrmDeptGenIdResponse> getResponseClass() {
    return BrmDeptGenIdResponse.class;
  }
}
