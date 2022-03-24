package com.dahuatech.icc.dss;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 生成用户ID
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class DssPlayBackRequest extends AbstractIccRequest<DssPlayBackResponse> {

  public DssPlayBackRequest() throws ClientException {
    super("/evo-apigw/admin/API/BRM/Device/GetCurrentMediaVK", Method.POST);
  }

  @Override
  public Class<DssPlayBackResponse> getResponseClass() {
    return DssPlayBackResponse.class;
  }
}
