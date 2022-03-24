package com.dahuatech.icc.hrms.model.v202011.house;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

public class HrmsHousePageRequest extends AbstractIccRequest<HrmsHousePageResponse> {

    public HrmsHousePageRequest(String searchType,String searchKey,String houseOwner,String houseCode,String houseUseFor, String pageNum,String pageSize) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_HOUSE_PAGE_GET), Method.GET);
        form("searchType",searchType);
        form("searchKey",searchKey);
        form("houseOwner",houseOwner);
        form("houseCode",houseCode);
        form("houseUseFor",houseUseFor);
        form("pageNum",pageNum);
        form("pageSize",pageSize);
    }

    @Override
    public Class<HrmsHousePageResponse> getResponseClass() {
        return HrmsHousePageResponse.class;
    }
}