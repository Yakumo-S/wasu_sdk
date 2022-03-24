package com.wasu.model.v202010.role;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 角色全量信息同步返回数据
 *
 * @author 237417
 * @since 1.0.0 2021/02/23
 */
public class BrmRoleSyncResponse extends IccResponse {
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
        return "BrmRoleSyncResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class RolePageData {
        private List<BrmRole> pageData;

        public List<BrmRole> getPageData() {
            return pageData;
        }

        public void setPageData(List<BrmRole> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "RolePageData{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

}
