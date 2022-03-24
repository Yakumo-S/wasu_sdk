package com.wasu.evo_accesscontrol;

import com.wasu.hutool.http.Method;
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

import java.util.HashMap;
import java.util.Map;

/**
 * API文档-门禁管理-设备树
 *
 * @author 232676
 * @since 1.0.0 2021/1/14 10:52
 */
public class DeviceTreeTest extends ExtentUtils {
  private static final String SYSTEM_NAME = "evo-accesscontrol";

  @BeforeAll
  static void beforeClass() {}

  @AfterAll
  static void afterClass() {}

  /**
   * 根据条件满足是否执行
   *
   * @return
   */
  boolean isSupport() {
    try {
      IClient iClient = new DefaultClient();
      return IccProfile.systemVersionMap.containsKey(SYSTEM_NAME);
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 门禁管理->设备树->设备树搜索接口
   *
   * <p>接口编号 accesscontrol_001
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/resource/tree/search
   *
   * <p>因客户端token=[bearer 36ea79c2-289f-416e-84e9-51519c06ca99]，无法解析用户ID，导致接口报错
   *
   * <p>密码认证方式token=[bearer 1:e3ad3f61-ba65-4c2c-a129-9eedd25fe3be],携带1:uuid,此问题需要子系统修复
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备树搜索接口（客户端认证）")
  @Tag("门禁管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not install [evo-accesscontrol]")
  public void accesscontrol_001_device_search_client() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/resource/tree/search";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("typeCode", "01;0;8;7");
    IClient iClient = new DefaultClient();
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数
    GeneralRequest notRequiredRequest = new GeneralRequest(url, Method.POST);
    String body =
        "{\"showStatus\":true,\"typeCode\":\"01;0;8;7\",\"hasCheckBox\":false,\"hideEmptyOrg\":true,\"searchKey\":\"455\",\"allowRFID\":false,\"deviceGenre\":\"0\",\"filterDeviceModel\":\"25\"}";
    notRequiredRequest.setBody(body);
    GeneralResponse notRequiredresponse =
        iClient.doAction(notRequiredRequest, notRequiredRequest.getResponseClass());
    printLog(notRequiredRequest, notRequiredresponse);
    Assertions.assertTrue(notRequiredresponse.isSuccess());
  }
  /**
   * 门禁管理->设备树->设备树搜索接口
   *
   * <p>接口编号 accesscontrol_001
   *
   * <p>方法类型 get
   *
   * <p>接口地址 /evo-apigw/evo-accesscontrol/${version}/resource/tree/search
   *
   * <p>因客户端token=[bearer 36ea79c2-289f-416e-84e9-51519c06ca99]，无法解析用户ID，导致接口报错
   *
   * <p>密码认证方式token=[bearer 1:e3ad3f61-ba65-4c2c-a129-9eedd25fe3be],携带1:uuid,此问题需要子系统修复
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备树搜索接口（密码认证）")
  @Tag("门禁管理")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not install [evo-accesscontrol]")
  public void accesscontrol_001_device_search_password() throws ClientException {
    // 1、设置url版本
    String url = "/evo-apigw/evo-accesscontrol/%s/resource/tree/search";
    url = String.format(url, IccProfile.systemVersionMap.get(SYSTEM_NAME));
    // 2、拼接必填参数
    Map<String, Object> map = new HashMap<>();
    map.put("typeCode", "01;0;8;7");
    IClient iClient =
        new DefaultClient(
            IccProfile.host,
            IccProfile.username,
            IccProfile.password,
            IccProfile.pwdClientId,
            IccProfile.pwdClientSecret);
    GeneralRequest request = new GeneralRequest(url, Method.POST);
    request.setBody(JSONUtil.toJsonStr(map));
    GeneralResponse response = iClient.doAction(request, request.getResponseClass());
    printLog(request, response);
    Assertions.assertTrue(response.isSuccess());
    // 3、拼接非必填参数,即贴近文档参数
    GeneralRequest notRequiredRequest = new GeneralRequest(url, Method.POST);
    String body =
        "{\"showStatus\":true,\"typeCode\":\"01;0;8;7\",\"hasCheckBox\":false,\"hideEmptyOrg\":true,\"searchKey\":\"455\",\"allowRFID\":false,\"deviceGenre\":\"0\",\"filterDeviceModel\":\"25\"}";
    notRequiredRequest.setBody(body);
    GeneralResponse notRequiredresponse =
        iClient.doAction(notRequiredRequest, notRequiredRequest.getResponseClass());
    printLog(notRequiredRequest, notRequiredresponse);
    Assertions.assertTrue(notRequiredresponse.isSuccess());
  }

  @BeforeEach
  public void before() throws ClientException {
    // 清理内存缓存的token，否则可能用例执行失败
    TokenHandleSingle.getInstance().getTokenMap().clear();
  }
}
