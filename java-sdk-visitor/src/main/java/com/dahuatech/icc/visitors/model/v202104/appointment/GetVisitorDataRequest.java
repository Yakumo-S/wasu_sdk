package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

/***
 * 访客信息分页查询接口
 * @author 237417
 * @since 20210421
 */
public class GetVisitorDataRequest extends AbstractIccRequest<GetVisitorDataResponse> {

    /** 用户名 */
    private Integer pageNum;
    /** 密码 */
    private Integer pageSize;
    /** 昵称 */
    private String v_name;
    /** 爱好 */
    private String v_cardNumber;
    /** 爱好名称 */
    private String v_dw;
    /** 被访人部门 */
    private String isv_deptName;
    /** 访客电话 */
    private String v_phone;
    /** 开始来访时间 yyyy-MM-dd HH:mm:ss */
    private String comeVisit_startTime;
    /** 结束来访时间 yyyy-MM-dd HH:mm:ss */
    private String comeVisit_endTime;
    /** 开始实际来访时间 yyyy-MM-dd HH:mm:ss */
    private String rcomeVisitstartTime;
    /** 结束实际来访时间 yyyy-MM-dd HH:mm:ss */
    private String rcomeVisitendTime;
    /** 签入岗亭 */
    private String v_inbox;
    /** 签出岗亭 */
    private String v_outbox;
    /** 部门 */
    private String deptIds;

    public GetVisitorDataRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_VISITOR_GET_REVIEW_LIST_POST), Method.POST);
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
        putBodyParameter("v_name",v_name);
        putBodyParameter("v_cardNumber",v_cardNumber);
        putBodyParameter("v_dw",v_dw);
        putBodyParameter("isv_deptName",isv_deptName);
        putBodyParameter("v_phone",v_phone);
        putBodyParameter("comeVisit_startTime",comeVisit_startTime);
        putBodyParameter("comeVisit_endTime",comeVisit_endTime);
        putBodyParameter("rcomeVisitstartTime",rcomeVisitstartTime);
        putBodyParameter("rcomeVisitendTime",rcomeVisitendTime);
        putBodyParameter("v_inbox",v_inbox);
        putBodyParameter("v_outbox",v_outbox);
        putBodyParameter("deptIds",deptIds);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        this.v_name = builder.v_name;
        this.v_cardNumber = builder.v_cardNumber;
        this.v_dw = builder.v_dw;
        this.isv_deptName = builder.isv_deptName;
        this.v_phone = builder.v_phone;
        this.comeVisit_startTime = builder.comeVisit_startTime;
        this.comeVisit_endTime = builder.comeVisit_endTime;
        this.rcomeVisitstartTime = builder.rcomeVisitstartTime;
        this.rcomeVisitendTime = builder.rcomeVisitendTime;
        this.v_inbox = builder.v_inbox;
        this.v_outbox = builder.v_outbox;
        this.deptIds = builder.deptIds;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<GetVisitorDataResponse> getResponseClass() {
        return GetVisitorDataResponse.class;
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

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        putBodyParameter("v_name",v_name);
        this.v_name = v_name;
    }

    public String getV_cardNumber() {
        return v_cardNumber;
    }

    public void setV_cardNumber(String v_cardNumber) {
        putBodyParameter("v_cardNumber",v_cardNumber);
        this.v_cardNumber = v_cardNumber;
    }

    public String getV_dw() {
        return v_dw;
    }

    public void setV_dw(String v_dw) {
        putBodyParameter("v_dw",v_dw);
        this.v_dw = v_dw;
    }

    public String getIsv_deptName() {
        return isv_deptName;
    }

    public void setIsv_deptName(String isv_deptName) {
        putBodyParameter("isv_deptName",isv_deptName);
        this.isv_deptName = isv_deptName;
    }

    public String getV_phone() {
        return v_phone;
    }

    public void setV_phone(String v_phone) {
        putBodyParameter("v_phone",v_phone);
        this.v_phone = v_phone;
    }

    public String getComeVisit_startTime() {
        return comeVisit_startTime;
    }

    public void setComeVisit_startTime(String comeVisit_startTime) {
        putBodyParameter("comeVisit_startTime",comeVisit_startTime);
        this.comeVisit_startTime = comeVisit_startTime;
    }

    public String getComeVisit_endTime() {
        return comeVisit_endTime;
    }

    public void setComeVisit_endTime(String comeVisit_endTime) {
        putBodyParameter("comeVisit_endTime",comeVisit_endTime);
        this.comeVisit_endTime = comeVisit_endTime;
    }

    public String getRcomeVisitstartTime() {
        return rcomeVisitstartTime;
    }

    public void setRcomeVisitstartTime(String rcomeVisitstartTime) {
        putBodyParameter("rcomeVisitstartTime",rcomeVisitstartTime);
        this.rcomeVisitstartTime = rcomeVisitstartTime;
    }

    public String getRcomeVisitendTime() {
        return rcomeVisitendTime;
    }

    public void setRcomeVisitendTime(String rcomeVisitendTime) {
        putBodyParameter("rcomeVisitendTime",rcomeVisitendTime);
        this.rcomeVisitendTime = rcomeVisitendTime;
    }

    public String getV_inbox() {
        return v_inbox;
    }

    public void setV_inbox(String v_inbox) {
        putBodyParameter("v_inbox",v_inbox);
        this.v_inbox = v_inbox;
    }

    public String getV_outbox() {
        return v_outbox;
    }

    public void setV_outbox(String v_outbox) {
        putBodyParameter("v_outbox",v_outbox);
        this.v_outbox = v_outbox;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        putBodyParameter("deptIds",deptIds);
        this.deptIds = deptIds;
    }

    public static class Builder {

        /** 用户名 */
        private Integer pageNum;
        /** 密码 */
        private Integer pageSize;
        /** 昵称 */
        private String v_name;
        /** 爱好 */
        private String v_cardNumber;
        /** 爱好名称 */
        private String v_dw;
        /** 被访人部门 */
        private String isv_deptName;
        /** 访客电话 */
        private String v_phone;
        /** 开始来访时间 yyyy-MM-dd HH:mm:ss */
        private String comeVisit_startTime;
        /** 结束来访时间 yyyy-MM-dd HH:mm:ss */
        private String comeVisit_endTime;
        /** 开始实际来访时间 yyyy-MM-dd HH:mm:ss */
        private String rcomeVisitstartTime;
        /** 结束实际来访时间 yyyy-MM-dd HH:mm:ss */
        private String rcomeVisitendTime;
        /** 签入岗亭 */
        private String v_inbox;
        /** 签出岗亭 */
        private String v_outbox;
        /** 部门 */
        private String deptIds;

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder v_name(String v_name) {
            this.v_name = v_name;
            return this;
        }

        public Builder v_cardNumber(String v_cardNumber) {
            this.v_cardNumber = v_cardNumber;
            return this;
        }

        public Builder v_dw(String v_dw) {
            this.v_dw = v_dw;
            return this;
        }

        public Builder isv_deptName(String isv_deptName) {
            this.isv_deptName = isv_deptName;
            return this;
        }

        public Builder v_phone(String v_phone) {
            this.v_phone = v_phone;
            return this;
        }

        public Builder comeVisit_startTime(String comeVisit_startTime) {
            this.comeVisit_startTime = comeVisit_startTime;
            return this;
        }

        public Builder comeVisit_endTime(String comeVisit_endTime) {
            this.comeVisit_endTime = comeVisit_endTime;
            return this;
        }

        public Builder rcomeVisitstartTime(String rcomeVisitstartTime) {
            this.rcomeVisitstartTime = rcomeVisitstartTime;
            return this;
        }

        public Builder rcomeVisitendTime(String rcomeVisitendTime) {
            this.rcomeVisitendTime = rcomeVisitendTime;
            return this;
        }

        public Builder v_inbox(String v_inbox) {
            this.v_inbox = v_inbox;
            return this;
        }

        public Builder v_outbox(String v_outbox) {
            this.v_outbox = v_outbox;
            return this;
        }

        public Builder deptIds(String deptIds) {
            this.deptIds = deptIds;
            return this;
        }

        public GetVisitorDataRequest build() throws ClientException {
            return new GetVisitorDataRequest(this);
        }
    }
}
