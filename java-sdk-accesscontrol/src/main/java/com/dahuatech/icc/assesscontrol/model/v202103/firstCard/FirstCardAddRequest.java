package com.dahuatech.icc.assesscontrol.model.v202103.firstCard;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 添加首卡
 *
 * @author 237417
 */
public class FirstCardAddRequest extends AbstractIccRequest<FirstCardAddResponse> {
    /** 人员编码 */
    private String personCode;
    /** 通道编码 */
    private String channelCode;
    /** 开门计划 */
    private String firstCardOpenTime;
    /** 开门计划ID */
    private List<Long> firstCardOpenTimeId;
    /** 首卡状态 */
    private String firstCardStatus;
    /*--------以上必填-----*/
    /** ID */
    private String id;

    public FirstCardAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_FIRST_CARD_ADD_POST), Method.POST);
        this.personCode = builder.personCode;
        this.channelCode = builder.channelCode;
        this.firstCardOpenTime = builder.firstCardOpenTime;
        this.firstCardOpenTimeId = builder.firstCardOpenTimeId;
        this.firstCardStatus = builder.firstCardStatus;
        putBodyParameter("personCode",personCode);
        putBodyParameter("channelCode",channelCode);
        putBodyParameter("firstCardOpenTime",firstCardOpenTime);
        putBodyParameter("firstCardOpenTimeId",firstCardOpenTimeId);
        putBodyParameter("firstCardStatus",firstCardStatus);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<FirstCardAddResponse> getResponseClass() {
        return FirstCardAddResponse.class;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
        putBodyParameter("personCode",personCode);
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        putBodyParameter("channelCode",channelCode);
    }

    public String getFirstCardOpenTime() {
        return firstCardOpenTime;
    }

    public void setFirstCardOpenTime(String firstCardOpenTime) {
        this.firstCardOpenTime = firstCardOpenTime;
        putBodyParameter("firstCardOpenTime",firstCardOpenTime);
    }

    public List<Long> getFirstCardOpenTimeId() {
        return firstCardOpenTimeId;
    }

    public void setFirstCardOpenTimeId(List<Long> firstCardOpenTimeId) {
        this.firstCardOpenTimeId = firstCardOpenTimeId;
        putBodyParameter("firstCardOpenTimeId",firstCardOpenTimeId);
    }

    public String getFirstCardStatus() {
        return firstCardStatus;
    }

    public void setFirstCardStatus(String firstCardStatus) {
        this.firstCardStatus = firstCardStatus;
        putBodyParameter("firstCardStatus",firstCardStatus);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        putBodyParameter("id",id);
    }

    public static class Builder {
        /** 人员编码 */
        private String personCode;
        /** 通道编码 */
        private String channelCode;
        /** 开门计划 */
        private String firstCardOpenTime;
        /** 开门计划ID */
        private List<Long> firstCardOpenTimeId;
        /** 首卡状态 */
        private String firstCardStatus;

        public Builder personCode(String personCode) {
            this.personCode = personCode;
            return this;
        }

        public Builder channelCode(String channelCode) {
            this.channelCode = channelCode;
            return this;
        }

        public Builder firstCardOpenTime(String firstCardOpenTime) {
            this.firstCardOpenTime = firstCardOpenTime;
            return this;
        }

        public Builder firstCardOpenTimeId(List<Long> firstCardOpenTimeId) {
            this.firstCardOpenTimeId = firstCardOpenTimeId;
            return this;
        }

        public Builder firstCardStatus(String firstCardStatus) {
            this.firstCardStatus = firstCardStatus;
            return this;
        }

        public FirstCardAddRequest build() throws ClientException {
            return new FirstCardAddRequest(this);
        }
    }
}
