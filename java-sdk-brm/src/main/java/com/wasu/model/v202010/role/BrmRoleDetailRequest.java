package com.wasu.model.v202010.role;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 角色信息
 *
 * @author 237417
 * @since 1.0.0 2021/02/23
 */

public class BrmRoleDetailRequest extends AbstractIccRequest<BrmRoleDetailResponse> {

    public BrmRoleDetailRequest(Long userId) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_ROLE_DETAIL_REST_GET, userId), Method.GET);
    }

    @Override
    public Class<BrmRoleDetailResponse> getResponseClass() {
        return BrmRoleDetailResponse.class;
    }
}
