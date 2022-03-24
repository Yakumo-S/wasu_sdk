package com.wasu.model.v202010.user;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 用户详情查看
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmUserDetailRequest extends AbstractIccRequest<BrmUserDetailResponse> {

  public BrmUserDetailRequest(Long userId) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_USER_DETAIL_REST_GET, userId), Method.GET);
  }

  @Override
  public Class<BrmUserDetailResponse> getResponseClass() {
    return BrmUserDetailResponse.class;
  }
}
