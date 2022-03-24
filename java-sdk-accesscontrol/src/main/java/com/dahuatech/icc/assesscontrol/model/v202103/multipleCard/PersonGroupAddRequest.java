package com.dahuatech.icc.assesscontrol.model.v202103.multipleCard;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 添加人员组
 *
 * @author 237417
 */
public class PersonGroupAddRequest extends AbstractIccRequest<PersonGroupAddResponse> {
    /** 人员编码 */
    private String personCode;
    /** 人员数量 */
    private Integer personNum;
    /** 人员组名称 */
    private String personGroupName;
    /*--------以上必填-----*/

    public PersonGroupAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_PERSON_GROUP_ADD_POST), Method.POST);
        this.personCode = builder.personCode;
        this.personNum = builder.personNum;
        this.personGroupName = builder.personGroupName;
        putBodyParameter("personCode",personCode);
        putBodyParameter("personNum",personNum);
        putBodyParameter("personGroupName",personGroupName);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<PersonGroupAddResponse> getResponseClass() {
        return PersonGroupAddResponse.class;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
        putBodyParameter("personCode",personCode);
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
        putBodyParameter("personNum",personNum);
    }

    public String getPersonGroupName() {
        return personGroupName;
    }

    public void setPersonGroupName(String personGroupName) {
        this.personGroupName = personGroupName;
        putBodyParameter("personGroupName",personGroupName);
    }

    public static class Builder {
        /** 人员编码 */
        private String personCode;
        /** 人员数量 */
        private Integer personNum;
        /** 人员组名称 */
        private String personGroupName;

        public Builder personCode(String personCode) {
            this.personCode = personCode;
            return this;
        }

        public Builder personNum(Integer personNum) {
            this.personNum = personNum;
            return this;
        }

        public Builder personGroupName(String personGroupName) {
            this.personGroupName = personGroupName;
            return this;
        }

        public PersonGroupAddRequest build() throws ClientException {
            return new PersonGroupAddRequest(this);
        }
    }
}
