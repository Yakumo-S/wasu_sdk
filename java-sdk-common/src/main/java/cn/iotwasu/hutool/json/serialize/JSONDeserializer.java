package cn.iotwasu.hutool.json.serialize;

import cn.iotwasu.hutool.json.JSON;

/**
 * JSON反序列话自定义实现类
 *
 * @author Looly
 * @param <T> 反序列化后的类型
 */
public interface JSONDeserializer<T> {

  /**
   * 反序列化，通过实现此方法，自定义实现JSON转换为指定类型的逻辑
   *
   * @param json {@link JSON}
   * @return 目标对象
   */
  T deserialize(JSON json);
}
