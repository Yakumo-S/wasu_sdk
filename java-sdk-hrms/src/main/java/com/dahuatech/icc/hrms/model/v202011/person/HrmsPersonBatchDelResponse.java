package com.dahuatech.icc.hrms.model.v202011.person;

import com.dahuatech.icc.oauth.http.IccResponse;

public class HrmsPersonBatchDelResponse extends IccResponse {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HrmsHouseUpdateResponse{" +
                "data='" + data + '\'' +
                '}';
    }
}