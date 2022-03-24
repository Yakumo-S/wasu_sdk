package com.wasu.model.v202010.user;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

public class BrmUserPrivilegeMenusRequest extends AbstractIccRequest<BrmUserPrivilegeMenusResponse> {


    public BrmUserPrivilegeMenusRequest(String terminal,String systemCode) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_USER_PRIVILEGE_MENUS_GET), Method.GET);
        form("terminal",terminal);
        form("systemCode",systemCode);
    }

    @Override
    public Class<BrmUserPrivilegeMenusResponse> getResponseClass() {
        return BrmUserPrivilegeMenusResponse.class;
    }
}
