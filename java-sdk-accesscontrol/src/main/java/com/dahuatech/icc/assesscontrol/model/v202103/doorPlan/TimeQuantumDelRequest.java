package com.dahuatech.icc.assesscontrol.model.v202103.doorPlan;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 删除开门计划
 *
 * @author 237417
 */
public class TimeQuantumDelRequest extends AbstractIccRequest<TimeQuantumDelResponse> {
    /** 开门计划ID */
    private Long id;
    /*--------以上必填-----*/

    public TimeQuantumDelRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_TIME_QUANTUM_DEL_POST), Method.POST);
        this.id = builder.id;
        putBodyParameter("id",id);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<TimeQuantumDelResponse> getResponseClass() {
        return TimeQuantumDelResponse.class;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        putBodyParameter("id",id);
    }

    public static class Builder {
        /** 开门计划ID */
        private Long id;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public TimeQuantumDelRequest build() throws ClientException {
            return new TimeQuantumDelRequest(this);
        }
    }
}
