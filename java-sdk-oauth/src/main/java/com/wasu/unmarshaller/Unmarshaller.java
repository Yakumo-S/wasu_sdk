package com.wasu.unmarshaller;

import com.wasu.icc.exception.ClientException;
import com.wasu.http.IccResponse;

/**
 * 协议转换接口
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public interface Unmarshaller {
  /**
   * 字符串转换对象
   *
   * @param clas 对象
   * @param content 字符串JSON
   * @param <T> 对象类
   * @return 返回转换对象
   * @throws ClientException 异常信息
   */
  <T extends IccResponse> T unmarshal(Class<T> clas, String content) throws ClientException;
}
