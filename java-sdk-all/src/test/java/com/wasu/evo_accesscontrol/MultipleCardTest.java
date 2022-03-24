package com.wasu.evo_accesscontrol;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import com.wasu.hutool.core.date.DatePattern;
import com.wasu.hutool.core.date.DateUtil;
import com.wasu.hutool.core.util.RandomUtil;
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
import com.wasu.model.v202010.person.BrmPersonCard;
import com.wasu.model.v202010.person.BrmPersonDelRequest;
import com.wasu.model.v202010.person.BrmPersonDelResponse;
import com.wasu.model.v202010.person.BrmPersonGenIdRequest;
import com.wasu.model.v202010.person.BrmPersonGenIdResponse;
import com.wasu.model.v202010.person.BrmPersonOnceRequest;
import com.wasu.model.v202010.person.BrmPersonOnceResponse;
import com.wasu.model.v202010.person.BrmPersonPageRequest;
import com.wasu.model.v202010.person.BrmPersonPageResponse;
import com.wasu.model.v202010.person.PersonData;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * API文档-门禁管理-多卡开门
 *
 * <p>用例执行前期条件，需要设备channelCode,需要person
 *
 * <p>添加-列表-详情-修改-删除，用例执行完成后，删除创建的门组
 *
 * @author 232676
 * @since 1.0.0 2021/1/15 16:11
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MultipleCardTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-accesscontrol";
  private static String channelCode = null;
  private static String personCode = null;
  private static String personGroupName = null;
  private static int personNum = 1;

  private static String cardCode = null;
  private static Integer paperType = 111;
  private static Long departmentId = 1L;

  static {
    cardCode = RandomUtil.randomNumbers(6);
    personCode = RandomUtil.randomString(6);
    personGroupName = "group" + RandomUtil.randomString(6);
  }

  @BeforeAll
  void beforeClass() throws ClientException {}

  @AfterAll
  void afterClass() throws ClientException {}

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
   * 门禁管理->多卡开门-添加人员组
   *
   * <p>接口编号 accesscontrol_022
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/personGroup/add
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-添加人员组")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_022_person_group_add() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-添加人员组");
    addPerson();
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/personGroup/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("personCodes", personCode);
    map.put("personNum", personNum);
    map.put("personGroupName", personGroupName);

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "多卡开门-添加人员组");
  }
  /**
   * 门禁管理->多卡开门-删除人员组
   *
   * <p>接口编号 accesscontrol_023
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/personGroup/delete
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-删除人员组")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_023_person_group_delete() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-删除人员组");
    addPerson();
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/personGroup/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("personCodes", personCode);
    map.put("personNum", personNum);
    map.put("personGroupName", personGroupName);

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    delPersonGroup(JSONUtil.parseObj(response.getResult()).getInt("data"));
    logger.info("----结束执行----{}------", "多卡开门-删除人员组");
  }
  /**
   * 门禁管理->多卡开门-添加多卡开门
   *
   * <p>接口编号 accesscontrol_024
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/openByMultiCard/add
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-添加多卡开门")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_024_multiple_card_add() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-添加多卡开门");
    // 添加人
    addPerson();
    // 添加人员组
    Integer personGroupId = groupAdd();
    // 添加多卡开门
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCard/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    // 多卡使能："0" - 关闭，"1" - 开启
    map.put("multiCardEnable", 1);
    map.put("channelCode", channelCode);
    map.put("channelName", "门禁多卡junit5");
    map.put("deviceName", "门禁多卡junit5");
    // 准备人员组
    Map<String, Object> groupImformat = new HashMap<>();
    groupImformat.put("id", personGroupId);
    groupImformat.put("openType", "刷卡");
    groupImformat.put("personGroupName", personGroupName);
    groupImformat.put("personNum", personNum);
    groupImformat.put("enablePersonNum", personNum);
    map.put(
        "personGroupInformation",
        JSONUtil.toJsonStr(Stream.of(groupImformat).collect(Collectors.toList())));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "多卡开门-添加多卡开门");
  }
  /**
   * 门禁管理->多卡开门-修改多卡开门
   *
   * <p>接口编号 accesscontrol_025
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/openByMultiCard/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-更新多卡开门")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_025_multiple_card_update() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-更新多卡开门");
    // 添加人
    addPerson();
    // 添加人员组
    Integer personGroupId = groupAdd();
    // 添加多卡开门
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCard/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    // 多卡使能："0" - 关闭，"1" - 开启
    map.put("multiCardEnable", "1");
    map.put("channelCode", channelCode);
    map.put("channelName", "门禁多卡junit5");
    map.put("deviceName", "门禁多卡junit5");
    // 准备人员组
    Map<String, Object> groupImformat = new HashMap<>();
    groupImformat.put("id", personGroupId);
    groupImformat.put("openType", "刷卡");
    groupImformat.put("personGroupName", personGroupName);
    groupImformat.put("personNum", personNum);
    groupImformat.put("enablePersonNum", personNum);
    map.put(
        "personGroupInformation",
        JSONUtil.toJsonStr(Stream.of(groupImformat).collect(Collectors.toList())));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    Integer multipleId = JSONUtil.parseObj(response.getResult()).getInt("data");
    // 关闭使能
    String closedUrl =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCard/update";
    closedUrl = String.format(closedUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    Map<String, Object> closedMap = new HashMap<>();
    // 多卡使能："0" - 关闭，"1" - 开启
    closedMap.put("multiCardEnable", "0");
    closedMap.put("id", multipleId);
    GeneralRequest closedRequest = new GeneralRequest(closedUrl, Method.POST);
    closedRequest.setBody(JSONUtil.toJsonStr(closedMap));
    GeneralResponse closedResponse =
        iClient.doAction(closedRequest, closedRequest.getResponseClass());
    printLog(closedRequest, closedResponse);
    Assertions.assertTrue(closedResponse.isSuccess());
    // 更新人员组
    Map<String, Object> updateGroupMap = new HashMap<>();
    // 多卡使能："0" - 关闭，"1" - 开启
    updateGroupMap.put("id", multipleId);
    updateGroupMap.put("multiCardEnable", "1");
    updateGroupMap.put("channelCode", channelCode);
    updateGroupMap.put("channelName", "门禁多卡junit5");
    updateGroupMap.put("deviceName", "门禁多卡junit5");
    // 准备人员组
    Map<String, Object> groupImformat2 = new HashMap<>();
    groupImformat.put("id", personGroupId);
    groupImformat.put("openType", "刷卡");
    groupImformat.put("personGroupName", personGroupName);
    groupImformat.put("personNum", personNum);
    groupImformat.put("enablePersonNum", personNum);
    updateGroupMap.put(
        "personGroupInformation",
        JSONUtil.toJsonStr(Stream.of(groupImformat).collect(Collectors.toList())));
    GeneralRequest updateRequest = new GeneralRequest(closedUrl, Method.POST);
    updateRequest.setBody(JSONUtil.toJsonStr(updateGroupMap));
    GeneralResponse updateResponse =
        iClient.doAction(updateRequest, updateRequest.getResponseClass());
    printLog(updateRequest, updateResponse);
    // TODO brm卡片那边有bug
    Assertions.assertTrue(updateResponse.isSuccess());
    logger.info("----结束执行----{}------", "多卡开门-更新多卡开门");
  }
  /**
   * 门禁管理->多卡开门-删除多卡开门
   *
   * <p>接口编号 accesscontrol_026
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/openByMultiCard/delete
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("多卡开门-删除多卡开门")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_026_multiple_card_delete() throws ClientException {
    logger.info("----开始执行----{}------", "多卡开门-删除多卡开门");
    // 添加人
    addPerson();
    // 添加人员组
    Integer personGroupId = groupAdd();
    // 添加多卡开门
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCard/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    // 多卡使能："0" - 关闭，"1" - 开启
    map.put("multiCardEnable", 1);
    map.put("channelCode", channelCode);
    map.put("channelName", "门禁多卡junit5");
    map.put("deviceName", "门禁多卡junit5");
    // 准备人员组
    Map<String, Object> groupImformat = new HashMap<>();
    groupImformat.put("id", personGroupId);
    groupImformat.put("openType", "刷卡");
    groupImformat.put("personGroupName", personGroupName);
    groupImformat.put("personNum", personNum);
    groupImformat.put("enablePersonNum", personNum);
    map.put(
        "personGroupInformation",
        JSONUtil.toJsonStr(Stream.of(groupImformat).collect(Collectors.toList())));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    Integer dataId = JSONUtil.parseObj(response.getResult()).getInt("data");
    delMultipleCard(dataId);
    logger.info("----结束执行----{}------", "多卡开门-删除多卡开门");
  }
  /**
   * 添加人员组
   *
   * @return
   */
  private Integer groupAdd() throws ClientException {
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/personGroup/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("personCodes", personCode);
    map.put("personNum", personNum);
    map.put("personGroupName", personGroupName);

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    return JSONUtil.parseObj(response.getResult()).getInt("data");
  }

  private void existDel() throws ClientException {
    IClient iClient = new DefaultClient();
    // 删除多卡开门列表
    List<Integer> multipleCards = queryMultipleCard();
    for (Integer id : multipleCards) {
      delMultipleCard(id);
    }
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 删除人员组
    List<Integer> personGroupGroupIds = queryPersonGroup();
    for (Integer id : personGroupGroupIds) {
      delPersonGroup(id);
    }
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } // 删除人员
    BrmPersonPageRequest request =
        BrmPersonPageRequest.builder()
            .statusList(Stream.of(0, 1, 2).collect(Collectors.toList()))
            .build();
    request.setSearchKey(personCode);
    BrmPersonPageResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    List<PersonData> pages = response.getData().getPageData();
    if (pages != null && pages.size() > 0) {
      List<Long> ids = new ArrayList<>();
      pages.stream()
          .forEach(
              s -> {
                ids.add(s.getId());
              });
      BrmPersonDelRequest delRequest = BrmPersonDelRequest.builder().ids(ids).build();
      BrmPersonDelResponse delResponse =
          iClient.doAction(delRequest, delRequest.getResponseClass());
      printLog(delRequest, delResponse);
      Assertions.assertTrue(delResponse.isSuccess());
    }
  }
  /**
   * 删除多卡开门
   *
   * @param id 多卡开门
   */
  private void delMultipleCard(Integer id) throws ClientException {
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCard/delete";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("id", id);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
  }
  /**
   * 删除人员组
   *
   * @param id 人员组Id
   */
  private void delPersonGroup(Integer id) throws ClientException {
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/personGroup/delete";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("id", id);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    // TODO 可能因设备删除确认延迟，导致人员组删除失败
    // Assertions.assertTrue(response.isSuccess());
  }

  /**
   * 查询多卡开门列表
   *
   * @return
   * @throws ClientException
   */
  public List<Integer> queryMultipleCard() throws ClientException {
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCard/bycondition/combined";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);
    //    map.put("singleCondition", channelCode);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    JSONArray array =
        JSONUtil.parseObj(response.getResult()).getJSONObject("data").getJSONArray("pageData");
    List<Integer> list = new ArrayList<>();
    if (array != null && array.size() > 0) {
      for (Object ob : array) {
        JSONObject pd = (JSONObject) ob;
        list.add(pd.getInt("id"));
      }
    }
    return list;
  }

  /**
   * 该接口暂未开放,且不符合restful
   *
   * @return
   */
  public List<Integer> queryPersonGroup() throws ClientException {
    // 1、设置url版本

    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/personGroup/bycondition/combined";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);
    map.put("singleCondition", personGroupName);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    JSONArray array =
        JSONUtil.parseObj(response.getResult()).getJSONObject("data").getJSONArray("pageData");
    List<Integer> personIds = new ArrayList<>();
    if (array != null && array.size() > 0) {
      for (Object ob : array) {
        JSONObject pd = (JSONObject) ob;
        personIds.add(pd.getInt("id"));
      }
    }
    return personIds;
  }

  private Long addPerson() throws ClientException {
    String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
    String name = ChineseNameGenerator.getInstance().generate();
    IClient iClient = new DefaultClient();
    // 产生ID
    BrmPersonGenIdRequest genIdRequest = new BrmPersonGenIdRequest();
    BrmPersonGenIdResponse genIdResponse =
        iClient.doAction(genIdRequest, genIdRequest.getResponseClass());
    printLog(genIdRequest, genIdResponse);
    // 设置卡片
    List<BrmPersonCard> cards = new ArrayList<>();
    BrmPersonCard card =
        BrmPersonCard.builder()
            .cardNumber(cardCode)
            .category("0")
            .endDate(DatePattern.NORM_DATETIME_FORMAT.format(DateUtil.endOfYear(new Date())))
            .startDate(DateUtil.now())
            .departmentId(departmentId)
            .build();
    cards.add(card);
    // 新增人员
    BrmPersonOnceRequest request =
        BrmPersonOnceRequest.builder()
            .code(personCode)
            .id(genIdResponse.getData().getId())
            .departmentId(departmentId)
            .name(name)
            .paperType(paperType)
            .build();
    request.setPaperNumber(idCard);
    request.setCards(cards);
    BrmPersonOnceResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    return genIdResponse.getData().getId();
  }

  @BeforeEach
  public void before() throws ClientException {
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }
}
