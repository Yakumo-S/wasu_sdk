package com.dahuatech.icc.assesscontrol.model.v202103.authPerson;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 按人授权更新
 *
 * @author 237417
 */
public class AuthPersonUpdateRequest extends AbstractIccRequest<AuthPersonUpdateResponse> {

    /** 卡号 */
    private String cardNumber;
    /** 权限细节 */
    private List<AuthPersonAddRequest.CardPrivilegeDetails> cardPrivilegeDetails;
    /** 开门计划id */
    private Long timeQuantumId;
    /*--------以上必填-----*/

    public AuthPersonUpdateRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_PERSON_UPDATE_POST), Method.POST);
        this.cardNumber = builder.cardNumber;
        this.cardPrivilegeDetails = builder.cardPrivilegeDetails;
        this.timeQuantumId = builder.timeQuantumId;
        putBodyParameter("cardNumber",cardNumber);
        putBodyParameter("cardPrivilegeDetails",cardPrivilegeDetails);
        putBodyParameter("timeQuantumId",timeQuantumId);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthPersonUpdateResponse> getResponseClass() {
        return AuthPersonUpdateResponse.class;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        putBodyParameter("cardNumber",cardNumber);
    }

    public List<AuthPersonAddRequest.CardPrivilegeDetails> getCardPrivilegeDetails() {
        return cardPrivilegeDetails;
    }

    public void setCardPrivilegeDetails(List<AuthPersonAddRequest.CardPrivilegeDetails> cardPrivilegeDetails) {
        this.cardPrivilegeDetails = cardPrivilegeDetails;
        putBodyParameter("cardPrivilegeDetails",cardPrivilegeDetails);
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
        private String cardNumber;
        /** 权限细节 */
        private List<AuthPersonAddRequest.CardPrivilegeDetails> cardPrivilegeDetails;
        /** 开门计划id */
        private Long timeQuantumId;
        /*--------以上必填-----*/

        public Builder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder cardPrivilegeDetails(List<AuthPersonAddRequest.CardPrivilegeDetails> cardPrivilegeDetails) {
            this.cardPrivilegeDetails = cardPrivilegeDetails;
            return this;
        }

        public Builder timeQuantumId(Long timeQuantumId) {
            this.timeQuantumId = timeQuantumId;
            return this;
        }

        public AuthPersonUpdateRequest build() throws ClientException {
            return new AuthPersonUpdateRequest(this);
        }
    }

    public static class CardPrivilegeDetails {
        /** 授权类型：1 - 门禁点授权，2 - 门组授权，3 - 梯控授权 */
        private Integer privilegeType;
        /** 授权类型：门禁点授权使用通道编码，门组授权使用门组id */
        private String resourceCode;

        public Integer getPrivilegeType() {
            return privilegeType;
        }

        public void setPrivilegeType(Integer privilegeType) {
            this.privilegeType = privilegeType;
        }

        public String getResourceCode() {
            return resourceCode;
        }

        public void setResourceCode(String resourceCode) {
            this.resourceCode = resourceCode;
        }
    }
}
