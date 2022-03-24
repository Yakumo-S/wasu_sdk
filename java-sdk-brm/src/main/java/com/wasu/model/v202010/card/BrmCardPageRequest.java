package com.wasu.model.v202010.card;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 卡片分页查询
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmCardPageRequest extends AbstractIccRequest<BrmCardPageResponse> {

  private int pageNum;
  private int pageSize;
  /**
   * 排序字段
   * 排序字段（参数描述参考返回列表）：id（默认）、createTime、updateTime、cardNumber、startDate、endDate、availableTimes、personId、departmentId
   */
  private String sort;
  /** 排序规则 排序规则：正序-ASC 倒序-DESC（默认） */
  private String sortType;
  /** 卡号列表 列表最大支持500 */
  private List<String> cardNumberList;
  /** 卡类型列表 */
  private List<String> cardTypeList;
  /** 人员编号列表 列表最大支持500 */
  private List<Long> personIdList;
  /** 卡状态 255-空白 0-激活 1-挂失 2-注销 8-欠费 16-逾期 32-预欠费 */
  private List<String> cardStatusList;

  private Integer isMainCard;
  /** 区分是否是虚拟卡 1为虚拟卡 */
  private Integer isVirtual;
  /** 区分是否是胁迫卡 1为胁迫卡 */
  private Integer isCoercion;
  /** 卡介质 0-IC卡 1-有源RFID 2-CPU卡 */
  private String category;
  /** 卡归属主部门id */
  private Long departmentId;
  /** 是否查询主部门所有下级部门卡片（非必填，卡归属主部门id存在时生效,默认false） */
  private boolean includeSubDepartmentFlag;

  public BrmCardPageRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_PAGE_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
    putBodyParameter("pageNum", 1);
    putBodyParameter("pageSize", 10);
  }

  @Override
  public Class<BrmCardPageResponse> getResponseClass() {
    return BrmCardPageResponse.class;
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    putBodyParameter("pageNum", pageNum);
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    putBodyParameter("pageSize", pageSize);
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
    putBodyParameter("sort", sort);
  }

  public String getSortType() {
    return sortType;
  }

  public void setSortType(String sortType) {
    this.sortType = sortType;
    putBodyParameter("sortType", sortType);
  }

  public List<String> getCardNumberList() {
    return cardNumberList;
  }

  public void setCardNumberList(List<String> cardNumberList) {
    this.cardNumberList = cardNumberList;
    putBodyParameter("cardNumberList", cardNumberList);
  }

  public List<String> getCardTypeList() {
    return cardTypeList;
  }

  public void setCardTypeList(List<String> cardTypeList) {
    this.cardTypeList = cardTypeList;
    putBodyParameter("cardTypeList", cardTypeList);
  }

  public List<Long> getPersonIdList() {
    return personIdList;
  }

  public void setPersonIdList(List<Long> personIdList) {
    this.personIdList = personIdList;
    putBodyParameter("personIdList", personIdList);
  }

  public List<String> getCardStatusList() {
    return cardStatusList;
  }

  public void setCardStatusList(List<String> cardStatusList) {
    this.cardStatusList = cardStatusList;
    putBodyParameter("cardStatusList", cardStatusList);
  }

  public Integer getIsMainCard() {
    return isMainCard;
  }

  public void setIsMainCard(Integer isMainCard) {
    this.isMainCard = isMainCard;
    putBodyParameter("isMainCard", isMainCard);
  }

  public Integer getIsVirtual() {
    return isVirtual;
  }

  public void setIsVirtual(Integer isVirtual) {
    this.isVirtual = isVirtual;
    putBodyParameter("isVirtual", isVirtual);
  }

  public Integer getIsCoercion() {
    return isCoercion;
  }

  public void setIsCoercion(Integer isCoercion) {
    this.isCoercion = isCoercion;
    putBodyParameter("isCoercion", isCoercion);
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

  public boolean isIncludeSubDepartmentFlag() {
    return includeSubDepartmentFlag;
  }

  public void setIncludeSubDepartmentFlag(boolean includeSubDepartmentFlag) {
    this.includeSubDepartmentFlag = includeSubDepartmentFlag;
    putBodyParameter("includeSubDepartmentFlag", includeSubDepartmentFlag);
  }
}
