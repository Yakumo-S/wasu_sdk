package com.wasu.http;

import com.wasu.iot.exception.ClientException;
import com.wasu.iot.exception.ServerException;
import com.wasu.profile.GrantType;

/**
 * 默认请求类
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public interface IClient {

  /**
   * 请求结果以String
   *
   * <p>实现类已设置鉴权，无需再次设置accessToken
   *
   * @param request iot请求
   * @return String 结果
   * @throws ClientException 客户端异常
   * @throws ServerException 服务异常
   */
  String doAction(IotHttpRequest request) throws ClientException, ServerException;

  /**
   * 请求结果以对象返回
   *
   * <p>实现类已设置鉴权，无需再次设置accessToken
   *
   * @param request iot请求
   * @param tClass  response 对象
   * @param <T>     泛型 对象
   * @return 返回iotResponse
   * @throws ClientException 客户端异常
   * @throws ServerException 服务异常
   */
  <T extends IotResponse> T doAction(IotHttpRequest request, Class<T> tClass)
      throws ClientException, ServerException;


  /**
   * 根据grantType类型，获取access_token
   *
   * @param grantType 使用鉴权类型
   * @return IccTokenResponse.IccToken
   */
  IotTokenResponse getAccessToken(GrantType grantType);

  /**
   * 使用默认类型，获取access_token
   *
   * @return IccTokenResponse.IccToken
   */
  IotTokenResponse getAccessToken();


}
