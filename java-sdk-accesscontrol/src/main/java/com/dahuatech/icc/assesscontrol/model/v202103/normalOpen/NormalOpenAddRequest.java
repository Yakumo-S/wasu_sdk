package com.dahuatech.icc.assesscontrol.model.v202103.normalOpen;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 添加常开常闭计划
 *
 * @author 237417
 */
public class NormalOpenAddRequest extends AbstractIccRequest<NormalOpenAddResponse> {

    /** 通道编码 */
    private String channelCode;
    /** 通道在离线状态。ON 状态下才允许添加 */
    private String onlineStatus;
    /*--------以上必填-----*/
    /** 常开计划，开门计划id */
    private Integer openDoorsPlanId;
    /** 常闭计划，开门计划id。常开计划和常闭计划，不能同时为空，时间段不能重复 */
    private Integer closeDoorPlanId;

    public NormalOpenAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_OPEN_NORMALLY_SETTING_ADD_POST),Method.POST);
        this.channelCode = builder.channelCode;
        this.onlineStatus = builder.onlineStatus;
        putBodyParameter("channelCode",channelCode);
        putBodyParameter("onlineStatus",onlineStatus);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<NormalOpenAddResponse> getResponseClass() {
        return NormalOpenAddResponse.class;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        putBodyParameter("channelCode",channelCode);
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
        putBodyParameter("onlineStatus",onlineStatus);
    }

    public Integer getOpenDoorsPlanId() {
        return openDoorsPlanId;
    }

    public void setOpenDoorsPlanId(Integer openDoorsPlanId) {
        this.openDoorsPlanId = openDoorsPlanId;
        putBodyParameter("openDoorsPlanId",openDoorsPlanId);
    }

    public Integer getCloseDoorPlanId() {
        return closeDoorPlanId;
    }

    public void setCloseDoorPlanId(Integer closeDoorPlanId) {
        this.closeDoorPlanId = closeDoorPlanId;
        putBodyParameter("closeDoorPlanId",closeDoorPlanId);
    }

    public static class Builder {
        /** 通道编码 */
        private String channelCode;
        /** 通道在离线状态。ON 状态下才允许添加 */
        private String onlineStatus;

        public Builder channelCode(String channelCode) {
            this.channelCode = channelCode;
            return this;
        }

        public Builder onlineStatus(String onlineStatus) {
            this.onlineStatus = onlineStatus;
            return this;
        }

        public NormalOpenAddRequest build() throws ClientException {
            return new NormalOpenAddRequest(this);
        }
    }
}
