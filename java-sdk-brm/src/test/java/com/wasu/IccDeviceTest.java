package com.wasu;

import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
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
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 232676
 * @since 2020/10/21 16:39
 */
public class IccDeviceTest {

  /**
   * 设备详情
   *
   * @throws ClientException
   */
  @Test
  public void deviceQuery() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmDeviceQueryRequest deviceQueryRequest = new BrmDeviceQueryRequest("1000002");
    BrmDeviceQueryResponse brmDeviceQueryResponse =
        iClient.doAction(deviceQueryRequest, deviceQueryRequest.getResponseClass());
    Assert.assertTrue(brmDeviceQueryResponse.isSuccess());
  }
  /**
   * 设备分页查询
   *
   * @throws ClientException
   */
  @Test
  public void devicePage() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmDevicePageRequest devicePageRequest = new BrmDevicePageRequest();
    BrmDevicePageResponse devicePageResponse =
        iClient.doAction(devicePageRequest, devicePageRequest.getResponseClass());
    Assert.assertTrue(devicePageResponse.isSuccess());
  }
  /**
   * 设备树
   *
   * @throws ClientException
   */
  @Test
  public void deviceTree() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmDeviceTreeRequest deviceTreeRequest = new BrmDeviceTreeRequest();
    //    deviceTreeRequest.setAct("search");
    //    deviceTreeRequest.setSearchKey("10.35.183.80");
    //    deviceTreeRequest.setId("001");
    deviceTreeRequest.setType("001;1;1");
    deviceTreeRequest.setCheckStat(1);
    BrmDeviceTreeResponse deviceTreeResponse =
        iClient.doAction(deviceTreeRequest, deviceTreeRequest.getResponseClass());
    Assert.assertTrue(deviceTreeResponse.isSuccess());
  }
  /**
   * 设备树
   *
   * @throws ClientException
   */
  @Test
  public void deviceChannelPage() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmDeviceChannelPageRequest channelPageRequest = new BrmDeviceChannelPageRequest();
    BrmDeviceChannelPageResponse channelPageResponse =
        iClient.doAction(channelPageRequest, channelPageRequest.getResponseClass());
    Assert.assertTrue(channelPageResponse.isSuccess());
  }
  /**
   * 设备全量数据同步
   *
   * @throws ClientException
   */
  @Test
  public void deviceSync() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    BrmDeviceSyncRequest deviceSyncRequest = new BrmDeviceSyncRequest();
    BrmDeviceSyncResponse deviceSyncResponse =
        iClient.doAction(deviceSyncRequest, deviceSyncRequest.getResponseClass());
    Assert.assertTrue(deviceSyncResponse.isSuccess());
  }
}
