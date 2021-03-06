package cn.iotwasu.iot.util;

import cn.iotwasu.hutool.core.lang.TypeReference;
import cn.iotwasu.hutool.json.JSONUtil;

/**
 * json-bean 工具类
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public class BeanUtil {

  public static <T> T toBean(String jsonString, TypeReference<T> typeReference) {
    return JSONUtil.toBean(jsonString, typeReference.getType(), true);
  }

  public static <T> T toBean(String jsonString, Class<T> t) {
    return JSONUtil.toBean(jsonString, t);
  }
}
