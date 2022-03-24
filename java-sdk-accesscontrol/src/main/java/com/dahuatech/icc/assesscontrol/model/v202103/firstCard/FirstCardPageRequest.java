package com.dahuatech.icc.assesscontrol.model.v202103.firstCard;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 首卡列表
 *
 * @author 237417
 */
public class FirstCardPageRequest extends AbstractIccRequest<FirstCardPageResponse> {

    /** 页码 */
    private String pageNum;
    /** 页容量 */
    private String pageSize;
    /*--------以上必填-----*/
    /** 首卡名称，支持模糊搜索 */
    private String singleCondition;

    public FirstCardPageRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_FIRST_CARD_PAGE_LIST_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        putBodyParameter("pageNum",1);
        putBodyParameter("pageSize",10);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<FirstCardPageResponse> getResponseClass() {
        return FirstCardPageResponse.class;
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
        /** 页码 */
        private String pageNum;
        /** 页容量 */
        private String pageSize;

        public Builder pageNum(String pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(String pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public FirstCardPageRequest build() throws ClientException {
            return new FirstCardPageRequest(this);
        }
    }
}
