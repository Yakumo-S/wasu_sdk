package com.wasu.md;

import com.wasu.hutool.http.Method;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IccTokenResponse;
import com.wasu.model.v202010.GeneralRequest;
import com.wasu.model.v202010.GeneralResponse;

/**
 * @author 232676
 * @since 2020/10/29 10:35
 */
public class IccTokenDemo {

  public static void main(String[] args) throws ClientException {
    IClient iClient = new DefaultClient();

    IccTokenResponse.IccToken token = iClient.getAccessToken();
    System.out.println(token);

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
