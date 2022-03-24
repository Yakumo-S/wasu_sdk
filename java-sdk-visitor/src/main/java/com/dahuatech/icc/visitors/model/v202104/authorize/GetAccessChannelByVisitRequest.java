package com.dahuatech.icc.visitors.model.v202104.authorize;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

public class GetAccessChannelByVisitRequest extends AbstractIccRequest<GetAccessChannelByVisitResponse> {

    public GetAccessChannelByVisitRequest() throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_GET_ACCESS_CHANNEL_BY_VISIT_GET), Method.GET);
    }

    @Override
    public Class<GetAccessChannelByVisitResponse> getResponseClass() {
        return GetAccessChannelByVisitResponse.class;
    }

}
