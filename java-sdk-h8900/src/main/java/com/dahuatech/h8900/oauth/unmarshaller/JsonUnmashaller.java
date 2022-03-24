package com.dahuatech.h8900.oauth.unmarshaller;

import com.dahuatech.hutool.json.JSONException;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.h8900.oauth.http.H8900Response;
import com.dahuatech.icc.util.BeanUtil;

/**
 * json 转换
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class JsonUnmashaller implements Unmarshaller {

  @Override
  public <T extends H8900Response> T unmarshal(Class<T> clazz, String content)
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
