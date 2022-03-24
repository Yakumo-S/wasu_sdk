package com.wasu.evo_brm;

import com.wasu.hutool.core.util.StrUtil;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.ExtentUtils;
import com.wasu.model.v202010.device.BrmDevice;
import com.wasu.model.v202010.device.BrmDeviceChannelPageRequest;
import com.wasu.model.v202010.device.BrmDeviceChannelPageResponse;
import com.wasu.model.v202010.device.BrmDevicePageRequest;
import com.wasu.model.v202010.device.BrmDevicePageResponse;
import com.wasu.model.v202010.device.BrmDeviceQueryRequest;
import com.wasu.model.v202010.device.BrmDeviceQueryResponse;
import com.wasu.model.v202010.device.BrmDeviceSyncRequest;
import com.wasu.model.v202010.device.BrmDeviceSyncResponse;
import com.wasu.model.v202010.device.BrmDeviceTreeRequest;
import com.wasu.model.v202010.device.BrmDeviceTreeResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.List;

/**
 * 基础资源-部门管理
 *
 * @author 232676
 * @since 2021/01/22 09:39
 */
public class DeviceTest extends ExtentUtils {
  private static String deviceCode = null;
  private static final String SYSTEM_NAME = "evo-brm";

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
      BrmDeviceSyncRequest deviceSyncRequest = new BrmDeviceSyncRequest();
      BrmDeviceSyncResponse deviceSyncResponse =
          iClient.doAction(deviceSyncRequest, deviceSyncRequest.getResponseClass());
      Assertions.assertTrue(deviceSyncResponse.isSuccess());
      List<BrmDevice> pages = deviceSyncResponse.getData().getPageData();
      if (pages != null && !pages.isEmpty()) {
        for (BrmDevice bd : pages) {
          deviceCode = bd.getDeviceCode();
          if (StrUtil.isNotBlank(deviceCode)) {
            return true;
          }
        }
      }
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 基础资源->设备管理-详情
   *
   * <p>接口编号 evo_brm_017
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/device/{deviceCode}
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-详情")
  @Tag("基础资源")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [evo-brm] or without  device")
  public void evo_brm_017_device_query() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-详情");
    IClient iClient = new DefaultClient();
    BrmDeviceQueryRequest deviceQueryRequest = new BrmDeviceQueryRequest(deviceCode);
    BrmDeviceQueryResponse brmDeviceQueryResponse =
        iClient.doAction(deviceQueryRequest, deviceQueryRequest.getResponseClass());
    printLog(deviceQueryRequest, brmDeviceQueryResponse);
    Assertions.assertTrue(brmDeviceQueryResponse.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-详情");
  }
  /**
   * 基础资源->设备管理-设备分页查询
   *
   * <p>接口编号 evo_brm_018
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/device/subsystem/page
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-分页查询")
  @Tag("基础资源")
  @EnabledIf(value = "isSupport", disabledReason = "enverionment not [evo-brm] or without  device")
  public void evo_brm_018_device_sub_page() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-分页查询");
    IClient iClient = new DefaultClient();
    BrmDevicePageRequest devicePageRequest = new BrmDevicePageRequest();
    BrmDevicePageResponse devicePageResponse =
        iClient.doAction(devicePageRequest, devicePageRequest.getResponseClass());
    Assertions.assertTrue(devicePageResponse.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-分页查询");
  }
  /**
   * 基础资源->设备管理-设备树
   *
   * <p>接口编号 evo_brm_019
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/device/tree
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-设备树")
  @Tag("基础资源")
  public void evo_brm_019_device_tree() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-设备树");
    IClient iClient = new DefaultClient();
    BrmDeviceTreeRequest deviceTreeRequest = new BrmDeviceTreeRequest();
    //    deviceTreeRequest.setAct("search");
    //    deviceTreeRequest.setSearchKey("10.35.183.80");
    //    deviceTreeRequest.setId("001");
    deviceTreeRequest.setType("001;1;1");
    deviceTreeRequest.setCheckStat(1);
    BrmDeviceTreeResponse deviceTreeResponse =
        iClient.doAction(deviceTreeRequest, deviceTreeRequest.getResponseClass());
    Assertions.assertTrue(deviceTreeResponse.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-设备树");
  }
  /**
   * 基础资源->设备管理-通道分页查询
   *
   * <p>接口编号 evo_brm_020
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/device/channel/subsystem/page
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-通道分页查询")
  @Tag("基础资源")
  public void evo_brm_020_device_channel_page() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-通道分页查询");
    IClient iClient = new DefaultClient();
    BrmDeviceChannelPageRequest channelPageRequest = new BrmDeviceChannelPageRequest();
    BrmDeviceChannelPageResponse channelPageResponse =
        iClient.doAction(channelPageRequest, channelPageRequest.getResponseClass());
    Assertions.assertTrue(channelPageResponse.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-通道分页查询");
  }
  /**
   * 基础资源->设备管理-全量同步
   *
   * <p>接口编号 evo_brm_020
   *
   * <p>方法类型 post
   *
   * <p>接口地址 /evo-apigw/evo-brm/${version}/device/channel/subsystem/page
   *
   * @throws ClientException
   */
  @Test
  @DisplayName("设备管理-全量同步")
  @Tag("基础资源")
  public void evo_brm_021_device_sync() throws ClientException {
    logger.info("----开始执行----{}------", "设备管理-全量同步");
    IClient iClient = new DefaultClient();
    BrmDeviceSyncRequest deviceSyncRequest = new BrmDeviceSyncRequest();
    BrmDeviceSyncResponse deviceSyncResponse =
        iClient.doAction(deviceSyncRequest, deviceSyncRequest.getResponseClass());
    Assertions.assertTrue(deviceSyncResponse.isSuccess());
    logger.info("----结束执行----{}------", "设备管理-全量同步");
  }
}
