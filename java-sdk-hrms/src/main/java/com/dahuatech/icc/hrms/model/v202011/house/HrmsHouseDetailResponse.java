package com.dahuatech.icc.hrms.model.v202011.house;

import com.dahuatech.icc.oauth.http.IccResponse;

public class HrmsHouseDetailResponse extends IccResponse {

    private HrmsHouseDetail data;

    public HrmsHouseDetail getData() {
        return data;
    }

    public void setData(HrmsHouseDetail data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HrmsHouseDetailResponse{" +
                "data='" + data + '\'' +
                '}';
    }
}