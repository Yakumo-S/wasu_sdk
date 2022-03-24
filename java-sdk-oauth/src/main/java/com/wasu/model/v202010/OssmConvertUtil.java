package com.wasu.model.v202010;

import com.wasu.hutool.core.util.StrUtil;
import com.wasu.hutool.http.HttpRequest;
import com.wasu.hutool.http.HttpResponse;
import com.wasu.hutool.http.HttpUtil;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.DefaultClient;
import com.wasu.http.IClient;
import com.wasu.http.IccTokenResponse;
import com.wasu.profile.IccProfile;

import java.io.File;

/**
 * @author 232676
 * @since 1.0.0 2020/12/7 9:26
 */
public class OssmConvertUtil {
  private static final Log logger = LogFactory.get();

  /**
   * 下载图片
   *
   * @param path 相对地址[uuid/YYYY-MM-DD/1/uuid.jpg] *
   * @param file 文件
   * @return 是否下载成功
   */
  public static boolean download(String path, String file) {
    return HttpUtil.downloadFile(revertImageUrl(path), file) > 0;
  }

  /**
   * 下载图片
   *
   * @param path 相对地址[uuid/YYYY-MM-DD/1/uuid.jpg] *
   * @param file 文件
   * @return 是否下载成功
   */
  public static boolean download(String path, File file) {
    return HttpUtil.downloadFile(revertImageUrl(path), file) > 0;
  }
  /**
   * 返回重定向后可访问和下载的地址
   *
   * @param path 相对地址[uuid/YYYY-MM-DD/1/uuid.jpg] *
   * @param token 手动传token
   * @return 可访问地址
   */
  public static String revertImageUrl(String path, String token) {
    try {
      HttpRequest request = HttpRequest.get(IccProfile.URL_SCHEME + "/evo-apigw/evo-oss/" + path);
      if (StrUtil.isBlank(token)) {
        logger.warn("token is null ,check config");
        return StrUtil.EMPTY;
      }
      request.form("token", token);
      HttpResponse response = request.execute();
      if (response.getStatus() == 302) {
        String locationPath = response.header("Location");
        locationPath = checkPath(locationPath);
        if (StrUtil.isNotBlank(locationPath) && locationPath.toLowerCase().startsWith("http")) {
          return locationPath;
        }
        return IccProfile.URL_SCHEME + locationPath;
      }
    } catch (Exception e) {
      logger.warn("get oss redirect url error ={}", e);
    }
    return StrUtil.EMPTY;
  }

  /**
   * 返回重定向后可访问和下载的地址
   *
   * @param path 相对地址[uuid/YYYY-MM-DD/1/uuid.jpg]
   * @return 可访问地址
   */
  public static String revertImageUrl(String path) {
    try {
      IClient iClient = new DefaultClient();
      IccTokenResponse.IccToken token = iClient.getAccessToken();
      if (token == null) {
        logger.warn("token is null ,check config");
        return StrUtil.EMPTY;
      }
      return revertImageUrl(path, token.getAccess_token());
    } catch (ClientException e) {
      logger.warn("get oss redirect url error ={}", e);
    }
    return StrUtil.EMPTY;
  }

  /**
   * 校验地址是否包含[/],[http]，补充
   *
   * @param path 相对地址[uuid/YYYY-MM-DD/1/uuid.jpg]
   * @return 返回兼容地址
   */
  private static String checkPath(String path) {
    if (StrUtil.isBlank(path)) {
      logger.warn("oss path is empty");
      return path;
    }

    if (path.startsWith("/") || path.toLowerCase().startsWith("http")) {
      return path;
    } else {
      return "/" + path;
    }
  }
}
