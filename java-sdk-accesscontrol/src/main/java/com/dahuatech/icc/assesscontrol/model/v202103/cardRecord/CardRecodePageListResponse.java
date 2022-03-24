package com.dahuatech.icc.assesscontrol.model.v202103.cardRecord;

import com.dahuatech.icc.oauth.http.IccResponse;

/**
 * 刷卡记录详情
 *
 * @author 237417
 */
public class CardRecodePageListResponse extends IccResponse {
    /** 返回数据 */
    private CardRecodeData data;

    public CardRecodeData getData() {
        return data;
    }

    public void setData(CardRecodeData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CardRecodePageListResponse{" +
                "data=" + data +
                '}';
    }

    public static class CardRecodeData {
        /** 分页数据 */
        private CardRecodePageData pageData;
        /** 分页大小 */
        private Integer pageSize;
        /** 错误信息 */
        private String errMsg;
        /** 总页码, -1-不统计 */
        private Integer totalPage;
        /** 总行数 */
        private Integer totalRows;

        public CardRecodePageData getPageData() {
            return pageData;
        }

        public void setPageData(CardRecodePageData pageData) {
            this.pageData = pageData;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public Integer getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(Integer totalPage) {
            this.totalPage = totalPage;
        }

        public Integer getTotalRows() {
            return totalRows;
        }

        public void setTotalRows(Integer totalRows) {
            this.totalRows = totalRows;
        }

        @Override
        public String toString() {
            return "CardRecodeData{" +
                    "pageData=" + pageData +
                    ", pageSize=" + pageSize +
                    ", errMsg='" + errMsg + '\'' +
                    ", totalPage=" + totalPage +
                    ", totalRows=" + totalRows +
                    '}';
        }
    }

    public static class CardRecodePageData {
        /** 卡号 */
        private String cardNumber;
        /** 卡状态，-1-空白卡，0-正常卡，1-挂失卡，2-注销卡 */
        private Integer cardStatus;
        /** 卡类型，0-IC卡, 1-有源RFID, 2-CPU卡 */
        private Integer cardType;
        /** 通道编码 */
        private String channelCode;
        /** 通道名称 */
        private String channelName;
        /** 部门名称 */
        private String deptName;
        /** 设备编码 */
        private String deviceCode;
        /** 设备名称 */
        private String deviceName;
        /** 事件类型 1-进门, 2出门, 3-进/出门 */
        private Integer enterOrExit;
        /** 刷卡记录ID */
        private String id;
        /** 1 内部人员, 2 访客 */
        private Integer imageType;
        /** 开门结果，0-失败，1-成功 */
        private Integer openResult;
        /** 开门类型，详见 开门类型 字典 */
        private Integer openType;
        /** 证件号码 */
        private String paperNumber;
        /** 人员编号 */
        private String personCode;
        /** 人员编号 */
        private Long personId;
        /** 人员姓名 */
        private String personName;
        /** 人脸照片 */
        private String recordImage;
        /** 失败原因，详见开门失败字典 */
        private String remark;
        /** 刷卡时间 */
        private String swingTime;
        /** 口罩状态(3-带口罩,2—没带口罩,1-未识别) */
        private Integer maskState;
        /** 是否超温 */
        private boolean overTemp;
        /** 体温 */
        private String curTemp;

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public Integer getCardStatus() {
            return cardStatus;
        }

        public void setCardStatus(Integer cardStatus) {
            this.cardStatus = cardStatus;
        }

        public Integer getCardType() {
            return cardType;
        }

        public void setCardType(Integer cardType) {
            this.cardType = cardType;
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

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
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

        public Integer getEnterOrExit() {
            return enterOrExit;
        }

        public void setEnterOrExit(Integer enterOrExit) {
            this.enterOrExit = enterOrExit;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getImageType() {
            return imageType;
        }

        public void setImageType(Integer imageType) {
            this.imageType = imageType;
        }

        public Integer getOpenResult() {
            return openResult;
        }

        public void setOpenResult(Integer openResult) {
            this.openResult = openResult;
        }

        public Integer getOpenType() {
            return openType;
        }

        public void setOpenType(Integer openType) {
            this.openType = openType;
        }

        public String getPaperNumber() {
            return paperNumber;
        }

        public void setPaperNumber(String paperNumber) {
            this.paperNumber = paperNumber;
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

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getRecordImage() {
            return recordImage;
        }

        public void setRecordImage(String recordImage) {
            this.recordImage = recordImage;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getSwingTime() {
            return swingTime;
        }

        public void setSwingTime(String swingTime) {
            this.swingTime = swingTime;
        }

        public Integer getMaskState() {
            return maskState;
        }

        public void setMaskState(Integer maskState) {
            this.maskState = maskState;
        }

        public boolean isOverTemp() {
            return overTemp;
        }

        public void setOverTemp(boolean overTemp) {
            this.overTemp = overTemp;
        }

        public String getCurTemp() {
            return curTemp;
        }

        public void setCurTemp(String curTemp) {
            this.curTemp = curTemp;
        }

        @Override
        public String toString() {
            return "CardRecodePageData{" +
                    "cardNumber='" + cardNumber + '\'' +
                    ", cardStatus=" + cardStatus +
                    ", cardType=" + cardType +
                    ", channelCode='" + channelCode + '\'' +
                    ", channelName='" + channelName + '\'' +
                    ", deptName='" + deptName + '\'' +
                    ", deviceCode='" + deviceCode + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", enterOrExit=" + enterOrExit +
                    ", id='" + id + '\'' +
                    ", imageType=" + imageType +
                    ", openResult=" + openResult +
                    ", openType=" + openType +
                    ", paperNumber='" + paperNumber + '\'' +
                    ", personCode='" + personCode + '\'' +
                    ", personId=" + personId +
                    ", personName='" + personName + '\'' +
                    ", recordImage='" + recordImage + '\'' +
                    ", remark='" + remark + '\'' +
                    ", swingTime='" + swingTime + '\'' +
                    ", maskState=" + maskState +
                    ", overTemp=" + overTemp +
                    ", curTemp='" + curTemp + '\'' +
                    '}';
        }
    }
}
