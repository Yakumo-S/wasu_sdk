package com.dahuatech.icc.hrms.model.v202011.building;

import com.dahuatech.icc.oauth.http.IccResponse;

/**
 * 楼栋查看
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class HrmsBuildingDetailResponse extends IccResponse {
    /** 楼栋ID */
    private HrmsBuildingDetail data;

    public HrmsBuildingDetail getData() {
        return data;
    }

    public void setData(HrmsBuildingDetail data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HrmsBuildingDetailResponse{" +
                "data='" + data + '\'' +
                '}';
    }
}
