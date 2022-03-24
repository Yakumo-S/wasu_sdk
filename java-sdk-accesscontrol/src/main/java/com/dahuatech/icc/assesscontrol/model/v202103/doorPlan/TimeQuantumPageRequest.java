package com.dahuatech.icc.assesscontrol.model.v202103.doorPlan;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 开门计划列表
 *
 * @author 237417
 */
public class TimeQuantumPageRequest extends AbstractIccRequest<TimeQuantumPageResponse> {
    /** 查询条件 */
    private String singleCondition;
    /** 请求页码 */
    private Integer pageNum;
    /** 每页大小 */
    private Integer pageSize;
    /*--------以上必填-----*/

    public TimeQuantumPageRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_TIME_QUANTUM_PAGE_LIST_POST), Method.POST);
        this.singleCondition = builder.singleCondition;
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        putBodyParameter("singleCondition",singleCondition);
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<TimeQuantumPageResponse> getResponseClass() {
        return TimeQuantumPageResponse.class;
    }

    public String getSingleCondition() {
        return singleCondition;
    }

    public void setSingleCondition(String singleCondition) {
        this.singleCondition = singleCondition;
        putBodyParameter("singleCondition",singleCondition);
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

    public static class Builder {
        /** 查询条件 */
        private String singleCondition;
        /** 请求页码 */
        private Integer pageNum;
        /** 每页大小 */
        private Integer pageSize;

        public Builder singleCondition(String singleCondition) {
            this.singleCondition = singleCondition;
            return this;
        }

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public TimeQuantumPageRequest build() throws ClientException {
            return new TimeQuantumPageRequest(this);
        }
    }
}
