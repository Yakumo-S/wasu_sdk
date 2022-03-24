package com.wasu.evo_ipms;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import com.wasu.hutool.core.date.DatePattern;
import com.wasu.hutool.core.date.DateUtil;
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
 * 停车场环境 10.80.3.101,10.80.4.55(自动化)
 *
 * <p>API文档-停车管理-设备管理
 *
 * @author 232676
 * @since 1.0.0 2021/2/01 10:52
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeviceTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "ipms";
  private static String personCode = "junit5ICC006";
  private static String carCode = "zheA8A8ME";
  private static String cardCode = "3623221996";

  private static Integer paperType = 111;
  private static Long departmentId = 1L;
  private static String carNum = "浙A8A8ME";

  static {
    try {
      IClient pwdiClient =
          new DefaultClient("10.80.4.55", "liulihai", "ea452bb4-7942-4546-b445-b2a15e76fa57");
    } catch (ClientException e) {
      e.printStackTrace();
    }
  }

  @BeforeEach
  public void before() throws ClientException {
    existDel();

    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }

  @BeforeAll
  void beforeClass() throws ClientException {}

  @AfterAll
  static void afterClass() {}

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
    return true;
  }

  /**
   * 停车管理->车辆管理-led设备信息
   *
   * <p>接口编号 ipms_012
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/api/evo/device/led/{type}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-led设备信息")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_012_device_led_info() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-led设备信息");
    // 屏幕类型：1诱导屏、2余位屏、3通用屏
    String url = "/evo-apigw/ipms/api/evo/device/led/%s";
    url = String.format(url, 1);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 屏幕类型：1诱导屏、2余位屏、3通用屏
    url = "/evo-apigw/ipms/api/evo/device/led/%s";
    url = String.format(url, 2);
    GeneralRequest request2 = new GeneralRequest(url, Method.GET);
    GeneralResponse response2 = iClient.doAction(request2, request2.getResponseClass());
    printLog(request2, response2);
    Assertions.assertTrue(response.isSuccess());
    // 屏幕类型：1诱导屏、2余位屏、3通用屏
    url = "/evo-apigw/ipms/api/evo/device/led/%s";
    url = String.format(url, 3);
    GeneralRequest request3 = new GeneralRequest(url, Method.GET);
    GeneralResponse response3 = iClient.doAction(request3, request3.getResponseClass());
    printLog(request3, response3);
    Assertions.assertTrue(response3.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-led设备信息");
  }
  /**
   * 停车管理->车辆管理-获取公钥
   *
   * <p>接口编号 ipms_013
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/rsa/getPubKey
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-获取公钥")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_013_device_pubkey() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-获取公钥");
    String url = "/evo-apigw/ipms/rsa/getPubKey";
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-获取公钥");
  }
  /**
   * 停车管理->车辆管理-可用服务信息
   *
   * <p>接口编号 ipms_014
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/api/evo/device/server/{category}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-可用服务信息")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_014_device_server_list() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-可用服务信息");
    // 设备大类 35 出入口设备，36道闸设备，37显示设备
    String url = "/evo-apigw/ipms/api/evo/device/server/%s";
    url = String.format(url, 35);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 设备大类 35 出入口设备，36道闸设备，37显示设备
    url = "/evo-apigw/ipms/api/evo/device/server/%s";
    url = String.format(url, 36);
    GeneralRequest request2 = new GeneralRequest(url, Method.GET);
    GeneralResponse response2 = iClient.doAction(request2, request2.getResponseClass());
    printLog(request2, response2);
    Assertions.assertTrue(response.isSuccess());
    // 设备大类 35 出入口设备，36道闸设备，37显示设备
    url = "/evo-apigw/ipms/api/evo/device/server/%s";
    url = String.format(url, 37);
    GeneralRequest request3 = new GeneralRequest(url, Method.GET);
    GeneralResponse response3 = iClient.doAction(request3, request3.getResponseClass());
    printLog(request3, response3);
    Assertions.assertTrue(response3.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-可用服务信息");
  }
  /**
   * 停车管理->车辆管理-道闸信息
   *
   * <p>接口编号 ipms_015
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/device/sluice/channel
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-道闸信息")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_015_device_sluice() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-道闸信息");
    String url = "/evo-apigw/ipms/device/sluice/channel";
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-道闸信息");
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

  private void deleteCar(String id) throws ClientException {
    logger.info("----开始执行----{}------", "车辆管理-车辆删除");
    // 1、设置url版本
    String url = "/evo-apigw/ipms/car/delete/%s";
    url = String.format(url, id);
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-车辆删除");
  }

  private List<String> queryCar() throws ClientException {
    logger.info("----开始执行----{}------", "车辆管理-车辆列表");
    // 1、设置url版本
    String url = "/evo-apigw/ipms/car/list";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);
    map.put("carNumLikeStr", carNum);
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-车辆列表");

    List<String> cardIds = new ArrayList<>();
    if (response.isSuccess()) {
      JSONObject obj = JSONUtil.parseObj(response.getResult());
      JSONArray pageData = obj.getJSONObject("data").getJSONArray("pageData");
      if (pageData.isEmpty()) {
        return cardIds;
      }
      String carId = ((JSONObject) pageData.get(0)).getStr("id");
      if (StrUtil.isNotBlank(carId)) {
        cardIds.add(carId);
      }
    }
    return cardIds;
  }

  private void existDel() throws ClientException {
    IClient iClient = new DefaultClient();
    // 删除车辆
    List<String> cardIds = queryCar();
    if (!cardIds.isEmpty()) {
      for (String id : cardIds) {
        deleteCar(id);
      }
    }
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
  }
}
