package com.dahuatech.icc.assesscontrol.model.v202103.authPerson;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 人员权限分页查询
 *
 * @author 237417
 */
public class AuthPersonPageListResponse extends IccResponse {
    private  AuthPersonPageData data;

    private int currentPage;

    private int totalPage;

    private int pageSize;

    private int totalRows;

    public AuthPersonPageData getData() {
        return data;
    }

    public void setData(AuthPersonPageData data) {
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
        return "AuthPersonPageListResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class AuthPersonPageData {
        private List<AuthPersonPageList> pageData;

        public List<AuthPersonPageList> getPageData() {
            return pageData;
        }

        public void setPageData(List<AuthPersonPageList> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "AuthPersonPageData{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

    public static class AuthPersonPageList {
        /** 授权状态: "-1" - 全部，"1" - 未授权，"2" - 已授权 */
        private String authorizeStatus;
        /** 卡号 */
        private String cardNumber;
        /** 卡片通道权限数量 */
        private Integer cardPrivilegeDetailCount;
        /** 卡片状态 */
        private String cardStatus;
        /** 卡片类型 */
        private String cardType;
        /** 部门id */
        private Long deptId;
        /** 部门名称 */
        private String deptName;
        /** 记录 id */
        private Long id;
        /** 人员比编号 */
        private String personCode;
        /** 人员姓名 */
        private String personName;
        /** 任务状态。 "-1" - 全部，"0" - 已下发，"1" - 下发中 */
        private String taskStatus;
        /** 成功数量 */
        private Integer successCount;
        /** 开门计划ID */
        private Long timeQuantumId;

        public String getAuthorizeStatus() {
            return authorizeStatus;
        }

        public void setAuthorizeStatus(String authorizeStatus) {
            this.authorizeStatus = authorizeStatus;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public Integer getCardPrivilegeDetailCount() {
            return cardPrivilegeDetailCount;
        }

        public void setCardPrivilegeDetailCount(Integer cardPrivilegeDetailCount) {
            this.cardPrivilegeDetailCount = cardPrivilegeDetailCount;
        }

        public String getCardStatus() {
            return cardStatus;
        }

        public void setCardStatus(String cardStatus) {
            this.cardStatus = cardStatus;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public Long getDeptId() {
            return deptId;
        }

        public void setDeptId(Long deptId) {
            this.deptId = deptId;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPersonCode() {
            return personCode;
        }

        public void setPersonCode(String personCode) {
            this.personCode = personCode;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getTaskStatus() {
            return taskStatus;
        }

        public void setTaskStatus(String taskStatus) {
            this.taskStatus = taskStatus;
        }

        public Integer getSuccessCount() {
            return successCount;
        }

        public void setSuccessCount(Integer successCount) {
            this.successCount = successCount;
        }

        public Long getTimeQuantumId() {
            return timeQuantumId;
        }

        public void setTimeQuantumId(Long timeQuantumId) {
            this.timeQuantumId = timeQuantumId;
        }

        @Override
        public String toString() {
            return "AuthPersonPageList{" +
                    "authorizeStatus='" + authorizeStatus + '\'' +
                    ", cardNumber='" + cardNumber + '\'' +
                    ", cardPrivilegeDetailCount=" + cardPrivilegeDetailCount +
                    ", cardStatus='" + cardStatus + '\'' +
                    ", cardType='" + cardType + '\'' +
                    ", deptId=" + deptId +
                    ", deptName='" + deptName + '\'' +
                    ", id=" + id +
                    ", personCode='" + personCode + '\'' +
                    ", personName='" + personName + '\'' +
                    ", taskStatus='" + taskStatus + '\'' +
                    ", successCount=" + successCount +
                    ", timeQuantumId=" + timeQuantumId +
                    '}';
        }
    }
}
