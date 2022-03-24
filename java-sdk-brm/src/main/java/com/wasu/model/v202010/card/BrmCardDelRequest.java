package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 卡片删除请求
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmCardDelRequest extends AbstractIccRequest<BrmCardDelResponse> {

  private List<Long> cardIds;
  private List<String> cardNumbers;

  public BrmCardDelRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_DEL_DELETE), Method.DELETE);
  }

  @Override
  public Class<BrmCardDelResponse> getResponseClass() {
    return BrmCardDelResponse.class;
  }

  public List<Long> getCardIds() {
    return cardIds;
  }

  public void setCardIds(List<Long> cardIds) {
    this.cardIds = cardIds;
    putBodyParameter("cardIds", cardIds);
  }

  public List<String> getCardNumbers() {
    return cardNumbers;
  }

  public void setCardNumbers(List<String> cardNumbers) {
    this.cardNumbers = cardNumbers;
    putBodyParameter("cardNumbers", cardNumbers);
  }
}
