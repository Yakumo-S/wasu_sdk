package com.wasu.model.v202010.card;

import com.wasu.model.v202010.person.PersonDepartment;
import com.wasu.http.IccResponse;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 卡片全量数据同步返回结果
 *
 * @author 232676
 * @since 1.0.0 2020/11/12 19:27
 */
public class BrmCardSyncResponse extends IccResponse {
  private CardPageData data;

  public CardPageData getData() {
    return data;
  }

  public void setData(CardPageData data) {
    this.data = data;
  }

  public static class CardPageData {
    private List<CardSyncPage> pageData;

    public List<CardSyncPage> getPageData() {
      return pageData;
    }

    public void setPageData(List<CardSyncPage> pageData) {
      this.pageData = pageData;
    }

    @Override
    public String toString() {
      return "CardPageData{" + "pageData=" + pageData + '}';
    }
  }

  public static class CardSyncPage {
    /** 部门列表 */
    List<PersonDepartment> personDepartmentListVO;
    /** 主键 */
    private Long id;
    /** 卡号 */
    private String cardNumber;
    /** 卡类型 */
    // @NotBlank(message = CARD_INFO_NOT_EMPTY,groups = {AddGroup.class})

    private String cardType;
    /** 卡密码 */
    private String cardPassword;
    /** rsa加密uuid */
    private String passwordKey;
    /** 子系统编号 */
    private String subSystems;
    /** 人员ID */
    private Long personId;
    /** 部门ID */
    private Long departmentId;
    /** 部门名称 */
    private String departmentName;
    /** 人员姓名 */
    private String personName;
    /** 人员电话号码 */
    private String phone;
    /** 开始时间 */
    private Date startDate;
    /** 结束时间 */
    private Date endDate;
    /** 卡状态 */
    private String cardStatus;
    /** 使用次数 */
    private String availableTimes;
    /** 备注 */
    private String description;
    /** 有效标志位 */
    private String validFlag;
    /** 区分是IC卡还是RFID卡 */
    private String category;
    /** 区分是否是主卡 1为主卡 */
    private Integer isMainCard;
    /** 区分是否是虚拟卡 1为虚拟卡 */
    private Integer isVirtual;
    /** 区分是否是胁迫卡 1为胁迫卡 */
    private Integer isCoercion;
    /** 新卡号 - 换卡时使用 */
    private String newCardNumber;
    /** 卡号集合 */
    private List<String> cardNumbers;
    /** 卡号ID集合 */
    private List<Long> cardIds;
    /** 子系统使用 对卡片删除限制 1为增加限制 2为删除限制 */
    private Integer deleteAuth;
    /** 子系统使用 对卡片修改限制 1为增加限制 2为删除限制 */
    private Integer updateAuth;
    /** 扩展信息 */
    private Map<String, String> ext;
    /** 自定义字段分页查询信息 */
    private Map<String, Object> pageFieldExt;
    /** 人员关联胁迫卡ID */
    private String personCoercionCardNum;

    private Integer domainId;

    private String lowerDataCode;

    private String cardSn;

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

    public String getCardType() {
      return cardType;
    }

    public void setCardType(String cardType) {
      this.cardType = cardType;
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

    public String getSubSystems() {
      return subSystems;
    }

    public void setSubSystems(String subSystems) {
      this.subSystems = subSystems;
    }

    public Long getPersonId() {
      return personId;
    }

    public void setPersonId(Long personId) {
      this.personId = personId;
    }

    public Long getDepartmentId() {
      return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
      this.departmentId = departmentId;
    }

    public String getDepartmentName() {
      return departmentName;
    }

    public void setDepartmentName(String departmentName) {
      this.departmentName = departmentName;
    }

    public String getPersonName() {
      return personName;
    }

    public void setPersonName(String personName) {
      this.personName = personName;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
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

    public String getAvailableTimes() {
      return availableTimes;
    }

    public void setAvailableTimes(String availableTimes) {
      this.availableTimes = availableTimes;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
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

    public Integer getIsVirtual() {
      return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
      this.isVirtual = isVirtual;
    }

    public Integer getIsCoercion() {
      return isCoercion;
    }

    public void setIsCoercion(Integer isCoercion) {
      this.isCoercion = isCoercion;
    }

    public String getNewCardNumber() {
      return newCardNumber;
    }

    public void setNewCardNumber(String newCardNumber) {
      this.newCardNumber = newCardNumber;
    }

    public List<String> getCardNumbers() {
      return cardNumbers;
    }

    public void setCardNumbers(List<String> cardNumbers) {
      this.cardNumbers = cardNumbers;
    }

    public List<Long> getCardIds() {
      return cardIds;
    }

    public void setCardIds(List<Long> cardIds) {
      this.cardIds = cardIds;
    }

    public Integer getDeleteAuth() {
      return deleteAuth;
    }

    public void setDeleteAuth(Integer deleteAuth) {
      this.deleteAuth = deleteAuth;
    }

    public Integer getUpdateAuth() {
      return updateAuth;
    }

    public void setUpdateAuth(Integer updateAuth) {
      this.updateAuth = updateAuth;
    }

    public Map<String, String> getExt() {
      return ext;
    }

    public void setExt(Map<String, String> ext) {
      this.ext = ext;
    }

    public Map<String, Object> getPageFieldExt() {
      return pageFieldExt;
    }

    public void setPageFieldExt(Map<String, Object> pageFieldExt) {
      this.pageFieldExt = pageFieldExt;
    }

    public String getPersonCoercionCardNum() {
      return personCoercionCardNum;
    }

    public void setPersonCoercionCardNum(String personCoercionCardNum) {
      this.personCoercionCardNum = personCoercionCardNum;
    }

    public List<PersonDepartment> getPersonDepartmentListVO() {
      return personDepartmentListVO;
    }

    public void setPersonDepartmentListVO(List<PersonDepartment> personDepartmentListVO) {
      this.personDepartmentListVO = personDepartmentListVO;
    }

    public Integer getDomainId() {
      return domainId;
    }

    public void setDomainId(Integer domainId) {
      this.domainId = domainId;
    }

    public String getLowerDataCode() {
      return lowerDataCode;
    }

    public void setLowerDataCode(String lowerDataCode) {
      this.lowerDataCode = lowerDataCode;
    }

    public String getCardSn() {
      return cardSn;
    }

    public void setCardSn(String cardSn) {
      this.cardSn = cardSn;
    }
  }
}
