package com.dahuatech.icc.hrms.model.v202011.building;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 楼栋查看
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class HrmsBuildingDetailRequest extends AbstractIccRequest<HrmsBuildingDetailResponse> {
    public HrmsBuildingDetailRequest(String id) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_BUILDING_VIEW_REST_GET,id), Method.GET);
    }

    @Override
    public Class<HrmsBuildingDetailResponse> getResponseClass() {
        return HrmsBuildingDetailResponse.class;
    }
}
