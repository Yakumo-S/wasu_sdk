package com.dahuatech.icc.hrms.model.v202011.building;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 楼栋分页查询
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class HrmsBuildingPageRequest extends AbstractIccRequest<HrmsBuildingPageResponse> {

    /** 当前页面 */
    private String pageNum;
    /** 每页数量 */
    private String pageSize;
    /** 搜索类型（1-模糊，2-精确） */
    private String searchType;
    /*--------以上必填-----*/

    /** 楼栋名称 */
    private String buildingName;
    /** 所属小区ID */
    private String blockId;
    /** 楼栋负责人姓名 */
    private String buildingPerson;
    /** 所属组织编码 */
    private String orgCode;
    /** 模糊搜索关键词 */
    private String searchKey;


    public HrmsBuildingPageRequest(Builder builder) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_BUILDING_PAGE_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        this.searchKey = builder.searchType;
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
        putBodyParameter("searchType",searchType);
    }

    @Override
    public Class<HrmsBuildingPageResponse> getResponseClass() {
        return HrmsBuildingPageResponse.class;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        putBodyParameter("pageNum",pageNum);
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        putBodyParameter("pageSize",pageSize);
        this.pageSize = pageSize;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        putBodyParameter("searchType",searchType);
        this.searchType = searchType;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        putBodyParameter("buildingName",buildingName);
        this.buildingName = buildingName;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        putBodyParameter("blockId",blockId);
        this.blockId = blockId;
    }

    public String getBuildingPerson() {
        return buildingPerson;
    }

    public void setBuildingPerson(String buildingPerson) {
        putBodyParameter("buildingPerson",buildingPerson);
        this.buildingPerson = buildingPerson;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        putBodyParameter("orgCode",orgCode);
        this.orgCode = orgCode;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        putBodyParameter("searchKey",searchKey);
        this.searchKey = searchKey;
    }

    @Override
    public String toString() {
        return "HrmsBuildingPageRequest{" +
                "pageNum='" + pageNum + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", searchType='" + searchType + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", blockId='" + blockId + '\'' +
                ", buildingPerson='" + buildingPerson + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", searchKey='" + searchKey + '\'' +
                '}';
    }

    public static class Builder {

        /** 当前页面 */
        private String pageNum;
        /** 每页数量 */
        private String pageSize;
        /** 搜索类型（1-模糊，2-精确） */
        private String searchType;
        /*--------以上必填-----*/

        public Builder pageNum(String pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(String pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder searchType(String searchType) {
            this.searchType = searchType;
            return this;
        }

        public HrmsBuildingPageRequest build() throws ClientException {
            return new HrmsBuildingPageRequest(this);
        }
    }
}
