package com.dahuatech.icc.hrms.model.v202011.person;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

public class HrmsPersonDelRequest extends AbstractIccRequest<HrmsPersonDelResponse> {

    public HrmsPersonDelRequest(String id) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_PERSON_DELETE_GET,id), Method.GET);
    }

    @Override
    public Class<HrmsPersonDelResponse> getResponseClass() {
        return HrmsPersonDelResponse.class;
    }

}
