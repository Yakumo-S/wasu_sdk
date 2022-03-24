package com.wasu.md;

import com.wasu.hutool.http.Method;
import com.wasu.hutool.json.JSONUtil;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IccTokenResponse;
import com.wasu.model.v202010.GeneralRequest;
import com.wasu.profile.GrantType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 232676
 * @since 2020/10/29 10:35
 */
public class IccTokenDemo1 {

  public static void main(String[] args) throws ClientException {


    IClient iClient =
        new DefaultClient("172.3.110.80", "system", "dahua2021", "ewrwe", "0f1f3927-b781-4d26-b8f6-198eef27bc0af");
    IccTokenResponse.IccToken accessToken = iClient.getAccessToken(GrantType.password);
    IccTokenResponse.IccToken accessToken3 = iClient.getAccessToken();
    System.out.println(accessToken3);

    GeneralRequest request=new GeneralRequest("/evo-apigw/evo-brm/1.0.0/device/search/channel", Method.POST);

    request.header("User-Client","1");
    Map<String,Object> map=new HashMap<>();
    map.put("pageSize",10);
    map.put("pageNum",1);
    request.body(JSONUtil.toJsonStr(map));
    String body=iClient.doAction(request);


    IClient iClient2 =
            new DefaultClient("172.3.110.80",  "ewrwe", "0f1f3927-b781-4d26-b8f6-98eef27bc0af");

    IccTokenResponse.IccToken accessToken4 = iClient.getAccessToken();
    System.out.println(accessToken4);

    GeneralRequest request2=new GeneralRequest("/evo-apigw/evo-brm/1.0.0/device/search/channel", Method.POST);

    request.header("User-Client","1");
    Map<String,Object> map1=new HashMap<>();
    map.put("pageSize",10);
    map.put("pageNum",1);
    request.body(JSONUtil.toJsonStr(map));
    String body2=iClient.doAction(request2);
    System.out.println(body2);
  }



}
