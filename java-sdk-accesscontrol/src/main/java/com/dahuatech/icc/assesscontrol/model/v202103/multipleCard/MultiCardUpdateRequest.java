package com.dahuatech.icc.assesscontrol.model.v202103.multipleCard;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 修改多卡开门
 *
 * @author 237417
 */
public class MultiCardUpdateRequest extends AbstractIccRequest<MultiCardUpdateResponse> {

    /** 多卡开门ID */
    private Long id;
    /*--------以上必填-----*/

    /** 多卡开门使能："0" - 关闭，"1" - 开启 */
    private String multiCardEnable;
    /** 通道编码 */
    private String channelCode;
    /** 通道名称 */
    private String channelName;
    /** 设备名称 */
    private String deviceName;
    /** 人员组 */
    private String personGroupInformation;

    public MultiCardUpdateRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_PERSON_GROUP_ADD_POST), Method.POST);
        this.id = builder.id;
        putBodyParameter("id",id);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<MultiCardUpdateResponse> getResponseClass() {
        return MultiCardUpdateResponse.class;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        putBodyParameter("id",id);
    }

    public String getMultiCardEnable() {
        return multiCardEnable;
    }

    public void setMultiCardEnable(String multiCardEnable) {
        this.multiCardEnable = multiCardEnable;
        putBodyParameter("multiCardEnable",multiCardEnable);
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        putBodyParameter("channelCOde",channelCode);
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
        putBodyParameter("channelName",channelName);
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        putBodyParameter("deviceName",deviceName);
    }

    public String getPersonGroupInformation() {
        return personGroupInformation;
    }

    public void setPersonGroupInformation(String personGroupInformation) {
        this.personGroupInformation = personGroupInformation;
        putBodyParameter("personGroupInformation",personGroupInformation);
    }

    public static class Builder {
        /** 多卡开门ID */
        private Long id;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public MultiCardUpdateRequest build() throws ClientException {
            return new MultiCardUpdateRequest(this);
        }
    }
}
