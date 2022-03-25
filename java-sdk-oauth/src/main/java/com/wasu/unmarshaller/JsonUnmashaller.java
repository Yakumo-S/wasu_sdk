package com.wasu.unmarshaller;

import com.wasu.http.IotResponse;
import com.wasu.hutool.json.JSONException;
import com.wasu.iot.exception.ClientException;
import com.wasu.iot.util.BeanUtil;

/**
 * json 转换
 *
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class JsonUnmashaller implements Unmarshaller {

  @Override
  public <T extends IotResponse> T unmarshal(Class<T> clazz, String content)
      throws ClientException {
    try {
      return BeanUtil.toBean(content, clazz);
    } catch (JSONException e) {
      throw newUnmarshalException(clazz, content, e);
    }
  }

  private ClientException newUnmarshalException(Class<?> clazz, String content, Exception e) {
    return new ClientException(
        "unmarshal response from json content failed, clazz = "
            + clazz.getSimpleName()
            + ", origin response = "
            + content);
  }
}
