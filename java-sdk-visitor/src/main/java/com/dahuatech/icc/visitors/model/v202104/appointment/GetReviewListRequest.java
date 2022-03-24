package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

/***
 * H5访客列表接口
 * @author 237417
 * @since 20210421
 */
public class GetReviewListRequest extends AbstractIccRequest<GetReviewListResponse> {

    public GetReviewListRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_VISITOR_GET_REVIEW_LIST_POST), Method.POST);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<GetReviewListResponse> getResponseClass() {
        return GetReviewListResponse.class;
    }

    public static class Builder {



        public GetReviewListRequest build() throws ClientException {
            return new GetReviewListRequest(this);
        }
    }
}
