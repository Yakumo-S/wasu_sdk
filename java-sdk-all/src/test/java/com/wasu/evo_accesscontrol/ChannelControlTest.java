package com.wasu.evo_accesscontrol;

import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.http.Method;
import com.wasu.hutool.json.JSONObject;
import com.wasu.hutool.json.JSONUtil;
import com.wasu.icc.exception.ClientException;
import com.wasu.handle.TokenHandleSingle;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.model.v202010.GeneralRequest;
import com.wasu.model.v202010.GeneralResponse;
import com.wasu.profile.IccProfile;
import com.wasu.ExtentUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.HashMap;
import java.util.Map;

/**
 * API文档-门禁管理-门通道控制
 *
 * @author 232676
 * @since 1.0.0 2021/1/14 10:52
 */
public class ChannelControlTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-accesscontrol";
  private static String channelCode = null;

  @BeforeAll
  static void beforeClass() {}

  @AfterAll
  static void afterClass() {}
  /**
   * 根据条件满足是否执行
   *
   * <p>此处接口需[channelCode],否则用例无法继续执行
   *
   * @return
   */
  static boolean isSupport() {
    try {
      IClient iClient = new DefaultClient();
      // 如果没有门禁子系统，直接略过
      if (!IccProfile.systemVersionMap.containsKey(SYSTEM_NAME)) {
        return false;
      }
      // 判断是否存在设备
      String url = "/evo-apigw/evo-brm/%s/device/subsystem/page";
      url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
      GeneralRequest request = new GeneralRequest(url, Method.POST);
      request.body("{\"pageNum\":1,\"pageSize\":1,\"categorys\":[8],\"isOnline\":1}");
      GeneralResponse response = iClient.doAction(request, request.getResponseClass());
      if (response.isSuccess()) {
        JSONObject dev =
            (JSONObject)
                JSONUtil.parseObj(response.getResult())
                    .getJSONObject("data")
                    .getJSONArray("pageData")
                    .get(0);
        JSONObject unit = (JSONObject) dev.getJSONArray("units").get(0);
        JSONObject channels = (JSONObject) unit.getJSONArray("channels").get(0);
        channelCode = channels.getStr("channelCode");
        if (StrUtil.isNotBlank(channelCode)) {
          return true;
        }
      }
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 门禁管理->门通道控制->开门
   *
   * <p>接口编号 accesscontrol_002
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelControl/openDoor
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门通道-开门")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_002_channel_control_open_door() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/openDoor";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCodeList", new String[] {channelCode});
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数

  }
  /**
   * 门禁管理->门通道控制->关门
   *
   * <p>接口编号 accesscontrol_003
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelControl/closeDoor
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门通道-关门")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_003_channel_control_close_door() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/closeDoor";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCodeList", new String[] {channelCode});
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数

  }
  /**
   * 门禁管理->门通道控制->常开
   *
   * <p>接口编号 accesscontrol_004
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelControl/stayOpen
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门通道-常开")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_004_channel_control_stay_door() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/stayOpen";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCodeList", new String[] {channelCode});
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数

  }
  /**
   * 门禁管理->门通道控制->常闭
   *
   * <p>接口编号 accesscontrol_005
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelControl/stayClose
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门通道-常闭")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_005_channel_control_stay_close() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/stayClose";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCodeList", new String[] {channelCode});
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数
  }
  /**
   * 门禁管理->门通道控制->正常状态
   *
   * <p>接口编号 accesscontrol_006
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelControl/normal
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门通道-正常")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_006_channel_control_normal() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/normal";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCodeList", new String[] {channelCode});
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数
  }
  /**
   * 门禁管理->门通道控制->门状态
   *
   * <p>接口编号 accesscontrol_007
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelControl/getDoorStatus
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门通道-门状态")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_007_channel_control_door_status() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/getDoorStatus";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCodeList", new String[] {channelCode});
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数
  }

  @BeforeEach
  public void before() throws ClientException {
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }
}
