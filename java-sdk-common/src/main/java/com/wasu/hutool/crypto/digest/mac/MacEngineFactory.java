package com.wasu.hutool.crypto.digest.mac;

import com.wasu.hutool.crypto.SmUtil;
import com.wasu.hutool.crypto.digest.HmacAlgorithm;

import javax.crypto.SecretKey;

/**
 * {@link com.wasu.hutool.crypto.digest.mac.MacEngine} 实现工厂类
 *
 * @author Looly
 * @since 4.5.13
 */
public class MacEngineFactory {

  /**
   * 根据给定算法和密钥生成对应的{@link com.wasu.hutool.crypto.digest.mac.MacEngine}
   *
   * @param algorithm 算法，见{@link HmacAlgorithm}
   * @param key 密钥
   * @return {@link com.wasu.hutool.crypto.digest.mac.MacEngine}
   */
  public static MacEngine createEngine(String algorithm, SecretKey key) {
    if (algorithm.equalsIgnoreCase(HmacAlgorithm.HmacSM3.getValue())) {
      // HmacSM3算法是BC库实现的
      return SmUtil.createHmacSm3Engine(key.getEncoded());
    }
    return new DefaultHMacEngine(algorithm, key);
  }
}
