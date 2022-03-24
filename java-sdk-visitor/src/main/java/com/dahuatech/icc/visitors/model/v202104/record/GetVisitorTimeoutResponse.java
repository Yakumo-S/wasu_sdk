package com.dahuatech.icc.visitors.model.v202104.record;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

public class GetVisitorTimeoutResponse extends IccResponse {
    private VisitorTimeoutData data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public VisitorTimeoutData getData() {
        return data;
    }

    public void setData(VisitorTimeoutData data) {
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
        return "GetVisitorTimeoutResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class VisitorTimeoutData {
        private List<VisitorTimeoutPageList> pageData;

        public List<VisitorTimeoutPageList> getPageData() {
            return pageData;
        }

        public void setPageData(List<VisitorTimeoutPageList> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "VisitorTimeoutData{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

    public static class VisitorTimeoutPageList {
        /** 部门名称 */
        private String isv_deptName;
        /** 超时人数 */
        private Integer count;

        public String getIsv_deptName() {
            return isv_deptName;
        }

        public void setIsv_deptName(String isv_deptName) {
            this.isv_deptName = isv_deptName;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "VisitorTimeoutPageList{" +
                    "isv_deptName='" + isv_deptName + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
