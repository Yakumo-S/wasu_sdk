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
 * <p>API文档-停车管理-车辆管理
 *
 * @author 232676
 * @since 1.0.0 2021/1/14 10:52
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarControlTest extends ExtentUtils {
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
   * 停车管理->车辆管理-查询车场的车位和余位信息
   *
   * <p>接口编号 ipms_001
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/parkinglot/stat
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车辆管理-查询车场的车位和余位信息")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_001_parking_stat() throws ClientException {
    logger.info("----开始执行----{}------", "车辆管理-查询车场的车位和余位信息");
    // 添加前删除数据
    // 1、设置url版本
    String url = "/evo-apigw/ipms/parkinglot/stat";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-查询车场的车位和余位信息");
  }
  /**
   * 停车管理->车辆管理-添加车辆
   *
   * <p>接口编号 ipms_002
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/ipms/car/add
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车辆管理-添加车辆")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_002_car_add() throws ClientException {
    logger.info("----开始执行----{}------", "车辆管理-添加车辆");
    Long uid = addPerson();
    // 1、设置url版本
    String url = "/evo-apigw/ipms/car/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    Map<String, Object> map = new HashMap<>();
    map.put("carCode", carCode);
    map.put("carNum", carNum);
    map.put("carColor", "0");
    map.put("carNumColor", "0");
    map.put("carType", "1");
    map.put("ownerId", uid);
    map.put("carBrand", 1);
    map.put("deptId", departmentId);
    request.body(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-添加车辆");
  }
  /**
   * 停车管理->车辆管理-更新车辆
   *
   * <p>接口编号 ipms_002
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/ipms/car/add
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车辆管理-更新车辆")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_003_car_update() throws ClientException {
    logger.info("----开始执行----{}------", "车辆管理-添加车辆");
    Long uid = addPerson();
    // 1、设置url版本
    String url = "/evo-apigw/ipms/car/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    Map<String, Object> map = new HashMap<>();
    map.put("carCode", carCode);
    map.put("carNum", carNum);
    map.put("carColor", "0");
    map.put("carNumColor", "0");
    map.put("carType", "1");
    map.put("ownerId", uid);
    map.put("carBrand", 1);
    map.put("deptId", departmentId);
    request.body(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-添加车辆");
    logger.info("----开始执行----{}------", "车辆管理-更新车辆");
    // 1、设置url版本
    String updateUrl = "/evo-apigw/ipms/car/update";
    updateUrl = String.format(updateUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    GeneralRequest updateRequest = new GeneralRequest(updateUrl, Method.POST);
    Map<String, Object> updateMap = new HashMap<>();
    updateMap.put("id", JSONUtil.parseObj(response.getResult()).getStr("data"));
    updateMap.put("carNum", carNum);
    updateMap.put("carCode", carCode);
    updateMap.put("carColor", "0");
    updateMap.put("carNumColor", "0");
    updateMap.put("carType", "2");
    updateMap.put("ownerId", uid);
    updateMap.put("carBrand", 1);
    updateMap.put("deptId", departmentId);
    updateRequest.body(JSONUtil.toJsonStr(updateMap));
    GeneralResponse updateResponse =
        iClient.doAction(updateRequest, updateRequest.getResponseClass());
    printLog(updateRequest, updateResponse);
    Assertions.assertTrue(updateResponse.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-更新车辆");
  }
  /**
   * 停车管理->车辆管理-车辆删除
   *
   * <p>接口编号 ipms_004
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/car/delete/{id}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车辆管理-车辆删除")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_004_car_delete() throws ClientException {
    logger.info("----开始执行----{}------", "车辆管理-添加车辆");
    Long uid = addPerson();
    // 1、设置url版本
    String url = "/evo-apigw/ipms/car/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    Map<String, Object> map = new HashMap<>();
    map.put("carCode", carCode);
    map.put("carNum", carNum);
    map.put("carColor", "0");
    map.put("carNumColor", "0");
    map.put("carType", "1");
    map.put("ownerId", uid);
    map.put("carBrand", 1);
    map.put("deptId", departmentId);
    request.body(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-添加车辆");
    logger.info("----开始执行----{}------", "车辆管理-车辆删除");
    // 1、设置url版本
    String deleteUrl = "/evo-apigw/ipms/car/delete/%s";
    deleteUrl = String.format(deleteUrl, JSONUtil.parseObj(response.getResult()).getStr("data"));
    GeneralRequest delRequest = new GeneralRequest(deleteUrl, Method.GET);
    GeneralResponse delResponse = iClient.doAction(delRequest, delRequest.getResponseClass());
    printLog(delRequest, delResponse);
    Assertions.assertTrue(delResponse.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-车辆删除");
  }
  /**
   * 停车管理->车辆管理-车辆列表
   *
   * <p>接口编号 ipms_002
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/car/list
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车辆管理-车辆列表")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_005_car_list() throws ClientException {
    logger.info("----开始执行----{}------", "车辆管理-车辆列表");
    // 1、设置url版本
    String url = "/evo-apigw/ipms/car/list";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 20);
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-车辆列表");
  }
  /**
   * 停车管理->车辆管理-车辆详情
   *
   * <p>接口编号 ipms_006
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/car/find/{id}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车辆管理-车辆详情")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_006_car_detail() throws ClientException {
    logger.info("----开始执行----{}------", "车辆管理-添加车辆");
    Long uid = addPerson();
    // 1、设置url版本
    String url = "/evo-apigw/ipms/car/add";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    Map<String, Object> map = new HashMap<>();
    map.put("carCode", carCode);
    map.put("carNum", carNum);
    map.put("carColor", "0");
    map.put("carNumColor", "0");
    map.put("carType", "1");
    map.put("ownerId", uid);
    map.put("carBrand", 1);
    map.put("deptId", departmentId);
    request.body(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-添加车辆");

    logger.info("----开始执行----{}------", "车辆管理-车辆详情");
    // 1、设置url版本
    String detailUrl = "/evo-apigw/ipms/car/find/%s";
    detailUrl = String.format(detailUrl, JSONUtil.parseObj(response.getResult()).getStr("data"));
    GeneralRequest detailRequest = new GeneralRequest(detailUrl, Method.GET);
    GeneralResponse detailResponse =
        iClient.doAction(detailRequest, detailRequest.getResponseClass());
    printLog(detailRequest, detailResponse);
    Assertions.assertTrue(detailResponse.isSuccess());
    logger.info("----结束执行----{}------", "车辆管理-车辆详情");
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
