package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

public class VisitorReviewRequest extends AbstractIccRequest<VisitorReviewResponse> {

    /** 访客ID */
    private Integer id;
    /** 访客类型 */
    private Integer visitorType;
    /** 是否跳过 */
    private Boolean result;

    public VisitorReviewRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_VISITOR_GET_REVIEW_LIST_POST), Method.POST);
        this.id = builder.id;
        this.visitorType = builder.visitorType;
        this.result = builder.result;
        putBodyParameter("id",id);
        putBodyParameter("visitorType",visitorType);
        putBodyParameter("result",result);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<VisitorReviewResponse> getResponseClass() {
        return VisitorReviewResponse.class;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        putBodyParameter("id",id);
        this.id = id;
    }

    public Integer getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(Integer visitorType) {
        putBodyParameter("visitorType",visitorType);
        this.visitorType = visitorType;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        putBodyParameter("result",result);
        this.result = result;
    }

    @Override
    public String toString() {
        return "VisitorReviewRequest{" +
                "id=" + id +
                ", visitorType=" + visitorType +
                ", result=" + result +
                '}';
    }

    public static class Builder {

        /** 访客ID */
        private Integer id;
        /** 访客类型 */
        private Integer visitorType;
        /** 是否跳过 */
        private Boolean result;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder visitorType(Integer visitorType) {
            this.visitorType = visitorType;
            return this;
        }

        public Builder result(Boolean result) {
            this.result = result;
            return this;
        }

        public VisitorReviewRequest build() throws ClientException {
            return new VisitorReviewRequest(this);
        }
    }
}