package com.dahuatech.icc.assesscontrol.model.v202103.authDoor;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 按门组授权新增
 *
 * @author 237417
 */
public class AuthDoorAddRequest extends AbstractIccRequest<AuthDoorAddResponse> {

    /** 卡号 */
    private List<String> cardNumbers;
    /** 门组ID */
    private Number doorGroupId;
    /** 人员ID */
    private String personIdsString;
    /** 开门计划ID */
    private Long timeQuantumId;
    /*--------以上必填-----*/


    public AuthDoorAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_PERSON_ADD_POST), Method.POST);
        this.cardNumbers = builder.cardNumbers;
        this.doorGroupId = builder.doorGroupId;
        this.personIdsString = builder.personIdsString;
        this.timeQuantumId = builder.timeQuantumId;
        putBodyParameter("cardNumbers",cardNumbers);
        putBodyParameter("doorGroupId",doorGroupId);
        putBodyParameter("personIdsString",personIdsString);
        putBodyParameter("timeQuantumId",timeQuantumId);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthDoorAddResponse> getResponseClass() {
        return AuthDoorAddResponse.class;
    }

    public List<String> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(List<String> cardNumbers) {
        this.cardNumbers = cardNumbers;
        putBodyParameter("cardNumbers",cardNumbers);
    }

    public Number getDoorGroupId() {
        return doorGroupId;
    }

    public void setDoorGroupId(Number doorGroupId) {
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

    public Long getTimeQuantumId() {
        return timeQuantumId;
    }

    public void setTimeQuantumId(Long timeQuantumId) {
        this.timeQuantumId = timeQuantumId;
        putBodyParameter("timeQuantumId",timeQuantumId);
    }

    public static class Builder {
        /** 卡号 */
        private List<String> cardNumbers;
        /** 门组ID */
        private Number doorGroupId;
        /** 人员ID */
        private String personIdsString;
        /** 开门计划ID */
        private Long timeQuantumId;
        /*--------以上必填-----*/

        public Builder cardNumbers(List<String> cardNumbers) {
            this.cardNumbers = cardNumbers;
            return this;
        }

        public Builder doorGroupId(Number doorGroupId) {
            this.doorGroupId = doorGroupId;
            return this;
        }

        public Builder personIdsString(String personIdsString) {
            this.personIdsString = personIdsString;
            return this;
        }

        public Builder timeQuantumId(Long timeQuantumId) {
            this.timeQuantumId = timeQuantumId;
            return this;
        }

        public AuthDoorAddRequest build() throws ClientException {
            return new AuthDoorAddRequest(this);
        }
    }
}
