package com.dahuatech.icc.assesscontrol.model.v202103.normalOpen;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 删除常开常闭计划
 *
 * @author 237417
 */
public class NormalOpenDeleteRequest extends AbstractIccRequest<NormalOpenDeleteResponse> {

    /** 通道编码，多个使用逗号分隔 */
    private String channelCode;
    /*--------以上必填-----*/

    public NormalOpenDeleteRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_OPEN_NORMALLY_SETTING_ADD_POST), Method.POST);
        this.channelCode = builder.channelCode;
        putBodyParameter("channelCode",channelCode);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<NormalOpenDeleteResponse> getResponseClass() {
        return NormalOpenDeleteResponse.class;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        putBodyParameter("channelCode",channelCode);
    }

    public static class Builder {

        /** 通道编码，多个使用逗号分隔 */
        private String channelCode;
        /*--------以上必填-----*/

        public Builder channelCode(String channelCode) {
            this.channelCode = channelCode;
            return this;
        }

        public NormalOpenDeleteRequest build() throws ClientException {
            return new NormalOpenDeleteRequest(this);
        }
    }
}
