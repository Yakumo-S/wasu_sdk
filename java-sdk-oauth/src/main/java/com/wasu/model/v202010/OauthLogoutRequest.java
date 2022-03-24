package com.wasu.model.v202010;

import com.wasu.hutool.http.Method;
import com.wasu.icc.exception.ClientException;
import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;

/**
 * 注销授权信息，需要鉴权
 *
 * <p>无请求参数，需请求头
 *
 * <p>Authorization-鉴权信息(必填)
 *
 * <p>openId -微信用户唯一表示（非必填）
 *
 * <p>User-Client-客户端标识位（非必填）
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthLogoutRequest extends AbstractIccRequest<OauthLogoutResponse> {
  /** openId请求头，非必填 */
  private String openId;
  /** User-Client，非必填 */
  private String userClient;

  public OauthLogoutRequest() throws ClientException {
    super(OauthConstant.url(OauthConstant.OAUTH_URL_LOGOUT_GET), Method.GET, Boolean.TRUE);
  }

  @Override
  public Class<OauthLogoutResponse> getResponseClass() {
    return OauthLogoutResponse.class;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
    header("openId", openId);
  }

  public String getUserClient() {
    return userClient;
  }

  public void setUserClient(String userClient) {
    this.userClient = userClient;
    header("User-Client", userClient);
  }
}
