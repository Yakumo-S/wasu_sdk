package com.wasu;

import com.wasu.http.IotClient;
import com.wasu.http.IotClientImpl;
import com.wasu.hutool.core.util.RandomUtil;
import com.wasu.iot.exception.ClientException;
import com.wasu.model.v202010.GeneralResponse;
import com.wasu.model.v202203.CreateDeviceRequest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author liulihai
 * @version 1.0
 * @date 2022/3/25
 */
public class IotTest {

  private String productKey = "623c0775c2dc427d0480ab5f";
  private String deviceId = RandomUtil.randomString(2) + "00001" + RandomUtil.randomNumbers(2);
  private String deviceName = "冰河路" + RandomUtil.randomNumbers(2);

  @Test
  public void register() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    CreateDeviceRequest request = new CreateDeviceRequest("623c0775c2dc427d0480ab5f");
    request.setDeviceId(deviceId);
    request.setDeviceName(deviceName);
    request.setLatitude("31.207561");
    request.setLongitude("120.23475");
    String reso = iotClient.register(request);
    System.out.println();
  }

  @Test
  public void online() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    GeneralResponse result = iotClient.online(productKey, deviceId);
    System.out.println(result);
  }

  @Test
  public void event() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    Map<String, Object> data = new HashMap<>();
    GeneralResponse result = iotClient.reportEvent(productKey, deviceId, "powerOffAlarm", data);
    System.out.println(result);
  }

  @Test
  public void properties() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    Map<String, Object> properties = new HashMap<>();
    properties.put("switchStatus", 0);
    GeneralResponse result = iotClient.reportProperties(productKey, deviceId, properties);
    System.out.println(result);
  }
}
