package com.wasu.md;

import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IccTokenResponse;
import com.wasu.profile.IccProfile;

/**
 * @author 232676
 * @since 2020/10/29 10:35
 */
public class IccTokenDemo {

  public static void main(String[] args) throws ClientException {
    IClient iClient = new DefaultClient();
    IccTokenResponse.IccToken token = iClient.getAccessToken(IccProfile.grantType);
    System.out.println(token);
  }
}
