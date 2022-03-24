package com.dahuatech.icc.assesscontrol.model.v202103.multipleCard;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 删除多卡开门
 *
 * @author 237417
 */
public class MultiCardDelRequest extends AbstractIccRequest<MultiCardDelResponse> {

    /** 人员组ID */
    private Long id;

    public MultiCardDelRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_PERSON_GROUP_ADD_POST), Method.POST);
        this.id = builder.id;
        putBodyParameter("id",id);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<MultiCardDelResponse> getResponseClass() {
        return MultiCardDelResponse.class;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        putBodyParameter("id",id);
    }

    public static class Builder {
        /** 人员组ID */
        private Long id;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public MultiCardDelRequest build() throws ClientException {
            return new MultiCardDelRequest(this);
        }
    }
}
