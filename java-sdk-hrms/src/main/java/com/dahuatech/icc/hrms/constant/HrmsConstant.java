package com.dahuatech.icc.hrms.constant;

import com.dahuatech.hutool.core.util.StrUtil;
import com.dahuatech.hutool.log.Log;
import com.dahuatech.hutool.log.LogFactory;
import com.dahuatech.icc.oauth.profile.IccProfile;

/**
 * @author 232676
 * @since 1.0.0 2020/11/2 15:40
 */
public class HrmsConstant {
  /** 模块名称 */
  public static final String SYSTEM_NAME = "evo-hrms";
  /** 小区新增 */
  public static final String BRM_URL_BLOCK_ADD_POST = "/evo-apigw/evo-hrms/block/add";
  /** 小区修改 */
  public static final String BRM_URL_BLOCK_UPDATE_POST = "/evo-apigw/evo-hrms/block/update";
  /** 小区查看 */
  public static final String BRM_URL_BLOCK_VIEW_REST_GET =
      "/evo-apigw/evo-hrms/organization/view/{}";
  /** 小区删除 */
  public static final String BRM_URL_BLOCK_DELETE_POST = "/evo-apigw/evo-hrms/block/batchDelete";
  /** 楼幢新增 */
  public static final String BRM_URL_BUILDING_ADD_POST = "/evo-apigw/evo-hrms/building/add";
  /** 楼幢修改 */
  public static final String BRM_URL_BUILDING_UPDATE_POST = "/evo-apigw/evo-hrms/building/update";
  /** 楼幢删除，rest接口 */
  public static final String BRM_URL_BUILDING_DELETE_REST_GET = "/evo-hrms/building/delete/{id}";
  /** 楼栋查看，rest接口 */
  public static final String BRM_URL_BUILDING_VIEW_REST_GET =
      "/evo-apigw/evo-hrms/building/edit/{id}";
  /** 楼栋分页查询 */
  public static final String BRM_URL_BUILDING_PAGE_POST = "/evo-hrms/building/page";

  /** 房屋修改 */
  public static final String BRM_URL_HOUSE_UPDATE_POST =
          "/evo-apigw/evo-hrms/house/update";
  /** 房屋详情查询 */
  public static final String BRM_URL_HOUSE_EDIT_GET =
          "/evo-apigw/evo-hrms/house/edit/{id}";
  /** 人房关系 */
  public static final String BRM_URL_HOUSE_PERSON_BINGING_GET =
          "/evo-apigw/evo-hrms/house/personBinding";
  /** 房屋列表分页查询 */
  public static final String BRM_URL_HOUSE_PAGE_GET =
          "/evo-apigw/evo-hrms/house/page";

  /** 人员新增 */
  public static final String BRM_URL_PERSON_ADD_POST =
          "/evo-apigw/evo-hrms/person/add";
  /** 人员修改 */
  public static final String BRM_URL_PERSON_UPDATE_POST=
          "/evo-apigw/evo-hrms/person/update";
  /** 人员详情查询 */
  public static final String BRM_URL_PERSON_VIEW_GET =
          "/evo-apigw/evo-hrms/person/view/{id}";
  /** 人员单个删除 */
  public static final String BRM_URL_PERSON_DELETE_GET =
          "/evo-apigw/evo-hrms/person/delete/{id}";
  /** 人员批量删除 */
  public static final String BRM_URL_PERSON_BATCH_DELETE_POST =
          "/evo-apigw/evo-hrms/person/batchDelete";
  /** 人员分页查询 */
  public static final String BRM_URL_PERSON_PAGE_GET =
          "/evo-apigw/evo-hrms/person/page?pageNum=1&pageSize=20";


  private static final Log logger = LogFactory.get();
  /** 非必填 */
  public static String version = "";

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
