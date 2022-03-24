package com.dahuatech.icc.assesscontrol.model.v202103.normalOpen;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 常开常闭计划列表
 *
 * @author 237417
 */
public class NormalOpenPageListResponse extends IccResponse {
    private NormalOpenPageData data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public NormalOpenPageData getData() {
        return data;
    }

    public void setData(NormalOpenPageData data) {
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
        return "NormalOpenPageListResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class NormalOpenPageData {
        /** 通道编码 */
        private String channelCode;
        /** 常闭计划ID */
        private Integer closeDoorsPlanId;
        /** 常闭计划名称 */
        private String closeDoorsPlanName;
        /** 设备名称 */
        private String deviceName;
        /** 是否为高峰计划配置 */
        private boolean escFlag;
        /** 无实际意义 */
        private boolean flag;
        /** 常开常闭计划ID */
        private Long id;
        /** 通道在离线状态:"ON" - 在线，"OFF" - 离线 */
        private String onlineStatus;

        public String getChannelCode() {
            return channelCode;
        }

        public void setChannelCode(String channelCode) {
            this.channelCode = channelCode;
        }

        public Integer getCloseDoorsPlanId() {
            return closeDoorsPlanId;
        }

        public void setCloseDoorsPlanId(Integer closeDoorsPlanId) {
            this.closeDoorsPlanId = closeDoorsPlanId;
        }

        public String getCloseDoorsPlanName() {
            return closeDoorsPlanName;
        }

        public void setCloseDoorsPlanName(String closeDoorsPlanName) {
            this.closeDoorsPlanName = closeDoorsPlanName;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public boolean isEscFlag() {
            return escFlag;
        }

        public void setEscFlag(boolean escFlag) {
            this.escFlag = escFlag;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOnlineStatus() {
            return onlineStatus;
        }

        public void setOnlineStatus(String onlineStatus) {
            this.onlineStatus = onlineStatus;
        }

        @Override
        public String toString() {
            return "NormalOpenPageData{" +
                    "channelCode='" + channelCode + '\'' +
                    ", closeDoorsPlanId=" + closeDoorsPlanId +
                    ", closeDoorsPlanName='" + closeDoorsPlanName + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", escFlag=" + escFlag +
                    ", flag=" + flag +
                    ", id=" + id +
                    ", onlineStatus='" + onlineStatus + '\'' +
                    '}';
        }
    }

}
