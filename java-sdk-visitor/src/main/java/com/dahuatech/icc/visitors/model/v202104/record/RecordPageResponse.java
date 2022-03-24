package com.dahuatech.icc.visitors.model.v202104.record;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

public class RecordPageResponse extends IccResponse {
    private RecordPageData data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;
    private String enableCloudDB;

    public RecordPageData getData() {
        return data;
    }

    public void setData(RecordPageData data) {
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

    public String getEnableCloudDB() {
        return enableCloudDB;
    }

    public void setEnableCloudDB(String enableCloudDB) {
        this.enableCloudDB = enableCloudDB;
    }

    public static class RecordPageData {
        private List<RecordPagePageList> pageData;

    }

    public static class RecordPagePageList {
        /** ID */
        private Long id;
        /** 设备编号 */
        private String deviceCode;
        /** 设备名称 */
        private String deviceName;
        /** 通道号 */
        private String channelCode;
        /** 通道名称 */
        private String channelName;
        /** 刷卡时间 yyyy-MM-dd HH:mm:ss */
        private String swingTime;
        /** 人员姓名 */
        private String personName;
        /** 人员编号 */
        private String personCode;
        /** 人员ID */
        private Long personId;
        /** 卡号 */
        private String cardNumber;
        /** 开门类型 */
        private Integer openType;
        /** 开门结果 */
        private Integer openResult;
        /** 卡状态 */
        private Integer cardStatus;
        /** 进出门类型 */
        private Integer enterOrExit;
        /** 错误信息 */

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDeviceCode() {
            return deviceCode;
        }

        public void setDeviceCode(String deviceCode) {
            this.deviceCode = deviceCode;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
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

        public String getSwingTime() {
            return swingTime;
        }

        public void setSwingTime(String swingTime) {
            this.swingTime = swingTime;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getPersonCode() {
            return personCode;
        }

        public void setPersonCode(String personCode) {
            this.personCode = personCode;
        }

        public Long getPersonId() {
            return personId;
        }

        public void setPersonId(Long personId) {
            this.personId = personId;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public Integer getOpenType() {
            return openType;
        }

        public void setOpenType(Integer openType) {
            this.openType = openType;
        }

        public Integer getOpenResult() {
            return openResult;
        }

        public void setOpenResult(Integer openResult) {
            this.openResult = openResult;
        }

        public Integer getCardStatus() {
            return cardStatus;
        }

        public void setCardStatus(Integer cardStatus) {
            this.cardStatus = cardStatus;
        }

        public Integer getEnterOrExit() {
            return enterOrExit;
        }

        public void setEnterOrExit(Integer enterOrExit) {
            this.enterOrExit = enterOrExit;
        }

        @Override
        public String toString() {
            return "RecordPagePageList{" +
                    "id=" + id +
                    ", deviceCode='" + deviceCode + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", channelCode='" + channelCode + '\'' +
                    ", channelName='" + channelName + '\'' +
                    ", swingTime='" + swingTime + '\'' +
                    ", personName='" + personName + '\'' +
                    ", personCode='" + personCode + '\'' +
                    ", personId=" + personId +
                    ", cardNumber='" + cardNumber + '\'' +
                    ", openType=" + openType +
                    ", openResult=" + openResult +
                    ", cardStatus=" + cardStatus +
                    ", enterOrExit=" + enterOrExit +
                    '}';
        }
    }
}