package com.dahuatech.icc.hrms.model.v202011.house;

import java.util.Date;
import java.util.List;

public class HrmsHouseDetail {

    /** 房屋ID */
    private String id;
    /** 房屋所属小区ID */
    private String blockId;
    /** 房屋所属小区名称 */
    private String blockName;
    /** 房屋所属小区地址 */
    private String blockAddressAll;
    /** 房屋所属楼栋ID */
    private String buildingId;
    /** 房屋所属楼栋名称 */
    private String buildingName;
    /** 房屋所属楼栋类型 */
    private String buildingType;
    /** 房屋所属楼栋地址 */
    private String buildingAddress;
    /** 房屋组织编码 */
    private String orgCode;
    /** 部门ID */
    private Long cardDepartId;
    /** 房屋所属单元 */
    private Integer houseUnit;
    /** 房屋所在层数 */
    private Integer noFloor;
    /** 房屋所在户数 */
    private Integer noHouseHold;
    /** 房屋号 */
    private String houseCode;
    /** 房屋状态 0：禁用，1-启用 */
    private Integer houseState;
    /** 房屋类型 */
    private Integer houseType;
    /** 房屋地址 */
    private String houseAddress;
    /** 房屋全地址 */
    private String houseAddressAll;
    /** 房屋用途 */
    private Integer houseUseFor;
    /** 房屋用途翻译 */
    private String houseUseForName;
    /** 建筑性质 */
//    private Integer buildingType;
    /** 建筑面积 */
    private String houseArea;
    /** 房间数 */
    private Integer roomNum;
    /** 房屋下入住人数 */
    private Integer householdPerson;
    /** 房屋下入住人员 */
    private List<String> hrmsPersonInfoList;
    /** 房屋二维码 */
    private String houseQrCode;
    /** 描述 */
    private String description;
    /** 业主人员表ID */
    private String ownerPersonId;
    /** 业主姓名 */
    private String houseOwner;
    /** 业主证件类型 */
    private String ownerCertType;
    /** 业主证件号 */
    private String ownerCert;
    /** 业主证件类型 */
    private String ownerCerType;
    /** 业主手机号 */
    private String ownerPhone;
    /** 业务照片集合 */
    private List<String> ownerPersonPhotoList;
    /** 承租人人员表ID */
    private String renterPersonId;
    /** 承租人姓名 */
    private String renterName;
    /** 承租人证件类型 */
    private String renterCertType;
    /** 承租人身份证号 */
    private String renterCert;
    /** 承租人手机号 */
    private String renterPhone;
    /** 承租人照片集合 */
    private List<String> renterPersonPhotoList;
    /** 委托人ID */
    private String assignorId;
    /** 委托人姓名 */
    private String assignor;
    /** 委托人证件类型 */
    private String assignorCertType;
    /** 委托人证件号 */
    private String assignorCert;
    /** 委托人电话 */
    private String assignorPhone;
    /** 委托人照片集合 */
    private List<String> assignorPersonPhotoList;
    /** 是否允许删除 */
    private Integer allowDelete;
    /** 创建日期 */
    private Date createDate;
    /** 修改日期 */
    private Date updateDate;
    /** 所属单位ID */
    private String companyId;
    /** 所属单位 */
    private String company;
    /** 创建用户名 */
    private String createUser;
    /** 更新用户名 */
    private String updateUser;
    /** 下级域Id */
    private String domainId;
    /** 房屋产权证号 */
    private String propertyCertificateNumber;
    /** 经度 */
    private String mapX;
    /** 纬度 */
    private String mapY;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockAddressAll() {
        return blockAddressAll;
    }

    public void setBlockAddressAll(String blockAddressAll) {
        this.blockAddressAll = blockAddressAll;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Long getCardDepartId() {
        return cardDepartId;
    }

    public void setCardDepartId(Long cardDepartId) {
        this.cardDepartId = cardDepartId;
    }

    public Integer getNoFloor() {
        return noFloor;
    }

    public void setNoFloor(Integer noFloor) {
        this.noFloor = noFloor;
    }

    public Integer getNoHouseHold() {
        return noHouseHold;
    }

    public void setNoHouseHold(Integer noHouseHold) {
        this.noHouseHold = noHouseHold;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public Integer getHouseState() {
        return houseState;
    }

    public void setHouseState(Integer houseState) {
        this.houseState = houseState;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseAddressAll() {
        return houseAddressAll;
    }

    public void setHouseAddressAll(String houseAddressAll) {
        this.houseAddressAll = houseAddressAll;
    }

    public Integer getHouseUseFor() {
        return houseUseFor;
    }

    public void setHouseUseFor(Integer houseUseFor) {
        this.houseUseFor = houseUseFor;
    }

    public String getHouseUseForName() {
        return houseUseForName;
    }

    public void setHouseUseForName(String houseUseForName) {
        this.houseUseForName = houseUseForName;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getHouseholdPerson() {
        return householdPerson;
    }

    public void setHouseholdPerson(Integer householdPerson) {
        this.householdPerson = householdPerson;
    }

    public List<String> getHrmsPersonInfoList() {
        return hrmsPersonInfoList;
    }

    public void setHrmsPersonInfoList(List<String> hrmsPersonInfoList) {
        this.hrmsPersonInfoList = hrmsPersonInfoList;
    }

    public String getHouseQrCode() {
        return houseQrCode;
    }

    public void setHouseQrCode(String houseQrCode) {
        this.houseQrCode = houseQrCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerPersonId() {
        return ownerPersonId;
    }

    public void setOwnerPersonId(String ownerPersonId) {
        this.ownerPersonId = ownerPersonId;
    }

    public String getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(String houseOwner) {
        this.houseOwner = houseOwner;
    }

    public String getOwnerCertType() {
        return ownerCertType;
    }

    public void setOwnerCertType(String ownerCertType) {
        this.ownerCertType = ownerCertType;
    }

    public String getOwnerCert() {
        return ownerCert;
    }

    public void setOwnerCert(String ownerCert) {
        this.ownerCert = ownerCert;
    }

    public String getOwnerCerType() {
        return ownerCerType;
    }

    public void setOwnerCerType(String ownerCerType) {
        this.ownerCerType = ownerCerType;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public List<String> getOwnerPersonPhotoList() {
        return ownerPersonPhotoList;
    }

    public void setOwnerPersonPhotoList(List<String> ownerPersonPhotoList) {
        this.ownerPersonPhotoList = ownerPersonPhotoList;
    }

    public String getRenterPersonId() {
        return renterPersonId;
    }

    public void setRenterPersonId(String renterPersonId) {
        this.renterPersonId = renterPersonId;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getRenterCertType() {
        return renterCertType;
    }

    public void setRenterCertType(String renterCertType) {
        this.renterCertType = renterCertType;
    }

    public String getRenterCert() {
        return renterCert;
    }

    public void setRenterCert(String renterCert) {
        this.renterCert = renterCert;
    }

    public List<String> getRenterPersonPhotoList() {
        return renterPersonPhotoList;
    }

    public void setRenterPersonPhotoList(List<String> renterPersonPhotoList) {
        this.renterPersonPhotoList = renterPersonPhotoList;
    }

    public String getAssignorId() {
        return assignorId;
    }

    public void setAssignorId(String assignorId) {
        this.assignorId = assignorId;
    }

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
    }

    public String getAssignorCertType() {
        return assignorCertType;
    }

    public void setAssignorCertType(String assignorCertType) {
        this.assignorCertType = assignorCertType;
    }

    public String getAssignorCert() {
        return assignorCert;
    }

    public void setAssignorCert(String assignorCert) {
        this.assignorCert = assignorCert;
    }

    public String getAssignorPhone() {
        return assignorPhone;
    }

    public void setAssignorPhone(String assignorPhone) {
        this.assignorPhone = assignorPhone;
    }

    public List<String> getAssignorPersonPhotoList() {
        return assignorPersonPhotoList;
    }

    public void setAssignorPersonPhotoList(List<String> assignorPersonPhotoList) {
        this.assignorPersonPhotoList = assignorPersonPhotoList;
    }

    public Integer getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Integer allowDelete) {
        this.allowDelete = allowDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getPropertyCertificateNumber() {
        return propertyCertificateNumber;
    }

    public void setPropertyCertificateNumber(String propertyCertificateNumber) {
        this.propertyCertificateNumber = propertyCertificateNumber;
    }

    public String getMapX() {
        return mapX;
    }

    public void setMapX(String mapX) {
        this.mapX = mapX;
    }

    public String getMapY() {
        return mapY;
    }

    public void setMapY(String mapY) {
        this.mapY = mapY;
    }

    @Override
    public String toString() {
        return "HrmsHouseDetail{" +
                "id='" + id + '\'' +
                ", blockId='" + blockId + '\'' +
                ", blockName='" + blockName + '\'' +
                ", blockAddressAll='" + blockAddressAll + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", buildingAddress='" + buildingAddress + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", cardDepartId=" + cardDepartId +
                ", noFloor=" + noFloor +
                ", noHouseHold=" + noHouseHold +
                ", houseCode='" + houseCode + '\'' +
                ", houseState=" + houseState +
                ", houseType=" + houseType +
                ", houseAddress='" + houseAddress + '\'' +
                ", houseAddressAll='" + houseAddressAll + '\'' +
                ", houseUseFor=" + houseUseFor +
                ", houseUseForName='" + houseUseForName + '\'' +
                ", houseArea='" + houseArea + '\'' +
                ", roomNum=" + roomNum +
                ", householdPerson=" + householdPerson +
                ", hrmsPersonInfoList=" + hrmsPersonInfoList +
                ", houseQrCode='" + houseQrCode + '\'' +
                ", description='" + description + '\'' +
                ", ownerPersonId='" + ownerPersonId + '\'' +
                ", houseOwner='" + houseOwner + '\'' +
                ", ownerCertType='" + ownerCertType + '\'' +
                ", ownerCert='" + ownerCert + '\'' +
                ", ownerCerType='" + ownerCerType + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", ownerPersonPhotoList=" + ownerPersonPhotoList +
                ", renterPersonId='" + renterPersonId + '\'' +
                ", renterName='" + renterName + '\'' +
                ", renterCertType='" + renterCertType + '\'' +
                ", renterCert='" + renterCert + '\'' +
                ", renterPersonPhotoList=" + renterPersonPhotoList +
                ", assignorId='" + assignorId + '\'' +
                ", assignor='" + assignor + '\'' +
                ", assignorCertType='" + assignorCertType + '\'' +
                ", assignorCert='" + assignorCert + '\'' +
                ", assignorPhone='" + assignorPhone + '\'' +
                ", assignorPersonPhotoList=" + assignorPersonPhotoList +
                ", allowDelete=" + allowDelete +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", companyId='" + companyId + '\'' +
                ", company='" + company + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", domainId='" + domainId + '\'' +
                ", propertyCertificateNumber='" + propertyCertificateNumber + '\'' +
                ", mapX='" + mapX + '\'' +
                ", mapY='" + mapY + '\'' +
                '}';
    }
}
