package com.dahuatech.icc.assesscontrol.model.v202103.authDoor;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 人员权限分页查询
 *
 * @author 237417
 */
public class AuthDoorPageListResponse extends IccResponse {
    private AuthDoorPageList data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public AuthDoorPageList getData() {
        return data;
    }

    public void setData(AuthDoorPageList data) {
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
        return "AuthDoorPageListResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class AuthDoorPageList {
        private List<AuthDoorPage> pageData;

        public List<AuthDoorPage> getPageData() {
            return pageData;
        }

        public void setPageData(List<AuthDoorPage> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "AuthDoorPageList{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

    public static class AuthDoorPage {
        /** 授权状态: "-1" - 全部，"1" - 未授权，"2" - 已授权 */
        private String authorizeStatus;
        /** 卡号 */
        private String cardNumber;
        /** 部门ID */
        private Long deptId;
        /** 部门名称 */
        private String deptName;
        /** 人员比编号 */
        private String personCode;
        /** 人员ID */
        private Integer personId;
        /** 人员姓名 */
        private String personName;
        /** 开门计划名称 */
        private String timeQuantumName;
        /** 通道编码 */
        private String resourceCode;

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

        public String getPersonCode() {
            return personCode;
        }

        public void setPersonCode(String personCode) {
            this.personCode = personCode;
        }

        public Integer getPersonId() {
            return personId;
        }

        public void setPersonId(Integer personId) {
            this.personId = personId;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getTimeQuantumName() {
            return timeQuantumName;
        }

        public void setTimeQuantumName(String timeQuantumName) {
            this.timeQuantumName = timeQuantumName;
        }

        public String getResourceCode() {
            return resourceCode;
        }

        public void setResourceCode(String resourceCode) {
            this.resourceCode = resourceCode;
        }

        @Override
        public String toString() {
            return "AuthDoorPage{" +
                    "authorizeStatus='" + authorizeStatus + '\'' +
                    ", cardNumber='" + cardNumber + '\'' +
                    ", deptId=" + deptId +
                    ", deptName='" + deptName + '\'' +
                    ", personCode='" + personCode + '\'' +
                    ", personId=" + personId +
                    ", personName='" + personName + '\'' +
                    ", timeQuantumName='" + timeQuantumName + '\'' +
                    ", resourceCode='" + resourceCode + '\'' +
                    '}';
        }
    }
}

