package com.wasu.http;

import com.wasu.unmarshaller.Unmarshaller;

/**
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public abstract class AbstractIClient implements IClient, Unmarshaller {

  /**
   * 请求签名
   *
   * @param request iot请求request
   * @return 返回签名后的request
   */
  abstract IotHttpRequest signRequest(IotHttpRequest request);
}
