package com.dahuatech.icc.assesscontrol.model.v202103.authDoor;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 按人授权新增
 *
 * @author 237417
 */
public class AuthPersonByChannelAddRequest extends AbstractIccRequest<AuthPersonByChannelAddResponse> {

    /** 卡号 */
    private List<String> cardNumbers;
    /** 通道编码 */
    private String channelCode;
    /** 人员ID */
    private String personIdsString;
    /** 开门计划ID */
    private Long timeQuantumId;
    /*--------以上必填-----*/


    public AuthPersonByChannelAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_PERSON_BY_CHANNEL_CODE_ADD_POST), Method.POST);
        this.cardNumbers = builder.cardNumbers;
        this.channelCode = builder.channelCode;
        this.personIdsString = builder.personIdsString;
        this.timeQuantumId = builder.timeQuantumId;
        putBodyParameter("cardNumbers",cardNumbers);
        putBodyParameter("channelCode",channelCode);
        putBodyParameter("personIdsString",personIdsString);
        putBodyParameter("timeQuantumId",timeQuantumId);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthPersonByChannelAddResponse> getResponseClass() {
        return AuthPersonByChannelAddResponse.class;
    }

    public List<String> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(List<String> cardNumbers) {
        this.cardNumbers = cardNumbers;
        putBodyParameter("cardNumbers",cardNumbers);
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
        /** 通道编码 */
        private String channelCode;
        /** 人员ID */
        private String personIdsString;
        /** 开门计划ID */
        private Long timeQuantumId;
        /*--------以上必填-----*/

        public Builder cardNumbers(List<String> cardNumbers) {
            this.cardNumbers = cardNumbers;
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

        public Builder timeQuantumId(Long timeQuantumId) {
            this.timeQuantumId = timeQuantumId;
            return this;
        }

        public AuthPersonByChannelAddRequest build() throws ClientException {
            return new AuthPersonByChannelAddRequest(this);
        }
    }
}
