package com.dahuatech.icc.hrms.model.v202011.building;

import java.util.List;

/**
 * 楼栋详情
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class HrmsBuildingDetail {
    /** 建筑物类型 */
    private String buildType;
    /** 楼栋名称 */
    private String buildingName;
    /** 房屋用途 */
    private Integer houseUseFor;
    /** 建筑地址 */
    private String address;
    /** 单元数 */
    private String dwellingUnits;
    /** 地面层数 */
    private String groundFloors;
    /** 每层户数 */
    private String houseSperfloor;
    /** 地下层数 */
    private String undergroundLayers;
    /** 所属小区ID */
    private String blockId;
    /** 所属小区名称 */
    private String blockName;
    /** 同步添加默认住户[0-否, 1-是] */
    private String isAddPerson;
    /** 房屋 */
    private List<HouseInfo> houseInfoList;
    /*--------以上必填-----*/

    /** 楼栋序号 */
    private String buildingNum;
    /** 经度 */
    private String mapX;
    /** 纬度 */
    private String mapY;
    /** 建筑面积[平方米] */
    private String area;
    /** 地下是否入住【0-否，1-是】 */
    private String isLiveUnderground;
    /** 建筑年份【yyyy-MM】 */
    private String buildDate;
    /** 楼栋描述 */
    private String description;
    /** 楼栋负责人ID */
    private String buildingPersonId;
    /** 楼栋负责人名称 */
    private String buildingPerson;
    /** 楼栋负责人电话 */
    private String buildingPersonPhone;
    /** 楼栋图片 */
    private List<PhoneList> phoneList;

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getHouseUseFor() {
        return houseUseFor;
    }

    public void setHouseUseFor(Integer houseUseFor) {
        this.houseUseFor = houseUseFor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDwellingUnits() {
        return dwellingUnits;
    }

    public void setDwellingUnits(String dwellingUnits) {
        this.dwellingUnits = dwellingUnits;
    }

    public String getGroundFloors() {
        return groundFloors;
    }

    public void setGroundFloors(String groundFloors) {
        this.groundFloors = groundFloors;
    }

    public String getHouseSperfloor() {
        return houseSperfloor;
    }

    public void setHouseSperfloor(String houseSperfloor) {
        this.houseSperfloor = houseSperfloor;
    }

    public String getUndergroundLayers() {
        return undergroundLayers;
    }

    public void setUndergroundLayers(String undergroundLayers) {
        this.undergroundLayers = undergroundLayers;
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

    public String getIsAddPerson() {
        return isAddPerson;
    }

    public void setIsAddPerson(String isAddPerson) {
        this.isAddPerson = isAddPerson;
    }

    public List<HouseInfo> getHouseInfoList() {
        return houseInfoList;
    }

    public void setHouseInfoList(List<HouseInfo> houseInfoList) {
        this.houseInfoList = houseInfoList;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIsLiveUnderground() {
        return isLiveUnderground;
    }

    public void setIsLiveUnderground(String isLiveUnderground) {
        this.isLiveUnderground = isLiveUnderground;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBuildingPersonId() {
        return buildingPersonId;
    }

    public void setBuildingPersonId(String buildingPersonId) {
        this.buildingPersonId = buildingPersonId;
    }

    public String getBuildingPerson() {
        return buildingPerson;
    }

    public void setBuildingPerson(String buildingPerson) {
        this.buildingPerson = buildingPerson;
    }

    public String getBuildingPersonPhone() {
        return buildingPersonPhone;
    }

    public void setBuildingPersonPhone(String buildingPersonPhone) {
        this.buildingPersonPhone = buildingPersonPhone;
    }

    public List<PhoneList> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<PhoneList> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "HrmsBuildingDetail{" +
                "buildType='" + buildType + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", houseUseFor=" + houseUseFor +
                ", address='" + address + '\'' +
                ", dwellingUnits='" + dwellingUnits + '\'' +
                ", groundFloors='" + groundFloors + '\'' +
                ", houseSperfloor='" + houseSperfloor + '\'' +
                ", undergroundLayers='" + undergroundLayers + '\'' +
                ", blockId='" + blockId + '\'' +
                ", blockName='" + blockName + '\'' +
                ", isAddPerson='" + isAddPerson + '\'' +
                ", houseInfoList=" + houseInfoList +
                ", buildingNum='" + buildingNum + '\'' +
                ", mapX='" + mapX + '\'' +
                ", mapY='" + mapY + '\'' +
                ", area='" + area + '\'' +
                ", isLiveUnderground='" + isLiveUnderground + '\'' +
                ", buildDate='" + buildDate + '\'' +
                ", description='" + description + '\'' +
                ", buildingPersonId='" + buildingPersonId + '\'' +
                ", buildingPerson='" + buildingPerson + '\'' +
                ", buildingPersonPhone='" + buildingPersonPhone + '\'' +
                ", phoneList=" + phoneList +
                '}';
    }

    public static class PhoneList {

    }

    public static class HouseInfo {

    }

}
