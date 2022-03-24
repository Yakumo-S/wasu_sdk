package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 卡片详情查看
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmCardQueryRequest extends AbstractIccRequest<BrmCardQueryResponse> {

  public BrmCardQueryRequest(String cardNumber) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_DETAIL_REST_GET, cardNumber), Method.GET);
  }

  @Override
  public Class<BrmCardQueryResponse> getResponseClass() {
    return BrmCardQueryResponse.class;
  }
}
