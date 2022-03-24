package com.dahuatech.icc.assesscontrol.model.v202103.doorPlan;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 添加开门计划
 *
 * @author 237417
 */
public class TimeQuantumAddRequest extends AbstractIccRequest<TimeQuantumAddResponse> {

    /** 开门计划细节(monday-sunday代表周一到周日,每天可以配置四个时间段,前后时间段不能重叠) */
    private String detail;
    /** 描述 */
    private String memo;
    /** 开门计划 */
    private String name;
    /** 计划类型：1-普通时段。目前只支持普通时段 */
    private Integer type;
    /*--------以上必填-----*/

    public TimeQuantumAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_TIME_QUANTUM_ADD_POST), Method.POST);
        this.detail = builder.detail;
        this.memo = builder.memo;
        this.name = builder.name;
        this.type = builder.type;
        putBodyParameter("detail",detail);
        putBodyParameter("memo",memo);
        putBodyParameter("name",name);
        putBodyParameter("type",type);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<TimeQuantumAddResponse> getResponseClass() {
        return TimeQuantumAddResponse.class;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
        putBodyParameter("detail",detail);
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
        putBodyParameter("memo",memo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        putBodyParameter("name",name);
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
        putBodyParameter("type",type);
    }

    public static class Builder {
        /** 开门计划细节(monday-sunday代表周一到周日,每天可以配置四个时间段,前后时间段不能重叠) */
        private String detail;
        /** 描述 */
        private String memo;
        /** 开门计划 */
        private String name;
        /** 计划类型：1-普通时段。目前只支持普通时段 */
        private Integer type;

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public TimeQuantumAddRequest build() throws ClientException {
            return new TimeQuantumAddRequest(this);
        }
    }
}
