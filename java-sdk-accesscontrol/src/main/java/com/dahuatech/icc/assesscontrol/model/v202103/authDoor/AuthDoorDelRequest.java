package com.dahuatech.icc.assesscontrol.model.v202103.authDoor;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 按门组授权删除
 *
 * @author 237417
 */
public class AuthDoorDelRequest extends AbstractIccRequest<AuthDoorDelResponse> {

    /** 卡号 */
    private String cardNumberString;
    /** 门组ID */
    private String doorGroupId;
    /** 人员ID */
    private String personIdsString;

    public AuthDoorDelRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_DOOR_DEL_POST), Method.POST);
        this.cardNumberString = builder.cardNumberString;
        this.doorGroupId = builder.doorGroupId;
        this.personIdsString = builder.personIdsString;
        putBodyParameter("cardNumberString",cardNumberString);
        putBodyParameter("doorGroupId",doorGroupId);
        putBodyParameter("personIdsString",personIdsString);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthDoorDelResponse> getResponseClass() {
        return AuthDoorDelResponse.class;
    }

    public String getCardNumberString() {
        return cardNumberString;
    }

    public void setCardNumberString(String cardNumberString) {
        this.cardNumberString = cardNumberString;
        putBodyParameter("cardNumberString",cardNumberString);
    }

    public String getDoorGroupId() {
        return doorGroupId;
    }

    public void setDoorGroupId(String doorGroupId) {
        this.doorGroupId = doorGroupId;
        putBodyParameter("doorGroupId",doorGroupId);
    }

    public String getPersonIdsString() {
        return personIdsString;
    }

    public void setPersonIdsString(String personIdsString) {
        this.personIdsString = personIdsString;
        putBodyParameter("personIdsString",personIdsString);
    }

    public static class Builder {

        /** 卡号 */
        private String cardNumberString;
        /** 通道编码 */
        private String doorGroupId;
        /** 人员ID */
        private String personIdsString;

        public Builder cardNumberString(String cardNumberString) {
            this.cardNumberString = cardNumberString;
            return this;
        }

        public Builder doorGroupId(String doorGroupId) {
            this.doorGroupId = doorGroupId;
            return this;
        }

        public Builder personIdsString(String personIdsString) {
            this.personIdsString = personIdsString;
            return this;
        }

        public AuthDoorDelRequest build() throws ClientException {
            return new AuthDoorDelRequest(this);
        }
    }
}
