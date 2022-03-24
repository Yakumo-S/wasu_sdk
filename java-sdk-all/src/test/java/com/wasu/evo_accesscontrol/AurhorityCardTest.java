package com.wasu.evo_accesscontrol;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import com.wasu.hutool.core.date.DatePattern;
import com.wasu.hutool.core.date.DateUtil;
import com.wasu.hutool.core.util.RandomUtil;
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
 * API文档-门禁管理-常开常闭计划
 *
 * <p>用例执行前期条件，需要设备channelCode,且设备在线
 *
 * @author 232676
 * @since 1.0.0 2021/1/20 08:11
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AurhorityCardTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-accesscontrol";
  private static String channelCode = null;
  private static String personCode = null;
  private static String cardCode = null;
  private static Integer paperType = 111;
  private static Long departmentId = 1L;

  @BeforeAll
  static void beforeClass() {}

  @AfterAll
  static void afterClass() {}

  @BeforeEach
  void beforeEach() throws ClientException {
    cardCode = RandomUtil.randomNumbers(6);
    personCode = RandomUtil.randomNumbers(6);
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
   * 门禁管理->按人（卡）授权-新增
   *
   * <p>接口编号 accesscontrol_031
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/1.0.0/card/accessControl/doorAuthority
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("按人（卡）授权-新增")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_031_auth_person_add() throws ClientException, InterruptedException {
    // TODO 需要测试门禁点，门组，梯控
    logger.info("----开始执行----{}------", "按人（卡）授权-新增");
    addPerson();
    TimeUnit.SECONDS.sleep(5);
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/1.0.0/card/accessControl/doorAuthority";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("timeQuantumId", 1);
    map.put("cardNumbers", Stream.of(cardCode).collect(Collectors.toList()));
    Map<String, Object> cardDetail = new HashMap<>();
    cardDetail.put("privilegeType", 1);
    cardDetail.put("resouceCode", channelCode);
    map.put("cardPrivilegeDetails", Stream.of(cardDetail).collect(Collectors.toList()));

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());

    logger.info("----结束执行----{}------", "按人（卡）授权-新增");
  }
  /**
   * 门禁管理->按人（卡）授权-更新
   *
   * <p>接口编号 accesscontrol_032
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/doorAuthority/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("按人（卡）授权-更新")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_032_auth_person_update() throws ClientException, InterruptedException {
    // TODO 需要测试门禁点，门组，梯控
    logger.info("----开始执行----{}------", "按人（卡）授权-新增");
    addPerson();
    TimeUnit.SECONDS.sleep(5);
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/1.0.0/card/accessControl/doorAuthority";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("timeQuantumId", 1);
    map.put("cardNumbers", Stream.of(cardCode).collect(Collectors.toList()));
    Map<String, Object> cardDetail = new HashMap<>();
    cardDetail.put("privilegeType", 1);
    cardDetail.put("resouceCode", channelCode);
    map.put("cardPrivilegeDetails", Stream.of(cardDetail).collect(Collectors.toList()));

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 门组授权
    String updateGroupUrl =
        "/evo-apigw/evo-accesscontrol/1.0.0/card/accessControl/doorAuthority/update";
    updateGroupUrl = String.format(updateGroupUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    GeneralRequest updateGroupRequest = new GeneralRequest(updateGroupUrl, Method.POST);

    Map<String, Object> updateMap = new HashMap<>();
    updateMap.put("timeQuantumId", 1);
    updateMap.put("cardNumber", cardCode);
    Map<String, Object> updateCardDetail = new HashMap<>();
    updateCardDetail.put("privilegeType", 1);
    updateCardDetail.put("resouceCode", channelCode);
    updateMap.put("cardPrivilegeDetails", Stream.of(updateCardDetail).collect(Collectors.toList()));

    updateGroupRequest.setBody(JSONUtil.toJsonStr(updateMap));

    GeneralResponse updateGroupResponse =
        iClient.doAction(updateGroupRequest, updateGroupRequest.getResponseClass());
    printLog(updateGroupRequest, updateGroupResponse);
    Assertions.assertTrue(updateGroupResponse.isSuccess());
    logger.info("----结束执行----{}------", "按人（卡）授权-新增");
  }
  /**
   * 门禁管理->按人（卡）授权-删除
   *
   * <p>接口编号 accesscontrol_033
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/card/accessControl/doorAuthority/delete/batch
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("按人（卡）授权-删除")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_033_auth_person_delete() throws ClientException, InterruptedException {
    // TODO 需要测试门禁点，门组，梯控
    logger.info("----开始执行----{}------", "按人（卡）授权-删除");
    addPerson();
    TimeUnit.SECONDS.sleep(5);
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/1.0.0/card/accessControl/doorAuthority";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("timeQuantumId", 1);
    map.put("cardNumbers", Stream.of(cardCode).collect(Collectors.toList()));
    Map<String, Object> cardDetail = new HashMap<>();
    cardDetail.put("privilegeType", 1);
    cardDetail.put("resouceCode", channelCode);
    map.put("cardPrivilegeDetails", Stream.of(cardDetail).collect(Collectors.toList()));

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 门组授权
    String delGroupUrl =
        "/evo-apigw/evo-accesscontrol/1.0.0/card/accessControl/doorAuthority/delete/batch";
    delGroupUrl = String.format(delGroupUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    GeneralRequest delRequest = new GeneralRequest(delGroupUrl, Method.POST);
    Map<String, Object> delMap = new HashMap<>();
    delMap.put("privilegeType", "1");
    delMap.put("cardNums", Stream.of(cardCode).collect(Collectors.toList()));
    delRequest.setBody(JSONUtil.toJsonStr(delMap));
    GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    printLog(delRequest, delResponse);
    Assertions.assertTrue(delResponse.isSuccess());
    logger.info("----结束执行----{}------", "按人（卡）授权-删除");
  }
  /**
   * 门禁管理->按人（卡）授权-授权查询
   *
   * <p>接口编号 accesscontrol_034
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/doorAuthority/bycondition/combined
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("按人（卡）授权-删除")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_034_auth_person_list() throws ClientException, InterruptedException {
    // TODO 需要测试门禁点，门组，梯控
    logger.info("----开始执行----{}------", "按人（卡）授权-删除");
    addPerson();
    TimeUnit.SECONDS.sleep(5);
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/1.0.0/card/accessControl/doorAuthority";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("timeQuantumId", 1);
    map.put("cardNumbers", Stream.of(cardCode).collect(Collectors.toList()));
    Map<String, Object> cardDetail = new HashMap<>();
    cardDetail.put("privilegeType", 1);
    cardDetail.put("resouceCode", channelCode);
    map.put("cardPrivilegeDetails", Stream.of(cardDetail).collect(Collectors.toList()));

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 门组授权
    String listUrl =
        "/evo-apigw/evo-accesscontrol/1.0.0/card/accessControl/doorAuthority/bycondition/combined";
    listUrl = String.format(listUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    GeneralRequest listRequest = new GeneralRequest(listUrl, Method.POST);
    Map<String, Object> listMap = new HashMap<>();
    listMap.put("pageNum", 1);
    listMap.put("pageSize",20);
    listMap.put("authorizeStatus",-1);
    listMap.put("taskStatus",-1);
    listMap.put("personCode",personCode);
    listMap.put("cardNumber",cardCode);




    listRequest.setBody(JSONUtil.toJsonStr(listMap));
    GeneralResponse delResponse = iClient.doAction(listRequest, listRequest.getResponseClass());
    printLog(listRequest, delResponse);
    Assertions.assertTrue(delResponse.isSuccess());
    logger.info("----结束执行----{}------", "按人（卡）授权-删除");
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

  private void existDel() throws ClientException {
    IClient iClient = new DefaultClient();
    // 删除人员
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

  @BeforeEach
  public void before() throws ClientException {
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }
}
