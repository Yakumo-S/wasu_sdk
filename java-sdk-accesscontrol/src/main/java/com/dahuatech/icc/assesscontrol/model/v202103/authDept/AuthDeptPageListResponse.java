package com.dahuatech.icc.assesscontrol.model.v202103.authDept;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 部门权限分页查询
 *
 * @author 237417
 */
public class AuthDeptPageListResponse extends IccResponse {
    private AuthDeptPageList data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public AuthDeptPageList getData() {
        return data;
    }

    public void setData(AuthDeptPageList data) {
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
        return "AuthDeptPageListResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class AuthDeptPageList {
        private List<AuthDeptPage> pageData;

        public List<AuthDeptPage> getPageData() {
            return pageData;
        }

        public void setPageData(List<AuthDeptPage> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "AuthDeptPageList{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

    public static class AuthDeptPage {
        /** ID */
        private Integer id;
        /** 部门ID */
        private Long deptId;
        /** 部门名称 */
        private String deptName;
        /** 开门计划名称 */
        private String doorWeekPlanName;
        /** 开门计划ID */
        private Integer doorWeekPlanId;
        /** 通道编码 */
        private String doorPointsIds;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getDoorWeekPlanName() {
            return doorWeekPlanName;
        }

        public void setDoorWeekPlanName(String doorWeekPlanName) {
            this.doorWeekPlanName = doorWeekPlanName;
        }

        public Integer getDoorWeekPlanId() {
            return doorWeekPlanId;
        }

        public void setDoorWeekPlanId(Integer doorWeekPlanId) {
            this.doorWeekPlanId = doorWeekPlanId;
        }

        public String getDoorPointsIds() {
            return doorPointsIds;
        }

        public void setDoorPointsIds(String doorPointsIds) {
            this.doorPointsIds = doorPointsIds;
        }

        @Override
        public String toString() {
            return "AuthDeptPage{" +
                    "id=" + id +
                    ", deptId=" + deptId +
                    ", deptName='" + deptName + '\'' +
                    ", doorWeekPlanName='" + doorWeekPlanName + '\'' +
                    ", doorWeekPlanId=" + doorWeekPlanId +
                    ", doorPointsIds='" + doorPointsIds + '\'' +
                    '}';
        }
    }
}