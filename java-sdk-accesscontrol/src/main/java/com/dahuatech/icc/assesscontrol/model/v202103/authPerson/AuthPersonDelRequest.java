package com.dahuatech.icc.assesscontrol.model.v202103.authPerson;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 按人授权删除
 *
 * @author 237417
 */
public class AuthPersonDelRequest extends AbstractIccRequest<AuthPersonDelResponse> {

    /** 卡号 */
    private List<String> cardNums;
    /** 需要保留的权限类型："1" - 门禁点授权， "2" - 门组授权， "3" - 梯控授权 */
    private Integer privilegeType;
    /*--------以上必填-----*/

    public AuthPersonDelRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_PERSON_DELETE_POST), Method.POST);
        this.cardNums = builder.cardNums;
        this.privilegeType = builder.privilegeType;
        putBodyParameter("carNums",cardNums);
        putBodyParameter("privilegeType",privilegeType);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthPersonDelResponse> getResponseClass() {
        return AuthPersonDelResponse.class;
    }

    public List<String> getCardNums() {
        return cardNums;
    }

    public void setCardNums(List<String> cardNums) {
        this.cardNums = cardNums;
        putBodyParameter("carNums",cardNums);
    }

    public Integer getPrivilegeType() {
        return privilegeType;
    }

    public void setPrivilegeType(Integer privilegeType) {
        this.privilegeType = privilegeType;
        putBodyParameter("privilegeType",privilegeType);
    }

    public static class Builder {
        /** 卡号 */
        private List<String> cardNums;
        /** 需要保留的权限类型："1" - 门禁点授权， "2" - 门组授权， "3" - 梯控授权 */
        private Integer privilegeType;

        public Builder cardNums(List<String> cardNums) {
            this.cardNums = cardNums;
            return this;
        }

        public Builder privilegeType(Integer privilegeType) {
            this.privilegeType = privilegeType;
            return this;
        }

        public AuthPersonDelRequest build() throws ClientException {
            return new AuthPersonDelRequest(this);
        }
    }
}
