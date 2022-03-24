package com.dahuatech.icc.assesscontrol.model.v202103.cardRecord;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 刷卡记录详情
 *
 * @author 237417
 */
public class CardRecodeDetailRequest extends AbstractIccRequest<CardRecodeDetailResponse> {

    public CardRecodeDetailRequest(Long id,String swingTime) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_SWING_CARD_RECORD_DETAIL_GET), Method.GET);
        form("id",id);
        form("swingTime",swingTime);
    }

    @Override
    public Class<CardRecodeDetailResponse> getResponseClass() {
        return CardRecodeDetailResponse.class;
    }

}
