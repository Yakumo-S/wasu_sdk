package com.dahuatech.icc.assesscontrol.model.v202103.authDept;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 按部门授权删除
 *
 * @author 237417
 */
public class AuthDeptDelRequest extends AbstractIccRequest<AuthDeptDelResponse> {

    /** 门组ID */
    private Integer doorGroupId;
    /** 部门ID */
    private String deptIdsString;

    public AuthDeptDelRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_DEPT_DEL_POST), Method.POST);
        this.deptIdsString = builder.deptIdsString;
        this.doorGroupId = builder.doorGroupId;
        putBodyParameter("deptIdsString",deptIdsString);
        putBodyParameter("doorGroupId",doorGroupId);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthDeptDelResponse> getResponseClass() {
        return AuthDeptDelResponse.class;
    }

    public Integer getDoorGroupId() {
        return doorGroupId;
    }

    public void setDoorGroupId(Integer doorGroupId) {
        this.doorGroupId = doorGroupId;
        putBodyParameter("deptIdsString",deptIdsString);
    }

    public String getDeptIdsString() {
        return deptIdsString;
    }

    public void setDeptIdsString(String deptIdsString) {
        this.deptIdsString = deptIdsString;
        putBodyParameter("doorGroupId",doorGroupId);
    }

    public static class Builder {

        /** 门组ID */
        private Integer doorGroupId;
        /** 部门ID */
        private String deptIdsString;

        public Builder doorGroupId(Integer doorGroupId) {
            this.doorGroupId = doorGroupId;
            return this;
        }

        public Builder deptIdsString(String deptIdsString) {
            this.deptIdsString = deptIdsString;
            return this;
        }

        public AuthDeptDelRequest build() throws ClientException {
            return new AuthDeptDelRequest(this);
        }
    }
}
