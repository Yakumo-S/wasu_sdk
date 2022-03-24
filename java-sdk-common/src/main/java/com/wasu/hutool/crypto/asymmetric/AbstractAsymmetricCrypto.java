package com.wasu.hutool.crypto.asymmetric;

import com.wasu.hutool.core.codec.BCD;
import com.wasu.hutool.core.codec.Base64;
import com.wasu.hutool.core.io.IORuntimeException;
import com.wasu.hutool.core.io.IoUtil;
import com.wasu.hutool.core.util.CharsetUtil;
import com.wasu.hutool.core.util.HexUtil;
import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.crypto.CryptoException;
import com.wasu.hutool.crypto.SecureUtil;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 抽象的非对称加密对象，包装了加密和解密为Hex和Base64的封装
 *
 * @param <T> 返回自身类型
 * @author Looly
 */
public abstract class AbstractAsymmetricCrypto<T extends AbstractAsymmetricCrypto<T>>
    extends BaseAsymmetric<T> {
  // ------------------------------------------------------------------ Constructor start

  /**
   * 构造
   *
   * <p>私钥和公钥同时为空时生成一对新的私钥和公钥<br>
   * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密
   *
   * @param algorithm 算法
   * @param privateKey 私钥
   * @param publicKey 公钥
   * @since 3.1.1
   */
  public AbstractAsymmetricCrypto(String algorithm, PrivateKey privateKey, PublicKey publicKey) {
    super(algorithm, privateKey, publicKey);
  }
  // ------------------------------------------------------------------ Constructor end

  // --------------------------------------------------------------------------------- Encrypt

  /**
   * 加密
   *
   * @param data 被加密的bytes
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return 加密后的bytes
   */
  public abstract byte[] encrypt(
      byte[] data, com.wasu.hutool.crypto.asymmetric.KeyType keyType);

  /**
   * 编码为Hex字符串
   *
   * @param data 被加密的bytes
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return Hex字符串
   */
  public String encryptHex(byte[] data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return HexUtil.encodeHexStr(encrypt(data, keyType));
  }

  /**
   * 编码为Base64字符串
   *
   * @param data 被加密的bytes
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return Base64字符串
   * @since 4.0.1
   */
  public String encryptBase64(byte[] data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return Base64.encode(encrypt(data, keyType));
  }

  /**
   * 加密
   *
   * @param data 被加密的字符串
   * @param charset 编码
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return 加密后的bytes
   */
  public byte[] encrypt(
      String data, String charset, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return encrypt(StrUtil.bytes(data, charset), keyType);
  }

  /**
   * 加密
   *
   * @param data 被加密的字符串
   * @param charset 编码
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return 加密后的bytes
   */
  public byte[] encrypt(
      String data, Charset charset, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return encrypt(StrUtil.bytes(data, charset), keyType);
  }

  /**
   * 加密，使用UTF-8编码
   *
   * @param data 被加密的字符串
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return 加密后的bytes
   */
  public byte[] encrypt(String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return encrypt(StrUtil.bytes(data, CharsetUtil.CHARSET_UTF_8), keyType);
  }

  /**
   * 编码为Hex字符串
   *
   * @param data 被加密的字符串
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return Hex字符串
   * @since 4.0.1
   */
  public String encryptHex(String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return HexUtil.encodeHexStr(encrypt(data, keyType));
  }

  /**
   * 编码为Hex字符串
   *
   * @param data 被加密的bytes
   * @param charset 编码
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return Hex字符串
   * @since 4.0.1
   */
  public String encryptHex(
      String data, Charset charset, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return HexUtil.encodeHexStr(encrypt(data, charset, keyType));
  }

  /**
   * 编码为Base64字符串，使用UTF-8编码
   *
   * @param data 被加密的字符串
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return Base64字符串
   * @since 4.0.1
   */
  public String encryptBase64(String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return Base64.encode(encrypt(data, keyType));
  }

  /**
   * 编码为Base64字符串
   *
   * @param data 被加密的字符串
   * @param charset 编码
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return Base64字符串
   * @since 4.0.1
   */
  public String encryptBase64(
      String data, Charset charset, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return Base64.encode(encrypt(data, charset, keyType));
  }

  /**
   * 加密
   *
   * @param data 被加密的数据流
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return 加密后的bytes
   * @throws IORuntimeException IO异常
   */
  public byte[] encrypt(InputStream data, com.wasu.hutool.crypto.asymmetric.KeyType keyType)
      throws IORuntimeException {
    return encrypt(IoUtil.readBytes(data), keyType);
  }

  /**
   * 编码为Hex字符串
   *
   * @param data 被加密的数据流
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return Hex字符串
   * @since 4.0.1
   */
  public String encryptHex(
      InputStream data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return HexUtil.encodeHexStr(encrypt(data, keyType));
  }

  /**
   * 编码为Base64字符串
   *
   * @param data 被加密的数据流
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return Base64字符串
   * @since 4.0.1
   */
  public String encryptBase64(
      InputStream data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return Base64.encode(encrypt(data, keyType));
  }

  /**
   * 分组加密
   *
   * @param data 数据
   * @param keyType 密钥类型
   * @return 加密后的密文
   * @throws CryptoException 加密异常
   * @since 4.1.0
   */
  public String encryptBcd(String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return encryptBcd(data, keyType, CharsetUtil.CHARSET_UTF_8);
  }

  /**
   * 分组加密
   *
   * @param data 数据
   * @param keyType 密钥类型
   * @param charset 加密前编码
   * @return 加密后的密文
   * @throws CryptoException 加密异常
   * @since 4.1.0
   */
  public String encryptBcd(
      String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType, Charset charset) {
    return BCD.bcdToStr(encrypt(data, charset, keyType));
  }

  // --------------------------------------------------------------------------------- Decrypt

  /**
   * 解密
   *
   * @param bytes 被解密的bytes
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return 解密后的bytes
   */
  public abstract byte[] decrypt(
      byte[] bytes, com.wasu.hutool.crypto.asymmetric.KeyType keyType);

  /**
   * 解密
   *
   * @param data 被解密的bytes
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return 解密后的bytes
   * @throws IORuntimeException IO异常
   */
  public byte[] decrypt(InputStream data, com.wasu.hutool.crypto.asymmetric.KeyType keyType)
      throws IORuntimeException {
    return decrypt(IoUtil.readBytes(data), keyType);
  }

  /**
   * 从Hex或Base64字符串解密，编码为UTF-8格式
   *
   * @param data Hex（16进制）或Base64字符串
   * @param keyType 私钥或公钥 {@link com.wasu.hutool.crypto.asymmetric.KeyType}
   * @return 解密后的bytes
   * @since 4.5.2
   */
  public byte[] decrypt(String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return decrypt(SecureUtil.decode(data), keyType);
  }

  /**
   * 解密为字符串，密文需为Hex（16进制）或Base64字符串
   *
   * @param data 数据，Hex（16进制）或Base64字符串
   * @param keyType 密钥类型
   * @param charset 加密前编码
   * @return 解密后的密文
   * @since 4.5.2
   */
  public String decryptStr(
      String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType, Charset charset) {
    return StrUtil.str(decrypt(data, keyType), charset);
  }

  /**
   * 解密为字符串，密文需为Hex（16进制）或Base64字符串
   *
   * @param data 数据，Hex（16进制）或Base64字符串
   * @param keyType 密钥类型
   * @return 解密后的密文
   * @since 4.5.2
   */
  public String decryptStr(String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return decryptStr(data, keyType, CharsetUtil.CHARSET_UTF_8);
  }

  /**
   * 解密BCD
   *
   * @param data 数据
   * @param keyType 密钥类型
   * @return 解密后的密文
   * @since 4.1.0
   */
  public byte[] decryptFromBcd(
      String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType) {
    return decryptFromBcd(data, keyType, CharsetUtil.CHARSET_UTF_8);
  }

  /**
   * 分组解密
   *
   * @param data 数据
   * @param keyType 密钥类型
   * @param charset 加密前编码
   * @return 解密后的密文
   * @since 4.1.0
   */
  public byte[] decryptFromBcd(
      String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType, Charset charset) {
    final byte[] dataBytes = BCD.ascToBcd(StrUtil.bytes(data, charset));
    return decrypt(dataBytes, keyType);
  }

  /**
   * 解密为字符串，密文需为BCD格式
   *
   * @param data 数据，BCD格式
   * @param keyType 密钥类型
   * @param charset 加密前编码
   * @return 解密后的密文
   * @since 4.5.2
   */
  public String decryptStrFromBcd(
      String data, com.wasu.hutool.crypto.asymmetric.KeyType keyType, Charset charset) {
    return StrUtil.str(decryptFromBcd(data, keyType, charset), charset);
  }

  /**
   * 解密为字符串，密文需为BCD格式，编码为UTF-8格式
   *
   * @param data 数据，BCD格式
   * @param keyType 密钥类型
   * @return 解密后的密文
   * @since 4.5.2
   */
  public String decryptStrFromBcd(String data, KeyType keyType) {
    return decryptStrFromBcd(data, keyType, CharsetUtil.CHARSET_UTF_8);
  }
}
