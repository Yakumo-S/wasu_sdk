package com.wasu.model.v202203;

import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;
import com.wasu.hutool.http.Method;
import com.wasu.iot.exception.ClientException;
import com.wasu.model.v202010.GeneralResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liulihai
 * @since 2022/3/25
 */
public class CreateDeviceRequest extends AbstractIccRequest<GeneralResponse> {

  /**
   * 设备序号
   */
  private String deviceId;
  /**
   * 设备名称
   */
  private String deviceName;
  /**
   * + 摄像头类设备验证码
   */
  private String code;
  /**
   * 密钥
   */
  private String deviceKey;
  /**
   * 纬度
   */
  private String latitude;
  /**
   * 经度
   */
  private String longitude;

  private Map<String, Object> data = new HashMap<>();

  public CreateDeviceRequest(String productKey) throws ClientException {
    super(OauthConstant.url(String.format("/api/iot/device/%s/add", productKey)), Method.POST);
    putBodyParameter("cmd", "dev_add");

  }


  @Override
  public Class<GeneralResponse> getResponseClass() {
    return GeneralResponse.class;
  }


  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
    putBodyParameter("deviceId", deviceId);
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
    data.put("deviceName", deviceName);
    putBodyParameter("data", data);
  }

  public void setCode(String code) {
    this.code = code;
    data.put("code", code);
    putBodyParameter("data", data);
  }

  public void setDeviceKey(String deviceKey) {
    this.deviceKey = deviceKey;
    putBodyParameter("deviceKey", deviceKey);

  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
    data.put("latitude", latitude);
    putBodyParameter("data", data);
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
    data.put("longitude", longitude);
    putBodyParameter("data", data);
  }

  public String getDeviceId() {
    return deviceId;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }
}
