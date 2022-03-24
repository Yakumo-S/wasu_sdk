package com.dahuatech.icc.assesscontrol.model.v202103.firstCard;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 首卡列表
 *
 * @author 237417
 */
public class FirstCardPageResponse extends IccResponse {
    /** 详情 */
    private FirstCardData data;

    public FirstCardData getData() {
        return data;
    }

    public void setData(FirstCardData data) {
        this.data = data;
    }

    public static class FirstCardData {
        /** 1 */
        private Number currentPage;
        /** 是否启用云数据 */
        private boolean enableCloudDB;
        /** 页面数据 */
        private List<FirstCardPageData> pageData;
        /** 页面大小 */
        private Number pageSize;
        /** 页面大小 */
        private Number totalPage;
        /** 总行数 */
        private Number totalRow;

        public Number getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Number currentPage) {
            this.currentPage = currentPage;
        }

        public boolean isEnableCloudDB() {
            return enableCloudDB;
        }

        public void setEnableCloudDB(boolean enableCloudDB) {
            this.enableCloudDB = enableCloudDB;
        }

        public List<FirstCardPageData> getPageData() {
            return pageData;
        }

        public void setPageData(List<FirstCardPageData> pageData) {
            this.pageData = pageData;
        }

        public Number getPageSize() {
            return pageSize;
        }

        public void setPageSize(Number pageSize) {
            this.pageSize = pageSize;
        }

        public Number getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(Number totalPage) {
            this.totalPage = totalPage;
        }

        public Number getTotalRow() {
            return totalRow;
        }

        public void setTotalRow(Number totalRow) {
            this.totalRow = totalRow;
        }

        @Override
        public String toString() {
            return "FirstCardData{" +
                    "currentPage=" + currentPage +
                    ", enableCloudDB=" + enableCloudDB +
                    ", pageData=" + pageData +
                    ", pageSize=" + pageSize +
                    ", totalPage=" + totalPage +
                    ", totalRow=" + totalRow +
                    '}';
        }
    }

    public static class FirstCardPageData {
        /** ID */
        private Number id;
        /** 通道码 */
        private String channelCode;
        /** 通道名称 */
        private String channelName;
        /** 设备名称 */
        private String deviceName;
        /** 设备状态 */
        private String deviceStatus;
        /** 首卡使能 */
        private String firstCardEnable;
        /** 开门计划 */
        private String firstCardOpenTime;
        /** 开门计划ID */
        private String firstCardOpenTimeId;
        /** 首卡状态 */
        private String firstCardStatus;
        /** 人员编码 */
        private String personCode;

        public Number getId() {
            return id;
        }

        public void setId(Number id) {
            this.id = id;
        }

        public String getChannelCode() {
            return channelCode;
        }

        public void setChannelCode(String channelCode) {
            this.channelCode = channelCode;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getDeviceStatus() {
            return deviceStatus;
        }

        public void setDeviceStatus(String deviceStatus) {
            this.deviceStatus = deviceStatus;
        }

        public String getFirstCardEnable() {
            return firstCardEnable;
        }

        public void setFirstCardEnable(String firstCardEnable) {
            this.firstCardEnable = firstCardEnable;
        }

        public String getFirstCardOpenTime() {
            return firstCardOpenTime;
        }

        public void setFirstCardOpenTime(String firstCardOpenTime) {
            this.firstCardOpenTime = firstCardOpenTime;
        }

        public String getFirstCardOpenTimeId() {
            return firstCardOpenTimeId;
        }

        public void setFirstCardOpenTimeId(String firstCardOpenTimeId) {
            this.firstCardOpenTimeId = firstCardOpenTimeId;
        }

        public String getFirstCardStatus() {
            return firstCardStatus;
        }

        public void setFirstCardStatus(String firstCardStatus) {
            this.firstCardStatus = firstCardStatus;
        }

        public String getPersonCode() {
            return personCode;
        }

        public void setPersonCode(String personCode) {
            this.personCode = personCode;
        }

        @Override
        public String toString() {
            return "FirstCardPageData{" +
                    "id=" + id +
                    ", channelCode='" + channelCode + '\'' +
                    ", channelName='" + channelName + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", deviceStatus='" + deviceStatus + '\'' +
                    ", firstCardEnable='" + firstCardEnable + '\'' +
                    ", firstCardOpenTime='" + firstCardOpenTime + '\'' +
                    ", firstCardOpenTimeId='" + firstCardOpenTimeId + '\'' +
                    ", firstCardStatus='" + firstCardStatus + '\'' +
                    ", personCode='" + personCode + '\'' +
                    '}';
        }
    }
}
