package com.wasu.http;

import com.wasu.hutool.http.HttpRequest;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public abstract class AbstractHttpRequest {
  /**
   * 加密签名
   *
   * @param request IccHttpHttpRequest对象
   * @return HttpRequest hutool请求对象
   */
  abstract HttpRequest signRequest(IotHttpRequest request);
}
