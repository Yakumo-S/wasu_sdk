package com.dahuatech.icc.assesscontrol.model.v202103.doorPlan;

import com.dahuatech.icc.oauth.http.IccResponse;

/**
 * 开门计划详情
 *
 * @author 237417
 */
public class TimeQuantumDetailResponse extends IccResponse {
    /** 数据对象 */
    private TimeQuantum data;

    public TimeQuantum getData() {
        return data;
    }

    public void setData(TimeQuantum data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TimeQuantumPageResponse{" +
                "data=" + data +
                '}';
    }
}
