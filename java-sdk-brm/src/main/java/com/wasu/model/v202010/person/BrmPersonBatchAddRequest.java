package com.wasu.model.v202010.person;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.model.v202010.FieldExt;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 批量新增人员
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonBatchAddRequest extends AbstractIccRequest<BrmPersonBatchAddResponse> {

  private String service;
  private List<PersonBatchData> personList;

  private BrmPersonBatchAddRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_BATCH_ADD_POST), Method.POST);
    this.personList = builder.personList;

    putBodyParameter("personList", personList);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "BrmPersonBatchAddRequest{"
        + "service='"
        + service
        + '\''
        + ", personList="
        + personList
        + '}';
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
    putBodyParameter("service", service);
  }

  public List<PersonBatchData> getPersonList() {
    return personList;
  }

  public void setPersonList(List<PersonBatchData> personList) {
    this.personList = personList;
    putBodyParameter("personList", personList);
  }

  @Override
  public Class<BrmPersonBatchAddResponse> getResponseClass() {
    return BrmPersonBatchAddResponse.class;
  }

  public static class PersonBatchData {
    private Long id;
    private String code;
    private String name;
    private Long departmentId;
    /** 身份类型 */
    private Integer paperType;

    private String paperNumber;
    /** 有效刷卡次数 仅来宾用户有效 */
    private Integer availableTimes;
    /** 电话 */
    private String phone;
    /** 电子邮箱 */
    private String email;
    /** 生日 */
    private Date birthday;

    private Integer country;
    /** 民族 */
    private Integer nation;
    /** 民族名称 */
    private String nationName;
    /** 人员自编号 */
    private String selfCode;
    /** 组织编码 */
    private String ownerCode;
    /** 操作卡片修改限制 子系统使用： 1-为增加限制 ，2-为删除限制 */
    private String updateAuth;
    /** 操作卡片删除限制 子系统使用： 1-为增加限制 ，2-为删除限制 */
    private String deleteAuth;
    /** 所属部门列表,一人多部门场景使用：若departmentId、departmentList同时传值，以departmentId传参为准，该参数无效 */
    private List<PersonDepartment> departmentList;
    /** 生物特征数据:人脸头像、人脸特征、指纹特征 */
    private List<PersonBioSignatures> personBiosignatures;
    /** 扩展属性值 */
    private Map<String, String> ext;
    /** 自定义字段信息 */
    private FieldExt fieldExt;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Long getDepartmentId() {
      return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
      this.departmentId = departmentId;
    }

    public Integer getPaperType() {
      return paperType;
    }

    public void setPaperType(Integer paperType) {
      this.paperType = paperType;
    }

    public String getPaperNumber() {
      return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
      this.paperNumber = paperNumber;
    }

    public Integer getAvailableTimes() {
      return availableTimes;
    }

    public void setAvailableTimes(Integer availableTimes) {
      this.availableTimes = availableTimes;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public Date getBirthday() {
      return birthday;
    }

    public void setBirthday(Date birthday) {
      this.birthday = birthday;
    }

    public Integer getCountry() {
      return country;
    }

    public void setCountry(Integer country) {
      this.country = country;
    }

    public Integer getNation() {
      return nation;
    }

    public void setNation(Integer nation) {
      this.nation = nation;
    }

    public String getNationName() {
      return nationName;
    }

    public void setNationName(String nationName) {
      this.nationName = nationName;
    }

    public String getSelfCode() {
      return selfCode;
    }

    public void setSelfCode(String selfCode) {
      this.selfCode = selfCode;
    }

    public String getOwnerCode() {
      return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
      this.ownerCode = ownerCode;
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

    public List<PersonDepartment> getDepartmentList() {
      return departmentList;
    }

    public void setDepartmentList(List<PersonDepartment> departmentList) {
      this.departmentList = departmentList;
    }

    public List<PersonBioSignatures> getPersonBiosignatures() {
      return personBiosignatures;
    }

    public void setPersonBiosignatures(List<PersonBioSignatures> personBiosignatures) {
      this.personBiosignatures = personBiosignatures;
    }

    public Map<String, String> getExt() {
      return ext;
    }

    public void setExt(Map<String, String> ext) {
      this.ext = ext;
    }

    public FieldExt getFieldExt() {
      return fieldExt;
    }

    public void setFieldExt(FieldExt fieldExt) {
      this.fieldExt = fieldExt;
    }
  }

  public static class Builder {
    private List<PersonBatchData> personList;

    public Builder personList(List<PersonBatchData> personList) {
      this.personList = personList;
      return this;
    }

    public BrmPersonBatchAddRequest build() throws ClientException {
      return new BrmPersonBatchAddRequest(this);
    }
  }
}
