package com.wasu;

import com.wasu.http.IotClient;
import com.wasu.http.IotClientImpl;
import com.wasu.iot.exception.ClientException;
import com.wasu.model.v202010.GeneralResponse;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author liulihai
 * @version 1.0
 * @date 2022/3/25
 */
public class IotTest {

  private String productKey = "623c0775c2dc427d0480ab5f";

  @Test
  public void online() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    GeneralResponse result = iotClient.online(productKey, "CZ12304");
    System.out.println(result);
  }

  @Test
  public void event() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    Map<String, Object> data = new HashMap<>();
    GeneralResponse result = iotClient.reportEvent(productKey, "CZ12305", "powerOffAlarm", data);
    System.out.println(result);
  }

  @Test
  public void properties() throws ClientException {
    IotClient iotClient = new IotClientImpl();
    Map<String, Object> properties = new HashMap<>();
    properties.put("switchStatus", 0);
    GeneralResponse result = iotClient.reportProperties(productKey, "CZ12305", properties);
    System.out.println(result);
  }
}
