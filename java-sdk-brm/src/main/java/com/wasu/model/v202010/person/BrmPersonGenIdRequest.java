package com.wasu.model.v202010.person;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 生成用户ID
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonGenIdRequest extends AbstractIccRequest<BrmPersonGenIdResponse> {

  public BrmPersonGenIdRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_GEN_ID_GET), Method.GET);
  }

  @Override
  public Class<BrmPersonGenIdResponse> getResponseClass() {
    return BrmPersonGenIdResponse.class;
  }
}
