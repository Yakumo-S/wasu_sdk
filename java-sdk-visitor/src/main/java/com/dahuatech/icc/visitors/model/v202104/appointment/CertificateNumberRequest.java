package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

/***
 * 根据身份证查询访客信息
 * @author 237417
 * @since 20210421
 */
public class CertificateNumberRequest extends AbstractIccRequest<CertificateNumberResponse> {

    public CertificateNumberRequest() throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_VISITOR_GET_APPOINTMENT_BY_CERTIFICATE_NUMBER_GET), Method.GET);
    }

    @Override
    public Class<CertificateNumberResponse> getResponseClass() {
        return CertificateNumberResponse.class;
    }

}