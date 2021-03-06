package cn.iotwasu.http;

import cn.iotwasu.model.v202010.GeneralResponse;
import cn.iotwasu.model.v202203.CreateDeviceRequest;
import java.util.Map;

/**
 * @author liulihai
 * @since 2020/10/27 19:50
 */
public interface IotClient {

  /**
   * 设备注册（添加）
   * <p>
   * 必填字段 deviceId,deviceName,longitude,latitude
   *
   * @param createDeviceRequest 请求
   * @return 字符串
   */
  String register(CreateDeviceRequest createDeviceRequest);

  /**
   * 上线
   *
   * @param productKey 产品productKey
   * @param deviceId   设备序号
   * @return 返回
   */
  GeneralResponse online(String productKey, String deviceId);

  /**
   * 上报属性 字段基于物模型
   *
   * @param productKey 产品productKey
   * @param deviceId   设备序号
   * @param properties 属性值 K-V（参考物模型）
   * @return 返回
   */
  GeneralResponse reportProperties(String productKey, String deviceId, Map<String, Object> properties);

  /**
   * 上报事件
   *
   * @param productKey 产品productKey
   * @param deviceId   设备序号
   * @param event      事件标识（参考物模型）
   * @param data       产生事件的属性值 K-V
   * @return 返回
   */
  GeneralResponse reportEvent(String productKey, String deviceId, String event, Map<String, Object> data);

  /**
   * 离线
   *
   * @param productKey 产品productKey
   * @param deviceId   设备序号
   * @return 返回
   */
  @Deprecated
  GeneralResponse offline(String productKey, String deviceId);


}
