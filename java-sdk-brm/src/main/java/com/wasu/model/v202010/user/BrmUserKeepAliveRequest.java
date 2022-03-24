package com.wasu.model.v202010.user;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

public class BrmUserKeepAliveRequest
        extends AbstractIccRequest<BrmUserKeepAliveResponse> {

    /** 终端类型 */
    private Integer clientType;
    /** 用户登录magicId */
    private String magicId;
    /*--------以上必填-----*/

    public BrmUserKeepAliveRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_USER_KEEP_ALIVE_POST), Method.POST);
        this.clientType = builder.clientType;
        this.magicId = builder.magicId;
        putBodyParameter("clientType",clientType);
        putBodyParameter("magicId",magicId);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<BrmUserKeepAliveResponse> getResponseClass() {
        return BrmUserKeepAliveResponse.class;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
        putBodyParameter("clientType",clientType);
    }

    public String getMagicId() {
        return magicId;
    }

    public void setMagicId(String magicId) {
        this.magicId = magicId;
        putBodyParameter("magicId",magicId);
    }

    @Override
    public String toString() {
        return "BrmUserKeepAliveRequest{" +
                "clientType=" + clientType +
                ", magicId='" + magicId + '\'' +
                '}';
    }

    public static class Builder {
        /** 终端类型 */
        private Integer clientType;
        /** 用户登录magicId */
        private String magicId;
        /*--------以上必填-----*/

        public Builder clientType(Integer clientType) {
            this.clientType = clientType;
            return this;
        }

        public Builder magicId(String magicId) {
            this.magicId = magicId;
            return this;
        }

        public BrmUserKeepAliveRequest build() throws ClientException {
            return new BrmUserKeepAliveRequest(this);
        }
    }
}
