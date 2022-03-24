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
public class BrmCardReplaceRequest extends AbstractIccRequest<BrmCardReplaceResponse> {

  private String cardNumber;
  private String newCardNumber;

  private BrmCardReplaceRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_REPLACE_PUT), Method.PUT);
    this.cardNumber = builder.cardNumber;
    this.newCardNumber = builder.newCardNumber;

    putBodyParameter("cardNumber", cardNumber);
    putBodyParameter("newCardNumber", newCardNumber);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmCardReplaceResponse> getResponseClass() {
    return BrmCardReplaceResponse.class;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    putBodyParameter("cardNumber", cardNumber);
  }

  public String getNewCardNumber() {
    return newCardNumber;
  }

  public void setNewCardNumber(String newCardNumber) {
    this.newCardNumber = newCardNumber;
    putBodyParameter("newCardNumber", newCardNumber);
  }

  public static class Builder {
    private String cardNumber;
    private String newCardNumber;

    public Builder cardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
      return this;
    }

    public Builder newCardNumber(String newCardNumber) {
      this.newCardNumber = newCardNumber;
      return this;
    }

    public BrmCardReplaceRequest build() throws ClientException {
      return new BrmCardReplaceRequest(this);
    }
  }
}
