package cn.iotwasu.model.v202010;

import cn.iotwasu.http.AbstractIccRequest;
import cn.iotwasu.hutool.http.ContentType;
import cn.iotwasu.hutool.http.Method;
import cn.iotwasu.iot.exception.ClientException;
import cn.iotwasu.profile.IotProfile;

/**
 * 通用请求
 *
 * @author liulihai
 * @since 2020/11/18 9:58
 */
public class GeneralRequest extends AbstractIccRequest<GeneralResponse> {
  /**
   * 构造器
   *
   * @param url 请求Url
   * @param method 方法类型
   * @param needAuth 是否需要鉴权
   * @throws ClientException 客户端异常
   */
  public GeneralRequest(String url, Method method, Boolean needAuth) throws ClientException {
    super(IotProfile.URL_SCHEME + url, method, needAuth);
  }
  /**
   * 构造器
   *
   * @param url 请求Url
   * @param method 方法类型
   * @throws ClientException 客户端异常
   */
  public GeneralRequest(String url, Method method) throws ClientException {
    super(IotProfile.URL_SCHEME + url, method, Boolean.TRUE);
  }

  @Override
  public void setBody(String body) {
    httpRequest.contentType(ContentType.JSON.toString());
    super.setBody(body);
  }

  /**
   * 构造器
   *
   * @param url 请求Url
   * @param method 方法类型
   * @param body 请求参数json
   * @throws ClientException 客户端异常
   */
  public GeneralRequest(String url, Method method, String body) throws ClientException {
    super(IotProfile.URL_SCHEME + url, method, Boolean.TRUE, body);
  }

  @Override
  public Class<GeneralResponse> getResponseClass() {
    return GeneralResponse.class;
  }
}
