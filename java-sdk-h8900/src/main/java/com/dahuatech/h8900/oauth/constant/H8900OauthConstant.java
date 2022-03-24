package com.dahuatech.h8900.oauth.constant;

import com.dahuatech.h8900.oauth.profile.H8900Profile;
import com.dahuatech.hutool.core.collection.CollectionUtil;
import com.dahuatech.hutool.core.util.ArrayUtil;
import com.dahuatech.hutool.core.util.StrUtil;

import java.util.*;

/**
 * @author 232676
 * @since 2021-05-17
 */
public class H8900OauthConstant {

    /**
     * 模块名称
     */
    public static final String SYSTEM_NAME = "admin";
    /**
     * 获取鉴权公钥请求地址
     */
    public static final String OAUTH_URL_PUBLIC_KEY_POST = "/WPMS/getPublicKey";
    /**
     * 密码认证请求地址
     */
    public static final String OAUTH_URL_PWD_AUTH_POST = "/WPMS/login";
    /**
     * ipms accessToken
     */
    public static final String IPMS_TOKEN_GET = "/ipms/subSystem/generate/token?userName=system";

    private static String HTTP_PREFIX = H8900Profile.HTTP_PROTOCOL + H8900Profile.host;

    private static String HTTPS_PREFIX = H8900Profile.HTTPS_PROTOCOL + H8900Profile.host;

    private static List<String> PORT_8314 = new ArrayList<>(Arrays.asList("/CardSolution/", "/admin/rest/api"));

    private static List<String> PORT_8103 = new ArrayList<>(Arrays.asList("/ipms/"));

    public static String version = "1.0.0";
    private static boolean initVersionFromBrm = Boolean.FALSE;

    /**
     * 处理h8900地址
     *
     * @param url 请求地址
     * @return
     */
    public static String urls(String url) {
        //支持传全路径
        if (StrUtil.startWith(url, "http")) {
            return url;
        }
        //
        if (urlContains(url, PORT_8314)) {
            return H8900Profile.HTTP_PROTOCOL + H8900Profile.host + ":8314" + url;
        }

        return H8900Profile.HTTPS_PROTOCOL + H8900Profile.host + url;
    }

    /**
     * 判断部分地址是归属某个端口
     *
     * @param url
     * @param collection
     * @return
     */
    private static boolean urlContains(String url, Collection<?> collection) {
        for (Object ct : collection) {
            if (url.contains((String)ct)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 处理h8900地址
     *
     * @param url 请求地址
     * @return
     */
    public static String url(String url) {
        boolean containsHttpPrefix = false;
        if (StrUtil.startWith(url, "http")) {
            return String.format(url, version);
        }
        return String.format(H8900Profile.URL_SCHEME + url, version);
    }

    /**
     * 客户端类型
     */
    public enum ClientType {
        /**
         * WEB
         */
        WEB(1),
        /**
         * 客户端
         */
        CLIENT(2),
        /**
         * App 客户端
         */
        APP(3);

        private int clientType;

        ClientType(int clientType) {
            this.clientType = clientType;
        }

        public int getClientType() {
            return clientType;
        }
    }
}
