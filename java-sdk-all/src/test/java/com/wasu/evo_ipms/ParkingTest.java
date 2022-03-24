package com.wasu.evo_ipms;

import com.wasu.hutool.http.Method;
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
 * 停车场环境 10.80.3.101,10.80.4.55(自动化,稳定)
 *
 * <p>API文档-停车管理-车场设置
 *
 * @author 232676
 * @since 1.0.0 2021/1/14 10:52
 */
public class ParkingTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "ipms";
  private static String channelCode = null;
  private static Integer doorGoupId = null;
  private final String doorGroupName = "junit5";

  static {
    try {
      IClient pwdiClient =
          new DefaultClient("10.80.4.55", "liulihai", "ea452bb4-7942-4546-b445-b2a15e76fa57");
    } catch (ClientException e) {
      e.printStackTrace();
    }
  }

  @BeforeAll
  static void beforeClass() {}

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
   * 停车管理->车场设置-查询车场的车位和余位信息
   *
   * <p>接口编号 ipms_001
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/ipms/parkinglot/stat
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车场设置-查询车场的车位和余位信息")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_001_parking_stat() throws ClientException {
    logger.info("----开始执行----{}------", "车场设置-查询车场的车位和余位信息");
    // 添加前删除数据
    // 1、设置url版本
    String url = "/evo-apigw/ipms/parkinglot/stat";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车场设置-查询车场的车位和余位信息");
  }
  /**
   * 停车管理->车场设置-停车场列表
   *
   * <p>接口编号 ipms_016
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/ipms/map/getParkingLotNameList
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车场设置-停车场列表")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_016_parklot_list() throws ClientException {
    logger.info("----开始执行----{}------", "车场设置-停车场列表");
    String url = "/evo-apigw/ipms/map/getParkingLotNameList";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车场设置-停车场列表");
  }
  /**
   * 停车管理->车场设置-停车场组织
   *
   * <p>接口编号 ipms_017
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/ipms/api/evo/org
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("车场设置-停车场组织")
  @Tag("停车管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [ipms]")
  public void ipms_017_park_org() throws ClientException {
    logger.info("----开始执行----{}------", "车场设置-停车场组织");
    String url = "/evo-apigw/ipms/map/getParkingLotNameList";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    IClient iClient = new DefaultClient();
    Map<String, Object> map = new HashMap<>();
    map.put("method", "ORG.CHECK");
    map.put("param", "");
    GeneralRequest request = new GeneralRequest(url, Method.GET);
    request.form(map);
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    logger.info("----结束执行----{}------", "车场设置-停车场组织");
  }

  @BeforeEach
  public void before() throws ClientException {
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }
}
