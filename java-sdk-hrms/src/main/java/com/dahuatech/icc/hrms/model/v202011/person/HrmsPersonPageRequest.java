package com.dahuatech.icc.hrms.model.v202011.person;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

public class HrmsPersonPageRequest extends AbstractIccRequest<HrmsPersonPageResponse> {

    public HrmsPersonPageRequest(String classification) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_PERSON_PAGE_GET,classification), Method.GET);
    }

    @Override
    public Class<HrmsPersonPageResponse> getResponseClass() {
        return HrmsPersonPageResponse.class;
    }

}
