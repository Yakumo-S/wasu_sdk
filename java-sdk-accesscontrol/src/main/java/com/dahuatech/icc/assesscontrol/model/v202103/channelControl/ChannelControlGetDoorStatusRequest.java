package com.dahuatech.icc.assesscontrol.model.v202103.channelControl;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 门通道控制获取门状态
 *
 * @author 237417
 */
public class ChannelControlGetDoorStatusRequest extends AbstractIccRequest<ChannelControlGetDoorStatusResponse> {
    
    /** 门通道编码 */
    private List<String> channelCodeList;

    public ChannelControlGetDoorStatusRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_STAY_OPEN_POST), Method.POST);
        this.channelCodeList = builder.channelCodeList;
        putBodyParameter("channelCodeList",channelCodeList);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<ChannelControlGetDoorStatusResponse> getResponseClass() {
        return ChannelControlGetDoorStatusResponse.class;
    }

    public List<String> getChannelCodeList() {
        return channelCodeList;
    }

    public void setChannelCodeList(List<String> channelCodeList) {
        this.channelCodeList = channelCodeList;
        putBodyParameter("channelCodeList",channelCodeList);
    }

    public static class Builder {
        /** 门通道编码 */
        private List<String> channelCodeList;

        public Builder channelCodeList(List<String> channelCodeList) {
            this.channelCodeList = channelCodeList;
            return this;
        }

        public ChannelControlGetDoorStatusRequest build() throws ClientException {
            return new ChannelControlGetDoorStatusRequest(this);
        }
    }
}