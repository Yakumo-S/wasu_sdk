package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

/***
 * 内部人员登出接口
 * @author 237417
 * @since 20210421
 */
public class PersonLogoutRequest extends AbstractIccRequest<PersonLogoutResponse> {

    public PersonLogoutRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_PERSON_LOGOUT_POST), Method.POST);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<PersonLogoutResponse> getResponseClass() {
        return PersonLogoutResponse.class;
    }

    public static class Builder {



        public PersonLogoutRequest build() throws ClientException {
            return new PersonLogoutRequest(this);
        }
    }
}