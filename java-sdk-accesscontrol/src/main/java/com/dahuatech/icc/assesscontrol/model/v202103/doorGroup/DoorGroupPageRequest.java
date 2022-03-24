package com.dahuatech.icc.assesscontrol.model.v202103.doorGroup;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 门组列表
 *
 * @author 237417
 */
public class DoorGroupPageRequest extends AbstractIccRequest<DoorGroupPageResponse> {
    /** 页码，默认1 */
    private String pageNum;
    /** 页容量，默认20 */
    private String pageSize;
    /** 门组名称，支持模糊搜索 */
    private String singleCondition;

    public DoorGroupPageRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_DOOR_GROUP_PAGE_LIST_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        this.singleCondition = builder.singleCondition;
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
        putBodyParameter("singleCondition",singleCondition);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<DoorGroupPageResponse> getResponseClass() {
        return DoorGroupPageResponse.class;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
        putBodyParameter("pageNum",pageNum);
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
        putBodyParameter("pageSize",pageSize);
    }

    public String getSingleCondition() {
        return singleCondition;
    }

    public void setSingleCondition(String singleCondition) {
        this.singleCondition = singleCondition;
        putBodyParameter("singleCondition",singleCondition);
    }

    public static class Builder {
        /** 页码，默认1 */
        private String pageNum;
        /** 页容量，默认20 */
        private String pageSize;
        /** 门组名称，支持模糊搜索 */
        private String singleCondition;

        public Builder pageNum(String pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(String pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder singleCondition(String singleCondition) {
            this.singleCondition = singleCondition;
            return this;
        }

        public DoorGroupPageRequest build() throws ClientException {
            return new DoorGroupPageRequest(this);
        }
    }
}
