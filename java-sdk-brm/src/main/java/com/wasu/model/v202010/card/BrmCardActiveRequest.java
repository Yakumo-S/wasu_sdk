package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 卡片激活
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmCardActiveRequest extends AbstractIccRequest<BrmCardActiveResponse> {

  private String cardNumber;
  private String category;
  private Long departmentId;
  private String startDate;
  private String endDate;
  private String cardType;
  private Long personId;

  private BrmCardActiveRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_ACTIVE_PUT), Method.PUT);
    this.personId = builder.personId;
    this.cardNumber = builder.cardNumber;
    this.category = builder.category;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.departmentId = builder.departmentId;
    this.cardType = builder.cardType;
    putBodyParameter("personId", personId);
    putBodyParameter("departmentId", departmentId);
    putBodyParameter("cardNumber", cardNumber);
    putBodyParameter("category", category);
    putBodyParameter("startDate", startDate);
    putBodyParameter("endDate", endDate);
    putBodyParameter("departmentId", departmentId);
    putBodyParameter("cardType", cardType);
  }

  public static Builder builder() {
    return new BrmCardActiveRequest.Builder();
  }

  @Override
  public Class<BrmCardActiveResponse> getResponseClass() {
    return BrmCardActiveResponse.class;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    putBodyParameter("cardNumber", cardNumber);
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
    putBodyParameter("category", category);
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
    putBodyParameter("departmentId", departmentId);
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
    putBodyParameter("startDate", startDate);
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
    putBodyParameter("endDate", endDate);
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
    putBodyParameter("cardType", cardType);
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
    putBodyParameter("personId", personId);
  }

  public static class Builder {
    private String cardNumber;
    private String category;
    private Long departmentId;
    private String startDate;
    private String endDate;
    private String cardType;
    private Long personId;

    public Builder personId(Long personId) {
      this.personId = personId;
      return this;
    }

    public Builder cardType(String cardType) {
      this.cardType = cardType;
      return this;
    }

    public Builder cardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
      return this;
    }

    public Builder category(String category) {
      this.category = category;
      return this;
    }

    public Builder departmentId(Long departmentId) {
      this.departmentId = departmentId;
      return this;
    }

    public Builder startDate(String startDate) {
      this.startDate = startDate;
      return this;
    }

    public Builder endDate(String endDate) {
      this.endDate = endDate;
      return this;
    }

    public BrmCardActiveRequest build() throws ClientException {
      return new BrmCardActiveRequest(this);
    }
  }
}
