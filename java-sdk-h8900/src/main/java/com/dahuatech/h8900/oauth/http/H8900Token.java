package com.dahuatech.h8900.oauth.http;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class H8900Token {
    private String success;
    private String loginName;
    private String errMsg;
    private String token;
    private String id;
    private String cmsIp;
    private String cmsPort;
    private String orgCode;
    private String publicKey;
    private String nonce;
    private Long ttl;
    private String ipmsAccessToken;
    private Map<String,Object> param=new HashMap<>();

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    public String getIpmsAccessToken() {
        return ipmsAccessToken;
    }

    public void setIpmsAccessToken(String ipmsAccessToken) {
        this.ipmsAccessToken = ipmsAccessToken;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
        param.put("userName",loginName);

    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        param.put("token",token);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        param.put("userId",id);
    }

    public String getCmsIp() {
        return cmsIp;
    }

    public void setCmsIp(String cmsIp) {
        this.cmsIp = cmsIp;
    }

    public String getCmsPort() {
        return cmsPort;
    }

    public void setCmsPort(String cmsPort) {
        this.cmsPort = cmsPort;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    @Override public String toString() {
        return "H8900Token{" + "success='" + success + '\'' + ", loginName='" + loginName + '\'' + ", errMsg='" + errMsg
            + '\'' + ", token='" + token + '\'' + ", id='" + id + '\'' + ", cmsIp='" + cmsIp + '\'' + ", cmsPort='"
            + cmsPort + '\'' + ", orgCode='" + orgCode + '\'' + ", publicKey='" + publicKey + '\'' + ", nonce='" + nonce
            + '\'' + ", ttl=" + ttl + ", ipmsAccessToken='" + ipmsAccessToken + '\'' + '}';
    }
}
