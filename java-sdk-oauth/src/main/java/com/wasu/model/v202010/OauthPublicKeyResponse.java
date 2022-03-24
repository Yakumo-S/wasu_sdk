package com.wasu.model.v202010;

import com.wasu.http.IccResponse;

/**
 * 鉴权公钥
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class OauthPublicKeyResponse extends IccResponse {

  private PublicKeyData data;

  public PublicKeyData getData() {
    return data;
  }

  public void setData(PublicKeyData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "OauthPublicKeyResponse{" + "data=" + data + '}';
  }

  public static class PublicKeyData {
    private String publicKey;

    public String getPublicKey() {
      return publicKey;
    }

    public void setPublicKey(String publicKey) {
      this.publicKey = publicKey;
    }

    @Override
    public String toString() {
      return "PublicKeyData{" + "publicKey='" + publicKey + '\'' + '}';
    }
  }
}
