package com.dahuatech.icc.assesscontrol.model.v202103.authDept;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 按部门授权
 *
 * @author 237417
 */
public class AuthDeptRequest extends AbstractIccRequest<AuthDeptResponse> {

    /** 通道编码 */
    private String channelCode;
    /** 部门ID */
    private String deptIdString;

    public AuthDeptRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_DEPT_POST), Method.POST);
        this.channelCode = builder.channelCode;
        this.deptIdString = builder.deptIdString;
        putBodyParameter("channelCode",channelCode);
        putBodyParameter("deptIdString",deptIdString);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthDeptResponse> getResponseClass() {
        return AuthDeptResponse.class;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        putBodyParameter("channelCode",channelCode);
    }

    public String getDeptIdString() {
        return deptIdString;
    }

    public void setDeptIdString(String deptIdString) {
        this.deptIdString = deptIdString;
        putBodyParameter("deptIdString",deptIdString);
    }

    public static class Builder {

        /** 通道编码 */
        private String channelCode;
        /** 部门ID */
        private String deptIdString;

        public Builder channelCode(String channelCode) {
            this.channelCode = channelCode;
            return this;
        }

        public Builder deptIdString(String deptIdString) {
            this.deptIdString = deptIdString;
            return this;
        }

        public AuthDeptRequest build() throws ClientException {
            return new AuthDeptRequest(this);
        }
    }
}
