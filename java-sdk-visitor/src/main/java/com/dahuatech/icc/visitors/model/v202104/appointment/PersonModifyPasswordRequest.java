package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

/***
 * 修改密码接口
 * @author 237417
 * @since 20210421
 */
public class PersonModifyPasswordRequest extends AbstractIccRequest<PersonModifyPasswordResponse> {

    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 新密码 */
    private String newPassword;

    public PersonModifyPasswordRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_PERSON_MODIFY_PASSWORD_POST), Method.POST);
        this.username = builder.username;
        this.password = builder.password;
        this.newPassword = builder.newPassword;
        putBodyParameter("username",username);
        putBodyParameter("password",password);
        putBodyParameter("newPassword",newPassword);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<PersonModifyPasswordResponse> getResponseClass() {
        return PersonModifyPasswordResponse.class;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        putBodyParameter("newPassword",newPassword);
        this.newPassword = newPassword;
    }

    public static class Builder {

        /** 用户名 */
        private String username;
        /** 密码 */
        private String password;
        /** 新密码 */
        private String newPassword;

        public Builder userName(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder newPassword(String newPassword) {
            this.newPassword = newPassword;
            return this;
        }

        public PersonModifyPasswordRequest build() throws ClientException {
            return new PersonModifyPasswordRequest(this);
        }
    }
}