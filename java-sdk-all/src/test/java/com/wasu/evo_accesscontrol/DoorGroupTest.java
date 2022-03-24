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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * API文档-门禁管理-门组控制
 *
 * <p>用例执行前期条件，需要设备channelCode
 *
 * <p>添加-列表-详情-修改-删除，用例执行完成后，删除创建的门组
 *
 * @author 232676
 * @since 1.0.0 2021/1/14 10:52
 */
public class DoorGroupTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-accesscontrol";
  private static String channelCode = null;
  private static Integer doorGoupId = null;
  private final String doorGroupName = "junit5";

  @BeforeAll
  static void beforeClass() {}

  @AfterAll
  static void afterClass() {}

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
   * 门禁管理->门组管理-门组添加
   *
   * <p>接口编号 accesscontrol_008
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/doorGroup
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门组管理-添加门组")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_008_door_group_add() throws ClientException {
    logger.info("----开始执行----{}------", "门组管理-添加门组");
    // 添加前删除数据
    existDel();
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("name", doorGroupName);
    map.put("memo", doorGroupName);
    map.put("orgCode", "001");
    Map<String, Object> doorGroupDetail = new HashMap<>();
    doorGroupDetail.put("channelCode", channelCode);
    map.put("doorGroupDetail", Stream.of(doorGroupDetail).collect(Collectors.toList()));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    doorGoupId = JSONUtil.parseObj(response.getResult()).getInt("data");
    Assertions.assertNotNull(doorGoupId);
    logger.info("----结束执行----{}------", "门组管理-添加门组");
  }
  /**
   * 门禁管理->门组管理-修改门组
   *
   * <p>接口编号 accesscontrol_009
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/doorGroup/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门组管理-修改门组")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_009_door_group_update() throws ClientException {
    logger.info("----开始执行----{}------", "门组管理-修改门组");
    // 添加设备
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    Map<String, Object> map = new HashMap<>();
    map.put("name", doorGroupName);
    map.put("memo", doorGroupName);
    map.put("orgCode", "001");
    Map<String, Object> doorGroupDetail = new HashMap<>();
    doorGroupDetail.put("channelCode", channelCode);
    map.put("doorGroupDetail", Stream.of(doorGroupDetail).collect(Collectors.toList()));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    doorGoupId = JSONUtil.parseObj(response.getResult()).getInt("data");
    // 更新设备
    String updateUrl = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/update";
    updateUrl = String.format(updateUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    Map<String, Object> updateMap = new HashMap<>();
    updateMap.put("id", doorGoupId);
    updateMap.put("name", doorGroupName);
    updateMap.put("memo", doorGroupName + "dev");
    updateMap.put("orgCode", "001");
    Map<String, Object> updateDoorGroupDetail = new HashMap<>();
    updateDoorGroupDetail.put("channelCode", channelCode);
    // TODO 新增和修改
    updateMap.put(
        "deleteDoorGroupRelDoorList",
        Stream.of(updateDoorGroupDetail).collect(Collectors.toList()));
    GeneralRequest updateRequest = new GeneralRequest(updateUrl, Method.POST);
    updateRequest.setBody(JSONUtil.toJsonStr(updateMap));
    GeneralResponse updateResponse =
        iClient.doAction(updateRequest, updateRequest.getResponseClass());
    printLog(updateRequest, updateResponse);
    Assertions.assertTrue(updateResponse.isSuccess());

    // 先删除再新增
    updateMap.remove("deleteDoorGroupRelDoorList");
    updateMap.put(
        "addDoorGroupRelDoorList", Stream.of(updateDoorGroupDetail).collect(Collectors.toList()));
    updateRequest = new GeneralRequest(updateUrl, Method.POST);
    updateRequest.setBody(JSONUtil.toJsonStr(updateMap));
    updateResponse = iClient.doAction(updateRequest, updateRequest.getResponseClass());
    printLog(updateRequest, updateResponse);
    Assertions.assertTrue(updateResponse.isSuccess());

    logger.info("----结束执行----{}------", "门组管理-修改门组");
  }
  /**
   * 门禁管理->门组管理-删除门组
   *
   * <p>接口编号 accesscontrol_010
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/doorGroup/delete/batch
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门组管理-删除门组")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_010_door_group_delete() throws ClientException {
    logger.info("----开始执行----{}------", "门组管理-删除门组");
    // 添加设备
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    Map<String, Object> map = new HashMap<>();
    map.put("name", doorGroupName);
    map.put("memo", doorGroupName);
    map.put("orgCode", "001");
    Map<String, Object> doorGroupDetail = new HashMap<>();
    doorGroupDetail.put("channelCode", channelCode);
    map.put("doorGroupDetail", Stream.of(doorGroupDetail).collect(Collectors.toList()));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    doorGoupId = JSONUtil.parseObj(response.getResult()).getInt("data");
    // 删除设备
    String delUrl = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/delete/batch";
    delUrl = String.format(delUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    Map<String, Object> delMap = new HashMap<>();
    delMap.put("doorGroupIds", new Integer[] {doorGoupId});
    GeneralRequest delRequest = new GeneralRequest(delUrl, Method.POST);
    delRequest.setBody(JSONUtil.toJsonStr(delMap));
    GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    printLog(delRequest, delResponse);
    Assertions.assertTrue(delResponse.isSuccess());
    logger.info("----结束执行----{}------", "门组管理-删除门组");
  }
  /**
   * 门禁管理->门组管理-门组详情
   *
   * <p>接口编号 accesscontrol_011
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/doorGroup/${id}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门组管理-门组详情")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_011_door_group_detail() throws ClientException {
    logger.info("----开始执行----{}------", "门组管理-门组详情");
    // 添加设备
    String url = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    Map<String, Object> map = new HashMap<>();
    map.put("name", doorGroupName);
    map.put("memo", doorGroupName);
    map.put("orgCode", "001");
    Map<String, Object> doorGroupDetail = new HashMap<>();
    doorGroupDetail.put("channelCode", channelCode);
    map.put("doorGroupDetail", Stream.of(doorGroupDetail).collect(Collectors.toList()));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    doorGoupId = JSONUtil.parseObj(response.getResult()).getInt("data");
    // 门组详情
    String detailUrl = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/%s";
    detailUrl = String.format(detailUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME), doorGoupId);
    GeneralRequest detailRequest = new GeneralRequest(detailUrl, Method.POST);
    GeneralResponse detailResponse =
        iClient.doAction(detailRequest, detailRequest.getResponseClass());
    printLog(detailRequest, detailResponse);
    Assertions.assertTrue(detailResponse.isSuccess());
    logger.info("----结束执行----{}------", "门组管理-门组详情");
  }
  /**
   * 门禁管理->门组管理-门组添加
   *
   * <p>接口编号 accesscontrol_008
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/doorGroup/bycondition/combined
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("门组管理-门组列表")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device ")
  public void accesscontrol_012_door_group_list() throws ClientException {
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/bycondition/combined";
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
    map.put("singleCondition", doorGroupName);
    request.setBody(JSONUtil.toJsonStr(map));
    response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
  }

  /**
   * 清数据
   *
   * @throws ClientException
   */
  private void existDel() throws ClientException {
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/bycondition/combined";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("singleCondition", doorGroupName);
    map.put("pageNum", 1);
    map.put("pageSize", 20);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    if (response.isSuccess()) {
      JSONObject obj = JSONUtil.parseObj(response.getResult());
      JSONArray pageData = obj.getJSONObject("data").getJSONArray("pageData");
      List<Integer> doorGroupIds = new ArrayList<>();
      for (Object pd : pageData) {
        JSONObject dc = (JSONObject) pd;
        doorGroupIds.add(dc.getInt("id"));
      }
      if (doorGroupIds.isEmpty()) {
        // 结束运行，无需删除
        return;
      }
      // 1、设置url版本
      String delUrl = "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/delete/batch";
      delUrl = String.format(delUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
      // 2、拼接必填参数
      Map<String, Object> delMap = new HashMap<>();
      delMap.put("doorGroupIds", doorGroupIds);
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
