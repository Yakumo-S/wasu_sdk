package com.dahuatech.icc.hrms.model.v202011.person;

import com.dahuatech.icc.oauth.http.IccResponse;

public class HrmsPersonDetailResponse extends IccResponse {

    private HrmsPersonDetail data;

    public HrmsPersonDetail getData() {
        return data;
    }

    public void setData(HrmsPersonDetail data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HrmsHouseUpdateResponse{" +
                "data='" + data + '\'' +
                '}';
    }
}
