package com.wasu;

import com.wasu.hutool.core.lang.Console;
import com.wasu.model.v202011.EventSubscribeDelRequest;
import com.wasu.model.v202011.EventSubscribeDelResponse;
import com.wasu.model.v202011.EventSubscribeRequest;
import com.wasu.model.v202011.EventSubscribeResponse;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import org.junit.*;

/**
 * @author 232676
 * @since 2020/10/21 16:39
 */
public class IccEventTest {

  @BeforeClass
  public static void beforeClass() throws ClientException {
    Console.log("开始执行环境清理");

    Console.log("结束执行环境清理");
  }

  @Before
  public void before() throws ClientException {}

  @After
  public void after() throws ClientException {
    IClient iClient = new DefaultClient();
  }

  /**
   * 人员新增
   *
   * @throws ClientException
   */
  @Test
  public void eventSubscribe() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    EventSubscribeRequest subscribeRequest = new EventSubscribeRequest();
    String mqinfo =
        "{\"param\":{\"monitors\":[{\"monitor\":\"http://10.33.67.173:8080/mq\",\"monitorType\":\"url\",\"events\":[{\"category\":\"business\",\"subscribeAll\":1,\"domainSubscribe\":0,\"scheme\":1,\"eventType\":0,\"authorities\":[],\"grades\":[1,2]},{\"category\":\"alarm\",\"subscribeAll\":1,\"domainSubscribe\":0,\"authorities\":[]}]}],\"subsystem\":{\"subsystemType\":1,\"name\":\"ICCTEST\",\"magic\":\"ip_port\"}}}";
    subscribeRequest.body(mqinfo);
    EventSubscribeResponse subscribeResponse =
        iClient.doAction(subscribeRequest, subscribeRequest.getResponseClass());
    Assert.assertTrue(subscribeResponse.isSuccess());
  }
  /**
   * 人脸订阅
   *
   * @throws ClientException
   */
  @Test
  public void eventFaceSubscribe() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    EventSubscribeRequest subscribeRequest = new EventSubscribeRequest();
    String mqinfo =
        "{\"param\":{\"monitors\":[{\"monitor\":\"http://10.33.67.173:8080/mq\",\"monitorType\":\"url\",\"events\":[{\"category\":\"alarm\",\"subscribeAll\":1,\"domainSubscribe\":0,\"authorities\":[{\"types\":[\"1001006\",\"1001001\",\"1001000\",\"1001002\",\"1001003\",\"1001004\",\"1001005\",\"1001006\"]}]}]}],\"subsystem\":{\"subsystemType\":1,\"name\":\"ICCTEST\",\"magic\":\"ip_port\"}}}";
    subscribeRequest.body(mqinfo);
    EventSubscribeResponse subscribeResponse =
        iClient.doAction(subscribeRequest, subscribeRequest.getResponseClass());
    Assert.assertTrue(subscribeResponse.isSuccess());
  }
  /**
   * 车辆订阅 CAR
   *
   * @throws ClientException
   */
  @Test
  public void eventCAR() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    EventSubscribeRequest subscribeRequest = new EventSubscribeRequest();
    String mqinfo =
        "{\"param\":{\"monitors\":[{\"monitor\":\"http://10.33.67.173:8080/mq\",\"monitorType\":\"url\",\"events\":[{\"category\":\"business\",\"subscribeAll\":1,\"domainSubscribe\":0,\"scheme\":1,\"eventType\":0,\"authorities\":[],\"grades\":[1,2,3]}]}],\"subsystem\":{\"subsystemType\":1,\"name\":\"CAR\",\"magic\":\"ip_port\"}}}";
    subscribeRequest.body(mqinfo);
    EventSubscribeResponse subscribeResponse =
        iClient.doAction(subscribeRequest, subscribeRequest.getResponseClass());
    Assert.assertTrue(subscribeResponse.isSuccess());
  }
  /**
   * 人员新增
   *
   * @throws ClientException
   */
  @Test
  public void eventSubscribeDel() throws ClientException {
    // 新增
    IClient iClient = new DefaultClient();
    EventSubscribeDelRequest subscribeDelRequest = new EventSubscribeDelRequest("ICC-FACE");
    EventSubscribeDelResponse subscribeDelResponse =
        iClient.doAction(subscribeDelRequest, subscribeDelRequest.getResponseClass());

    EventSubscribeDelRequest delRequest = new EventSubscribeDelRequest("ICCTEST");
    EventSubscribeDelResponse delResponse =
        iClient.doAction(delRequest, delRequest.getResponseClass());

    EventSubscribeDelRequest carreq = new EventSubscribeDelRequest("CAR");
    EventSubscribeDelResponse carsp = iClient.doAction(carreq, carreq.getResponseClass());

    Assert.assertTrue(subscribeDelResponse.isSuccess());
  }
}
