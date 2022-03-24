package com.wasu.model.v202010.card;

import com.wasu.model.v202010.FieldExt;
import com.wasu.model.v202010.person.PersonDepartment;

import java.util.Date;
import java.util.List;

public class BrmCardPageDetail {
  private Long id;
  private String cardNumber;
  private String cardPassword;
  private Long personId;
  private Integer departmentId;
  private String departmentName;
  private Date startDate;
  private Date endDate;
  private String cardStatus;
  private Date createTime;
  private Long createBy;
  private Date updateTime;
  private Long updateBy;
  private String validFlag;
  private String category;
  private Integer isMainCard;
  private Integer isCoercion;
  private List<PersonDepartment> personDepartmentListVO;
  private FieldExt fieldExt;

  public FieldExt getFieldExt() {
    return fieldExt;
  }

  public void setFieldExt(FieldExt fieldExt) {
    this.fieldExt = fieldExt;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCardPassword() {
    return cardPassword;
  }

  public void setCardPassword(String cardPassword) {
    this.cardPassword = cardPassword;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getCardStatus() {
    return cardStatus;
  }

  public void setCardStatus(String cardStatus) {
    this.cardStatus = cardStatus;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Long getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Long createBy) {
    this.createBy = createBy;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Long getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(Long updateBy) {
    this.updateBy = updateBy;
  }

  public String getValidFlag() {
    return validFlag;
  }

  public void setValidFlag(String validFlag) {
    this.validFlag = validFlag;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getIsMainCard() {
    return isMainCard;
  }

  public void setIsMainCard(Integer isMainCard) {
    this.isMainCard = isMainCard;
  }

  public Integer getIsCoercion() {
    return isCoercion;
  }

  public void setIsCoercion(Integer isCoercion) {
    this.isCoercion = isCoercion;
  }

  public List<PersonDepartment> getPersonDepartmentListVO() {
    return personDepartmentListVO;
  }

  public void setPersonDepartmentListVO(List<PersonDepartment> personDepartmentListVO) {
    this.personDepartmentListVO = personDepartmentListVO;
  }
}
