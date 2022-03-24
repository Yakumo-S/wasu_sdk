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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * API文档-门禁管理-首卡开门 *
 *
 * <p>用例执行前期条件，需要设备channelCode,需要person
 *
 * <p>添加-列表-详情-修改-删除，用例执行完成后，删除创建的门组
 *
 * @author 232676
 * @since 1.0.0 2021/1/15 16:11
 */
public class FirstCardTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-accesscontrol";
  private static String channelCode = null;
  private static String personCode = null;
  private static String cardCode = null;
  private static Integer paperType = 111;
  private static Long departmentId = 1L;

  static {
    cardCode = RandomUtil.randomNumbers(6);
    personCode = RandomUtil.randomString(6);
  }

  @BeforeAll
  static void beforeClass() {}

  @AfterAll
  static void afterClass() {}

  @BeforeEach
  void beforeEach() throws ClientException {
    existDel();
  }

  @AfterEach
  void afterEach() throws ClientException {}
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
   * 门禁管理->首卡开门-添加
   *
   * <p>接口编号 accesscontrol_018
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/openByFirstCard/add
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("首卡开门-添加卡片")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_018_first_card_add() throws ClientException {
    logger.info("----开始执行----{}------", "首卡开门-添加卡片");
    addPerson();
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("personCode", personCode);
    map.put("channelCode", channelCode);
    map.put("firstCardOpenTime", "默认计划");
    map.put("firstCardOpenTimeId", "1");
    map.put("firstCardStatus", "正常");

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());

    logger.info("----结束执行----{}------", "首卡开门-添加卡片");
  }
  /**
   * 门禁管理->首卡开门-修改
   *
   * <p>接口编号 accesscontrol_019
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/openByFirstCard/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("首卡开门-修改")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_019_first_card_update() throws ClientException {
    logger.info("----开始执行----{}------", "首卡开门-修改卡片");
    // 无法获取id，无法修改
    Assertions.assertTrue(Boolean.FALSE);
    logger.info("----结束执行----{}------", "首卡开门-修改卡片");
  }
  /**
   * 门禁管理->首卡开门-删除
   *
   * <p>接口编号 accesscontrol_019
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/openByFirstCard/update
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("首卡开门-删除")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_020_first_card_delete() throws ClientException {
    logger.info("----开始执行----{}------", "首卡开门-添加卡片");
    addPerson();
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("personCode", personCode);
    map.put("channelCode", channelCode);
    map.put("firstCardOpenTime", "默认计划");
    map.put("firstCardOpenTimeId", "1");
    map.put("firstCardStatus", "正常");

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 删除多卡开门
    Integer multCardId = JSONUtil.parseObj(response.getResult()).getInt("data");
    String delUrl =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/delete";
    delUrl = String.format(delUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    Map<String, Object> delMap = new HashMap<>();
    delMap.put("id", multCardId);
    GeneralRequest delRequest = new GeneralRequest(delUrl, Method.POST);
    // TODO 需整改
    delRequest.body(JSONUtil.toJsonStr(delMap));
    GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    printLog(delRequest, delResponse);
    Assertions.assertTrue(delResponse.isSuccess());

    logger.info("----结束执行----{}------", "首卡开门-删除卡片");
  }
  /**
   * 门禁管理->首卡开门-首卡列表
   *
   * <p>接口编号 accesscontrol_021
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/openByFirstCard/bycondition/combined
   *
   * <p>注意 该接口变态,参数使用了[form]表单数据提交格式,已要求整改
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("首卡开门-首卡列表")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_021_first_card_list() throws ClientException {
    logger.info("----开始执行----{}------", "首卡开门-首卡列表");
    // 1、设置url版本
    String url =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/bycondition/combined";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);

    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    // TODO 需整改
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());

    logger.info("----结束执行----{}------", "首卡开门-首卡列表");
  }
  /**
   * 门禁管理->首卡开门-首卡列表
   *
   * <p>接口编号 accesscontrol_021
   *
   * <p>方法类型 post
   *
   * <p>接口地址
   * /evo-apigw/evo-accesscontrol/${version}/card/accessControl/channelAuthManage/openByFirstCard/bycondition/combined
   *
   * <p>注意 该接口变态,参数使用了[form]表单数据提交格式,已要求整改
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("首卡开门-首卡列表")
  @Tag("门禁管理")
  @EnabledIf(
      value = "isSupport",
      disabledReason = "enverionment not [evo-accesscontrol] or without device")
  public void accesscontrol_021_first_card_list_b() throws ClientException {
    logger.info("----开始执行----{}------", "首卡开门-首卡列表");
    // 该接口参数风格突变，需新接口替代
    Assertions.assertTrue(Boolean.FALSE);
    logger.info("----结束执行----{}------", "首卡开门-首卡列表");
  }

  //  private void existDel() throws ClientException {
  //    IClient iClient = new DefaultClient();
  //    // 删除人员
  //    BrmPersonPageRequest request =
  //        BrmPersonPageRequest.builder()
  //            .statusList(Stream.of(0, 1, 2).collect(Collectors.toList()))
  //            .build();
  //    request.setSearchKey(personCode);
  //    BrmPersonPageResponse response = iClient.doAction(request, request.getResponseClass());
  //    Assertions.assertTrue(response.isSuccess());
  //    List<PersonData> pages = response.getData().getPageData();
  //    if (pages != null && pages.size() > 0) {
  //      List<Long> ids = new ArrayList<>();
  //      pages.stream()
  //          .forEach(
  //              s -> {
  //                ids.add(s.getId());
  //              });
  //      BrmPersonDelRequest delRequest = BrmPersonDelRequest.builder().ids(ids).build();
  //      BrmPersonDelResponse delResponse =
  //          iClient.doAction(delRequest, delRequest.getResponseClass());
  //      Assertions.assertTrue(delResponse.isSuccess());
  //    }
  //  }
  private void existDel() throws ClientException {
    IClient iClient = new DefaultClient();
    // 删除人员
    BrmPersonPageRequest request =
        BrmPersonPageRequest.builder()
            .statusList(Stream.of(0, 1, 2).collect(Collectors.toList()))
            .build();
    request.setSearchKey(personCode);
    BrmPersonPageResponse response = iClient.doAction(request, request.getResponseClass());
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
      Assertions.assertTrue(delResponse.isSuccess());
    }
    // 删除计划
    String listUrl =
        "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/bycondition/combined";
    listUrl = String.format(listUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);

    GeneralRequest listRequest = new GeneralRequest(listUrl, Method.POST);
    // TODO 需整改
    listRequest.form(map);
    GeneralResponse listResponse = iClient.doAction(listRequest, listRequest.getResponseClass());
    printLog(listRequest, listResponse);
    Assertions.assertTrue(listResponse.isSuccess());
    JSONArray array =
        JSONUtil.parseObj(listResponse.getResult()).getJSONObject("data").getJSONArray("pageData");
    if (array != null && array.size() > 0) {
      for (Object ob : array) {
        JSONObject card = (JSONObject) ob;
        Integer id = card.getInt("id");
        String chanCode = card.getStr("channelCode");
        if (id != null && channelCode.equals(chanCode)) {
          // 删除计划
          String delUrl =
              "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/delete";
          delUrl = String.format(delUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
          // 2、拼接必填参数
          Map<String, Object> delMap = new HashMap<>();
          delMap.put("id", id);
          GeneralRequest delRequest = new GeneralRequest(delUrl, Method.POST);
          // TODO 需整改
          delRequest.body(JSONUtil.toJsonStr(delMap));
          GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
          printLog(delRequest, delResponse);
//          Assertions.assertTrue(delResponse.isSuccess());
        }
      }
    }
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
