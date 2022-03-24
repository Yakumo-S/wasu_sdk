package com.dahuatech.icc.visitors.model.v202104.record;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

public class GetVisitorTimeoutRequest extends AbstractIccRequest<GetVisitorTimeoutResponse> {

    /** 查询日期 yyyy-MM-dd */
    private String comeVisit_startTime;

    public GetVisitorTimeoutRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_GET_VISITOR_TIMEOUT_POST), Method.POST);
        this.comeVisit_startTime = builder.comeVisit_startTime;
        putBodyParameter("comeVisit_start",comeVisit_startTime);
    }

    public String getComeVisit_startTime() {
        return comeVisit_startTime;
    }

    public void setComeVisit_startTime(String comeVisit_startTime) {
        putBodyParameter("comeVisit_start",comeVisit_startTime);
        this.comeVisit_startTime = comeVisit_startTime;
    }

    @Override
    public String toString() {
        return "GetVisitorTimeoutRequest{" +
                "comeVisit_startTime='" + comeVisit_startTime + '\'' +
                '}';
    }

    @Override
    public Class<GetVisitorTimeoutResponse> getResponseClass() {
        return GetVisitorTimeoutResponse.class;
    }

    public static Builder builder() {
        return  new Builder();
    }

    private static class Builder {
        /** 查询日期 yyyy-MM-dd */
        private String comeVisit_startTime;

        public Builder comeVisit_startTime(String comeVisit_startTime) {
            this.comeVisit_startTime = comeVisit_startTime;
            return this;
        }

        public GetVisitorTimeoutRequest build() throws ClientException {
            return new GetVisitorTimeoutRequest(this);
        }
    }
}
