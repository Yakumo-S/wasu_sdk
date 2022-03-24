package com.wasu.evo_accesscontrol;

import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.http.Method;
import com.wasu.hutool.json.JSONArray;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API文档-门禁管理-常开常闭计划
 *
 * <p>用例执行前期条件，需要设备channelCode,且设备在线
 *
 * @author 232676
 * @since 1.0.0 2021/1/20 08:11
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AurhorityDoorGroupTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-accesscontrol";
  private static String channelCode = null;
  private static String openPlanName = "junit5开";
  private static String openPlanDetail =
      "{\"sunday\":[\"00: 00-10: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"]}";
  private static String closedPlanName = "junit5关";
  private static String closedPlanDetail =
      "{\"tuesday\":[\"20: 00-21: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"]}";
  private String prefixPlanName = "junit5";

  @BeforeAll
  void beforeClass() throws ClientException {}

  @AfterAll
  void afterClass() {}

  @BeforeEach
  void beforeEach() throws ClientException {
    existDel();
  }

  @AfterEach
  void afterEach() throws ClientException {
    existDel();
  }
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
        JSONArray dev =
            JSONUtil.parseObj(response.getResult()).getJSONObject("data").getJSONArray("pageData");
        for (Object ob : dev) {
          JSONObject dt = (JSONObject) ob;
          JSONObject unit = (JSONObject) dt.getJSONArray("units").get(0);
          JSONObject channels = (JSONObject) unit.getJSONArray("channels").get(0);
          channelCode = channels.getStr("channelCode");
          int isOnline = channels.getInt("isOnline");
          // 存在且在线
          if (StrUtil.isNotBlank(channelCode) && isOnline == 1) {
            return true;
          }
        }
      }
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 门禁管理->多卡开门-添加常开常闭计划
   *
   * <p>接口编号 accesscontrol_027
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channel/openNormallySetting/add
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-添加常开常闭计划")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without online device")
  public void accesscontrol_027_normal_open_add() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-添加常开常闭计划");
    Integer closedId = addClosedPlan();
    Integer openId = addOpenPlan();

    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCode", channelCode);
    map.put("onlineStatus", "ON");
    map.put("openDoorsPlanId", openId);
    //    map.put("closeDoorsPlanId", closedId);

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "多卡开门-添加常开常闭计划");
  }
  /**
   * 门禁管理->多卡开门-更新常开常闭计划
   *
   * <p>接口编号 accesscontrol_028
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channel/openNormallySetting/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-更新常开常闭计划")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without online device")
  public void accesscontrol_028_nomal_open_update() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-更新常开常闭计划");
    Integer closedId = addClosedPlan();
    Integer openId = addOpenPlan();
    Integer openPlusId = addOpenPlanPlus();
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCode", channelCode);
    map.put("onlineStatus", "ON");
    map.put("openDoorsPlanId", openId);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());

    String updateUrl =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/update";
    updateUrl = String.format(updateUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> updateMap = new HashMap<>();
    updateMap.put("channelCode", channelCode);
    updateMap.put("onlineStatus", "ON");
    updateMap.put("openDoorsPlanId", openPlusId);
    iClient = new DefaultClient();
    GeneralRequest updateRequest = new GeneralRequest(updateUrl, Method.POST);
    updateRequest.setBody(JSONUtil.toJsonStr(updateMap));
    GeneralResponse updateResponse =
        iClient.doAction(updateRequest, updateRequest.getResponseClass());
    printLog(updateRequest, updateResponse);
    Assertions.assertTrue(updateResponse.isSuccess());

    logger.info("----结束执行----{}------", "多卡开门-更新常开常闭计划");
  }
  /**
   * 门禁管理->多卡开门-删除常开常闭计划
   *
   * <p>接口编号 accesscontrol_029
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channel/openNormallySetting/delete
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-添加常开常闭计划")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without online device")
  public void accesscontrol_029_nomal_open_delete() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-删除常开常闭计划");
    Integer closedId = addClosedPlan();
    Integer openId = addOpenPlan();
    Integer openPlusId = addOpenPlanPlus();
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("channelCode", channelCode);
    map.put("onlineStatus", "ON");
    map.put("openDoorsPlanId", openId);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());

    String delUrl =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/delete";
    delUrl = String.format(delUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> delMap = new HashMap<>();
    delMap.put("channelCode", channelCode);

    iClient = new DefaultClient();
    GeneralRequest delRequest = new GeneralRequest(delUrl, Method.POST);
    delRequest.setBody(JSONUtil.toJsonStr(delMap));
    GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    printLog(delRequest, delResponse);
    Assertions.assertTrue(delResponse.isSuccess());

    logger.info("----结束执行----{}------", "多卡开门-删除常开常闭计划");
  }
  /**
   * 门禁管理->多卡开门-常开常闭计划列表
   *
   * <p>接口编号 accesscontrol_030
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channel/openNormallySetting/bycondition/combined
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-常开常闭计划列表")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without online device")
  public void accesscontrol_030_nomal_open_list() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-常开常闭计划列表");
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/bycondition/combined";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);
    map.put("singleCondition", channelCode);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    // TODO 不符合restful风格
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());

    logger.info("----结束执行----{}------", "多卡开门-常开常闭计划列表");
  }
  /**
   * 门禁管理->多卡开门-常开常闭计划列表
   *
   * <p>接口编号 accesscontrol_030
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channel/openNormallySetting/bycondition/combined
   *
   * @throws ClientException
   */

  @Test
  @DisplayName("多卡开门-常开常闭计划列表（不符合restful）")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without online device")
  public void accesscontrol_030_1_nomal_open_list() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-常开常闭计划列表");
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/bycondition/combined";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);
    map.put("singleCondition", channelCode);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "多卡开门-常开常闭计划列表");
  }
  /**
   * 添加常开门计划
   *
   * @return 常开门主键ID
   * @throws ClientException
   */
  private Integer addOpenPlan() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("name", openPlanName);
    map.put("memo", openPlanName);
    map.put("detail", openPlanDetail);
    map.put("type", 1);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    Integer planId = JSONUtil.parseObj(response.getResult()).getInt("data");
    Assertions.assertNotNull(planId);
    return planId;
  }

  private void delNormalOpen() throws ClientException {
    String delUrl =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/delete";
    delUrl = String.format(delUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> delMap = new HashMap<>();
    delMap.put("channelCode", channelCode);
    DefaultClient iClient = new DefaultClient();
    GeneralRequest delRequest = new GeneralRequest(delUrl, Method.POST);
    delRequest.setBody(JSONUtil.toJsonStr(delMap));
    GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    printLog(delRequest, delResponse);
    Assertions.assertTrue(delResponse.isSuccess());
  }
  /**
   * 添加常开门计划,更新用
   *
   * @return 常开门主键ID
   * @throws ClientException
   */
  private Integer addOpenPlanPlus() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("name", openPlanName + 1);
    map.put("memo", openPlanName + 1);
    map.put("detail", openPlanDetail);
    map.put("type", 1);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    Integer planId = JSONUtil.parseObj(response.getResult()).getInt("data");
    Assertions.assertNotNull(planId);
    return planId;
  }
  /**
   * 添加常闭门计划
   *
   * @return 常闭门主键ID
   * @throws ClientException
   */
  private Integer addClosedPlan() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("name", closedPlanName);
    map.put("memo", closedPlanName);
    map.put("detail", closedPlanDetail);
    map.put("type", 1);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    Integer planId = JSONUtil.parseObj(response.getResult()).getInt("data");
    Assertions.assertNotNull(planId);
    return planId;
  }
  /**
   * 清数据
   *
   * @throws ClientException
   */
  void existDel() throws ClientException {
    IClient iClient = new DefaultClient();
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/1/page";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("singleCondition", prefixPlanName);
    map.put("pageSize", 20);
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    if (response.isSuccess()) {
      JSONObject obj = JSONUtil.parseObj(response.getResult());
      JSONArray pageData = obj.getJSONObject("data").getJSONArray("pageData");
      List<Integer> planIds = new ArrayList<>();
      for (Object pd : pageData) {
        JSONObject dc = (JSONObject) pd;
        planIds.add(dc.getInt("id"));
      }
      if (planIds.isEmpty()) {
        // 结束运行，无需删除
        return;
      }
      // 1、设置url版本
      String delUrl = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/delete";
      delUrl = String.format(delUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
      // 2、拼接必填参数
      Map<String, Object> delMap = new HashMap<>();
      delMap.put("ids", planIds);
      GeneralRequest delRequest = new GeneralRequest(delUrl, Method.POST);
      delRequest.setBody(JSONUtil.toJsonStr(delMap));
      GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
      printLog(delRequest, delResponse);
      Assertions.assertTrue(delResponse.isSuccess());
    }
    delNormalOpen();
  }

  @BeforeEach
  public void before() throws ClientException {
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }
}
