package com.wasu.model.v202010.role;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 角色信息分页返回数据
 *
 * @author 237417
 * @since 1.0.0 2021/02/23
 */
public class BrmRolePageResponse extends IccResponse {

    private RolePageData data;

    private int currentPage;

    private int totalPage;

    private int pageSize;

    private int totalRows;

    public RolePageData getData() {
        return data;
    }

    public void setData(RolePageData data) {
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
        return "BrmRolePageResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class RolePageData {
        private List<RolePageList> pageData;

        public List<RolePageList> getPageData() {
            return pageData;
        }

        public void setPageData(List<RolePageList> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "RolePageData{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

    public static class RolePageList {
        private String id;
        private String roleName;
        private Integer roleGrade;
        private Integer privilegeType;
        private Integer administerRootCheck;
        private Integer operationRootCheck;
        private Integer appRootCheck;
        private Integer defaultRole;
        private String ownerCode;
        private Integer status;
        private String memo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public Integer getRoleGrade() {
            return roleGrade;
        }

        public void setRoleGrade(Integer roleGrade) {
            this.roleGrade = roleGrade;
        }

        public Integer getPrivilegeType() {
            return privilegeType;
        }

        public void setPrivilegeType(Integer privilegeType) {
            this.privilegeType = privilegeType;
        }

        public Integer getAdministerRootCheck() {
            return administerRootCheck;
        }

        public void setAdministerRootCheck(Integer administerRootCheck) {
            this.administerRootCheck = administerRootCheck;
        }

        public Integer getOperationRootCheck() {
            return operationRootCheck;
        }

        public void setOperationRootCheck(Integer operationRootCheck) {
            this.operationRootCheck = operationRootCheck;
        }

        public Integer getAppRootCheck() {
            return appRootCheck;
        }

        public void setAppRootCheck(Integer appRootCheck) {
            this.appRootCheck = appRootCheck;
        }

        public Integer getDefaultRole() {
            return defaultRole;
        }

        public void setDefaultRole(Integer defaultRole) {
            this.defaultRole = defaultRole;
        }

        public String getOwnerCode() {
            return ownerCode;
        }

        public void setOwnerCode(String ownerCode) {
            this.ownerCode = ownerCode;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        @Override
        public String toString() {
            return "RolePageList{" +
                    "id='" + id + '\'' +
                    ", roleName='" + roleName + '\'' +
                    ", roleGrade=" + roleGrade +
                    ", privilegeType=" + privilegeType +
                    ", administerRootCheck=" + administerRootCheck +
                    ", operationRootCheck=" + operationRootCheck +
                    ", appRootCheck=" + appRootCheck +
                    ", defaultRole=" + defaultRole +
                    ", ownerCode='" + ownerCode + '\'' +
                    ", status=" + status +
                    ", memo='" + memo + '\'' +
                    '}';
        }
    }
}
