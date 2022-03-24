package com.dahuatech.icc.visitors.model.v202104.record;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

public class RecordPageRequest extends AbstractIccRequest<RecordPageResponse> {

    /** 页面 */
    private Integer pageNum;
    /** 每页数量 */
    private Integer pageSize;
    /** 刷卡开始时间 yyyy-MM-dd HH:mm:ss */
    private String startSwingTime;
    /** 刷卡结束时间 yyyy-MM-dd HH:mm:ss */
    private String endSwingTime;
    /** 卡号 */
    private String cardNumber;
    /** 姓名 */
    private String personName;
    /** 通道号 */
    private String channelCode;

    public RecordPageRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_GET_VISITOR_TIMEOUT_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        this.startSwingTime = builder.startSwingTime;
        this.endSwingTime = builder.endSwingTime;
        this.cardNumber = builder.cardNumber;
        this.personName = builder.personName;
        this.channelCode = builder.channelCode;
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
        putBodyParameter("startSwingTime",startSwingTime);
        putBodyParameter("endSwingTime",endSwingTime);
        putBodyParameter("cardNumber",cardNumber);
        putBodyParameter("personName",personName);
        putBodyParameter("channelCode",channelCode);
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        putBodyParameter("pageNum",pageNum);
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        putBodyParameter("pageSize",pageSize);
        this.pageSize = pageSize;
    }

    public String getStartSwingTime() {
        return startSwingTime;
    }

    public void setStartSwingTime(String startSwingTime) {
        putBodyParameter("startSwingTime",startSwingTime);
        this.startSwingTime = startSwingTime;
    }

    public String getEndSwingTime() {
        return endSwingTime;
    }

    public void setEndSwingTime(String endSwingTime) {
        putBodyParameter("endSwingTime",endSwingTime);
        this.endSwingTime = endSwingTime;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        putBodyParameter("cardNumber",cardNumber);
        this.cardNumber = cardNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        putBodyParameter("personName",personName);
        this.personName = personName;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        putBodyParameter("channelCode",channelCode);
        this.channelCode = channelCode;
    }

    @Override
    public String toString() {
        return "RecordPageRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startSwingTime='" + startSwingTime + '\'' +
                ", endSwingTime='" + endSwingTime + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", personName='" + personName + '\'' +
                ", channelCode='" + channelCode + '\'' +
                '}';
    }

    @Override
    public Class<RecordPageResponse> getResponseClass() {
        return RecordPageResponse.class;
    }

    public static Builder builder() {
        return  new Builder();
    }

    private static class Builder {

        /** 页面 */
        private Integer pageNum;
        /** 每页数量 */
        private Integer pageSize;
        /** 刷卡开始时间 yyyy-MM-dd HH:mm:ss */
        private String startSwingTime;
        /** 刷卡结束时间 yyyy-MM-dd HH:mm:ss */
        private String endSwingTime;
        /** 卡号 */
        private String cardNumber;
        /** 姓名 */
        private String personName;
        /** 通道号 */
        private String channelCode;

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder startSwingTime(String startSwingTime) {
            this.startSwingTime = startSwingTime;
            return this;
        }

        public Builder endSwingTime(String endSwingTime) {
            this.endSwingTime = endSwingTime;
            return this;
        }

        public Builder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public Builder channelCode(String channelCode) {
            this.channelCode = channelCode;
            return this;
        }

        public RecordPageRequest build() throws ClientException {
            return new RecordPageRequest(this);
        }
    }
}