package com.dahuatech.icc.hrms.model.v202011.building;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.sun.javaws.security.AppContextUtil;

import java.util.List;

/**
 * 楼栋新增
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class HrmsBuildingAddRequest extends AbstractIccRequest<HrmsBuildingAddResponse> {

    /** 建筑物类型 */
    private String buildType;
    /** 楼栋名称 */
    private String buildingName;
    /** 房屋用途 */
    private Integer houseUseFor;
    /** 批量添加【0-否，1-是】 */
    private Integer isBatchAdd;
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

    /** 楼栋序号【isBatchAdd=0时必填】 */
    private String buildingNum;
    /** 楼栋开始序号【isBatchAdd=1时必填】 */
    private String startNum;
    /** 楼栋结束序号【isBatchAdd=1时必填】 */
    private String endNum;
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

    public HrmsBuildingAddRequest(Builder builder) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_BUILDING_ADD_POST),Method.POST);
        this.buildType =builder.buildType;
        this.buildingName = builder.buildingName;
        this.houseUseFor = builder.houseUseFor;
        this.isBatchAdd = builder.isBatchAdd;
        this.address = builder.address;
        this.dwellingUnits = builder.dwellingUnits;
        this.groundFloors = builder.groundFloors;
        this.houseSperfloor = builder.houseSperfloor;
        this.undergroundLayers = builder.undergroundLayers;
        this.blockId = builder.blockId;
        this.blockName = builder.blockName;
        this.isAddPerson = builder.isAddPerson;
        this.houseInfoList = builder.houseInfoList;
        putBodyParameter("buildType",buildType);
        putBodyParameter("buildingName",buildingName);
        putBodyParameter("houseUseFor",houseUseFor);
        putBodyParameter("isBatchAdd",isBatchAdd);
        putBodyParameter("address",address);
        putBodyParameter("dwellingUnits",dwellingUnits);
        putBodyParameter("groundFloors",groundFloors);
        putBodyParameter("houseSperfloor",houseSperfloor);
        putBodyParameter("undergroundLayers",undergroundLayers);
        putBodyParameter("blockId",blockId);
        putBodyParameter("blockName",blockName);
        putBodyParameter("isAddPerson",isAddPerson);
        putBodyParameter("houseInfoList",houseInfoList);
    }

    @Override
    public Class<HrmsBuildingAddResponse> getResponseClass() {
        return HrmsBuildingAddResponse.class;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
        putBodyParameter("buildType",buildType);
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
        putBodyParameter("buildingName",buildingName);
    }

    public Integer getHouseUseFor() {
        return houseUseFor;
    }

    public void setHouseUseFor(Integer houseUseFor) {
        this.houseUseFor = houseUseFor;
        putBodyParameter("houseUseFor",houseUseFor);
    }

    public Integer getIsBatchAdd() {
        return isBatchAdd;
    }

    public void setIsBatchAdd(Integer isBatchAdd) {
        this.isBatchAdd = isBatchAdd;
        putBodyParameter("isBatchAdd",isBatchAdd);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        putBodyParameter("address",address);
    }

    public String getDwellingUnits() {
        return dwellingUnits;
    }

    public void setDwellingUnits(String dwellingUnits) {
        this.dwellingUnits = dwellingUnits;
        putBodyParameter("dwellingUnits",dwellingUnits);
    }

    public String getGroundFloors() {
        return groundFloors;
    }

    public void setGroundFloors(String groundFloors) {
        this.groundFloors = groundFloors;
        putBodyParameter("groundFloors",groundFloors);
    }

    public String getHouseSperfloor() {
        return houseSperfloor;
    }

    public void setHouseSperfloor(String houseSperfloor) {
        this.houseSperfloor = houseSperfloor;
        putBodyParameter("houseSperfloor",houseSperfloor);
    }

    public String getUndergroundLayers() {
        return undergroundLayers;
    }

    public void setUndergroundLayers(String undergroundLayers) {
        this.undergroundLayers = undergroundLayers;
        putBodyParameter("undergroundLayers",undergroundLayers);
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
        putBodyParameter("blockId",blockId);
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
        putBodyParameter("blockName",blockName);
    }

    public String getIsAddPerson() {
        return isAddPerson;
    }

    public void setIsAddPerson(String isAddPerson) {
        this.isAddPerson = isAddPerson;
        putBodyParameter("isAddPerson",isAddPerson);
    }

    public List<HouseInfo> getHouseInfoList() {
        return houseInfoList;
    }

    public void setHouseInfoList(List<HouseInfo> houseInfoList) {
        this.houseInfoList = houseInfoList;
        putBodyParameter("houseInfoList",houseInfoList);
    }

    public List<PhoneList> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<PhoneList> phoneList) {
        putBodyParameter("phoneList",phoneList);
        this.phoneList = phoneList;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        putBodyParameter("buildingNum",buildingNum);
        this.buildingNum = buildingNum;
    }

    public String getStartNum() {
        return startNum;
    }

    public void setStartNum(String startNum) {
        putBodyParameter("startNum",startNum);
        this.startNum = startNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        putBodyParameter("endNum",endNum);
        this.endNum = endNum;
    }

    public String getMapX() {
        return mapX;
    }

    public void setMapX(String mapX) {
        putBodyParameter("mapX",mapX);
        this.mapX = mapX;
    }

    public String getMapY() {
        return mapY;
    }

    public void setMapY(String mapY) {
        putBodyParameter("mapY",mapY);
        this.mapY = mapY;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        putBodyParameter("area",area);
        this.area = area;
    }

    public String getIsLiveUnderground() {
        return isLiveUnderground;
    }

    public void setIsLiveUnderground(String isLiveUnderground) {
        putBodyParameter("isLiveUnderground",isLiveUnderground);
        this.isLiveUnderground = isLiveUnderground;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        putBodyParameter("buildDate",buildDate);
        this.buildDate = buildDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        putBodyParameter("description",description);
        this.description = description;
    }

    public String getBuildingPersonId() {
        return buildingPersonId;
    }

    public void setBuildingPersonId(String buildingPersonId) {
        putBodyParameter("buildingPersonId",buildingPersonId);
        this.buildingPersonId = buildingPersonId;
    }

    public String getBuildingPerson() {
        return buildingPerson;
    }

    public void setBuildingPerson(String buildingPerson) {
        putBodyParameter("buildingPerson",buildingPerson);
        this.buildingPerson = buildingPerson;
    }

    public String getBuildingPersonPhone() {
        return buildingPersonPhone;
    }

    public void setBuildingPersonPhone(String buildingPersonPhone) {
        putBodyParameter("buildingPersonPhone",buildingPersonPhone);
        this.buildingPersonPhone = buildingPersonPhone;
    }


    @Override
    public String toString() {
        return "HrmsBuildingAddRequest{" +
                "buildType='" + buildType + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", houseUseFor=" + houseUseFor +
                ", isBatchAdd=" + isBatchAdd +
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
                ", startNum='" + startNum + '\'' +
                ", endNum='" + endNum + '\'' +
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


    public static class Builder {

        /** 建筑物类型 */
        private String buildType;
        /** 楼栋名称 */
        private String buildingName;
        /** 房屋用途 */
        private Integer houseUseFor;
        /** 批量添加【0-否，1-是】 */
        private Integer isBatchAdd;
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

        public Builder buildType(String buildType) {
            this.buildType = buildType;
            return this;
        }

        public Builder buildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }

        public Builder houseUseFor(Integer houseUseFor) {
            this.houseUseFor = houseUseFor;
            return this;
        }

        public Builder isBatchAdd(Integer isBatchAdd) {
            this.isBatchAdd = isBatchAdd;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder dwellingUnits(String dwellingUnits) {
            this.dwellingUnits = dwellingUnits;
            return this;
        }

        public Builder groundFloors(String groundFloors) {
            this.groundFloors = groundFloors;
            return this;
        }

        public Builder houseSperfloor(String houseSperfloor) {
            this.houseSperfloor = houseSperfloor;
            return this;
        }

        public Builder undergroundLayers(String undergroundLayers) {
            this.undergroundLayers = undergroundLayers;
            return this;
        }

        public Builder blockId(String blockId) {
            this.blockId = blockId;
            return this;
        }

        public Builder blockName(String blockName) {
            this.blockName = blockName;
            return this;
        }

        public Builder isAddPerson(String isAddPerson) {
            this.isAddPerson = isAddPerson;
            return this;
        }

        public Builder houseInfoList(List<HouseInfo> houseInfoList) {
            this.houseInfoList = houseInfoList;
            return this;
        }

        public HrmsBuildingAddRequest build() throws ClientException {
            return new HrmsBuildingAddRequest(this);
        }

    }

    public static class PhoneList {

    }

    public static class HouseInfo {

    }
}
