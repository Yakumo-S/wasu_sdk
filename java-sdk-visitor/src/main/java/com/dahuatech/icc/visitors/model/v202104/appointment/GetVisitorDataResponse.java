package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

public class GetVisitorDataResponse extends IccResponse {

    private GetVisitorPageList data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;
    private boolean enableCloudDB;

    public GetVisitorPageList getData() {
        return data;
    }

    public void setData(GetVisitorPageList data) {
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

    public boolean isEnableCloudDB() {
        return enableCloudDB;
    }

    public void setEnableCloudDB(boolean enableCloudDB) {
        this.enableCloudDB = enableCloudDB;
    }

    @Override
    public String toString() {
        return "GetVisitorDataResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                ", enableCloudDB=" + enableCloudDB +
                '}';
    }

    public static class GetVisitorPageList {
        private List<GetVisitorPage> pageData;

        public List<GetVisitorPage> getPageData() {
            return pageData;
        }

        public void setPageData(List<GetVisitorPage> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "GetVisitorPageList{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

    public static class GetVisitorPage {
        /** ID */
        private Integer id;
        /** 姓名 */
        private String v_name;
        /** 电话 */
        private String v_phone;
        /** 单位 */
        private String v_dw;
        /** 证件照 */
        private String v_certificateNumber;
        /** 来访时间 */
        private String v_time;
        /** 离访时间 */
        private String rvtime;
        /** 实际来访事件 */
        private String v_lvTime;
        /** 卡号 */
        private String v_cardNumber;
        /** 状态 */
        private Integer status;
        /** 被访人ID */
        private Integer isv_id;
        /** 被访人姓名 */
        private String isv_name;
        /** 被访人部门 */
        private String isv_deptName;
        /** 性别 */
        private String isv_sex;
        /** 手机号 */
        private String isv_phone;
        /** 来访时间 */
        private String v_timeStr;
        /** 离访 时间 */
        private String v_lvTimeStr;
        /** 实际来访时间 */
        private String rvtimeStr;
        /** 实际离访时间 */
        private String rvlvTimeStr;
        /** 状态名称 */
        private String statusName;
        /** 访客类型 */
        private Integer visitorType;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getV_name() {
            return v_name;
        }

        public void setV_name(String v_name) {
            this.v_name = v_name;
        }

        public String getV_phone() {
            return v_phone;
        }

        public void setV_phone(String v_phone) {
            this.v_phone = v_phone;
        }

        public String getV_dw() {
            return v_dw;
        }

        public void setV_dw(String v_dw) {
            this.v_dw = v_dw;
        }

        public String getV_certificateNumber() {
            return v_certificateNumber;
        }

        public void setV_certificateNumber(String v_certificateNumber) {
            this.v_certificateNumber = v_certificateNumber;
        }

        public String getV_time() {
            return v_time;
        }

        public void setV_time(String v_time) {
            this.v_time = v_time;
        }

        public String getRvtime() {
            return rvtime;
        }

        public void setRvtime(String rvtime) {
            this.rvtime = rvtime;
        }

        public String getV_lvTime() {
            return v_lvTime;
        }

        public void setV_lvTime(String v_lvTime) {
            this.v_lvTime = v_lvTime;
        }

        public String getV_cardNumber() {
            return v_cardNumber;
        }

        public void setV_cardNumber(String v_cardNumber) {
            this.v_cardNumber = v_cardNumber;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getIsv_id() {
            return isv_id;
        }

        public void setIsv_id(Integer isv_id) {
            this.isv_id = isv_id;
        }

        public String getIsv_name() {
            return isv_name;
        }

        public void setIsv_name(String isv_name) {
            this.isv_name = isv_name;
        }

        public String getIsv_deptName() {
            return isv_deptName;
        }

        public void setIsv_deptName(String isv_deptName) {
            this.isv_deptName = isv_deptName;
        }

        public String getIsv_sex() {
            return isv_sex;
        }

        public void setIsv_sex(String isv_sex) {
            this.isv_sex = isv_sex;
        }

        public String getIsv_phone() {
            return isv_phone;
        }

        public void setIsv_phone(String isv_phone) {
            this.isv_phone = isv_phone;
        }

        public String getV_timeStr() {
            return v_timeStr;
        }

        public void setV_timeStr(String v_timeStr) {
            this.v_timeStr = v_timeStr;
        }

        public String getV_lvTimeStr() {
            return v_lvTimeStr;
        }

        public void setV_lvTimeStr(String v_lvTimeStr) {
            this.v_lvTimeStr = v_lvTimeStr;
        }

        public String getRvtimeStr() {
            return rvtimeStr;
        }

        public void setRvtimeStr(String rvtimeStr) {
            this.rvtimeStr = rvtimeStr;
        }

        public String getRvlvTimeStr() {
            return rvlvTimeStr;
        }

        public void setRvlvTimeStr(String rvlvTimeStr) {
            this.rvlvTimeStr = rvlvTimeStr;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public Integer getVisitorType() {
            return visitorType;
        }

        public void setVisitorType(Integer visitorType) {
            this.visitorType = visitorType;
        }

        @Override
        public String toString() {
            return "GetVisitorPage{" +
                    "id=" + id +
                    ", v_name='" + v_name + '\'' +
                    ", v_phone='" + v_phone + '\'' +
                    ", v_dw='" + v_dw + '\'' +
                    ", v_certificateNumber='" + v_certificateNumber + '\'' +
                    ", v_time='" + v_time + '\'' +
                    ", rvtime='" + rvtime + '\'' +
                    ", v_lvTime='" + v_lvTime + '\'' +
                    ", v_cardNumber='" + v_cardNumber + '\'' +
                    ", status=" + status +
                    ", isv_id=" + isv_id +
                    ", isv_name='" + isv_name + '\'' +
                    ", isv_deptName='" + isv_deptName + '\'' +
                    ", isv_sex='" + isv_sex + '\'' +
                    ", isv_phone='" + isv_phone + '\'' +
                    ", v_timeStr='" + v_timeStr + '\'' +
                    ", v_lvTimeStr='" + v_lvTimeStr + '\'' +
                    ", rvtimeStr='" + rvtimeStr + '\'' +
                    ", rvlvTimeStr='" + rvlvTimeStr + '\'' +
                    ", statusName='" + statusName + '\'' +
                    ", visitorType=" + visitorType +
                    '}';
        }
    }
}
