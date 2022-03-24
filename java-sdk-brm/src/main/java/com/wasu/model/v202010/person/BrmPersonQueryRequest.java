package com.wasu.model.v202010.person;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 人员详情
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonQueryRequest extends AbstractIccRequest<BrmPersonQueryResponse> {

  public BrmPersonQueryRequest(Long id) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_DETAIL_REST_GET, id), Method.GET);
  }

  @Override
  public Class<BrmPersonQueryResponse> getResponseClass() {
    return BrmPersonQueryResponse.class;
  }
}
