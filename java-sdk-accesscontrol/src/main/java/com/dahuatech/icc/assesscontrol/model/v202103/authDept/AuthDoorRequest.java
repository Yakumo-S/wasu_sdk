package com.dahuatech.icc.assesscontrol.model.v202103.authDept;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 按门组授权
 *
 * @author 237417
 */
public class AuthDoorRequest extends AbstractIccRequest<AuthDoorResponse> {
    /** 门组ID */
    private Integer doorGroupId;
    /** 部门ID */
    private String deptIdsString;
    /** 开门计划ID */
    private Long timeQuantumId;

    public AuthDoorRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_DOOR_POST), Method.POST);
        this.doorGroupId = builder.doorGroupId;
        this.deptIdsString = builder.deptIdsString;
        this.timeQuantumId = builder.timeQuantumId;
        putBodyParameter("doorGroupId",doorGroupId);
        putBodyParameter("deptIdsString",deptIdsString);
        putBodyParameter("timeQuantumId",timeQuantumId);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthDoorResponse> getResponseClass() {
        return AuthDoorResponse.class;
    }

    public Integer getDoorGroupId() {
        return doorGroupId;
    }

    public void setDoorGroupId(Integer doorGroupId) {
        this.doorGroupId = doorGroupId;
        putBodyParameter("doorGroupId",doorGroupId);
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

    public static class Builder {

        /** 门组ID */
        private Integer doorGroupId;
        /** 部门ID */
        private String deptIdsString;
        /** 开门计划ID */
        private Long timeQuantumId;

        public Builder doorGroupId(Integer doorGroupId) {
            this.doorGroupId = doorGroupId;
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

        public AuthDoorRequest build() throws ClientException {
            return new AuthDoorRequest(this);
        }
    }
}
