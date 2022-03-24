package com.dahuatech.icc.assesscontrol.model.v202103.authDept;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 按人授权新增
 *
 * @author 237417
 */
public class AuthDeptByChannelAddRequest extends AbstractIccRequest<AuthDeptByChannelAddResponse> {
    /** 通道编码 */
    private String channelCode;
    /** 部门ID */
    private String deptIdsString;
    /** 开门计划ID */
    private Long timeQuantumId;
    /** 是否是快速下发 */
    private Integer fastAuth;
    /*--------以上必填-----*/


    public AuthDeptByChannelAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_DEPT_BY_CHANNEL_CODE_ADD_POST), Method.POST);
        this.channelCode = builder.channelCode;
        this.deptIdsString = builder.deptIdsString;
        this.timeQuantumId = builder.timeQuantumId;
        this.fastAuth = builder.fastAuth;
        putBodyParameter("channelCode",channelCode);
        putBodyParameter("deptIdsString",deptIdsString);
        putBodyParameter("timeQuantumId",timeQuantumId);
        putBodyParameter("fastAuth",fastAuth);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthDeptByChannelAddResponse> getResponseClass() {
        return AuthDeptByChannelAddResponse.class;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        putBodyParameter("channelCode",channelCode);
    }

    public String getDeptIdsString() {
        return deptIdsString;
    }

    public void setDeptIdsString(String deptIdsString) {
        this.deptIdsString = deptIdsString;
        putBodyParameter("deptIdsString",deptIdsString);
    }

    public Long getTimeQuantumId() {
        return timeQuantumId;
    }

    public void setTimeQuantumId(Long timeQuantumId) {
        this.timeQuantumId = timeQuantumId;
        putBodyParameter("timeQuantumId",timeQuantumId);
    }

    public Integer getFastAuth() {
        return fastAuth;
    }

    public void setFastAuth(Integer fastAuth) {
        this.fastAuth = fastAuth;
        putBodyParameter("fastAuth",fastAuth);
    }

    public static class Builder {

        /** 通道编码 */
        private String channelCode;
        /** 部门ID */
        private String deptIdsString;
        /** 开门计划ID */
        private Long timeQuantumId;
        /** 是否是快速下发 */
        private Integer fastAuth;

        public Builder channelCode(String channelCode) {
            this.channelCode = channelCode;
            return this;
        }

        public Builder deptIdsString(String deptIdsString) {
            this.deptIdsString = deptIdsString;
            return this;
        }

        public Builder timeQuantumId(Long timeQuantumId) {
            this.timeQuantumId = timeQuantumId;
            return this;
        }

        public Builder fastAuth(Integer fastAuth) {
            this.fastAuth = fastAuth;
            return this;
        }

        public AuthDeptByChannelAddRequest build() throws ClientException {
            return new AuthDeptByChannelAddRequest(this);
        }
    }
}
