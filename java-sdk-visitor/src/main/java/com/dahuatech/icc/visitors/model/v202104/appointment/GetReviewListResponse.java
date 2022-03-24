package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

public class GetReviewListResponse extends IccResponse {
    private ReviewListPageData data;

    public ReviewListPageData getData() {
        return data;
    }

    public void setData(ReviewListPageData data) {
        this.data = data;
    }

    public static class ReviewListPageData {
        private List<ReviewListPage> pageData;
        private int currentPage;
        private int totalPage;
        private int pageSize;
        private int totalRows;

        public List<ReviewListPage> getPageData() {
            return pageData;
        }

        public void setPageData(List<ReviewListPage> pageData) {
            this.pageData = pageData;
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
    }

    public static class ReviewListPage {
        /** 访客ID */
        private Integer id;
        /** 访客姓名 */
        private String v_name;
        /** 电话 */
        private String v_phone;
        /** 访客单位 */
        private String v_dw;
        /** 证件类型 */
        private String v_certificateType;
        /** 证件名称 */
        private String v_certificateNumber;
        /** 来访事由 */
        private String v_reason;
        /** 来访数量 */
        private String v_personSum;
        /** 访客状态 */
        private Integer status;
        /** 性别 */
        private Integer v_sex;
        /** 被访人ID */
        private Integer isv_id;
        /** 被访人姓名 */
        private String isv_name;
        /** 被访人部门 */
        private String isv_deptName;
        /** 被访人性别 */
        private String isv_sex;
        /** 被访人电话 */
        private String isv_phone;
        /** 预约来访时间 yyyy-MM-dd HH:mm:ss */
        private String v_timeStr;
        /** 预约离访时间 yyyy-MM-dd HH:mm:ss */
        private String v_lvTimeStr;
        /** 实际来访时间 yyyy-MM-dd HH:mm:ss */
        private String rvlvTimeStr;
        /** 状态名称 */
        private String statusName;
        /** 访客类型 */
        private Integer visitorType;
        /** 预约码 */
        private String appointmentCode;

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

        public String getV_certificateType() {
            return v_certificateType;
        }

        public void setV_certificateType(String v_certificateType) {
            this.v_certificateType = v_certificateType;
        }

        public String getV_certificateNumber() {
            return v_certificateNumber;
        }

        public void setV_certificateNumber(String v_certificateNumber) {
            this.v_certificateNumber = v_certificateNumber;
        }

        public String getV_reason() {
            return v_reason;
        }

        public void setV_reason(String v_reason) {
            this.v_reason = v_reason;
        }

        public String getV_personSum() {
            return v_personSum;
        }

        public void setV_personSum(String v_personSum) {
            this.v_personSum = v_personSum;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getV_sex() {
            return v_sex;
        }

        public void setV_sex(Integer v_sex) {
            this.v_sex = v_sex;
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

        public String getAppointmentCode() {
            return appointmentCode;
        }

        public void setAppointmentCode(String appointmentCode) {
            this.appointmentCode = appointmentCode;
        }

        @Override
        public String toString() {
            return "ReviewListPage{" +
                    "id=" + id +
                    ", v_name='" + v_name + '\'' +
                    ", v_phone='" + v_phone + '\'' +
                    ", v_dw='" + v_dw + '\'' +
                    ", v_certificateType='" + v_certificateType + '\'' +
                    ", v_certificateNumber='" + v_certificateNumber + '\'' +
                    ", v_reason='" + v_reason + '\'' +
                    ", v_personSum='" + v_personSum + '\'' +
                    ", status=" + status +
                    ", v_sex=" + v_sex +
                    ", isv_id=" + isv_id +
                    ", isv_name='" + isv_name + '\'' +
                    ", isv_deptName='" + isv_deptName + '\'' +
                    ", isv_sex='" + isv_sex + '\'' +
                    ", isv_phone='" + isv_phone + '\'' +
                    ", v_timeStr='" + v_timeStr + '\'' +
                    ", v_lvTimeStr='" + v_lvTimeStr + '\'' +
                    ", rvlvTimeStr='" + rvlvTimeStr + '\'' +
                    ", statusName='" + statusName + '\'' +
                    ", visitorType=" + visitorType +
                    ", appointmentCode='" + appointmentCode + '\'' +
                    '}';
        }
    }
}

