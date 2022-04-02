package cn.iotwasu.hutool.json.serialize;

import cn.iotwasu.hutool.json.JSONArray;

/**
 * JSON列表的序列化接口，用于将特定对象序列化为{@link JSONArray}
 *
 * @param <V> 对象类型
 * @author Looly
 */
public interface JSONArraySerializer<V> extends JSONSerializer<JSONArray, V> {}
