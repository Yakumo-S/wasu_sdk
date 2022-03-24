package com.dahuatech.h8900.oauth.http;

import com.dahuatech.h8900.oauth.unmarshaller.Unmarshaller;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public abstract class AbstractIClient implements IClient, Unmarshaller {

  /**
   * 请求签名
   *
   * @param request icc请求request
   * @return 返回签名后的request
   */
  abstract H8900HttpRequest signRequest(H8900HttpRequest request);
}
