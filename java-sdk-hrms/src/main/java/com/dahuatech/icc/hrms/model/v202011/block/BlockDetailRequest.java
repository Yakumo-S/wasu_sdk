package com.dahuatech.icc.hrms.model.v202011.block;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;


/**
 * 小区查看
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class BlockDetailRequest extends AbstractIccRequest<BlockDetailResponse> {

    public BlockDetailRequest(String orgCode) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_BLOCK_VIEW_REST_GET, orgCode), Method.GET);
    }

    @Override
    public Class<BlockDetailResponse> getResponseClass() {
        return BlockDetailResponse.class;
    }
}
