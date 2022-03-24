package com.dahuatech.icc.hrms.model.v202011.building;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 楼栋修改
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class HrmsBuildingUpdateRequest extends AbstractIccRequest<HrmsBuildingUpdateResponse> {

    /**楼栋ID*/
    private String id;
    /** 建筑物类型 */
    private String buildType;
    /** 楼栋名称 */
    private String buildingName;
    /** 房屋用途 */
    private Integer houseUseFor;
    /** 批量添加，【默认0】 */
    private Integer isBatchAdd;
    /** 楼栋序号【isBatchAdd=0时必填】 */
    private String buildingNum;
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
    private List<HrmsBuildingDetail.HouseInfo> houseInfoList;
    /*--------以上必填-----*/


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
    private List<HrmsBuildingDetail.PhoneList> phoneList;

    public HrmsBuildingUpdateRequest(Builder builder) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_BUILDING_UPDATE_POST), Method.POST);
        this.id = builder.id;
        this.buildType = builder.buildType;
        this.buildingName = builder.buildingName;
        this.houseUseFor = builder.houseUseFor;
        this.isBatchAdd = builder.isBatchAdd;
        this.buildingNum = builder.buildingNum;
        this.address = builder.address;
        this.dwellingUnits = builder.dwellingUnits;
        this.groundFloors = builder.groundFloors;
        this.houseSperfloor = builder.houseSperfloor;
        this.undergroundLayers = builder.undergroundLayers;
        this.blockId = builder.blockId;
        this.blockName = builder.blockName;
        this.isAddPerson = builder.isAddPerson;
        putBodyParameter("id",id);
        putBodyParameter("buildType",buildType);
        putBodyParameter("buildingName",buildingName);
        putBodyParameter("houseUseFor",houseUseFor);
        putBodyParameter("isBatchAdd",isBatchAdd);
        putBodyParameter("buildingNum",buildingNum);
        putBodyParameter("address",address);
        putBodyParameter("dwellingUnits",dwellingUnits);
        putBodyParameter("groundFloors",groundFloors);
        putBodyParameter("houseSperfloor",houseSperfloor);
        putBodyParameter("blockId",blockId);
        putBodyParameter("blockName",blockName);
        putBodyParameter("isAddPerson",isAddPerson);
        putBodyParameter("houseInfoList",houseInfoList);
    }

    @Override
    public Class<HrmsBuildingUpdateResponse> getResponseClass() {
        return HrmsBuildingUpdateResponse.class;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        putBodyParameter("id",id);
        this.id = id;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        putBodyParameter("buildType",buildType);
        this.buildType = buildType;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        putBodyParameter("buildingName",buildingName);
        this.buildingName = buildingName;
    }

    public Integer getHouseUseFor() {
        return houseUseFor;
    }

    public void setHouseUseFor(Integer houseUseFor) {
        putBodyParameter("houseUseFor",houseUseFor);
        this.houseUseFor = houseUseFor;
    }

    public Integer getIsBatchAdd() {
        return isBatchAdd;
    }

    public void setIsBatchAdd(Integer isBatchAdd) {
        putBodyParameter("isBatchAdd",isBatchAdd);
        this.isBatchAdd = isBatchAdd;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        putBodyParameter("buildingNum",buildingNum);
        this.buildingNum = buildingNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        putBodyParameter("address",address);
        this.address = address;
    }

    public String getDwellingUnits() {
        return dwellingUnits;
    }

    public void setDwellingUnits(String dwellingUnits) {
        putBodyParameter("dwellingUnits",dwellingUnits);
        this.dwellingUnits = dwellingUnits;
    }

    public String getGroundFloors() {
        return groundFloors;
    }

    public void setGroundFloors(String groundFloors) {
        putBodyParameter("groundFloors",groundFloors);
        this.groundFloors = groundFloors;
    }

    public String getHouseSperfloor() {
        return houseSperfloor;
    }

    public void setHouseSperfloor(String houseSperfloor) {
        putBodyParameter("houseSperfloor",houseSperfloor);
        this.houseSperfloor = houseSperfloor;
    }

    public String getUndergroundLayers() {
        return undergroundLayers;
    }

    public void setUndergroundLayers(String undergroundLayers) {
        putBodyParameter("undergroundLayers",undergroundLayers);
        this.undergroundLayers = undergroundLayers;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        putBodyParameter("blockId",blockId);
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        putBodyParameter("blockName",blockName);
        this.blockName = blockName;
    }

    public String getIsAddPerson() {
        return isAddPerson;
    }

    public void setIsAddPerson(String isAddPerson) {
        putBodyParameter("isAddPerson",isAddPerson);
        this.isAddPerson = isAddPerson;
    }

    public List<HrmsBuildingDetail.HouseInfo> getHouseInfoList() {
        return houseInfoList;
    }

    public void setHouseInfoList(List<HrmsBuildingDetail.HouseInfo> houseInfoList) {
        putBodyParameter("houseInfoList",houseInfoList);
        this.houseInfoList = houseInfoList;
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

    public List<HrmsBuildingDetail.PhoneList> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<HrmsBuildingDetail.PhoneList> phoneList) {
        putBodyParameter("phoneList",phoneList);
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "HrmsBuildingUpdateRequest{" +
                "id='" + id + '\'' +
                ", buildType='" + buildType + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", houseUseFor=" + houseUseFor +
                ", isBatchAdd=" + isBatchAdd +
                ", buildingNum='" + buildingNum + '\'' +
                ", address='" + address + '\'' +
                ", dwellingUnits='" + dwellingUnits + '\'' +
                ", groundFloors='" + groundFloors + '\'' +
                ", houseSperfloor='" + houseSperfloor + '\'' +
                ", undergroundLayers='" + undergroundLayers + '\'' +
                ", blockId='" + blockId + '\'' +
                ", blockName='" + blockName + '\'' +
                ", isAddPerson='" + isAddPerson + '\'' +
                ", houseInfoList=" + houseInfoList +
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

        /**楼栋ID*/
        private String id;
        /** 建筑物类型 */
        private String buildType;
        /** 楼栋名称 */
        private String buildingName;
        /** 房屋用途 */
        private Integer houseUseFor;
        /** 批量添加，【默认0】 */
        private Integer isBatchAdd;
        /** 楼栋序号【isBatchAdd=0时必填】 */
        private String buildingNum;
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
        private List<HrmsBuildingDetail.HouseInfo> houseInfoList;
        /*--------以上必填-----*/

        public Builder id(String id) {
            this.id = id;
            return this;
        }

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

        public Builder buildingNum(String buildingNum) {
            this.buildingNum = buildingNum;
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

        public Builder houseInfoList(List<HrmsBuildingDetail.HouseInfo> houseInfoList) {
            this.houseInfoList = houseInfoList;
            return this;
        }

        public HrmsBuildingUpdateRequest build() throws ClientException {
            return new HrmsBuildingUpdateRequest(this);
        }
    }
}
