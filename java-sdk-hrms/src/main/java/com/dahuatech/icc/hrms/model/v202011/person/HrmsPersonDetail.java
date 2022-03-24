package com.dahuatech.icc.hrms.model.v202011.person;

import java.util.Date;
import java.util.List;

public class HrmsPersonDetail {

    /** 人员ID */
    private String id;
    /** 别名 */
    private String alias;
    /** 实名认证方式（1-现场登记，2-在线实名认证，3-人工审核） */
    private Integer authType;
    /** 实名认证方式 */
    private String authTypeStr;
    /** 出生地 */
    private String birthAddress;
    /** 出生日期 */
    private Date birthday;
    /** 出生日期 */
    private String birthdayStr;
    /** 血型（参考数据字典） */
    private String bloodType;
    /** 血型 */
    private String bloodTypeStr;
    /** brm人员ID */
    private Long cardPersonId;
    /** 人员标签 */
    private String classification;
    /** 人员标签 */
    private String classificationStr;
    /** 标签颜色 */
    private String color;
    /** 服务处所/工作单位 */
    private String company;
    /** 创建时间 */
    private String createTimeStr;
    /** 创建用户ID */
    private String createUser;
    /** 文化程度（参考数据字典） */
    private String eduction;
    /** 文化程度 */
    private String eductionStr;
    /** 紧急联系人 */
    private String emergencyPerson;
    /** 紧急联系人联系方式 */
    private String emergencyPersonTel;
    /** 外文名 */
    private String firstName;
    /** 人员绑定的房屋组织编码 */
    private String houseOrgCode;
    /** 是否境外人员 */
    private Integer isForeign;
    /** 是否境外人员 */
    private String isForeignStr;
    /** 兵役情况（1-服过兵役，0-没有） */
    private String isMilitaryService;
    /** 兵役情况（1-服过兵役，0-没有） */
    private String isMilitaryServiceStr;
    /** 标签ID */
    private String labelId;
    /** 标签名 */
    private String labelName;
    /** 外文姓 */
    private String lastName;
    /** 来华时间 */
    private Date lhTime;
    /** 来华时间 */
    private String lhTimeStr;
    /** 来华目的（参考数据字典） */
    private String lhmd;
    /** 来华目的（参考数据字典） */
    private String lhmdStr;
    /** 居住地址 */
    private String liveAddress;
    /** 居住结束时间 */
    private Date liveEndTime;
    /** 居住结束时间 */
    private String liveEndTimeStr;
    /** 暂住事由（参考数据字典) */
    private String liveReason;
    /** 暂住事由 */
    private String liveReasonStr;
    /** 婚姻状态（参考数据字典） */
    private String marriageStatus;
    /** 婚姻状态（参考数据字典） */
    private String marriageStatusStr;
    /** 姓名 */
    private String name;
    /** 民族 */
    private String nationStr;
    /** 国籍（参考数据字典） */
    private String nationality;
    /** 国籍（参考数据字典） */
    private String nationalityStr;
    /** 户籍地址 */
    private String orgionPlace;
    /** 户主头像照（前端用此字段判断户主证件照是否可以更新） */
    private String ownerFaceUrl;
    /** 户主对应的人员id（户主可以手填，也可以从库内选择） */
    private String ownerPersonId;
    /** 证件号码 */
    private String paperNumber;
    /** 证件类型（参考数据字典） */
    private String paperType;
    /** 证件有效期/签发日期 */
    private Date paperValidity;
    /** 证件有效期/签发日期 */
    private String paperValidityStr;
    /** 人员照片 */
    private List<PersonPhoto> personPhotoList;
    /** 人员登记类型（不再维护） */
    private String personRegisterType;
    /** 人员登记类型 */
    private String personRegisterTypeStr;
    /** 手机号 */
    private String phone;
    /** 人脸照or封面照 */
    private String picUrl;
    /** 政治面貌 */
    private String politicalStatus;
    /** 政治面貌 */
    private String politicalStatusStr;
    /** 登记小区Id */
    private String registBlockId;
    /** 登记小区名 */
    private String registBlockName;
    /** 宗教信仰（参考数据字典） */
    private String religion;
    /** 宗教信仰（参考数据字典） */
    private String religionStr;
    /** 居住证起始日期 */
    private Date residenceBeginTime;
    /** 居住证起始日期 */
    private String residenceBeginTimeStr;
    /** 居住证结束日期 */
    private Date residenceEndTime;
    /** 居住证结束日期 */
    private String residenceEndTimeStr;
    /** 户号 */
    private String residenceNumber;
    /** 户主姓名 */
    private String residencePrimaryName;
    /** 户主证件号码 */
    private String residencePrimaryPaperNumber;
    /** 户主证件类型（参考数据字典） */
    private String residencePrimaryPaperType;
    /** 户主证件类型 */
    private String residencePrimaryPaperTypeStr;
    /** 户主电话 */
    private String residencePrimaryPhone;
    /** 与户主关系 */
    private String residenceRelation;
    /** 户口类型（参考数据字典） */
    private String residenceType;
    /** 户口类型（参考数据字典） */
    private String residenceTypeStr;
    /** 性别 */
    private String sex;
    /** 性别 */
    private String sexStr;
    /** 人员类别（1-常住人口，2-流动人员，3-其他人口，5-境外人口） */
    private String type;
    /** 人员类别（1-常住人口，2-流动人员，3-其他人口，5-境外人口） */
    private String typeStr;
    /** 修改时间 */
    private String updateTimeStr;
    /** 曾用名 */
    private String userName;
    /** 人员身份 */
    private List<String> useSubTypeList;
    /** 人员身份 */
    private String userSubTypeStr;
    /** 人员身份 */
    private List<UserTypeRel> userTypeRel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getAuthTypeStr() {
        return authTypeStr;
    }

    public void setAuthTypeStr(String authTypeStr) {
        this.authTypeStr = authTypeStr;
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodTypeStr() {
        return bloodTypeStr;
    }

    public void setBloodTypeStr(String bloodTypeStr) {
        this.bloodTypeStr = bloodTypeStr;
    }

    public Long getCardPersonId() {
        return cardPersonId;
    }

    public void setCardPersonId(Long cardPersonId) {
        this.cardPersonId = cardPersonId;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getClassificationStr() {
        return classificationStr;
    }

    public void setClassificationStr(String classificationStr) {
        this.classificationStr = classificationStr;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getEduction() {
        return eduction;
    }

    public void setEduction(String eduction) {
        this.eduction = eduction;
    }

    public String getEductionStr() {
        return eductionStr;
    }

    public void setEductionStr(String eductionStr) {
        this.eductionStr = eductionStr;
    }

    public String getEmergencyPerson() {
        return emergencyPerson;
    }

    public void setEmergencyPerson(String emergencyPerson) {
        this.emergencyPerson = emergencyPerson;
    }

    public String getEmergencyPersonTel() {
        return emergencyPersonTel;
    }

    public void setEmergencyPersonTel(String emergencyPersonTel) {
        this.emergencyPersonTel = emergencyPersonTel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHouseOrgCode() {
        return houseOrgCode;
    }

    public void setHouseOrgCode(String houseOrgCode) {
        this.houseOrgCode = houseOrgCode;
    }

    public Integer getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(Integer isForeign) {
        this.isForeign = isForeign;
    }

    public String getIsForeignStr() {
        return isForeignStr;
    }

    public void setIsForeignStr(String isForeignStr) {
        this.isForeignStr = isForeignStr;
    }

    public String getIsMilitaryService() {
        return isMilitaryService;
    }

    public void setIsMilitaryService(String isMilitaryService) {
        this.isMilitaryService = isMilitaryService;
    }

    public String getIsMilitaryServiceStr() {
        return isMilitaryServiceStr;
    }

    public void setIsMilitaryServiceStr(String isMilitaryServiceStr) {
        this.isMilitaryServiceStr = isMilitaryServiceStr;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLhTime() {
        return lhTime;
    }

    public void setLhTime(Date lhTime) {
        this.lhTime = lhTime;
    }

    public String getLhTimeStr() {
        return lhTimeStr;
    }

    public void setLhTimeStr(String lhTimeStr) {
        this.lhTimeStr = lhTimeStr;
    }

    public String getLhmd() {
        return lhmd;
    }

    public void setLhmd(String lhmd) {
        this.lhmd = lhmd;
    }

    public String getLhmdStr() {
        return lhmdStr;
    }

    public void setLhmdStr(String lhmdStr) {
        this.lhmdStr = lhmdStr;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public Date getLiveEndTime() {
        return liveEndTime;
    }

    public void setLiveEndTime(Date liveEndTime) {
        this.liveEndTime = liveEndTime;
    }

    public String getLiveEndTimeStr() {
        return liveEndTimeStr;
    }

    public void setLiveEndTimeStr(String liveEndTimeStr) {
        this.liveEndTimeStr = liveEndTimeStr;
    }

    public String getLiveReason() {
        return liveReason;
    }

    public void setLiveReason(String liveReason) {
        this.liveReason = liveReason;
    }

    public String getLiveReasonStr() {
        return liveReasonStr;
    }

    public void setLiveReasonStr(String liveReasonStr) {
        this.liveReasonStr = liveReasonStr;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getMarriageStatusStr() {
        return marriageStatusStr;
    }

    public void setMarriageStatusStr(String marriageStatusStr) {
        this.marriageStatusStr = marriageStatusStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationStr() {
        return nationStr;
    }

    public void setNationStr(String nationStr) {
        this.nationStr = nationStr;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalityStr() {
        return nationalityStr;
    }

    public void setNationalityStr(String nationalityStr) {
        this.nationalityStr = nationalityStr;
    }

    public String getOrgionPlace() {
        return orgionPlace;
    }

    public void setOrgionPlace(String orgionPlace) {
        this.orgionPlace = orgionPlace;
    }

    public String getOwnerFaceUrl() {
        return ownerFaceUrl;
    }

    public void setOwnerFaceUrl(String ownerFaceUrl) {
        this.ownerFaceUrl = ownerFaceUrl;
    }

    public String getOwnerPersonId() {
        return ownerPersonId;
    }

    public void setOwnerPersonId(String ownerPersonId) {
        this.ownerPersonId = ownerPersonId;
    }

    public String getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
        this.paperNumber = paperNumber;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public Date getPaperValidity() {
        return paperValidity;
    }

    public void setPaperValidity(Date paperValidity) {
        this.paperValidity = paperValidity;
    }

    public String getPaperValidityStr() {
        return paperValidityStr;
    }

    public void setPaperValidityStr(String paperValidityStr) {
        this.paperValidityStr = paperValidityStr;
    }

    public List<PersonPhoto> getPersonPhotoList() {
        return personPhotoList;
    }

    public void setPersonPhotoList(List<PersonPhoto> personPhotoList) {
        this.personPhotoList = personPhotoList;
    }

    public String getPersonRegisterType() {
        return personRegisterType;
    }

    public void setPersonRegisterType(String personRegisterType) {
        this.personRegisterType = personRegisterType;
    }

    public String getPersonRegisterTypeStr() {
        return personRegisterTypeStr;
    }

    public void setPersonRegisterTypeStr(String personRegisterTypeStr) {
        this.personRegisterTypeStr = personRegisterTypeStr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getPoliticalStatusStr() {
        return politicalStatusStr;
    }

    public void setPoliticalStatusStr(String politicalStatusStr) {
        this.politicalStatusStr = politicalStatusStr;
    }

    public String getRegistBlockId() {
        return registBlockId;
    }

    public void setRegistBlockId(String registBlockId) {
        this.registBlockId = registBlockId;
    }

    public String getRegistBlockName() {
        return registBlockName;
    }

    public void setRegistBlockName(String registBlockName) {
        this.registBlockName = registBlockName;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getReligionStr() {
        return religionStr;
    }

    public void setReligionStr(String religionStr) {
        this.religionStr = religionStr;
    }

    public Date getResidenceBeginTime() {
        return residenceBeginTime;
    }

    public void setResidenceBeginTime(Date residenceBeginTime) {
        this.residenceBeginTime = residenceBeginTime;
    }

    public String getResidenceBeginTimeStr() {
        return residenceBeginTimeStr;
    }

    public void setResidenceBeginTimeStr(String residenceBeginTimeStr) {
        this.residenceBeginTimeStr = residenceBeginTimeStr;
    }

    public Date getResidenceEndTime() {
        return residenceEndTime;
    }

    public void setResidenceEndTime(Date residenceEndTime) {
        this.residenceEndTime = residenceEndTime;
    }

    public String getResidenceEndTimeStr() {
        return residenceEndTimeStr;
    }

    public void setResidenceEndTimeStr(String residenceEndTimeStr) {
        this.residenceEndTimeStr = residenceEndTimeStr;
    }

    public String getResidenceNumber() {
        return residenceNumber;
    }

    public void setResidenceNumber(String residenceNumber) {
        this.residenceNumber = residenceNumber;
    }

    public String getResidencePrimaryName() {
        return residencePrimaryName;
    }

    public void setResidencePrimaryName(String residencePrimaryName) {
        this.residencePrimaryName = residencePrimaryName;
    }

    public String getResidencePrimaryPaperNumber() {
        return residencePrimaryPaperNumber;
    }

    public void setResidencePrimaryPaperNumber(String residencePrimaryPaperNumber) {
        this.residencePrimaryPaperNumber = residencePrimaryPaperNumber;
    }

    public String getResidencePrimaryPaperType() {
        return residencePrimaryPaperType;
    }

    public void setResidencePrimaryPaperType(String residencePrimaryPaperType) {
        this.residencePrimaryPaperType = residencePrimaryPaperType;
    }

    public String getResidencePrimaryPaperTypeStr() {
        return residencePrimaryPaperTypeStr;
    }

    public void setResidencePrimaryPaperTypeStr(String residencePrimaryPaperTypeStr) {
        this.residencePrimaryPaperTypeStr = residencePrimaryPaperTypeStr;
    }

    public String getResidencePrimaryPhone() {
        return residencePrimaryPhone;
    }

    public void setResidencePrimaryPhone(String residencePrimaryPhone) {
        this.residencePrimaryPhone = residencePrimaryPhone;
    }

    public String getResidenceRelation() {
        return residenceRelation;
    }

    public void setResidenceRelation(String residenceRelation) {
        this.residenceRelation = residenceRelation;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getResidenceTypeStr() {
        return residenceTypeStr;
    }

    public void setResidenceTypeStr(String residenceTypeStr) {
        this.residenceTypeStr = residenceTypeStr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getUseSubTypeList() {
        return useSubTypeList;
    }

    public void setUseSubTypeList(List<String> useSubTypeList) {
        this.useSubTypeList = useSubTypeList;
    }

    public String getUserSubTypeStr() {
        return userSubTypeStr;
    }

    public void setUserSubTypeStr(String userSubTypeStr) {
        this.userSubTypeStr = userSubTypeStr;
    }

    public List<UserTypeRel> getUserTypeRel() {
        return userTypeRel;
    }

    public void setUserTypeRel(List<UserTypeRel> userTypeRel) {
        this.userTypeRel = userTypeRel;
    }

    @Override
    public String toString() {
        return "HrmsPersonDetail{" +
                "id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                ", authType=" + authType +
                ", authTypeStr='" + authTypeStr + '\'' +
                ", birthAddress='" + birthAddress + '\'' +
                ", birthday=" + birthday +
                ", birthdayStr='" + birthdayStr + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", bloodTypeStr='" + bloodTypeStr + '\'' +
                ", cardPersonId=" + cardPersonId +
                ", classification='" + classification + '\'' +
                ", classificationStr='" + classificationStr + '\'' +
                ", color='" + color + '\'' +
                ", company='" + company + '\'' +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", createUser='" + createUser + '\'' +
                ", eduction='" + eduction + '\'' +
                ", eductionStr='" + eductionStr + '\'' +
                ", emergencyPerson='" + emergencyPerson + '\'' +
                ", emergencyPersonTel='" + emergencyPersonTel + '\'' +
                ", firstName='" + firstName + '\'' +
                ", houseOrgCode='" + houseOrgCode + '\'' +
                ", isForeign=" + isForeign +
                ", isForeignStr='" + isForeignStr + '\'' +
                ", isMilitaryService='" + isMilitaryService + '\'' +
                ", isMilitaryServiceStr='" + isMilitaryServiceStr + '\'' +
                ", labelId='" + labelId + '\'' +
                ", labelName='" + labelName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lhTime=" + lhTime +
                ", lhTimeStr='" + lhTimeStr + '\'' +
                ", lhmd='" + lhmd + '\'' +
                ", lhmdStr='" + lhmdStr + '\'' +
                ", liveAddress='" + liveAddress + '\'' +
                ", liveEndTime=" + liveEndTime +
                ", liveEndTimeStr='" + liveEndTimeStr + '\'' +
                ", liveReason='" + liveReason + '\'' +
                ", liveReasonStr='" + liveReasonStr + '\'' +
                ", marriageStatus='" + marriageStatus + '\'' +
                ", marriageStatusStr='" + marriageStatusStr + '\'' +
                ", name='" + name + '\'' +
                ", nationStr='" + nationStr + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nationalityStr='" + nationalityStr + '\'' +
                ", orgionPlace='" + orgionPlace + '\'' +
                ", ownerFaceUrl='" + ownerFaceUrl + '\'' +
                ", ownerPersonId='" + ownerPersonId + '\'' +
                ", paperNumber='" + paperNumber + '\'' +
                ", paperType='" + paperType + '\'' +
                ", paperValidity=" + paperValidity +
                ", paperValidityStr='" + paperValidityStr + '\'' +
                ", personPhotoList=" + personPhotoList +
                ", personRegisterType='" + personRegisterType + '\'' +
                ", personRegisterTypeStr='" + personRegisterTypeStr + '\'' +
                ", phone='" + phone + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", politicalStatusStr='" + politicalStatusStr + '\'' +
                ", registBlockId='" + registBlockId + '\'' +
                ", registBlockName='" + registBlockName + '\'' +
                ", religion='" + religion + '\'' +
                ", religionStr='" + religionStr + '\'' +
                ", residenceBeginTime=" + residenceBeginTime +
                ", residenceBeginTimeStr='" + residenceBeginTimeStr + '\'' +
                ", residenceEndTime=" + residenceEndTime +
                ", residenceEndTimeStr='" + residenceEndTimeStr + '\'' +
                ", residenceNumber='" + residenceNumber + '\'' +
                ", residencePrimaryName='" + residencePrimaryName + '\'' +
                ", residencePrimaryPaperNumber='" + residencePrimaryPaperNumber + '\'' +
                ", residencePrimaryPaperType='" + residencePrimaryPaperType + '\'' +
                ", residencePrimaryPaperTypeStr='" + residencePrimaryPaperTypeStr + '\'' +
                ", residencePrimaryPhone='" + residencePrimaryPhone + '\'' +
                ", residenceRelation='" + residenceRelation + '\'' +
                ", residenceType='" + residenceType + '\'' +
                ", residenceTypeStr='" + residenceTypeStr + '\'' +
                ", sex='" + sex + '\'' +
                ", sexStr='" + sexStr + '\'' +
                ", type='" + type + '\'' +
                ", typeStr='" + typeStr + '\'' +
                ", updateTimeStr='" + updateTimeStr + '\'' +
                ", userName='" + userName + '\'' +
                ", useSubTypeList=" + useSubTypeList +
                ", userSubTypeStr='" + userSubTypeStr + '\'' +
                ", userTypeRel=" + userTypeRel +
                '}';
    }

    private static class UserTypeRel {
        /** 身份子类编号 */
        private String userTypeId;
        /** 身份子类名称 */
        private String userTypeName;
        /** 标签Id */
        private String labelId;

        public String getUserTypeId() {
            return userTypeId;
        }

        public void setUserTypeId(String userTypeId) {
            this.userTypeId = userTypeId;
        }

        public String getUserTypeName() {
            return userTypeName;
        }

        public void setUserTypeName(String userTypeName) {
            this.userTypeName = userTypeName;
        }

        public String getLabelId() {
            return labelId;
        }

        public void setLabelId(String labelId) {
            this.labelId = labelId;
        }

        @Override
        public String toString() {
            return "UserTypeRel{" +
                    "userTypeId='" + userTypeId + '\'' +
                    ", userTypeName='" + userTypeName + '\'' +
                    ", labelId='" + labelId + '\'' +
                    '}';
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
