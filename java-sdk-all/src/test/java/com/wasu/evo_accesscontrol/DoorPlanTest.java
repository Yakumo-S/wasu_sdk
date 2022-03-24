package com.wasu.evo_accesscontrol;

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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * API文档-门禁管理-开门计划
 *
 * @author 232676
 * @since 1.0.0 2021/1/14 10:52
 */
public class DoorPlanTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-accesscontrol";
  private static String detail =
      "{\"monday\":[\"00: 00-23: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"],\"tuesday\":[\"00: 00-23: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"],\"wednesday\":[\"00: 00-23: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"],\"thursday\":[\"00: 00-23: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"],\"friday\":[\"00: 00-23: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"],\"saturday\":[\"00: 00-23: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"],\"sunday\":[\"00: 00-23: 59\",\"00: 00-00: 00\",\"00: 00-00: 00\",\"00: 00-00: 00\"]}";
  private final String planName = "junit5_opendoor_plan";
  private Integer planId = null;

  @BeforeAll
  static void beforeClass() {}

  @AfterAll
  static void afterClass() {}

  @AfterEach
  void afterEach() throws ClientException {
    existDel();
  }
  /**
   * 根据条件满足是否执行
   *
   * @return
   */
  static boolean isSupport() {
    // 如果没有门禁子系统，直接略过
    try {
      IClient iClient = new DefaultClient();
      return IccProfile.systemVersionMap.containsKey(SYSTEM_NAME);
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 门禁管理->开门计划-添加
   *
   * <p>接口编号 accesscontrol_013
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/timeQuantum
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("开门计划-添加")
  @Tag("门禁管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [evo-accesscontrol]")
  public void accesscontrol_013_door_plan_add() throws ClientException {
    logger.info("----开始执行----{}------", "开门计划-添加");
    // 添加前删除数据
    existDel();
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("name", planName);
    map.put("memo", planName);
    map.put("detail", detail);
    map.put("type", 1);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    planId = JSONUtil.parseObj(response.getResult()).getInt("data");
    Assertions.assertNotNull(planId);
    logger.info("----结束执行----{}------", "开门计划-添加");
  }
  /**
   * 门禁管理->开门计划-修改
   *
   * <p>接口编号 accesscontrol_014
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/timeQuantum/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("开门计划-修改")
  @Tag("门禁管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [evo-accesscontrol]")
  public void accesscontrol_014_door_plan_update() throws ClientException {
    logger.info("----开始执行----{}------", "开门计划-修改");
    // 添加前删除数据
    existDel();
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("name", planName);
    map.put("memo", planName);
    map.put("detail", detail);
    map.put("type", 1);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    planId = JSONUtil.parseObj(response.getResult()).getInt("data");
    Assertions.assertNotNull(planId);
    // ---------------修改开门计划
    // 1、设置url版本
    String updateUrl = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/update";
    updateUrl = String.format(updateUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> updateMap = new HashMap<>();
    updateMap.put("name", planName);
    updateMap.put("memo", planName + "_update");
    updateMap.put("detail", detail);
    updateMap.put("type", 1);
    updateMap.put("id", planId);
    request = new GeneralRequest(updateUrl, Method.POST);
    request.setBody(JSONUtil.toJsonStr(updateMap));
    GeneralResponse updateResponse = iClient.doAction(request, request.getResponseClass());
    printLog(request, updateResponse);
    Assertions.assertTrue(updateResponse.isSuccess());
    logger.info("----结束执行----{}------", "开门计划-修改");
  }
  /**
   * 门禁管理->开门计划-删除
   *
   * <p>接口编号 accesscontrol_015
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/timeQuantum/delete
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("开门计划-删除")
  @Tag("门禁管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [evo-accesscontrol]")
  public void accesscontrol_015_door_plan_delete() throws ClientException {
    logger.info("----开始执行----{}------", "开门计划-删除");
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("name", planName);
    map.put("memo", planName);
    map.put("detail", detail);
    map.put("type", 1);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    planId = JSONUtil.parseObj(response.getResult()).getInt("data");
    Assertions.assertNotNull(planId);
    // 1、设置url版本
    String delUrl = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/delete";
    delUrl = String.format(delUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> delMap = new HashMap<>();
    delMap.put("ids", Stream.of(planId).collect(Collectors.toList()));
    GeneralRequest delRequest = new GeneralRequest(delUrl, Method.POST);
    delRequest.setBody(JSONUtil.toJsonStr(delMap));
    GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    printLog(delRequest, delResponse);
    Assertions.assertTrue(delResponse.isSuccess());
    logger.info("----结束执行----{}------", "开门计划-删除");
  }
  /**
   * 门禁管理->开门计划-列表
   *
   * <p>接口编号 accesscontrol_008
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/timeQuantum/{id}/page
   *
   * <p>注：目前{id} 值只允许为 1
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("开门计划-列表")
  @Tag("门禁管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [evo-accesscontrol]")
  public void accesscontrol_016_door_plan_list() throws ClientException {
    logger.info("----开始执行----{}------", "开门计划-列表");

    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/1/page";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数
    map.put("singleCondition", planName);
    request.setBody(JSONUtil.toJsonStr(map));
    response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "开门计划-列表");
  }
  /**
   * 门禁管理->开门计划-详情
   *
   * <p>接口编号 accesscontrol_017
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/timeQuantum/getByIndex/{index}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("开门计划-详情")
  @Tag("门禁管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [evo-accesscontrol]")
  public void accesscontrol_017_door_plan_detail() throws ClientException {
    logger.info("----开始执行----{}------", "开门计划-详情");
    // 添加前删除数据
    existDel();
    // -----------------------------分割线,添加数据-----------------------------------

    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("name", planName);
    map.put("memo", planName);
    map.put("detail", detail);
    map.put("type", 1);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    planId = JSONUtil.parseObj(response.getResult()).getInt("data");
    // -----------------------------分割线,查询index-----------------------------------
    // 因详情参数是index字段，查询一下
    url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/1/page";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    map.clear();
    map.put("pageNum", 1);
    map.put("singleCondition", planName);
    map.put("pageSize", 20);
    GeneralRequest queryRequest = new GeneralRequest(url, Method.POST);
    queryRequest.setBody(JSONUtil.toJsonStr(map));
    IClient iCliesnt =
        new DefaultClient(
            IccProfile.host,
            IccProfile.username,
            IccProfile.password,
            IccProfile.pwdClientId,
            IccProfile.pwdClientSecret);
    GeneralResponse queryResponse =
        iCliesnt.doAction(queryRequest, queryRequest.getResponseClass());
    printLog(queryRequest, queryResponse);
    if (queryResponse.isSuccess()) {
      JSONObject obj = JSONUtil.parseObj(queryResponse.getResult());
      JSONArray pageData = obj.getJSONObject("data").getJSONArray("pageData");
      Integer index = ((JSONObject) pageData.get(0)).getInt("index");
      Assertions.assertNotNull(index);
      // -----------------------------分割线,查询详情-----------------------------------
      String detailUrl =
          "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/getByIndex/%s";
      detailUrl = String.format(detailUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME), index);
      GeneralRequest detailRequest = new GeneralRequest(detailUrl, Method.GET);
      GeneralResponse detailResponse = iClient.doAction(detailRequest, request.getResponseClass());
      printLog(detailRequest, detailResponse);
      Assertions.assertTrue(detailResponse.isSuccess());
    }
    logger.info("----结束执行----{}------", "开门计划-详情");
  }
  /**
   * 清数据
   *
   * @throws ClientException
   */
  private void existDel() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/1/page";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("singleCondition", planName);
    map.put("pageSize", 20);
    IClient iClient = new DefaultClient();
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
  }

  @BeforeEach
  public void before() throws ClientException {
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }
}
