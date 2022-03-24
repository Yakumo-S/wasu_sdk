package com.wasu.md;

import com.wasu.hutool.http.Method;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.model.v202010.GeneralRequest;
import com.wasu.model.v202010.GeneralResponse;

/**
 * @author 232676
 * @since 2020/10/29 10:35
 */
public class IccTokenDemo2 {

  public static void main(String[] args) throws ClientException {
    IClient iClient = new DefaultClient();
    /**
     * 1、请求地址是统一网关入口，以 /evo-apigw 开头
     * 2、方法参见 @see com.dahuatech.hutool.http.Method
     */
    GeneralRequest generalRequest = new GeneralRequest("/evo-apigw/evo-xxx/pathxxx", Method.GET);
    // post body
    generalRequest.body("json请求体");
    // get param 例如?name=xiao&mobile=1xxx
    generalRequest.form("key", "value");
    // set header
    generalRequest.header("key", "value");
    GeneralResponse generalResponse =
        iClient.doAction(generalRequest, generalRequest.getResponseClass());
  }
}
