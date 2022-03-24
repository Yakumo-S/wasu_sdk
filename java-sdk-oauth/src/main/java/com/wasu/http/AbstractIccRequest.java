package com.wasu.http;

import com.wasu.hutool.http.Method;
import com.wasu.iot.exception.ClientException;
import java.util.Map;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public abstract class AbstractIccRequest<T extends IotResponse> extends IotHttpRequest {
  public AbstractIccRequest(String url, Method method) throws ClientException {
    super(url, method, Boolean.TRUE);
  }

  public AbstractIccRequest(String url, Method method, boolean needAuth) throws ClientException {
    super(url, method, needAuth);
  }

  public AbstractIccRequest(String url, Method method, boolean needAuth, String body)
      throws ClientException {
    super(url, method, needAuth, body);
  }

  /**
   * 请求body，json，请求发送前会把map的值转换成json
   *
   * @param name 名称
   * @param value 值
   */
  protected void putBodyParameter(String name, Object value) {
    setParameter(this.bodyParameters, name, value);
  }

  /**
   * 表单格式，添加参数
   *
   * @param map map参数
   * @param name 名称
   * @param value 值
   */
  protected void setParameter(Map<String, Object> map, String name, Object value) {
    if (null == map || name == null || value == null) {
      return;
    }
    map.put(name, value);
  }

  /**
   * 返回结果对象
   *
   * @return Response对象
   */
  public abstract Class<T> getResponseClass();
}
