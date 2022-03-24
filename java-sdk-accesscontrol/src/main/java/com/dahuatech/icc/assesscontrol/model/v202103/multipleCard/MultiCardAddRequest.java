package com.dahuatech.icc.assesscontrol.model.v202103.multipleCard;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 添加多卡开门
 *
 * @author 237417
 */
public class MultiCardAddRequest extends AbstractIccRequest<MultiCardAddResponse> {
    /** 多卡使能："0" - 关闭，"1" - 开启 */
    private Integer multiCardEnable;
    /** 通道编码 */
    private String channelCode;
    /** 通道名称 */
    private String channelName;
    /** 设备名称 */
    private String deviceName;
    /** 人员组 */
    private PersonGroupInfo personGroupInformation;

    public MultiCardAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_PERSON_GROUP_ADD_POST), Method.POST);
        this.multiCardEnable = builder.multiCardEnable;
        this.channelCode = builder.channelCode;
        this.channelName = builder.channelName;
        this.deviceName = builder.deviceName;
        this.personGroupInformation = builder.personGroupInformation;
        putBodyParameter("multiCardEnable",multiCardEnable);
        putBodyParameter("channelCode",channelCode);
        putBodyParameter("channelName",channelName);
        putBodyParameter("deviceName",deviceName);
        putBodyParameter("personGroupInformation",personGroupInformation);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getMultiCardEnable() {
        return multiCardEnable;
    }

    public void setMultiCardEnable(Integer multiCardEnable) {
        this.multiCardEnable = multiCardEnable;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public PersonGroupInfo getPersonGroupInformation() {
        return personGroupInformation;
    }

    public void setPersonGroupInformation(PersonGroupInfo personGroupInformation) {
        this.personGroupInformation = personGroupInformation;
    }

    @Override
    public Class<MultiCardAddResponse> getResponseClass() {
        return MultiCardAddResponse.class;
    }

    public static class Builder {
        /** 多卡使能："0" - 关闭，"1" - 开启 */
        private Integer multiCardEnable;
        /** 通道编码 */
        private String channelCode;
        /** 通道名称 */
        private String channelName;
        /** 设备名称 */
        private String deviceName;
        /** 人员组 */
        private PersonGroupInfo personGroupInformation;

        public Builder multiCardEnable(Integer multiCardEnable) {
            this.multiCardEnable = multiCardEnable;
            return this;
        }

        public Builder channelCode(String channelCode) {
            this.channelCode = channelCode;
            return this;
        }

        public Builder channelName(String channelName) {
            this.channelName = channelName;
            return this;
        }

        public Builder deviceName(String deviceName) {
            this.deviceName = deviceName;
            return this;
        }

        public Builder personGroupInformation(PersonGroupInfo personGroupInformation) {
            this.personGroupInformation = personGroupInformation;
            return this;
        }

        public MultiCardAddRequest build() throws ClientException {
            return new MultiCardAddRequest(this);
        }
    }

    public static class PersonGroupInfo {
        /** 人员组信息 */
        private Long id;
        /** 人员组姓名 */
        private String personGroupName;
        /** 人员数量 */
        private String personNum;
        /** 使能人员数量 */
        private String enablePersonNum;
        /** 开门方式："刷卡"，"指纹"，"密码" */
        private String openType;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPersonGroupName() {
            return personGroupName;
        }

        public void setPersonGroupName(String personGroupName) {
            this.personGroupName = personGroupName;
        }

        public String getPersonNum() {
            return personNum;
        }

        public void setPersonNum(String personNum) {
            this.personNum = personNum;
        }

        public String getEnablePersonNum() {
            return enablePersonNum;
        }

        public void setEnablePersonNum(String enablePersonNum) {
            this.enablePersonNum = enablePersonNum;
        }

        public String getOpenType() {
            return openType;
        }

        public void setOpenType(String openType) {
            this.openType = openType;
        }
    }
}
