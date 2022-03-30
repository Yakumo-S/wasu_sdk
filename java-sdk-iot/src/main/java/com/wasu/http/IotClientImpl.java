package com.wasu.http;

import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.http.Method;
import com.wasu.hutool.json.JSONUtil;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.iot.exception.ClientException;
import com.wasu.iot.util.CollectionUtil;
import com.wasu.model.v202010.GeneralRequest;
import com.wasu.model.v202010.GeneralResponse;
import com.wasu.model.v202203.CreateDeviceRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author liulihai
 * @since 2022/3/25
 */
public class IotClientImpl implements IotClient {

  private static final Log logger = LogFactory.get();

  private IClient iClient = null;

  public IotClientImpl() throws ClientException {
    iClient = new DefaultClient();
  }

  @Override
  public String register(CreateDeviceRequest createDeviceRequest) {
    String re = null;
    try {
      if (StrUtil.isBlank(createDeviceRequest.getDeviceId())) {
        throw new RuntimeException("deviceId 不能为空");
      }
      if (StrUtil.isBlank(createDeviceRequest.getDeviceName())) {
        throw new RuntimeException("deviceName 不能为空");
      }
      if (StrUtil.isBlank(createDeviceRequest.getLatitude())) {
        throw new RuntimeException("latitude 维度不能为空");
      }
      if (StrUtil.isBlank(createDeviceRequest.getLongitude())) {
        throw new RuntimeException("longitude 经度不能为空");
      }
      re = iClient.doAction(createDeviceRequest);
      logger.info("添加设备={} 返回={}", createDeviceRequest, re);
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return re;
  }

  @Override
  public GeneralResponse online(String productKey, String deviceId) {
    GeneralResponse re = null;
    if (StrUtil.isBlank(productKey) || StrUtil.isBlank(deviceId)) {
      throw new RuntimeException("productKey或deviceId 不能为空");
    }
    try {
      GeneralRequest request = new GeneralRequest(
          String.format("/api/iot/v2/online/%s/%s", productKey, deviceId),
          Method.PUT);
      re = iClient.doAction(request, GeneralResponse.class);
      logger.info("设备上线={} 返回={}", deviceId, re);
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return re;
  }

  @Override
  public GeneralResponse reportProperties(String productKey, String deviceId, Map<String, Object> properties) {
    GeneralResponse re = null;
    if (StrUtil.isBlank(productKey) || StrUtil.isBlank(deviceId)) {
      throw new RuntimeException("productKey或deviceId 不能为空");
    }
    try {
      GeneralRequest request = new GeneralRequest(
          (String.format("/api/iot/v2/device/report/properties/%s/%s", productKey, deviceId)),
          Method.POST);
      Map<String, Object> msg = new HashMap<>();
      msg.put("properties", properties);
      request.body(JSONUtil.toJsonStr(msg));
      re = iClient.doAction(request, GeneralResponse.class);
      logger.info("设备属性上报={} 返回={}", deviceId, re);
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return re;
  }

  @Override
  public GeneralResponse reportEvent(String productKey, String deviceId, String event, Map<String, Object> data) {
    GeneralResponse re = null;
    if (StrUtil.isBlank(productKey) || StrUtil.isBlank(deviceId)) {
      throw new RuntimeException("productKey或deviceId 不能为空");
    }
    try {
      GeneralRequest request = new GeneralRequest(
          (String.format("/api/iot/v2/device/report/event/%s/%s", productKey, deviceId)),
          Method.POST);
      Map<String, Object> msg = new HashMap<>();
      msg.put("event", event);
      msg.put("messageType", "EVENT");
      if (!CollectionUtil.isEmpty(data)) {
        msg.put("data", data);
      }
      request.body(JSONUtil.toJsonStr(msg));
      re = iClient.doAction(request, GeneralResponse.class);
      logger.info("设备上报事件={} 返回={}", deviceId, re);
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return re;
  }

  @Override
  public GeneralResponse offline(String productKey, String deviceId) {
    return null;
  }
}
