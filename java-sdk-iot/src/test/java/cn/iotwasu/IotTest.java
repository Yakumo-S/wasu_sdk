package cn.iotwasu;

import cn.iotwasu.http.IotClient;
import cn.iotwasu.http.IotClientImpl;
import cn.iotwasu.hutool.core.thread.ThreadUtil;
import cn.iotwasu.hutool.core.util.RandomUtil;
import cn.iotwasu.iot.exception.ClientException;
import cn.iotwasu.model.v202010.GeneralResponse;
import cn.iotwasu.model.v202203.CreateDeviceRequest;
import java.util.HashMap;
import java.util.Map;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


/**
 * @author liulihai
 * @since 2022/3/25 19:50
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IotTest {

  private String productKey = "623c0775c2dc427d0480ab5f";
  private String deviceName = "冰河路" + RandomUtil.randomNumbers(2);
  private static final String deviceId;

  static {
    deviceId = RandomUtil.randomString(2) + "00001" + RandomUtil.randomNumbers(2);
  }

  /**
   * 新增设备
   *
   * @throws ClientException 客户端连接异常
   */
  @Test
  public void iot_01_register() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    CreateDeviceRequest request = new CreateDeviceRequest("623c0775c2dc427d0480ab5f");
    request.setDeviceId(deviceId);
    request.setDeviceName(deviceName);
    request.setLatitude("31.207561");
    request.setLongitude("120.23475");
    String reso = iotClient.register(request);
    System.out.println(reso);
    ThreadUtil.sleep(5000);
  }

  /**
   * 设备上线
   *
   * @throws ClientException 客户端连接异常
   */
  @Test
  public void iot_02_online() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    GeneralResponse result = iotClient.online(productKey, deviceId);
    System.out.println(result);
    ThreadUtil.sleep(1000);

  }

  /**
   * 事件上报
   *
   * @throws ClientException 客户端连接异常
   */
  @Test
  public void iot_03_event() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    //产生事件包含的物模型属性
    Map<String, Object> data = new HashMap<>();
    data.put("temp", "20");
    GeneralResponse result = iotClient.reportEvent(productKey, deviceId, "powerOffAlarm", data);
    System.out.println(result);
    ThreadUtil.sleep(2000);

  }

  /**
   * 属性上报
   *
   * @throws ClientException 客户端连接异常
   */
  @Test
  public void iot_04_properties() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    Map<String, Object> properties = new HashMap<>();
    //物模型属性
    properties.put("switchStatus", 1);
    GeneralResponse result = iotClient.reportProperties(productKey, deviceId, properties);
    System.out.println(result);
    ThreadUtil.sleep(2000);

  }
}
