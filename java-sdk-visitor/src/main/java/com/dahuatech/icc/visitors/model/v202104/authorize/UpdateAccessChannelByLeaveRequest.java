package com.dahuatech.icc.visitors.model.v202104.authorize;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

import java.util.List;

public class UpdateAccessChannelByLeaveRequest extends AbstractIccRequest<UpdateAccessChannelByLeaveResponse> {

    /** 通道编号 */
    private List<String> channelCodes;
    /** 是否全选 */
    private Boolean checkedAll;

    public UpdateAccessChannelByLeaveRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_UPDATE_ACCESS_CHANNEL_BY_LEAVE_POST),Method.POST);
        this.channelCodes = builder.channelCodes;
        this.checkedAll = builder.checkedAll;
        putBodyParameter("channelCodes",channelCodes);
        putBodyParameter("checkedAll",checkedAll);
    }

    @Override
    public Class<UpdateAccessChannelByLeaveResponse> getResponseClass() {
        return UpdateAccessChannelByLeaveResponse.class;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getChannelCodes() {
        return channelCodes;
    }

    public void setChannelCodes(List<String> channelCodes) {
        putBodyParameter("channelCodes",channelCodes);
        this.channelCodes = channelCodes;
    }

    public Boolean getCheckedAll() {
        return checkedAll;
    }

    public void setCheckedAll(Boolean checkedAll) {
        putBodyParameter("checkedAll",checkedAll);
        this.checkedAll = checkedAll;
    }

    @Override
    public String toString() {
        return "UpdateAccessChannelByLeaveRequest{" +
                "channelCodes=" + channelCodes +
                ", checkedAll=" + checkedAll +
                '}';
    }

    public static class Builder {
        /** 通道编号 */
        private List<String> channelCodes;
        /** 是否全选 */
        private Boolean checkedAll;

        public Builder channelCodes(List<String> channelCodes) {
            this.channelCodes = channelCodes;
            return this;
        }

        public Builder checkedAll(Boolean checkedAll) {
            this.checkedAll = checkedAll;
            return this;
        }

        public UpdateAccessChannelByLeaveRequest build() throws ClientException {
            return new UpdateAccessChannelByLeaveRequest(this);
        }
    }

}
