package com.dahuatech.icc.assesscontrol.model.v202103.doorGroup;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 门组详情
 *
 * @author 237417
 */
public class DoorGroupDetailRequest extends AbstractIccRequest<DoorGroupDetailResponse> {

    public DoorGroupDetailRequest(Integer id) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_DOOR_GROUP_DETAIL_GET,id), Method.GET);
    }

    @Override
    public Class<DoorGroupDetailResponse> getResponseClass() {
        return DoorGroupDetailResponse.class;
    }
}
