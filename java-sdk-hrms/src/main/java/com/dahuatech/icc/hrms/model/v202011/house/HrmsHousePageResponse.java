package com.dahuatech.icc.hrms.model.v202011.house;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

public class HrmsHousePageResponse extends IccResponse {

    private HrmsHousePageData data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public HrmsHousePageData getData() {
        return data;
    }

    public void setData(HrmsHousePageData data) {
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
        return "HrmsHousePageResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class HrmsHousePageData {
        private List<HrmsHouseDetail> pageData;

        public List<HrmsHouseDetail> getPageData() {
            return pageData;
        }

        public void setPageData(List<HrmsHouseDetail> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "HrmsHousePageData{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

}