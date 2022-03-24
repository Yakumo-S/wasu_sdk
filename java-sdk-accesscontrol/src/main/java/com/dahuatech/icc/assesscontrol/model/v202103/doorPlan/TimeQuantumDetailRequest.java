package com.dahuatech.icc.assesscontrol.model.v202103.doorPlan;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 开门计划详情
 *
 * @author 237417
 */
public class TimeQuantumDetailRequest extends AbstractIccRequest<TimeQuantumDetailResponse> {
    public TimeQuantumDetailRequest(Integer index) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_TIME_QUANTUM_DETAIL_GET,index), Method.GET);
    }

    @Override
    public Class<TimeQuantumDetailResponse> getResponseClass() {
        return TimeQuantumDetailResponse.class;
    }

}
