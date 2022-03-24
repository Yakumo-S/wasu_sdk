package com.dahuatech.icc.hrms.model.v202011.building;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 楼栋分页查询
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class HrmsBuildingPageResponse extends IccResponse {
    private HrmsBuildingPageList data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public HrmsBuildingPageList getData() {
        return data;
    }

    public void setData(HrmsBuildingPageList data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    @Override
    public String toString() {
        return "HrmsBuildingPageResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class HrmsBuildingPageList {

        private List<HrmsBuildingPageData> pageData;

        public List<HrmsBuildingPageData> getPageData() {
            return pageData;
        }

        public void setPageData(List<HrmsBuildingPageData> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "HrmsBuildingPageList{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

    public static class HrmsBuildingPageData {
        /** 楼栋ID */
        private String id;
        /** 建筑物类型 */
        private String buildType;
        /** 楼栋名称 */
        private String buildingName;
        /** 房屋用途 */
        private Integer houseUseFor;
        /** 楼栋序号 */
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
        /** 经度 */
        private String mapX;
        /** 纬度 */
        private String mapY;
        /** 所属小区ID */
        private String blockId;
        /** 所属小区名称 */
        private String blockName;
        /** 建筑面积【平方米】 */
        private String area;
        /** 地下是否入住【0-否,1-是】 */
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
        /** 同步添加默认住户【0-否，1-是】 */
        private String isAddPerson;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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

        public String getBuildingNum() {
            return buildingNum;
        }

        public void setBuildingNum(String buildingNum) {
            this.buildingNum = buildingNum;
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

        public String getIsAddPerson() {
            return isAddPerson;
        }

        public void setIsAddPerson(String isAddPerson) {
            this.isAddPerson = isAddPerson;
        }

        @Override
        public String toString() {
            return "HrmsBuildingPageData{" +
                    "id='" + id + '\'' +
                    ", buildType='" + buildType + '\'' +
                    ", buildingName='" + buildingName + '\'' +
                    ", houseUseFor=" + houseUseFor +
                    ", buildingNum='" + buildingNum + '\'' +
                    ", address='" + address + '\'' +
                    ", dwellingUnits='" + dwellingUnits + '\'' +
                    ", groundFloors='" + groundFloors + '\'' +
                    ", houseSperfloor='" + houseSperfloor + '\'' +
                    ", undergroundLayers='" + undergroundLayers + '\'' +
                    ", mapX='" + mapX + '\'' +
                    ", mapY='" + mapY + '\'' +
                    ", blockId='" + blockId + '\'' +
                    ", blockName='" + blockName + '\'' +
                    ", area='" + area + '\'' +
                    ", isLiveUnderground='" + isLiveUnderground + '\'' +
                    ", buildDate='" + buildDate + '\'' +
                    ", description='" + description + '\'' +
                    ", buildingPersonId='" + buildingPersonId + '\'' +
                    ", buildingPerson='" + buildingPerson + '\'' +
                    ", buildingPersonPhone='" + buildingPersonPhone + '\'' +
                    ", isAddPerson='" + isAddPerson + '\'' +
                    '}';
        }
    }
}
