package com.wasu.profile;

/**
 * 授权类型
 *
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public enum GrantType {
  /** 密码认证鉴权 */
  password,
  /** 客户端认证鉴权 */
  client_credentials,
  /** 只刷新token使用 */
  refresh_token
}
