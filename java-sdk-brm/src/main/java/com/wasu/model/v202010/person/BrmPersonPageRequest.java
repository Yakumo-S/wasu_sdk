package com.wasu.model.v202010.person;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 人员全量数据同步,默认maxRangeId=1000L
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmPersonPageRequest extends AbstractIccRequest<BrmPersonPageResponse> {

  private int pageSize;
  private int pageNum;
  private Integer departmentId;
  private boolean isContain;
  private String searchKey;
  /** 证件类型筛选 */
  private List<String> paperTypeList;
  /** 人员类型筛选 */
  private List<String> personTypeList;
  /** 民族筛选 */
  private List<String> nationList;
  /** 状态筛选 ： 0-删除 ，1-正常 ，2-冻结 */
  private List<Integer> statusList;
  /** 性别筛选： 0-未知， 1-男， 2-女 */
  private List<Integer> sexList;
  /** 人员身份 */
  private List<Long> personIdentityId;
  /** 1-指纹 2-红外/9421d人脸/人脸特征值 无此参数只显示人脸照片 选择多项时用逗号连接 eg. 1,2 */
  private List<Integer> biometricType;
  /** 人员ID列表 */
  private List<Long> personIdList;
  /** 人员姓名列表(精确匹配) */
  private List<String> nameList;
  /** 证件号码(精确匹配) */
  private List<String> paperNumberList;

  private BrmPersonPageRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_PAGE_POST), Method.POST);
    this.statusList = builder.statusList;
    putBodyParameter("statusList", statusList);
    putBodyParameter("pageNum", 1);
    putBodyParameter("pageSize", 10);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmPersonPageResponse> getResponseClass() {
    return BrmPersonPageResponse.class;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    putBodyParameter("pageSize", pageSize);
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    putBodyParameter("pageNum", pageNum);
  }

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
    putBodyParameter("departmentId", departmentId);
  }

  public boolean isContain() {
    return isContain;
  }

  public void setContain(boolean contain) {
    isContain = contain;
    putBodyParameter("contain", contain);
  }

  public String getSearchKey() {
    return searchKey;
  }

  public void setSearchKey(String searchKey) {
    this.searchKey = searchKey;
    putBodyParameter("searchKey", searchKey);
  }

  public List<String> getPaperTypeList() {
    return paperTypeList;
  }

  public void setPaperTypeList(List<String> paperTypeList) {
    this.paperTypeList = paperTypeList;
    putBodyParameter("paperTypeList", paperTypeList);
  }

  public List<String> getPersonTypeList() {
    return personTypeList;
  }

  public void setPersonTypeList(List<String> personTypeList) {
    this.personTypeList = personTypeList;
    putBodyParameter("personTypeList", personTypeList);
  }

  public List<String> getNationList() {
    return nationList;
  }

  public void setNationList(List<String> nationList) {
    this.nationList = nationList;
    putBodyParameter("nationList", nationList);
  }

  public List<Integer> getStatusList() {
    return statusList;
  }

  public void setStatusList(List<Integer> statusList) {
    this.statusList = statusList;
    putBodyParameter("statusList", statusList);
  }

  public List<Integer> getSexList() {
    return sexList;
  }

  public void setSexList(List<Integer> sexList) {
    this.sexList = sexList;
    putBodyParameter("sexList", sexList);
  }

  public List<Long> getPersonIdentityId() {
    return personIdentityId;
  }

  public void setPersonIdentityId(List<Long> personIdentityId) {
    this.personIdentityId = personIdentityId;
    putBodyParameter("personIdentityId", personIdentityId);
  }

  public List<Integer> getBiometricType() {
    return biometricType;
  }

  public void setBiometricType(List<Integer> biometricType) {
    this.biometricType = biometricType;
    putBodyParameter("biometricType", biometricType);
  }

  public List<Long> getPersonIdList() {
    return personIdList;
  }

  public void setPersonIdList(List<Long> personIdList) {
    this.personIdList = personIdList;
    putBodyParameter("personIdList", personIdList);
  }

  public List<String> getNameList() {
    return nameList;
  }

  public void setNameList(List<String> nameList) {
    this.nameList = nameList;
    putBodyParameter("nameList", nameList);
  }

  public List<String> getPaperNumberList() {
    return paperNumberList;
  }

  public void setPaperNumberList(List<String> paperNumberList) {
    this.paperNumberList = paperNumberList;
    putBodyParameter("paperNumberList", paperNumberList);
  }

  public static class Builder {
    private List<Integer> statusList;

    public Builder statusList(List<Integer> statusList) {
      this.statusList = statusList;
      return this;
    }

    public BrmPersonPageRequest build() throws ClientException {
      return new BrmPersonPageRequest(this);
    }
  }
}
