package com.dahuatech.icc.hrms.model.v202011.person;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

public class HrmsPersonBatchDelRequest extends AbstractIccRequest<HrmsPersonBatchDelResponse> {

    /** 人员ID */
    private List<String> ids;

    public HrmsPersonBatchDelRequest(Builder builder) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_PERSON_BATCH_DELETE_POST), Method.POST);
        this.ids = builder.ids;
        putBodyParameter("ids",ids);

    }

    @Override
    public Class<HrmsPersonBatchDelResponse> getResponseClass() {
        return HrmsPersonBatchDelResponse.class;
    }


    public static Builder builder() {
        return new Builder();
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        putBodyParameter("ids",ids);
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "HrmsPersonBatchDelRequest{" +
                "ids=" + ids +
                '}';
    }

    public static class Builder {

        /** 人员ID */
        private List<String> ids;

        public Builder ids(List<String> ids) {
            this.ids = ids;
            return this;
        }

        public HrmsPersonBatchDelRequest build() throws ClientException {
            return new HrmsPersonBatchDelRequest(this);
        }

    }
}
