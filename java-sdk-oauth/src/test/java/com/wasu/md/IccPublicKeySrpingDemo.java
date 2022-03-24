package com.wasu.md;

import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.model.v202010.OauthPublicKeyRequest;
import com.wasu.model.v202010.OauthPublicKeyResponse;

/**
 * @author 232676
 * @since 2020/10/29 10:35
 */
public class IccPublicKeySrpingDemo {

  public static void main(String[] args) throws ClientException {

    IClient iClient = new DefaultClient();
    // 公钥Request model
    OauthPublicKeyRequest publicKeyRequest = new OauthPublicKeyRequest();
    // 公钥Response model
    OauthPublicKeyResponse publicKey =
        iClient.doAction(publicKeyRequest, publicKeyRequest.getResponseClass());
    String pey = publicKey.getData().getPublicKey();
    System.out.println("获得公钥  " + publicKey.getData().getPublicKey());
  }
}
