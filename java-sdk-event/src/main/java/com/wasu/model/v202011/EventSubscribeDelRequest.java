package com.wasu.model.v202011;

import com.wasu.hutool.http.Method;
import com.wasu.constant.EventConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 事件取消订阅请求
 *
 * @author 232676
 * @since 1.0.0 2020/11/16 20:33
 */
public class EventSubscribeDelRequest extends AbstractIccRequest<EventSubscribeDelResponse> {

  public EventSubscribeDelRequest(String name) throws ClientException {
    super(EventConstant.url(EventConstant.EVENT_URL_SUBSCRIBE_DEL_DELETE + name), Method.DELETE);
  }

  @Override
  public Class<EventSubscribeDelResponse> getResponseClass() {
    return EventSubscribeDelResponse.class;
  }
}
