package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 批量ID生成
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmCardBatchGenIdRequest extends AbstractIccRequest<BrmCardBatchGenIdResponse> {

  public BrmCardBatchGenIdRequest(Integer number) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_BATCH_GEN_ID_GET), Method.GET);
    form("count", number);
  }

  @Override
  public Class<BrmCardBatchGenIdResponse> getResponseClass() {
    return BrmCardBatchGenIdResponse.class;
  }
}
