package com.dahuatech.h8900.oauth.http;

import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.exception.ServerException;

/**
 * 默认请求类
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public interface IClient {
    /**
     * 请求结果以String
     *
     * <p>实现类已设置鉴权，无需再次设置accessToken
     *
     * @param request icc请求
     * @return String 结果
     * @throws ClientException 客户端异常
     * @throws ServerException 服务异常
     */
    String doAction(H8900HttpRequest request) throws ClientException, ServerException;

    /**
     * 请求结果以对象返回
     *
     * <p>实现类已设置鉴权，无需再次设置accessToken
     *
     * @param request icc请求
     * @param tClass  response 对象
     * @param <T>     泛型 对象
     * @return 返回iccResponse
     * @throws ClientException 客户端异常
     * @throws ServerException 服务异常
     */
    <T extends H8900Response> T doAction(H8900HttpRequest request, Class<T> tClass)
        throws ClientException, ServerException;

    /**
     * 使用默认类型，获取access_token
     *
     * @return IccTokenResponse.IccToken
     */
    H8900Token getAccessToken();
}
