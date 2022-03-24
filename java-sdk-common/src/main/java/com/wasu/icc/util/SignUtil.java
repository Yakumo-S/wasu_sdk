/*
 * Copyright 2017 Baidu, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.wasu.icc.util;

import com.wasu.hutool.core.codec.Base64;
import com.wasu.icc.exception.IccException;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class SignUtil {
  private static final char[] DIGITS;

  static {
    DIGITS =
        new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
  }

  /**
   * RSA公钥加密
   *
   * @param str 加密字符串
   * @param publicKey 公钥
   * @return 密文
   */
  public static String encryptRSA(String str, String publicKey) {
    // base64编码的公钥
    try {
      byte[] decoded = Base64.decode(publicKey);
      RSAPublicKey pubKey =
          (RSAPublicKey)
              KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
      // RSA加密
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.ENCRYPT_MODE, pubKey);
      String outStr = Base64.encode(cipher.doFinal(str.getBytes("UTF-8")));
      return outStr;
    } catch (Exception e) {

    }
    return null;
  }

  public static String hmacSha256(String key, String data) throws IccException {
    try {
      Mac mac = Mac.getInstance("HmacSHA256");
      SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), mac.getAlgorithm());
      mac.init(signingKey);
      return encodeHex(mac.doFinal(data.getBytes()));
    } catch (Exception e) {
      e.printStackTrace();
      throw new IccException(-1, "Fail to generate HMAC-SHA256 signature");
    }
  }

  public static String md5(String data, String charset) {
    try {
      byte[] msg = data.getBytes(charset);
      MessageDigest md = MessageDigest.getInstance("MD5");
      return encodeHex(md.digest(msg));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static String encodeHex(byte[] data) {
    int l = data.length;
    char[] out = new char[l << 1];
    int i = 0;

    for (int j = 0; i < l; ++i) {
      out[j++] = DIGITS[(240 & data[i]) >>> 4];
      out[j++] = DIGITS[15 & data[i]];
    }

    return new String(out);
  }
}
