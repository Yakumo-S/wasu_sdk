package com.dahuatech.h8900.oauth.profile;

import com.dahuatech.hutool.core.util.CharsetUtil;
import com.dahuatech.hutool.core.util.StrUtil;
import com.dahuatech.hutool.http.*;
import com.dahuatech.hutool.json.JSONObject;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.hutool.log.Log;
import com.dahuatech.hutool.log.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class H8900Profile {
    private static final Log logger = LogFactory.get();

    /**
     * 各个子系统的版本
     */
    public static volatile Map<String, String> systemVersionMap = new ConcurrentHashMap<>();

    public static volatile boolean inited = Boolean.FALSE;
    /**
     * 平台服务IP或域名
     */
    public static String host;
    /**
     * 平台服务PORT端口
     */
    public static String port;
    /**
     * 密码认证用户名
     */
    public static String username;
    /**
     * 认证密码
     */
    public static String password;
    /**
     * 是否启用https
     */
    public static Boolean isHttps = Boolean.TRUE;

    public static Boolean network = Boolean.FALSE;

    public static String HTTPS_PROTOCOL = "https://";
    /**
     * 默认HTTPS,例如https://api.dahuatech.com,尾部不包含"/"
     */
    public static String URL_SCHEME = null;
    public static String HTTP_PROTOCOL = "http://";
    /**
     * 配置config
     */
    private final String CONFIG_HTTPS = "h8900.https";
    private volatile Properties configuration = new Properties();

    private H8900Profile() {
        init();
    }

    public static synchronized H8900Profile getInstance() {
        return H8900Profile.ConfigurationHolder.configuration;
    }

    public synchronized void init() {
        if (inited) {
            return;
        }
        inited = true;
        loadEnvConfig();
        // 记载子系统版本信息
        initSystemVersion();
    }

    private void loadEnvConfig() {
        loadH8900SdkProperties();
        String configHttps = "";
        if (this.configuration.containsKey(CONFIG_HTTPS)) {
            configHttps = this.configuration.getProperty(CONFIG_HTTPS);
        } else {
            configHttps = System.getProperty(CONFIG_HTTPS);
        }
        if (StrUtil.isNotBlank(configHttps) && "false".equalsIgnoreCase(configHttps)) {
            isHttps = Boolean.FALSE;
        }
        String sdkHost = "h8900.host";
        if (StrUtil.isBlank(host) && this.configuration.containsKey(sdkHost)) {
            host = this.configuration.getProperty(sdkHost);
        } else if (StrUtil.isBlank(host)) {
            host = System.getProperty(sdkHost);
        }
        String sdkPost = "h8900.port";
        if (StrUtil.isBlank(port) && this.configuration.containsKey(sdkPost)) {
            port = this.configuration.getProperty(sdkPost);
        } else if (StrUtil.isBlank(port)) {
            port = System.getProperty(sdkHost);
        }
        String sdkUsername = "h8900.username";
        if (StrUtil.isBlank(username) && this.configuration.containsKey(sdkUsername)) {
            username = this.configuration.getProperty(sdkUsername);
        } else if (StrUtil.isBlank(username)) {
            username = System.getProperty(sdkUsername);
        }
        String sdkPassword = "h8900.password";
        if (StrUtil.isBlank(password) && this.configuration.containsKey(sdkPassword)) {
            password = this.configuration.getProperty(sdkPassword);
        } else if (StrUtil.isBlank(password)) {
            password = System.getProperty(sdkPassword);
        }
    }

    private void loadH8900SdkProperties() {
        // 根路径为classpath
        InputStream is = this.getClass().getResourceAsStream("/config/h8900.properties");
        if (is != null) {
            try {
                this.configuration.clear();
                this.configuration.load(is);
            } catch (IOException e) {
            } finally {
                try {
                    is.close();
                } catch (Throwable t) {
                }
            }
        } else {
            logger.info(
                "can not load [classpath:resources/config/h8900.properties] , use DefaultClient constructor instead ");
        }
    }

    /**
     * 2步初始化资源系统版本信息
     */
    private void initSystemVersion() {
        String path = "/WPMS/getPublicKey";
        //是否https
        String url = HTTP_PROTOCOL + host + path;
        try {
            HttpRequest request = new HttpRequest(url).method(Method.POST);
            Map<String, Object> map = new HashMap<>();
            map.put("loginName", H8900Profile.username);
            request.body(JSONUtil.toJsonStr(map));
            request.timeout(80000);
            request.setReadTimeout(80000);
            request.contentType(ContentType.JSON.toString(CharsetUtil.CHARSET_UTF_8));
            HttpResponse result = request.execute();
            if (result.getStatus() == HttpStatus.HTTP_OK) {
                String resultBody = result.body();
                JSONObject obj = JSONUtil.parseObj(resultBody);
                if (obj != null && obj.containsKey("success") && "true".equals(obj.getStr("success"))) {
                    isHttps = Boolean.FALSE;
                    network = Boolean.TRUE;
                    URL_SCHEME = HTTP_PROTOCOL + host + ":" + port;
                    logger.info("check h8900 network success!  host [{}] ,use http", host);
                    return;
                }

            }
        } catch (Exception e) {
            logger.debug("check h8900 https error {}", host);
            e.printStackTrace();
        }
    }

    private static class ConfigurationHolder {
        private static H8900Profile configuration = new H8900Profile();
    }

}
