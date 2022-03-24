package com.dahuatech.icc.hrms.model.v202011.person;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

public class HrmsPersonDetailRequest extends AbstractIccRequest<HrmsPersonDetailResponse> {

    public HrmsPersonDetailRequest(String id) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_PERSON_VIEW_GET,id), Method.GET);
    }

    @Override
    public Class<HrmsPersonDetailResponse> getResponseClass() {
        return HrmsPersonDetailResponse.class;
    }
}
