package com.wasu;

import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IccTokenResponse;

/**
 * @author 232676
 * @since 2020/10/27 19:50
 */
public class IccHostDemo {
  public static void main(String[] args) {
    // 三种方式初始化
    try {
      // 1、初始化客户端授权
      IClient client = new DefaultClient();
      IccTokenResponse.IccToken clientToken = client.getAccessToken();
      System.out.println(clientToken);
      // 3、在classpath创建config/iccSdk.properties配置文件
      // #服务地址
      // icc.sdk.host=10.35.121.62
      // #客户端ID
      // icc.sdk.clientId=web_client
      // #客户端秘钥
      // icc.sdk.clientSecret=web_client
      // #-----------密码认证参数--------------
      // #密码认证ID
      // icc.sdk.pwdClientId=web_client
      // #密码认证秘钥
      // icc.sdk.pwdClientSecret=web_client
      // #登录用户名
      // icc.sdk.username=system
      // #用户密码
      // icc.sdk.password=dahua2006
      // #认证类型=password,client_credentials单选
      // icc.sdk.grantType=password
    } catch (ClientException e) {
      e.printStackTrace();
    }
  }
}
