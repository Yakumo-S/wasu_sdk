package com.wasu;

import com.wasu.http.IotClient;
import com.wasu.http.IotClientImpl;
import com.wasu.hutool.core.thread.ThreadUtil;
import com.wasu.hutool.core.util.RandomUtil;
import com.wasu.iot.exception.ClientException;
import com.wasu.model.v202010.GeneralResponse;
import com.wasu.model.v202203.CreateDeviceRequest;
import java.util.HashMap;
import java.util.Map;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author liulihai
 * @version 1.0
 * @date 2022/3/25
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IotTest {

  private String productKey = "623c0775c2dc427d0480ab5f";
  private String deviceName = "冰河路" + RandomUtil.randomNumbers(2);
  private static final String deviceId;

  static {
    deviceId = RandomUtil.randomString(2) + "00001" + RandomUtil.randomNumbers(2);
  }

  @Test
  public void iot_01_register() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    CreateDeviceRequest request = new CreateDeviceRequest("623c0775c2dc427d0480ab5f");
    request.setDeviceId(deviceId);
    request.setDeviceName(deviceName);
    request.setLatitude("31.207561");
    request.setLongitude("120.23475");
    String reso = iotClient.register(request);
    System.out.println();
    ThreadUtil.sleep(5000);
  }

  @Test
  public void iot_02_online() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    GeneralResponse result = iotClient.online(productKey, deviceId);
    System.out.println(result);
    ThreadUtil.sleep(1000);

  }

  @Test
  public void iot_03_event() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    Map<String, Object> data = new HashMap<>();
    GeneralResponse result = iotClient.reportEvent(productKey, deviceId, "powerOffAlarm", data);
    System.out.println(result);
    ThreadUtil.sleep(2000);

  }

  @Test
  public void iot_04_properties() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    Map<String, Object> properties = new HashMap<>();
    properties.put("switchStatus", 1);
    GeneralResponse result = iotClient.reportProperties(productKey, deviceId, properties);
    System.out.println(result);
    ThreadUtil.sleep(2000);

  }
}
