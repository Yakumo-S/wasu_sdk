package com.dahuatech.icc.assesscontrol.model.v202103.authPerson;

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
public class AuthPersonAddRequest extends AbstractIccRequest<AuthPersonAddResponse> {
    /** 卡号 */
    private List<String> cardNumbers;
    /** 权限细节 */
    private List<CardPrivilegeDetails> cardPrivilegeDetails;
    /** 开门计划id */
    private Long timeQuantumId;
    /*--------以上必填-----*/

    public AuthPersonAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_PERSON_ADD_POST), Method.POST);
        this.cardNumbers = builder.cardNumbers;
        this.cardPrivilegeDetails = builder.cardPrivilegeDetails;
        this.timeQuantumId = builder.timeQuantumId;
        putBodyParameter("cardNumbers",cardNumbers);
        putBodyParameter("cardPrivilegeDetails",cardPrivilegeDetails);
        putBodyParameter("timeQuantumId",timeQuantumId);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthPersonAddResponse> getResponseClass() {
        return AuthPersonAddResponse.class;
    }

    public List<String> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(List<String> cardNumbers) {
        this.cardNumbers = cardNumbers;
        putBodyParameter("cardNumbers",cardNumbers);
    }

    public List<CardPrivilegeDetails> getCardPrivilegeDetails() {
        return cardPrivilegeDetails;
    }

    public void setCardPrivilegeDetails(List<CardPrivilegeDetails> cardPrivilegeDetails) {
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
        private List<String> cardNumbers;
        /** 权限细节 */
        private List<CardPrivilegeDetails> cardPrivilegeDetails;
        /** 开门计划id */
        private Long timeQuantumId;
        /*--------以上必填-----*/

        public Builder cardNumbers(List<String> cardNumbers) {
            this.cardNumbers = cardNumbers;
            return this;
        }

        public Builder cardPrivilegeDetails(List<CardPrivilegeDetails> cardPrivilegeDetails) {
            this.cardPrivilegeDetails = cardPrivilegeDetails;
            return this;
        }

        public Builder timeQuantumId(Long timeQuantumId) {
            this.timeQuantumId = timeQuantumId;
            return this;
        }

        public AuthPersonAddRequest build() throws ClientException {
            return new AuthPersonAddRequest(this);
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
