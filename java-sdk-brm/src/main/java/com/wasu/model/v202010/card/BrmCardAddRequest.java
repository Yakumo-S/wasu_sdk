package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.model.v202010.FieldExt;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 卡片新增
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmCardAddRequest extends AbstractIccRequest<BrmCardAddResponse> {
  /** 卡号 */
  private String cardNumber;
  /** 卡类型 0-普通卡 1-VIP卡 2-来宾卡 3-巡逻卡 5-胁迫卡 6-巡检卡 7-黑名单卡 -1-未知卡类型 */
  private String cardType;

  /** 卡介质 0-IC卡 1-有源RFID 2-CPU卡 */
  private String category;
  /** 部门id */
  private Long departmentId;
  /** 卡片有效期-开始时间 */
  private String startDate;
  /** 卡片有效期-结束时间 */
  private String endDate;
  /*-----------------分割线，以下是非必填---------------------*/
  /** 1-限制，2-无限制 */
  private String updateAuth;
  /** 1-限制，2-无限制 */
  private String deleteAuth;

  private String cardPassword;
  private String passwordKey;
  private String personId;
  private String availableTimes;
  /** 自定义字段信息 */
  private FieldExt fieldExt;

  private BrmCardAddRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_ADD_POST), Method.POST);
    this.cardNumber = builder.cardNumber;
    this.category = builder.category;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.departmentId = builder.departmentId;
    this.cardType = builder.cardType;
    putBodyParameter("departmentId", departmentId);
    putBodyParameter("cardNumber", cardNumber);
    putBodyParameter("category", category);
    putBodyParameter("startDate", startDate);
    putBodyParameter("endDate", endDate);
    putBodyParameter("departmentId", departmentId);
    putBodyParameter("cardType", cardType);
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    putBodyParameter("cardNumber", cardNumber);
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
    putBodyParameter("cardType", cardType);
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

  public String getUpdateAuth() {
    return updateAuth;
  }

  public void setUpdateAuth(String updateAuth) {
    this.updateAuth = updateAuth;
    putBodyParameter("updateAuth", updateAuth);
  }

  public String getDeleteAuth() {
    return deleteAuth;
  }

  public void setDeleteAuth(String deleteAuth) {
    this.deleteAuth = deleteAuth;
    putBodyParameter("deleteAuth", deleteAuth);
  }

  public String getCardPassword() {
    return cardPassword;
  }

  public void setCardPassword(String cardPassword) {
    this.cardPassword = cardPassword;
    putBodyParameter("cardPassword", cardPassword);
  }

  public String getPasswordKey() {
    return passwordKey;
  }

  public void setPasswordKey(String passwordKey) {
    this.passwordKey = passwordKey;
    putBodyParameter("passwordKey", passwordKey);
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
    putBodyParameter("personId", personId);
  }

  public String getAvailableTimes() {
    return availableTimes;
  }

  public void setAvailableTimes(String availableTimes) {
    this.availableTimes = availableTimes;
    putBodyParameter("availableTimes", availableTimes);
  }

  public FieldExt getFieldExt() {
    return fieldExt;
  }

  public void setFieldExt(FieldExt fieldExt) {
    this.fieldExt = fieldExt;
    putBodyParameter("fieldExt", fieldExt);
  }

  @Override
  public Class<BrmCardAddResponse> getResponseClass() {
    return BrmCardAddResponse.class;
  }

  public static class Builder {
    private String cardNumber;
    private String category;
    private Long departmentId;
    private String startDate;
    private String endDate;
    private String cardType;

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

    public BrmCardAddRequest build() throws ClientException {
      return new BrmCardAddRequest(this);
    }
  }
}
