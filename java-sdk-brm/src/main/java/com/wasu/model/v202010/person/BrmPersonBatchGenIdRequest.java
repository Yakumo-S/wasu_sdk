package com.wasu.model.v202010.person;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * @author 237417
 * @since 1.0.0 2020/03/02
 */
public class BrmPersonBatchGenIdRequest extends AbstractIccRequest<BrmPersonBatchGenIdResponse> {


    public BrmPersonBatchGenIdRequest(Integer count) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_BATCH_GEN_ID_GET), Method.GET);
        form("count", count);
    }

    @Override
    public Class<BrmPersonBatchGenIdResponse> getResponseClass() {
        return BrmPersonBatchGenIdResponse.class;
    }
}
