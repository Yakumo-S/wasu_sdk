package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.model.v202010.FieldExt;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 批量新增卡片
 *
 * @author 232676
 * @since 1.0.0 2020/11/11 12:19
 */
public class BrmCardBatchAddRequest extends AbstractIccRequest<BrmCardBatchAddResponse> {

  private List<BrmCard> cardList;
  private FieldExt fieldExt;

  private BrmCardBatchAddRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_BATCH_ADD_POST), Method.POST);
    this.cardList = builder.cardList;
    putBodyParameter("cardList", cardList);
  }

  public static Builder builder() {
    return new Builder();
  }

  public List<BrmCard> getCardList() {
    return cardList;
  }

  public void setCardList(List<BrmCard> cardList) {
    this.cardList = cardList;
    putBodyParameter("cardList", cardList);
  }

  public FieldExt getFieldExt() {
    return fieldExt;
  }

  public void setFieldExt(FieldExt fieldExt) {
    this.fieldExt = fieldExt;
    putBodyParameter("fieldExt", fieldExt);
  }

  @Override
  public Class<BrmCardBatchAddResponse> getResponseClass() {
    return BrmCardBatchAddResponse.class;
  }

  public static class Builder {
    private List<BrmCard> cardList;

    public Builder cardList(List<BrmCard> cardList) {
      this.cardList = cardList;
      return this;
    }

    public BrmCardBatchAddRequest build() throws ClientException {
      return new BrmCardBatchAddRequest(this);
    }
  }
}
