package cn.iotwasu.unmarshaller;

import cn.iotwasu.http.IotResponse;
import cn.iotwasu.iot.exception.ClientException;

/**
 * 协议转换接口
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
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
  <T extends IotResponse> T unmarshal(Class<T> clas, String content) throws ClientException;
}
