package com.wasu.model.v202010;

import com.wasu.constant.OauthConstant;
import com.wasu.http.AbstractIccRequest;
import com.wasu.hutool.http.Method;
import com.wasu.iot.exception.ClientException;

/**
 * 保活请求，需鉴权
 *
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmKeepAliveRequest extends AbstractIccRequest<BrmKeepAliveResponse> {
  /** 终端类型 ,1 web 2 client 3 app */
  private int clientType;
  /** 用户登录magicId */
  private String magicId;

  public BrmKeepAliveRequest() throws ClientException {
    super(OauthConstant.brmUrl(OauthConstant.BRM_URL_KEEP_ALIVE_POST), Method.POST);
  }

  @Override
  public Class<BrmKeepAliveResponse> getResponseClass() {
    return BrmKeepAliveResponse.class;
  }

  public int getClientType() {
    return clientType;
  }

  public void setClientType(int clientType) {
    this.clientType = clientType;
    putBodyParameter("clientType", clientType);
  }

  public String getMagicId() {
    return magicId;
  }

  public void setMagicId(String magicId) {
    this.magicId = magicId;
    putBodyParameter("magicId", magicId);
  }
}
