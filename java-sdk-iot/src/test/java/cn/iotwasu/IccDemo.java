package cn.iotwasu;

import cn.iotwasu.http.DefaultClient;
import cn.iotwasu.http.IClient;
import cn.iotwasu.http.IotClient;
import cn.iotwasu.http.IotClientImpl;
import cn.iotwasu.iot.exception.ClientException;
import cn.iotwasu.model.v202203.CreateDeviceRequest;

/**
 * @author liulihai
 * @since 2020/10/27 19:50
 */
public class IccDemo {

  public static void main(String[] args) {
    // 三种方式初始化
    try {
      // 1、初始化客户端授权
//      IClient client = new DefaultClient("127.0.0.1", "clientId", "clientSecret");
//      IotTokenResponse  clientToken = client.getAccessToken(GrantType.client_credentials);
      // 2、初始化密码验证授权
      IClient pwdiClient =
          new DefaultClient("127.0.0.1:9091", "wasu", "123456", "web", "web");

      IotClient iotClient = new IotClientImpl();
      CreateDeviceRequest request = new CreateDeviceRequest("623c0775c2dc427d0480ab5f");
      request.setDeviceId("CZ12305");
      request.setDeviceName("滨江大厦4-2楼");
      request.setLatitude("30.207561");
      request.setLongitude("120.23475");
      String reso = iotClient.register(request);
      System.out.println(reso);
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
