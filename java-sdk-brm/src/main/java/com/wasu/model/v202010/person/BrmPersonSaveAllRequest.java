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
 * @author 237417
 * @since 1.0.0 2020/03/01
 */
public class BrmPersonSaveAllRequest extends AbstractIccRequest<BrmPersonSaveAllResponse> {

    private Long id;
    private String code;
    private String name;
    private Long departmentId;
    /** 身份类型 */
    private Integer paperType;

    private String paperNumber;
    /** 有效刷卡次数 仅来宾用户有效 */
    private int availableTimes;
    /** 电话 */
    private String phone;
    /** 电子邮箱 */
    private String email;
    /** 生日 */
    private Date birthday;

    private int country;
    /** 民族 */
    private int nation;
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

    private String service;
    /** 自定义字段信息 */
    private FieldExt fieldExt;
    /** 卡信息 */
    private List<BrmPersonCard> cards;
    /** 车信息 */
    private List<BrmPersonCar> cars;

    private BrmPersonSaveAllRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_ADD_ONCE_POST ), Method.POST);
        this.code = builder.code;
        this.id = builder.id;
        this.name = builder.name;
        this.paperType = builder.paperType;
        this.departmentId = builder.departmentId;
        this.cards = builder.cards;
        this.cars = builder.cars;
        putBodyParameter("departmentId", departmentId);
        putBodyParameter("code", code);
        putBodyParameter("id", id);
        putBodyParameter("name", name);
        putBodyParameter("paperType", paperType);
        putBodyParameter("cards", cards);
        putBodyParameter("cars", cars);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        putBodyParameter("id", id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        putBodyParameter("code", code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        putBodyParameter("name", name);
    }

    public int getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(int availableTimes) {
        this.availableTimes = availableTimes;
        putBodyParameter("availableTimes", availableTimes);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        putBodyParameter("phone", phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        putBodyParameter("email", email);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        putBodyParameter("birthday", birthday);
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
        putBodyParameter("country", country);
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
        putBodyParameter("nation", nation);
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
        putBodyParameter("nationName", nationName);
    }

    public String getSelfCode() {
        return selfCode;
    }

    public void setSelfCode(String selfCode) {
        this.selfCode = selfCode;
        putBodyParameter("selfCode", selfCode);
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
        putBodyParameter("ownerCode", ownerCode);
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

    public List<PersonDepartment> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<PersonDepartment> departmentList) {
        this.departmentList = departmentList;
        putBodyParameter("departmentList", departmentList);
    }

    public List<PersonBioSignatures> getPersonBiosignatures() {
        return personBiosignatures;
    }

    public void setPersonBiosignatures(List<PersonBioSignatures> personBiosignatures) {
        this.personBiosignatures = personBiosignatures;
        putBodyParameter("personBiosignatures", personBiosignatures);
    }

    public Map<String, String> getExt() {
        return ext;
    }

    public void setExt(Map<String, String> ext) {
        this.ext = ext;
        putBodyParameter("ext", ext);
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
        putBodyParameter("service", service);
    }

    public FieldExt getFieldExt() {
        return fieldExt;
    }

    public void setFieldExt(FieldExt fieldExt) {
        this.fieldExt = fieldExt;
        putBodyParameter("fieldExt", fieldExt);
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
        putBodyParameter("paperType", paperType);
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
        putBodyParameter("departmentId", departmentId);
    }

    public String getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
        this.paperNumber = paperNumber;
        putBodyParameter("paperNumber", paperNumber);
    }

    public List<BrmPersonCard> getCards() {
        return cards;
    }

    public void setCards(List<BrmPersonCard> cards) {
        this.cards = cards;
    }

    public List<BrmPersonCar> getCars() {
        return cars;
    }

    public void setCars(List<BrmPersonCar> cars) {
        this.cars = cars;
    }

    @Override
    public Class<BrmPersonSaveAllResponse> getResponseClass() {
        return BrmPersonSaveAllResponse.class;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String code;
        /** 证件类型 */
        private Integer paperType;

        private Long departmentId;

        /** 卡信息 */
        private List<BrmPersonCard> cards;
        /** 车信息 */
        private List<BrmPersonCar> cars;

        public Builder departmentId(Long departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder paperType(Integer paperType) {
            this.paperType = paperType;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder cards(List<BrmPersonCard> cards) {
            this.cards = cards;
            return this;
        }

        public Builder cars(List<BrmPersonCar> cars) {
            this.cars = cars;
            return this;
        }

        public BrmPersonSaveAllRequest build() throws ClientException {
            return new BrmPersonSaveAllRequest(this);
        }
    }
}

