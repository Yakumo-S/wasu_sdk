package com.dahuatech.icc.hrms.model.v202011.person;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.Date;
import java.util.List;

public class HrmsPersonAddRequest extends AbstractIccRequest<HrmsPersonAddResponse> {

    /** 姓名 */
    private String name;
    /** 人员类别（1-常住人口，2-流动人员，3-其他人口，5-境外人口） */
    private String type;
    /** 登记小区ID */
    private String registBlockId;
    /** 人员身份 */
    private List<String> userSubTypeList;
    /** 人员登记类型 */
    private String personRegisterType;
    /** 实名认证方式，1-现场登记；2-在线实名认证；3-人工审核 */
    private String authType;
    /** 证件有效期/签发日期 */
    private Date paperValidity;
    /*--------以上必填-----*/

    /** 性别（0-未知，1-男，2-女） */
    private String sex;
    /** 出生日期 */
    private Date birthday;
    /** 证件类型 */
    private String paperType;
    /** 证件号码 */
    private String paperNumber;
    /** 民族 */
    private String nation;
    /** 居住地址 */
    private String liveAddress;
    /** 电话 */
    private String phone;
    /** 人员标签 */
    private String classification;
    /** 曾用名 */
    private String userName;
    /** 出生地 */
    private String birthAddress;
    /** 户籍地址 */
    private String orgionPlace;
    /** 宗教信仰 */
    private String religion;
    /** 婚姻状态 */
    private String marriageStatus;
    /** 文化程度 */
    private String eduction;
    /** 兵役情况（1服过兵役，0没有） */
    private String isMilitaryService;
    /** 血型 */
    private String bloodType;
    /** 政治面貌 */
    private String politicalStatus;
    /** 单位 */
    private String company;
    /** 职位 */
    private String title;
    /** 居住证编号 */
    private String residencePermit;
    /** 居住证起始日期 */
    private String residenceBeginTime;
    /** 居住证结束日期 */
    private Date residenceEndTime;
    /** 暂住事由 */
    private String liveReason;
    /** 是否境外人员 */
    private Integer isForeign;
    /** 国籍 */
    private String nationality;
    /** 紧急联系人 */
    private String emergencyPerson;
    /** 紧密联系人联系方式 */
    private String emergencyPersonTel;
    /** 居住结束时间 */
    private Date liveEndTime;
    /** 户口类型 */
    private String residenceType;
    /** 户号 */
    private String residenceNumber;
    /** 户主姓名 */
    private String residencePrimaryName;
    /** 户主电话 */
    private String residencePrimaryPhone;
    /** 与户主关系 */
    private String residenceRelation;
    /** 户主证件类型 */
    private String residencePrimaryPaperType;
    /** 户主证件号码 */
    private String residencePrimaryPaperNumber;
    /** 人员别名 */
    private String alias;
    /** 来华目的 */
    private String lhmd;
    /** 来华时间 */
    private String lhTime;
    /** 人员绑定的房屋组织编码 */
    private String houseOrgCode;
    /** 人员照片集合 */
    private List<PersonPhoto> personPhotoList;
    /** 户主对应的人员id（户主可以手填，也可以从库内选择） */
    private String ownerPersonId;
    /** 户主头像照（前端用此字段判断户主证件照是否可以更新） */
    private String ownerFaceUrl;
    /** 是否处理人员标签（app用户更新人员时，标签不需要处理后台默认需要更新-true） */
    private Boolean isHandelPersonLabels;
    /** 登记小区 */
    private String registBlockName;
    /** 外文名 */
    private String firstName;
    /** 外文姓 */
    private String lastName;

    public HrmsPersonAddRequest(Builder builder) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_PERSON_ADD_POST), Method.POST);
        this.name = builder.name;
        this.type = builder.type;
        this.registBlockId = builder.registBlockId;
        this.userSubTypeList = builder.userSubTypeList;
        this.personRegisterType = builder.personRegisterType;
        this.authType = builder.authType;
        this.paperValidity = builder.paperValidity;
        putBodyParameter("name",name);
        putBodyParameter("type",type);
        putBodyParameter("registBlockId",registBlockId);
        putBodyParameter("userSubTypeList",userSubTypeList);
        putBodyParameter("personRegisterType",personRegisterType);
        putBodyParameter("authType",authType);
        putBodyParameter("paperValidity",paperValidity);
    }

    @Override
    public Class<HrmsPersonAddResponse> getResponseClass() {
        return HrmsPersonAddResponse.class;
    }


    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        putBodyParameter("name",name);
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        putBodyParameter("type",type);
        this.type = type;
    }

    public String getRegistBlockId() {
        return registBlockId;
    }

    public void setRegistBlockId(String registBlockId) {
        putBodyParameter("registBlockId",registBlockId);
        this.registBlockId = registBlockId;
    }

    public List<String> getUserSubTypeList() {
        return userSubTypeList;
    }

    public void setUserSubTypeList(List<String> userSubTypeList) {
        putBodyParameter("userSubTypeList",userSubTypeList);
        this.userSubTypeList = userSubTypeList;
    }

    public String getPersonRegisterType() {
        return personRegisterType;
    }

    public void setPersonRegisterType(String personRegisterType) {
        putBodyParameter("personRegisterType",personRegisterType);
        this.personRegisterType = personRegisterType;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        putBodyParameter("authType",authType);
        this.authType = authType;
    }

    public Date getPaperValidity() {
        return paperValidity;
    }

    public void setPaperValidity(Date paperValidity) {
        putBodyParameter("paperValidity",paperValidity);
        this.paperValidity = paperValidity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        putBodyParameter("sex",sex);
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        putBodyParameter("birthday",birthday);
        this.birthday = birthday;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        putBodyParameter("paperType",paperType);
        this.paperType = paperType;
    }

    public String getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
        putBodyParameter("paperNumber",paperNumber);
        this.paperNumber = paperNumber;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        putBodyParameter("nation",nation);
        this.nation = nation;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        putBodyParameter("liveAddress",liveAddress);
        this.liveAddress = liveAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        putBodyParameter("phone",phone);
        this.phone = phone;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        putBodyParameter("classification",classification);
        this.classification = classification;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        putBodyParameter("userName",userName);
        this.userName = userName;
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        putBodyParameter("birthAddress",birthAddress);
        this.birthAddress = birthAddress;
    }

    public String getOrgionPlace() {
        return orgionPlace;
    }

    public void setOrgionPlace(String orgionPlace) {
        putBodyParameter("orgionPlace",orgionPlace);
        this.orgionPlace = orgionPlace;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        putBodyParameter("religion",religion);
        this.religion = religion;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        putBodyParameter("marriageStatus",marriageStatus);
        this.marriageStatus = marriageStatus;
    }

    public String getEduction() {
        return eduction;
    }

    public void setEduction(String eduction) {
        putBodyParameter("eduction",eduction);
        this.eduction = eduction;
    }

    public String getIsMilitaryService() {
        return isMilitaryService;
    }

    public void setIsMilitaryService(String isMilitaryService) {
        putBodyParameter("isMilitaryService",isMilitaryService);
        this.isMilitaryService = isMilitaryService;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        putBodyParameter("bloodType",bloodType);
        this.bloodType = bloodType;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        putBodyParameter("politicalStatus",politicalStatus);
        this.politicalStatus = politicalStatus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        putBodyParameter("company",company);
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        putBodyParameter("title",title);
        this.title = title;
    }

    public String getResidencePermit() {
        return residencePermit;
    }

    public void setResidencePermit(String residencePermit) {
        putBodyParameter("residencePermit",residencePermit);
        this.residencePermit = residencePermit;
    }

    public String getResidenceBeginTime() {
        return residenceBeginTime;
    }

    public void setResidenceBeginTime(String residenceBeginTime) {
        putBodyParameter("residenceBeginTime",residenceBeginTime);
        this.residenceBeginTime = residenceBeginTime;
    }

    public Date getResidenceEndTime() {
        return residenceEndTime;
    }

    public void setResidenceEndTime(Date residenceEndTime) {
        putBodyParameter("residenceEndTime",residenceEndTime);
        this.residenceEndTime = residenceEndTime;
    }

    public String getLiveReason() {
        return liveReason;
    }

    public void setLiveReason(String liveReason) {
        putBodyParameter("liveReason",liveReason);
        this.liveReason = liveReason;
    }

    public Integer getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(Integer isForeign) {
        putBodyParameter("isForeign",isForeign);
        this.isForeign = isForeign;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        putBodyParameter("nationality",nationality);
        this.nationality = nationality;
    }

    public String getEmergencyPerson() {
        return emergencyPerson;
    }

    public void setEmergencyPerson(String emergencyPerson) {
        putBodyParameter("emergencyPerson",emergencyPerson);
        this.emergencyPerson = emergencyPerson;
    }

    public String getEmergencyPersonTel() {
        return emergencyPersonTel;
    }

    public void setEmergencyPersonTel(String emergencyPersonTel) {
        putBodyParameter("emergencyPersonTel",emergencyPersonTel);
        this.emergencyPersonTel = emergencyPersonTel;
    }

    public Date getLiveEndTime() {
        return liveEndTime;
    }

    public void setLiveEndTime(Date liveEndTime) {
        putBodyParameter("liveEndTime",liveEndTime);
        this.liveEndTime = liveEndTime;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        putBodyParameter("residenceType",residenceType);
        this.residenceType = residenceType;
    }

    public String getResidenceNumber() {
        return residenceNumber;
    }

    public void setResidenceNumber(String residenceNumber) {
        putBodyParameter("residenceNumber",residenceNumber);
        this.residenceNumber = residenceNumber;
    }

    public String getResidencePrimaryName() {
        return residencePrimaryName;
    }

    public void setResidencePrimaryName(String residencePrimaryName) {
        putBodyParameter("residencePrimaryName",residencePrimaryName);
        this.residencePrimaryName = residencePrimaryName;
    }

    public String getResidencePrimaryPhone() {
        return residencePrimaryPhone;
    }

    public void setResidencePrimaryPhone(String residencePrimaryPhone) {
        putBodyParameter("residencePrimaryPhone",residencePrimaryPhone);
        this.residencePrimaryPhone = residencePrimaryPhone;
    }

    public String getResidenceRelation() {
        return residenceRelation;
    }

    public void setResidenceRelation(String residenceRelation) {
        putBodyParameter("residenceRelation",residenceRelation);
        this.residenceRelation = residenceRelation;
    }

    public String getResidencePrimaryPaperType() {
        return residencePrimaryPaperType;
    }

    public void setResidencePrimaryPaperType(String residencePrimaryPaperType) {
        putBodyParameter("residencePrimaryPaperType",residencePrimaryPaperType);
        this.residencePrimaryPaperType = residencePrimaryPaperType;
    }

    public String getResidencePrimaryPaperNumber() {
        return residencePrimaryPaperNumber;
    }

    public void setResidencePrimaryPaperNumber(String residencePrimaryPaperNumber) {
        putBodyParameter("residencePrimatyPaperNumber",residencePrimaryPaperNumber);
        this.residencePrimaryPaperNumber = residencePrimaryPaperNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        putBodyParameter("alias",alias);
        this.alias = alias;
    }

    public String getLhmd() {
        return lhmd;
    }

    public void setLhmd(String lhmd) {
        putBodyParameter("lhmd",lhmd);
        this.lhmd = lhmd;
    }

    public String getLhTime() {
        return lhTime;
    }

    public void setLhTime(String lhTime) {
        putBodyParameter("lhTime",lhTime);
        this.lhTime = lhTime;
    }

    public String getHouseOrgCode() {
        return houseOrgCode;
    }

    public void setHouseOrgCode(String houseOrgCode) {
        putBodyParameter("houseOrgCode",houseOrgCode);
        this.houseOrgCode = houseOrgCode;
    }

    public List<PersonPhoto> getPersonPhotoList() {
        return personPhotoList;
    }

    public void setPersonPhotoList(List<PersonPhoto> personPhotoList) {
        putBodyParameter("personPhotoList",personPhotoList);
        this.personPhotoList = personPhotoList;
    }

    public String getOwnerPersonId() {
        return ownerPersonId;
    }

    public void setOwnerPersonId(String ownerPersonId) {
        putBodyParameter("ownerPersonId",ownerPersonId);
        this.ownerPersonId = ownerPersonId;
    }

    public String getOwnerFaceUrl() {
        return ownerFaceUrl;
    }

    public void setOwnerFaceUrl(String ownerFaceUrl) {
        putBodyParameter("ownerFaceUrl",ownerFaceUrl);
        this.ownerFaceUrl = ownerFaceUrl;
    }

    public Boolean getHandelPersonLabels() {
        return isHandelPersonLabels;
    }

    public void setHandelPersonLabels(Boolean handelPersonLabels) {
        putBodyParameter("isHandelPersonLabels",handelPersonLabels);
        isHandelPersonLabels = handelPersonLabels;
    }

    public String getRegistBlockName() {
        return registBlockName;
    }

    public void setRegistBlockName(String registBlockName) {
        putBodyParameter("registBlockName",registBlockName);
        this.registBlockName = registBlockName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        putBodyParameter("firstName",firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        putBodyParameter("lastName",lastName);
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "HrmsPersonAddRequest{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", registBlockId='" + registBlockId + '\'' +
                ", userSubTypeList=" + userSubTypeList +
                ", personRegisterType='" + personRegisterType + '\'' +
                ", authType='" + authType + '\'' +
                ", paperValidity=" + paperValidity +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", paperType='" + paperType + '\'' +
                ", paperNumber='" + paperNumber + '\'' +
                ", nation='" + nation + '\'' +
                ", liveAddress='" + liveAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", classification='" + classification + '\'' +
                ", userName='" + userName + '\'' +
                ", birthAddress='" + birthAddress + '\'' +
                ", orgionPlace='" + orgionPlace + '\'' +
                ", religion='" + religion + '\'' +
                ", marriageStatus='" + marriageStatus + '\'' +
                ", eduction='" + eduction + '\'' +
                ", isMilitaryService='" + isMilitaryService + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", residencePermit='" + residencePermit + '\'' +
                ", residenceBeginTime='" + residenceBeginTime + '\'' +
                ", residenceEndTime=" + residenceEndTime +
                ", liveReason='" + liveReason + '\'' +
                ", isForeign=" + isForeign +
                ", nationality='" + nationality + '\'' +
                ", emergencyPerson='" + emergencyPerson + '\'' +
                ", emergencyPersonTel='" + emergencyPersonTel + '\'' +
                ", liveEndTime=" + liveEndTime +
                ", residenceType='" + residenceType + '\'' +
                ", residenceNumber='" + residenceNumber + '\'' +
                ", residencePrimaryName='" + residencePrimaryName + '\'' +
                ", residencePrimaryPhone='" + residencePrimaryPhone + '\'' +
                ", residenceRelation='" + residenceRelation + '\'' +
                ", residencePrimaryPaperType='" + residencePrimaryPaperType + '\'' +
                ", residencePrimaryPaperNumber='" + residencePrimaryPaperNumber + '\'' +
                ", alias='" + alias + '\'' +
                ", lhmd='" + lhmd + '\'' +
                ", lhTime='" + lhTime + '\'' +
                ", houseOrgCode='" + houseOrgCode + '\'' +
                ", personPhotoList=" + personPhotoList +
                ", ownerPersonId='" + ownerPersonId + '\'' +
                ", ownerFaceUrl='" + ownerFaceUrl + '\'' +
                ", isHandelPersonLabels=" + isHandelPersonLabels +
                ", registBlockName='" + registBlockName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {

        /** 姓名 */
        private String name;
        /** 人员类别（1-常住人口，2-流动人员，3-其他人口，5-境外人口） */
        private String type;
        /** 登记小区ID */
        private String registBlockId;
        /** 人员身份 */
        private List<String> userSubTypeList;
        /** 人员登记类型 */
        private String personRegisterType;
        /** 实名认证方式，1-现场登记；2-在线实名认证；3-人工审核 */
        private String authType;
        /** 证件有效期/签发日期 */
        private Date paperValidity;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder registBlockId(String registBlockId) {
            this.registBlockId = registBlockId;
            return this;
        }

        public Builder userSubTypeList(List<String> userSubTypeList) {
            this.userSubTypeList = userSubTypeList;
            return this;
        }

        public Builder personRegisterType(String personRegisterType) {
            this.personRegisterType = personRegisterType;
            return this;
        }

        public Builder authType(String authType) {
            this.authType = authType;
            return this;
        }

        public Builder paperValidity(Date paperValidity) {
            this.paperValidity = paperValidity;
            return this;
        }

        public HrmsPersonAddRequest build() throws ClientException {
            return new HrmsPersonAddRequest(this);
        }

    }

    private static class PersonPhoto {
        /** 照片主键ID */
        private String id;
        /** 是否为封面照（1-是，0-否） */
        private Integer icCover;
        /** 照片名称 */
        private String photoName;
        /** 照片类型（参考数据字典） */
        private String type;
        /** 照片OSS相对路径 */
        private String url;
        /** 人员ID */
        private String personId;
        /** 创建时间 */
        private Date createTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getIcCover() {
            return icCover;
        }

        public void setIcCover(Integer icCover) {
            this.icCover = icCover;
        }

        public String getPhotoName() {
            return photoName;
        }

        public void setPhotoName(String photoName) {
            this.photoName = photoName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        @Override
        public String toString() {
            return "PersonPhoto{" +
                    "id='" + id + '\'' +
                    ", icCover=" + icCover +
                    ", photoName='" + photoName + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", personId='" + personId + '\'' +
                    ", createTime=" + createTime +
                    '}';
        }
    }
}
