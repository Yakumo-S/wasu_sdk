package com.dahuatech.icc.assesscontrol.model.v202103.authDoor;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 按人授权删除
 *
 * @author 237417
 */
public class AuthPersonByChannelDelRequest extends AbstractIccRequest<AuthPersonByChannelDelResponse> {

    /** 卡号 */
    private String cardNumberString;
    /** 通道编码 */
    private String channelCode;
    /** 人员ID */
    private String personIdsString;

    public AuthPersonByChannelDelRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_PERSON_DELETE_POST), Method.POST);
        this.cardNumberString = builder.cardNumberString;
        this.channelCode = builder.channelCode;
        this.personIdsString = builder.personIdsString;
        putBodyParameter("cardNumberString",cardNumberString);
        putBodyParameter("channelCode",channelCode);
        putBodyParameter("personIdsString",personIdsString);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthPersonByChannelDelResponse> getResponseClass() {
        return AuthPersonByChannelDelResponse.class;
    }

    public String getCardNumberString() {
        return cardNumberString;
    }

    public void setCardNumberString(String cardNumberString) {
        this.cardNumberString = cardNumberString;
        putBodyParameter("cardNumberString",cardNumberString);
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        putBodyParameter("channelCode",channelCode);
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
        private String channelCode;
        /** 人员ID */
        private String personIdsString;

        public Builder cardNumberString(String cardNumberString) {
            this.cardNumberString = cardNumberString;
            return this;
        }

        public Builder channelCode(String channelCode) {
            this.channelCode = channelCode;
            return this;
        }

        public Builder personIdsString(String personIdsString) {
            this.personIdsString = personIdsString;
            return this;
        }

        public AuthPersonByChannelDelRequest build() throws ClientException {
            return new AuthPersonByChannelDelRequest(this);
        }
    }
}
