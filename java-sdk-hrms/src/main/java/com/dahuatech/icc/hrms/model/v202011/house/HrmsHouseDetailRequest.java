package com.dahuatech.icc.hrms.model.v202011.house;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

public class HrmsHouseDetailRequest extends AbstractIccRequest<HrmsHouseDetailResponse> {

    public HrmsHouseDetailRequest(String id) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_HOUSE_EDIT_GET,id), Method.GET);
    }

    @Override
    public Class<HrmsHouseDetailResponse> getResponseClass() {
        return HrmsHouseDetailResponse.class;
    }
}
