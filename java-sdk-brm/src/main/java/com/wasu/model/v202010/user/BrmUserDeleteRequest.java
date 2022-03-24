package com.wasu.model.v202010.user;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

public class BrmUserDeleteRequest
        extends AbstractIccRequest<BrmUserDeleteResponse> {

    /** 用户ID数组 */
    private String ids;

    private BrmUserDeleteRequest(BrmUserDeleteRequest.Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_USER_DEL_DELETE), Method.DELETE);
        this.ids = builder.ids;
        putBodyParameter("ids", ids);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<BrmUserDeleteResponse> getResponseClass() {
        return BrmUserDeleteResponse.class;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
        putBodyParameter("ids", ids);
    }

    public static class Builder {
        /** 部门Id */
        private String ids;

        public Builder ids(String ids) {
            this.ids = ids;
            return this;
        }

        public BrmUserDeleteRequest build() throws ClientException {
            return new BrmUserDeleteRequest(this);
        }
    }
}
