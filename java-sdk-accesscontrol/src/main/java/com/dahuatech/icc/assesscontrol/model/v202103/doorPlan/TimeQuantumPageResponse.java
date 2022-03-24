package com.dahuatech.icc.assesscontrol.model.v202103.doorPlan;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 开门计划列表
 *
 * @author 237417
 */
public class TimeQuantumPageResponse extends IccResponse {
    private TimeQuantumData data;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public TimeQuantumData getData() {
        return data;
    }

    public void setData(TimeQuantumData data) {
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
        return "BrmOrganizationPageResponse{"
                + "data="
                + data
                + ", currentPage="
                + currentPage
                + ", totalPage="
                + totalPage
                + ", pageSize="
                + pageSize
                + ", totalRows="
                + totalRows
                + '}';
    }

    public static class TimeQuantumData {
        private List<TimeQuantum> pageData;

        public List<TimeQuantum> getPageData() {
            return pageData;
        }

        public void setPageData(List<TimeQuantum> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "TimeQuantumData{" +
                    "pageData=" + pageData +
                    '}';
        }
    }
}
