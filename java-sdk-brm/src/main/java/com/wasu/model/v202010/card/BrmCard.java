package com.wasu.model.v202010.card;

import com.wasu.icc.exception.ClientException;

/**
 * 卡片类
 *
 * @author 232676
 * @since 1.0.0 2020/11/11 9:08
 */
public class BrmCard {
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
  /** 1-限制，2-无限制 */
  private String updateAuth;
  /** 1-限制，2-无限制 */
  private String deleteAuth;

  private String cardPassword;
  private String passwordKey;

  private BrmCard(Builder builder) throws ClientException {
    this.cardNumber = builder.cardNumber;
    this.category = builder.category;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.departmentId = builder.departmentId;
    this.cardType = builder.cardType;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getUpdateAuth() {
    return updateAuth;
  }

  public void setUpdateAuth(String updateAuth) {
    this.updateAuth = updateAuth;
  }

  public String getDeleteAuth() {
    return deleteAuth;
  }

  public void setDeleteAuth(String deleteAuth) {
    this.deleteAuth = deleteAuth;
  }

  public String getCardPassword() {
    return cardPassword;
  }

  public void setCardPassword(String cardPassword) {
    this.cardPassword = cardPassword;
  }

  public String getPasswordKey() {
    return passwordKey;
  }

  public void setPasswordKey(String passwordKey) {
    this.passwordKey = passwordKey;
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

    public BrmCard build() throws ClientException {
      return new BrmCard(this);
    }
  }
}
