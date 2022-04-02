package cn.iotwasu.http;

import cn.iotwasu.hutool.http.HttpRequest;

/**
 * @author liulihai
 * @since 2020-10-24 20:59:11
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
