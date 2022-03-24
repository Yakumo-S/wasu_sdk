package com.dahuatech.icc.visitors.model.v202104.authorize;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

public class UpdateAccessChannelByVisitRequest extends AbstractIccRequest<UpdateAccessChannelByVisitResponse> {

    /** 通道编码 */
    private String channelCodes;
    /** 是否全选 */
    private Boolean checkedAll;

    public UpdateAccessChannelByVisitRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_UPDATE_ACCESS_CHANNEL_BY_VISIT_POST), Method.POST);
        this.channelCodes = builder.channelCodes;
        this.checkedAll = builder.checkedAll;
        putBodyParameter("channelCodes",channelCodes);
        putBodyParameter("checkedAll",checkedAll);
    }

    @Override
    public Class<UpdateAccessChannelByVisitResponse> getResponseClass() {
        return UpdateAccessChannelByVisitResponse.class;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getChannelCodes() {
        return channelCodes;
    }

    public void setChannelCodes(String channelCodes) {
        this.channelCodes = channelCodes;
        putBodyParameter("channelCodes",channelCodes);
    }

    public Boolean getCheckedAll() {
        return checkedAll;
    }

    public void setCheckedAll(Boolean checkedAll) {
        this.checkedAll = checkedAll;
        putBodyParameter("checkedAll",checkedAll);
    }

    @Override
    public String toString() {
        return "UpdateAccessChannelByVisitRequest{" +
                "channelCodes='" + channelCodes + '\'' +
                ", checkedAll=" + checkedAll +
                '}';
    }

    public static class Builder {
        /** 通道编码 */
        private String channelCodes;
        /** 是否全选 */
        private Boolean checkedAll;

        public Builder channelCodes(String channelCodes) {
            this.channelCodes = channelCodes;
            return this;
        }

        public Builder checkAll(Boolean checkedAll) {
            this.checkedAll = checkedAll;
            return this;
        }

        public UpdateAccessChannelByVisitRequest build() throws ClientException {
            return new UpdateAccessChannelByVisitRequest(this);
        }
    }

}