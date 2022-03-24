package com.dahuatech.icc.assesscontrol.model.v202103.doorGroup;

import com.dahuatech.icc.assesscontrol.model.v202103.channelControl.DoorGroup;
import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 门组列表
 *
 * @author 237417
 */
public class DoorGroupPageResponse extends IccResponse {

    private DoorGroupPageData data;

    public DoorGroupPageData getData() {
        return data;
    }

    public void setData(DoorGroupPageData data) {
        this.data = data;
    }

    public static class DoorGroupPageData {
        /** 当前页码 */
        private Number currentPage;
        /** 页容量 */
        private Number pageSize;
        /** 总页数 */
        private Number totalPage;
        /** 记录总条数 */
        private Number totalRows;
        /** 废弃属性 */
        private Boolean enableCloudDB;
        /** 分页数据 */
        private List<DoorGroup> pageData;

        public Number getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Number currentPage) {
            this.currentPage = currentPage;
        }

        public Number getPageSize() {
            return pageSize;
        }

        public void setPageSize(Number pageSize) {
            this.pageSize = pageSize;
        }

        public Number getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(Number totalPage) {
            this.totalPage = totalPage;
        }

        public Number getTotalRows() {
            return totalRows;
        }

        public void setTotalRows(Number totalRows) {
            this.totalRows = totalRows;
        }

        public Boolean getEnableCloudDB() {
            return enableCloudDB;
        }

        public void setEnableCloudDB(Boolean enableCloudDB) {
            this.enableCloudDB = enableCloudDB;
        }

        public List<DoorGroup> getPageData() {
            return pageData;
        }

        public void setPageData(List<DoorGroup> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "DoorGroupPageData{" +
                    "currentPage=" + currentPage +
                    ", pageSize=" + pageSize +
                    ", totalPage=" + totalPage +
                    ", totalRows=" + totalRows +
                    ", enableCloudDB=" + enableCloudDB +
                    ", pageData=" + pageData +
                    '}';
        }
    }
}
