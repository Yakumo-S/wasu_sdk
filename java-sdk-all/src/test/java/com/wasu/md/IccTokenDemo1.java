package com.wasu.md;

import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IccTokenResponse;
import com.wasu.profile.GrantType;

/**
 * @author 232676
 * @since 2020/10/29 10:35
 */
public class IccTokenDemo1 {

  public static void main(String[] args) throws ClientException {
    IClient iClient =
        new DefaultClient("10.35.183.106", "system", "dahua2020", "web_client", "web_client");
    IccTokenResponse.IccToken accessToken = iClient.getAccessToken(GrantType.password);
    System.out.println(accessToken);
    IClient iClient2 = new DefaultClient("10.35.183.106", "oauth_client", "oauth_client");
    IccTokenResponse.IccToken accessToken2 = iClient2.getAccessToken(GrantType.client_credentials);
    System.out.println(accessToken2);
    IccTokenResponse.IccToken accessToken3 = iClient2.getAccessToken();
    System.out.println(accessToken3);
  }
}
