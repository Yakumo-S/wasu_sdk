package com.wasu.evo_ipms;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import com.wasu.hutool.core.date.DatePattern;
import com.wasu.hutool.core.date.DateUtil;
import com.wasu.hutool.http.Method;
import com.wasu.icc.exception.ClientException;
import com.wasu.handle.TokenHandleSingle;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.model.v202010.GeneralRequest;
import com.wasu.model.v202010.GeneralResponse;
import com.wasu.profile.IccProfile;
import com.wasu.ExtentUtils;
import com.wasu.model.v202010.person.BrmPersonCard;
import com.wasu.model.v202010.person.BrmPersonGenIdRequest;
import com.wasu.model.v202010.person.BrmPersonGenIdResponse;
import com.wasu.model.v202010.person.BrmPersonOnceRequest;
import com.wasu.model.v202010.person.BrmPersonOnceResponse;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.*;

/**
 * 停车场环境 10.80.3.101,10.80.4.55(自动化)
 *
 * <p>API文档-停车管理-信息查询
 *
 * @author 232676
 * @since 1.0.0 2021/1/14 10:52
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParkingInfoTest extends ExtentUtils {
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
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }

  @BeforeAll
  void beforeClass() throws ClientException {}

  @AfterAll
  static void afterClass() {}

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
    return true;
  }

  /**
   * 停车管理->信息查询-过车数据
   *
   * <p>接口编号 ipms_007
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/carcapture/find/conditions
   *
   * <p>卡口相机只要抓拍了，就会有一条数据,有车经过就拍
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("信息查询-过车数据")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_007_car_access_record() throws ClientException {
    logger.info("----开始执行----{}------", "信息查询-过车数据");
    String url = "/evo-apigw/ipms/carcapture/find/conditions";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 5);
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "信息查询-过车数据");
  }
  /**
   * 停车管理->信息查询-车辆进出数据
   *
   * <p>接口编号 ipms_008
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/caraccess/find/his
   *
   * <p>车辆一次停车一条数据，入场时生成一条记录，出场时更新该条记录的出场信息
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("信息查询-车辆进出数据")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_008_car_in_out_record() throws ClientException {
    logger.info("----开始执行----{}------", "信息查询-车辆进出数据");
    String url = "/evo-apigw/ipms/caraccess/find/his";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 5);
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "信息查询-车辆进出数据");
  }
  /**
   * 停车管理->信息查询-场区车位余位
   *
   * <p>接口编号 ipms_009
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/parkinglot/query
   *
   * <p>查询不同场区车位余位情况列表
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("信息查询-场区车位余位")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_009_parkinglot_query() throws ClientException {
    logger.info("----开始执行----{}------", "信息查询-场区车位余位");
    String url = "/evo-apigw/ipms/parkinglot/query";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    // TODO 没有请求参数？
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "信息查询-场区车位余位");
  }
  /**
   * 停车管理->信息查询-收费信息
   *
   * <p>接口编号 ipms_010
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/consume/record/list
   *
   * <p>车辆停车收费信息
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("信息查询-收费信息")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_010_parkinglot_consume_query() throws ClientException {
    logger.info("----开始执行----{}------", "信息查询-收费信息");
    String url = "/evo-apigw/ipms/consume/record/list";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    Map<String, Object> map = new HashMap<>();
    map.put("pageNum", 1);
    map.put("pageSize", 5);
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "信息查询-收费信息");
  }
  /**
   * 停车管理->信息查询-月卡用户查询上次充值信息
   *
   * <p>接口编号 ipms_011
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/ipms/month/card/recharge/find
   *
   * <p>车辆停车收费信息
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("信息查询-收费信息")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_011_recharge_query() throws ClientException {
    IClient iClient = new DefaultClient();
    // TODO 无法更改月卡用户，此接口存在与否意义不大
    //
    //    logger.info("----开始执行----{}------", "信息查询-收费信息");
    //    String queryUrl = "/evo-apigw/ipms/month/card/recharge/find";
    //    queryUrl = String.format(queryUrl, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    //    GeneralRequest queryRequest = new GeneralRequest(queryUrl, Method.GET);
    //    Map<String, Object> queryMap = new HashMap<>();
    //    queryMap.put("ownerId", );
    //    queryRequest.form(queryMap);
    //    GeneralResponse queryResponse = iClient.doAction(queryRequest,
    // queryRequest.getResponseClass());
    //    printLog(queryRequest, queryResponse);
    //    Assertions.assertTrue(queryResponse.isSuccess());
    //    logger.info("----结束执行----{}------", "信息查询-收费信息");
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
}
