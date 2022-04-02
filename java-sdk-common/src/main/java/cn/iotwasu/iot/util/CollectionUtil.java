package cn.iotwasu.iot.util;

import java.util.Collection;
import java.util.Map;

/**
 * 集合相关工具类
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public class CollectionUtil {

  /**
   * 集合是否为空
   *
   * @param collection 集合
   * @return 是否为空
   */
  public static boolean isEmpty(Collection<?> collection) {
    return collection == null || collection.isEmpty();
  }

  /**
   * Map是否为空
   *
   * @param map 集合
   * @return 是否为空
   */
  public static boolean isEmpty(Map<?, ?> map) {
    return null == map || map.isEmpty();
  }
}
