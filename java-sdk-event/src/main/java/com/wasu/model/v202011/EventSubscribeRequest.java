package com.wasu.model.v202011;

import com.wasu.hutool.http.Method;
import com.wasu.constant.EventConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 事件订阅请求
 *
 * <p>事件订阅接口,对外监听类型（monitorType）是url，要求post请求无鉴权或者鉴权固定带在url上能访问，参数为json形式的对象（通用事件格式）。
 *
 * <p>另外需要访问保活接口保活，如果异常断开，保活会通知我，删除订阅信息。保活接口在同一API文档--基础资源--用户管理。
 *
 * @author 232676
 * @since 1.0.0 2020/11/16 20:33
 */
public class EventSubscribeRequest extends AbstractIccRequest<EventSubscribeResponse> {

  public EventSubscribeRequest() throws ClientException {
    super(EventConstant.url(EventConstant.EVENT_URL_SUBSCRIBE_POST), Method.POST);
  }

  @Override
  public Class<EventSubscribeResponse> getResponseClass() {
    return EventSubscribeResponse.class;
  }
}
