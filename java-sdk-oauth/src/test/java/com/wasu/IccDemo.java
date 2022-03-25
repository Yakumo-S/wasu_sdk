package com.wasu;

import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IotTokenResponse;
import com.wasu.iot.exception.ClientException;
import com.wasu.profile.GrantType;

/**
 * @author liulihai
 * @since 2020/10/27 19:50
 */
public class IccDemo {
  public static void main(String[] args) {
    // 三种方式初始化
    try {
      // 1、初始化客户端授权
      IClient client = new DefaultClient("127.0.0.1", "clientId", "clientSecret");
      IotTokenResponse.IccToken clientToken = client.getAccessToken(GrantType.client_credentials);

      // 2、初始化密码验证授权
      IClient pwdiClient =
          new DefaultClient("127.0.0.1", "username", "password", "pwdClientId", "pwdClientSecret");
      IotTokenResponse.IccToken pwdToken = pwdiClient.getAccessToken(GrantType.password);

      // 3、在classpath创建config/iotSdk.properties配置文件
      // #服务地址
      // iot.sdk.host=10.35.121.62
      // #客户端ID
      // iot.sdk.clientId=web_client
      // #客户端秘钥
      // iot.sdk.clientSecret=web_client
      // #-----------密码认证参数--------------
      // #密码认证ID
      // iot.sdk.pwdClientId=web_client
      // #密码认证秘钥
      // iot.sdk.pwdClientSecret=web_client
      // #登录用户名
      // iot.sdk.username=system
      // #用户密码
      // iot.sdk.password=dahua2006
      // #认证类型=password,client_credentials单选
      // iot.sdk.grantType=password
    } catch (ClientException e) {
      e.printStackTrace();
    }
  }
}
