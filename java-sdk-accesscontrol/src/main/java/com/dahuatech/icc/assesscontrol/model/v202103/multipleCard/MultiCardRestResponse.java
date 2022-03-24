package com.dahuatech.icc.assesscontrol.model.v202103.multipleCard;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 多卡开门列表
 *
 * @author 237417
 */
public class MultiCardRestResponse extends IccResponse {
    /** 数据 */
    private MultiCardData data;

    public MultiCardData getData() {
        return data;
    }

    public void setData(MultiCardData data) {
        this.data = data;
    }

    public static class MultiCardData {
        /** 当前页数 */
        private Number currentPage;
        /** 是否启用云数据库 */
        private boolean enableCloudDB;
        /** 页面数据 */
        private List<MultiCardPageData> pageData;
        /** 页面大小 */
        private Number pageSize;
        /** 总页数 */
        private Number totalPage;
        /** 总行数 */
        private Number totalRows;

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

        public List<MultiCardPageData> getPageData() {
            return pageData;
        }

        public void setPageData(List<MultiCardPageData> pageData) {
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

        public Number getTotalRows() {
            return totalRows;
        }

        public void setTotalRows(Number totalRows) {
            this.totalRows = totalRows;
        }

        @Override
        public String toString() {
            return "MultiCardData{" +
                    "currentPage=" + currentPage +
                    ", enableCloudDB=" + enableCloudDB +
                    ", pageData=" + pageData +
                    ", pageSize=" + pageSize +
                    ", totalPage=" + totalPage +
                    ", totalRows=" + totalRows +
                    '}';
        }
    }

    public static class MultiCardPageData {
        /** 通道编码 */
        private String channelCode;
        /** 通道名称 */
        private String channelName;
        /** 设备名称 */
        private String deviceName;
        /** 设备状态 */
        private String deviceStatus;
        /** 多卡开门ID */
        private Long id;
        /** 多卡开门使能："0"-关闭，"1"-开启 */
        private String multiCardEnable;

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

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMultiCardEnable() {
            return multiCardEnable;
        }

        public void setMultiCardEnable(String multiCardEnable) {
            this.multiCardEnable = multiCardEnable;
        }

        @Override
        public String toString() {
            return "MultiCardPageData{" +
                    "channelCode='" + channelCode + '\'' +
                    ", channelName='" + channelName + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", deviceStatus='" + deviceStatus + '\'' +
                    ", id=" + id +
                    ", multiCardEnable='" + multiCardEnable + '\'' +
                    '}';
        }
    }

}
