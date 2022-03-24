package com.dahuatech.icc.visitors.model.v202104.record;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

public class VisitorCountRequest extends AbstractIccRequest<VisitorCountResponse> {

    /** 访问起始时间 ：非必填 yyyy-MM-dd HH:mm:ss*/
    private String comeVisit_startTime;
    /** 访问结束时间 ：非必填 yyyy-MM-dd HH:mm:ss*/
    private String comeVisit_endTime;
    /** 父部门ID：非必填 */
    private String deptIds;

    public VisitorCountRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_GET_VISITOR_TIMEOUT_POST), Method.POST);
        this.comeVisit_startTime = builder.comeVisit_startTime;
        this.comeVisit_endTime = builder.comeVisit_endTime;
        this.deptIds = builder.deptIds;
        putBodyParameter("comeVisit_start",comeVisit_startTime);
        putBodyParameter("comeVisit_end",comeVisit_endTime);
        putBodyParameter("deptIds",deptIds);
    }

    public String getComeVisit_startTime() {
        return comeVisit_startTime;
    }

    public void setComeVisit_startTime(String comeVisit_startTime) {
        putBodyParameter("comeVisit_start",comeVisit_startTime);
        this.comeVisit_startTime = comeVisit_startTime;
    }

    public String getComeVisit_endTime() {
        return comeVisit_endTime;
    }

    public void setComeVisit_endTime(String comeVisit_endTime) {
        putBodyParameter("comeVisit_end",comeVisit_endTime);
        this.comeVisit_endTime = comeVisit_endTime;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        putBodyParameter("deptIds",deptIds);
        this.deptIds = deptIds;
    }

    @Override
    public String toString() {
        return "VisitorCountRequest{" +
                "comeVisit_startTime='" + comeVisit_startTime + '\'' +
                ", comeVisit_endTime='" + comeVisit_endTime + '\'' +
                ", deptIds='" + deptIds + '\'' +
                '}';
    }

    @Override
    public Class<VisitorCountResponse> getResponseClass() {
        return VisitorCountResponse.class;
    }

    public static Builder builder() {
        return  new Builder();
    }

    private static class Builder {

        /** 访问起始时间 ：非必填 yyyy-MM-dd HH:mm:ss*/
        private String comeVisit_startTime;
        /** 访问结束时间 ：非必填 yyyy-MM-dd HH:mm:ss*/
        private String comeVisit_endTime;
        /** 父部门ID：非必填 */
        private String deptIds;

        public Builder comeVisit_startTime(String comeVisit_startTime) {
            this.comeVisit_startTime = comeVisit_startTime;
            return this;
        }

        public Builder comeVisit_endTime(String comeVisit_endTime) {
            this.comeVisit_endTime = comeVisit_endTime;
            return this;
        }

        public Builder deptIds(String deptIds) {
            this.deptIds = deptIds;
            return this;
        }

        public VisitorCountRequest build() throws ClientException {
            return new VisitorCountRequest(this);
        }
    }
}