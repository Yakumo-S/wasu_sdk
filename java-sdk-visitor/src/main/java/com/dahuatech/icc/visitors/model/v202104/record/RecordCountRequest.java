package com.dahuatech.icc.visitors.model.v202104.record;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

import java.util.List;

public class RecordCountRequest extends AbstractIccRequest<RecordCountResponse> {

    /** 起始时间 yyyy-MM-dd HH:mm：ss*/
    private String startSwingTime;
    /** 结束时间 yyyy-MM-dd HH：mm：ss */
    private String endSwingTime;
    /** 通道编码 */
    private List<String> channelCodes;

    public RecordCountRequest(RecordCountRequest.Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_GET_VISITOR_TIMEOUT_POST), Method.POST);
        this.startSwingTime = builder.startSwingTime;
        this.endSwingTime = builder.endSwingTime;
        this.channelCodes = builder.channelCodes;
        putBodyParameter("startSwingTime",startSwingTime);
        putBodyParameter("endSwingTime",endSwingTime);
        putBodyParameter("channelCodes",channelCodes);
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

    public List<String> getChannelCodes() {
        return channelCodes;
    }

    public void setChannelCodes(List<String> channelCodes) {
        putBodyParameter("channelCodes",channelCodes);
        this.channelCodes = channelCodes;
    }

    @Override
    public String toString() {
        return "RecordCountRequest{" +
                "startSwingTime='" + startSwingTime + '\'' +
                ", endSwingTime='" + endSwingTime + '\'' +
                ", channelCodes=" + channelCodes +
                '}';
    }

    @Override
    public Class<RecordCountResponse> getResponseClass() {
        return RecordCountResponse.class;
    }

    public static Builder builder() {
        return  new Builder();
    }

    private static class Builder {
        /** 起始时间 yyyy-MM-dd HH:mm：ss*/
        private String startSwingTime;
        /** 结束时间 yyyy-MM-dd HH：mm：ss */
        private String endSwingTime;
        /** 通道编码 */
        private List<String> channelCodes;

        public Builder startSwingTime(String startSwingTime) {
            this.startSwingTime = startSwingTime;
            return this;
        }

        public Builder endSwingTime(String endSwingTime) {
            this.endSwingTime = endSwingTime;
            return this;
        }

        public Builder channelCodes(List<String> channelCodes) {
            this.channelCodes = channelCodes;
            return this;
        }

        public RecordCountRequest build() throws ClientException {
            return new RecordCountRequest(this);
        }
    }
}
