package com.dahuatech.icc.assesscontrol.model.v202103.normalOpen;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 常开常闭计划列表
 *
 * @author 237417
 */
public class NormalOpenPageListRequest extends AbstractIccRequest<NormalOpenPageListResponse> {
    /** 页码 */
    private Integer pageNum;
    /** 页容量 */
    private Integer pageSize;
    /*--------以上必填-----*/
    /** 查询条件 */
    private String singleCondition;

    public NormalOpenPageListRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_OPEN_NORMALLY_SETTING_ADD_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<NormalOpenPageListResponse> getResponseClass() {
        return NormalOpenPageListResponse.class;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        putBodyParameter("pageNum",pageNum);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
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
        /** 页码 */
        private Integer pageNum;
        /** 页容量 */
        private Integer pageSize;

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public NormalOpenPageListRequest build() throws ClientException {
            return new NormalOpenPageListRequest(this);
        }
    }
}
