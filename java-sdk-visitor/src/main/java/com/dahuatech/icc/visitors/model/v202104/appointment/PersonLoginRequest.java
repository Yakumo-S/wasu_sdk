package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

/***
 * 内部人员登录接口
 * @author 237417
 * @since 20210421
 */
public class PersonLoginRequest extends AbstractIccRequest<PersonLoginResponse> {

    /** 用户民/手机号 */
    private String username;
    /** 密码 */
    private String password;

    public PersonLoginRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_PERSON_LOGIN_POST), Method.POST);
        putBodyParameter("username",username);
        putBodyParameter("password",password);
        this.username = builder.username;
        this.password = builder.password;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<PersonLoginResponse> getResponseClass() {
        return PersonLoginResponse.class;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        putBodyParameter("username",username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        putBodyParameter("password",password);
        this.password = password;
    }

    public static class Builder {

        /** 用户民/手机号 */
        private String username;
        /** 密码 */
        private String password;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public PersonLoginRequest build() throws ClientException {
            return new PersonLoginRequest(this);
        }
    }
}
