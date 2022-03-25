package com.wasu.http;

import com.wasu.model.v202010.GeneralResponse;
import com.wasu.model.v202203.CreateDeviceRequest;
import java.util.Map;

/**
 * @author liulihai
 * @version 1.0
 * @date 2022/3/25
 */
public interface IotClient {

  /**
   * 创建设备，必填字段 deviceId,deviceName,longitude,latitude
   *
   * @param createDeviceRequest
   * @return
   */
  String create(CreateDeviceRequest createDeviceRequest);

  /**
   * 上线
   *
   * @param deviceId 设备序号
   * @return
   */
  GeneralResponse online(String productKey, String deviceId);

  /**
   * 上报属性
   *
   * @param deviceId
   * @param properties
   * @return
   */
  GeneralResponse reportProperties(String productKey, String deviceId, Map<String, Object> properties);

  /**
   * 上报事件
   *
   * @param event
   * @param data
   * @return
   */
  GeneralResponse reportEvent(String productKey, String deviceId, String event, Map<String, Object> data);

  /**
   * 离线
   *
   * @param deviceId
   * @return
   */
  GeneralResponse offline(String productKey, String deviceId);


}
