package com.wasu.constant;

import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.profile.IccProfile;

/**
 * 事件中心常量
 *
 * @author 232676
 * @since 1.0.0 2020/11/16 20:03
 */
public class EventConstant {
  /** 模块名称 */
  public static final String SYSTEM_NAME = "evo-event";
  /** 事件订阅 */
  public static final String EVENT_URL_SUBSCRIBE_POST = "/evo-apigw/evo-event/%s/subscribe/mqinfo";
  /** 事件取消订阅??restful */
  public static final String EVENT_URL_SUBSCRIBE_DEL_DELETE =
      "/evo-apigw/evo-event/%s/subscribe/mqinfo?name=";
  private static final Log logger = LogFactory.get();
  public static String version = "1.0.0";
  private static boolean initVersionFromBrm = Boolean.FALSE;

  public static String url(String url) {
    // 加载远程版本信息
    initVersion();
    return String.format(IccProfile.URL_SCHEME + url, version);
  }

  public static String url(String url, Object rest) {
    // 加载远程版本信息
    initVersion();
    return StrUtil.format(String.format(IccProfile.URL_SCHEME + url, version), rest);
  }

  private static void initVersion() {
    if (!initVersionFromBrm && IccProfile.systemVersionMap.containsKey(SYSTEM_NAME)) {
      version = IccProfile.systemVersionMap.get(SYSTEM_NAME);
      initVersionFromBrm = true;
    }
  }
}
