package com.dahuatech.icc.assesscontrol.model.v202103.authDept;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 部门权限分页查询
 *
 * @author 237417
 */
public class AuthDeptPageListRequest extends AbstractIccRequest<AuthDeptPageListResponse> {

    /** 页码 */
    private Integer pageNum;
    /** 分页大小 */
    private Integer pageSize;
    /*--------以上必填-----*/

    /** 通道编码 */
    private String channelCode;
    public AuthDeptPageListRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_DEPT_PAGE_LIST_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthDeptPageListResponse> getResponseClass() {
        return AuthDeptPageListResponse.class;
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

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public static class Builder {

        /** 页码 */
        private Integer pageNum;
        /** 分页大小 */
        private Integer pageSize;

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public AuthDeptPageListRequest build() throws ClientException {
            return new AuthDeptPageListRequest(this);
        }
    }
}
