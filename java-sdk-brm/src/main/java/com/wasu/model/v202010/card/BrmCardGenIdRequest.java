package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 卡片ID生成
 *
 * @author 232676
 * @since 1.0.0 2020/11/12 11:27
 */
public class BrmCardGenIdRequest extends AbstractIccRequest<BrmCardGenIdResponse> {

  public BrmCardGenIdRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_GEN_ID_GET), Method.GET);
  }

  @Override
  public Class<BrmCardGenIdResponse> getResponseClass() {
    return BrmCardGenIdResponse.class;
  }
}
