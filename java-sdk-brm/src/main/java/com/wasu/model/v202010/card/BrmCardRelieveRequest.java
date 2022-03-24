package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 卡片解挂失
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmCardRelieveRequest extends AbstractIccRequest<BrmCardRelieveResponse> {

  private List<Long> cardIds;

  public BrmCardRelieveRequest(List<Long> cardIds) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_RELIEVE_PUT), Method.PUT);
    putBodyParameter("cardIds", cardIds);
  }

  @Override
  public Class<BrmCardRelieveResponse> getResponseClass() {
    return BrmCardRelieveResponse.class;
  }

  public List<Long> getCardIds() {
    return cardIds;
  }

  public void setCardIds(List<Long> cardIds) {
    this.cardIds = cardIds;
    putBodyParameter("cardIds", cardIds);
  }
}
