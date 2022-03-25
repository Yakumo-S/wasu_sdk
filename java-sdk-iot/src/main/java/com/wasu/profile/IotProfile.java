package com.wasu.profile;

import com.wasu.http.IotResponse;
import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class IotProfile {

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
   * 客户端认证ID
   */
  public static String clientId;
  /**
   * 客户端认证秘钥
   */
  public static String clientSecret;
  /**
   * 当前使用认证类型
   */
  public static GrantType grantType;
  /**
   * 密码认证用户名
   */
  public static String username;
  /**
   * 认证密码
   */
  public static String password;
  /**
   * 密码认证客户端ID
   */
  public static String pwdClientId;
  /**
   * 密码认证客户端秘钥
   */
  public static String pwdClientSecret;
  /**
   * 客户端认证请求头用户userId=1
   */
  public static String CONFIG_CLIENT_USERID = "1";
  /**
   * 是否开启客户端模式，自动携带请求头User-Id=1
   */
  public static boolean CONFIG_CLIENT_USERID_ENABLE = Boolean.TRUE;
  private static String HTTPS_PROTOCOL = "http://";
  /**
   * 默认HTTPS,例如https://api.wasu.com,尾部不包含"/"
   */
  public static String URL_SCHEME = HTTPS_PROTOCOL;
  private static String HTTP_PROTOCOL = "http://";
  /**
   * 配置config
   */
  private final String CONFIG_HTTPS = "iot.sdk.enable.https";
  private volatile Properties configuration = new Properties();

  private IotProfile() {
    init();
  }

  public static synchronized IotProfile getInstance() {
    return IotProfile.ConfigurationHolder.configuration;
  }

  public synchronized void init() {
    if (inited) {
      return;
    }
    inited = true;
    loadEnvConfig();
    // 记载子系统版本信息
  }

  private void loadEnvConfig() {
    loadIccSdkProperties();

    String configClientEnable = "iot.sdk.config.client.enable";
    if (this.configuration.containsKey(configClientEnable)
        && "false".equalsIgnoreCase(this.configuration.getProperty(configClientEnable))) {
      CONFIG_CLIENT_USERID_ENABLE = false;
    } else {
      String configClientValue = System.getProperty(configClientEnable);
      if (StrUtil.isNotBlank(configClientValue)) {
        CONFIG_CLIENT_USERID_ENABLE = Boolean.parseBoolean(configClientValue);
      }
    }
    String configClientUserId = "wasu.iot.sdk.config.client.userId";
    if (this.configuration.containsKey(configClientUserId)) {
      CONFIG_CLIENT_USERID = this.configuration.getProperty(configClientUserId);
    } else {
      String configUserId = System.getProperty(configClientUserId);
      if (StrUtil.isNotBlank(configUserId)) {
        CONFIG_CLIENT_USERID = configUserId;
      }
    }

    String configHttps = "";
    if (this.configuration.containsKey(CONFIG_HTTPS)) {
      configHttps = this.configuration.getProperty(CONFIG_HTTPS);
    } else {
      configHttps = System.getProperty(CONFIG_HTTPS);
    }
    if (StrUtil.isNotBlank(configHttps) && "false".equalsIgnoreCase(configHttps)) {
      HTTPS_PROTOCOL = HTTP_PROTOCOL;
    }
    String sdkHost = "wasu.iot.sdk.host";
    if (StrUtil.isBlank(host) && this.configuration.containsKey(sdkHost)) {
      host = this.configuration.getProperty(sdkHost);
    } else if (StrUtil.isBlank(host)) {
      host = System.getProperty(sdkHost);
    }
    URL_SCHEME = HTTPS_PROTOCOL + host;
    String sdkClientId = "wasu.iot.sdk.clientId";
    if (StrUtil.isBlank(clientId) && this.configuration.containsKey(sdkClientId)) {
      clientId = this.configuration.getProperty(sdkClientId);
    } else if (StrUtil.isBlank(clientId)) {
      clientId = System.getProperty(sdkClientId);
    }
    String sdkClientSecret = "wasu.iot.sdk.clientSecret";
    if (StrUtil.isBlank(clientSecret) && this.configuration.containsKey(sdkClientSecret)) {
      clientSecret = StrUtil.trim(this.configuration.getProperty(sdkClientSecret));
    } else if (StrUtil.isBlank(clientSecret)) {
      clientSecret = System.getProperty(sdkClientSecret);
    }

    String sdkUsername = "wasu.iot.sdk.username";
    if (StrUtil.isBlank(username) && this.configuration.containsKey(sdkUsername)) {
      username = this.configuration.getProperty(sdkUsername);
    } else if (StrUtil.isBlank(username)) {
      username = System.getProperty(sdkUsername);
    }
    String sdkPassword = "wasu.iot.sdk.password";
    if (StrUtil.isBlank(password) && this.configuration.containsKey(sdkPassword)) {
      password = this.configuration.getProperty(sdkPassword);
    } else if (StrUtil.isBlank(password)) {
      password = System.getProperty(sdkPassword);
    }
    String sdkGrantType = "wasu.iot.sdk.grantType";
    if (grantType == null && this.configuration.containsKey(sdkGrantType)) {
      sdkGrantType = this.configuration.getProperty(sdkGrantType);
      grantType = GrantType.valueOf(sdkGrantType);
    } else if (grantType == null && StrUtil.isNotBlank(System.getProperty(sdkGrantType))) {
      sdkGrantType = System.getProperty(sdkGrantType);
      grantType = GrantType.valueOf(sdkGrantType);
    }
    if (grantType == null) {
      logger.error("IccProfile grantType can not be null , please set first");
    }
    if (grantType != null && grantType.equals(GrantType.password)) {
      if (StrUtil.isBlank(username)
          || StrUtil.isBlank(password)) {
        logger.error(
            "GrantType type [password] ,`username` or `password` `pwdClientId` or `pwdClientSecret` can not null,please set first");
      }
    }
    if (grantType != null && grantType.equals(GrantType.client_credentials)) {
      if (StrUtil.isBlank(clientId) || StrUtil.isBlank(clientSecret)) {
        logger.error(
            "GrantType type [client_credentials] ,`clientId` or `clientSecret` can not null,please set first");
      }
    }
  }

  private void loadIccSdkProperties() {
    // 根路径为classpath
    InputStream is = this.getClass().getResourceAsStream("/config/iotSdk.properties");
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
      logger
          .info("can not load [classpath:resources/config/iotSdk.properties] , use DefaultClient constructor instead ");
    }
  }


  private static class ConfigurationHolder {

    private static IotProfile configuration = new IotProfile();
  }

  static class VersionInfo {

    private String systemName;
    private String version;

    public String getSystemName() {
      return systemName;
    }

    public void setSystemName(String systemName) {
      this.systemName = systemName;
    }

    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    @Override
    public String toString() {
      return "VersionInfo{"
          + "systemName='"
          + systemName
          + '\''
          + ", version='"
          + version
          + '\''
          + '}';
    }
  }

  static class SystemVersions extends IotResponse {

    private VersionInfoDO data;

    public VersionInfoDO getData() {
      return data;
    }

    public void setData(VersionInfoDO data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "SystemVersions{" + "data=" + data + '}';
    }

    public class VersionInfoDO {

      private List<VersionInfo> versionInfo;

      public List<VersionInfo> getVersionInfo() {
        return versionInfo;
      }

      public void setVersionInfo(List<VersionInfo> versionInfo) {
        this.versionInfo = versionInfo;
      }
    }
  }
}
