package com.dahuatech.icc.hrms.model.v202011.building;

import com.dahuatech.icc.oauth.http.IccResponse;

/**
 * 楼栋修改
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class HrmsBuildingUpdateResponse extends IccResponse {
    /** 楼栋ID */
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HrmsBuildingUpdateResponse{" +
                "data='" + data + '\'' +
                '}';
    }
}
