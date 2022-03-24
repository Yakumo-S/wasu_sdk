package com.dahuatech.icc.assesscontrol.model.v202103.firstCard;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 删除首卡
 *
 * @author 237417
 */
public class FirstCardDelRequest extends AbstractIccRequest<FirstCardDelResponse> {
    /** 首卡开门ID */
    private Long id;

    public FirstCardDelRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_FIRST_CARD_DEL_POST), Method.POST);
        this.id = builder.id;
        putBodyParameter("id",id);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<FirstCardDelResponse> getResponseClass() {
        return FirstCardDelResponse.class;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        putBodyParameter("id",id);
    }

    public static class Builder {
        /** 首卡开门ID */
        private Long id;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public FirstCardDelRequest build() throws ClientException {
            return new FirstCardDelRequest(this);
        }
    }
}
