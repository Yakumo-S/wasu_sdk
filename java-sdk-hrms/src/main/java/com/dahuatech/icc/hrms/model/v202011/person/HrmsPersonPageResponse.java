package com.dahuatech.icc.hrms.model.v202011.person;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

public class HrmsPersonPageResponse extends IccResponse {
    private PeresonPageList data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public PeresonPageList getData() {
        return data;
    }

    public void setData(PeresonPageList data) {
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
        return "HrmsPersonPageResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class PeresonPageList {

        private List<HrmsPersonDetail> pageData;

        public List<HrmsPersonDetail> getPageData() {
            return pageData;
        }

        public void setPageData(List<HrmsPersonDetail> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "PeresonPageList{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

}

