// package com.dahuatech.icc.test;
//
// import com.dahuatech.icc.event.model.v202011.EventSubscribeDelRequest;
// import com.dahuatech.icc.event.model.v202011.EventSubscribeDelResponse;
// import com.dahuatech.icc.event.model.v202011.EventSubscribeRequest;
// import com.dahuatech.icc.event.model.v202011.EventSubscribeResponse;
// import com.dahuatech.icc.exception.ClientException;
// import com.dahuatech.icc.oauth.http.DefaultClient;
// import com.dahuatech.icc.oauth.http.IClient;
// import org.junit.Assert;
//
/// **
//
// * @author 232676
// * @since 1.0.0 2020/11/17 15:05
// */
// public class SubscribeDemo {
//  public static void main(String[] args) throws ClientException {
//    unsub();
//    IClient iClient =
//        new DefaultClient("10.35.183.106", "system", "dahua2020", "web_client", "web_client");
//    EventSubscribeRequest subscribeRequest = new EventSubscribeRequest();
//    String mqinfo =
//
// "{\"param\":{\"monitors\":[{\"monitor\":\"http://10.33.67.173:8080/mq\",\"monitorType\":\"url\",\"events\":[{\"category\":\"business\",\"subscribeAll\":1,\"domainSubscribe\":0,\"scheme\":1,\"eventType\":0,\"authorities\":[],\"grades\":[1,2]},{\"category\":\"alarm\",\"subscribeAll\":1,\"domainSubscribe\":0,\"authorities\":[]}]}],\"subsystem\":{\"subsystemType\":1,\"name\":\"CAR\",\"magic\":\"ip_port\"}}}";
//    subscribeRequest.body(mqinfo);
//    EventSubscribeResponse subscribeResponse =
//        iClient.doAction(subscribeRequest, subscribeRequest.getResponseClass());
//    Assert.assertTrue(subscribeResponse.isSuccess());
//  }
//
//  public static void  unsub() throws ClientException {
//    IClient iClient =
//            new DefaultClient("10.35.183.106", "system", "dahua2020", "web_client", "web_client");
//    EventSubscribeDelRequest subscribeRequest = new EventSubscribeDelRequest("CAR");
//    String mqinfo =
//
// "{\"param\":{\"monitors\":[{\"monitor\":\"http://10.33.67.173:8080/mq\",\"monitorType\":\"url\",\"events\":[{\"category\":\"business\",\"subscribeAll\":1,\"domainSubscribe\":0,\"scheme\":1,\"eventType\":0,\"authorities\":[],\"grades\":[1,2,3]}]}],\"subsystem\":{\"subsystemType\":1,\"name\":\"CAR\",\"magic\":\"ip_port\"}}}";
//    subscribeRequest.body(mqinfo);
//    EventSubscribeDelResponse subscribeResponse =
//            iClient.doAction(subscribeRequest, subscribeRequest.getResponseClass());
//    Assert.assertTrue(subscribeResponse.isSuccess());
//  }
//
// }
