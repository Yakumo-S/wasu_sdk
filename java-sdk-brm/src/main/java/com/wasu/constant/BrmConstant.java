package com.wasu.constant;

import com.wasu.hutool.core.util.StrUtil;
import com.wasu.profile.IccProfile;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmConstant {

  /** 模块名称 */
  public static final String SYSTEM_NAME = "evo-brm";

  /** 新增组织 */
  public static final String BRM_URL_ORGAN_ADD_POST = "/evo-apigw/evo-brm/%s/organization/add";
  /** 批量新增组织 */
  public static final String BRM_URL_ORGAN_BATCH_ADD_POST =
          "/evo-apigw/evo-brm/%s/organization/batch-add";
  /** 更新组织 */
  public static final String BRM_URL_ORGAN_UPDATE_PUT = "/evo-apigw/evo-brm/%s/organization/update";
  /** 删除组织 */
  public static final String BRM_URL_ORGAN_DEL_DELETE = "/evo-apigw/evo-brm/%s/organization/delete";
  /** 查询组织 */
  public static final String BRM_URL_ORGAN_QUERY_GET = "/evo-apigw/evo-brm/%s/organization/{}";
  /** 批量更新组织操作权限接口 */
  public static final String BRM_URL_ORGAN_UPDATE_OPERATE_LOCK_PUT =
          "/evo-apigw/evo-brm/%s/organization/update-operate-lock";
  /** 组织详情分页查询（综合对外接口） */
  public static final String BRM_URL_ORGAN_PAGE_LIST_POST =
          "/evo-apigw/evo-brm/%s/organization/page-list";
  /** 组织全量数据同步（全量数据同步） */
  public static final String BRM_URL_ORGAN_PAGE_GET = "/evo-apigw/evo-brm/%s/organization/page";

  /** 组织分页查询 */
  public static final String BRM_URL_ORGAN_SUBSYSTEM_PAGE_GET =
          "/evo-apigw/evo-brm/%s/organization/subsystem/page";

  /*----------------------------用户-------------------------*/
  /** 新增用户 */
  public static final String BRM_URL_USER_ADD_POST = "/evo-apigw/evo-brm/%s/user/add";
  /** 删除用户 */
  public static final String BRM_URL_USER_DEL_DELETE = "/evo-apigw/evo-brm/%s/user/delete";
  /** 更新用户 */
  public static final String BRM_URL_USER_UPDATE_PUT = "/evo-apigw/evo-brm/%s/user/update";
  /** 批量新增用户 */
  public static final String BRM_URL_USER_BATCH_ADD_POST = "/evo-apigw/evo-brm/%s/user/subsystem/add-batch";

  /** 查询用户详情,rest接口 */
  public static final String BRM_URL_USER_DETAIL_REST_GET = "/evo-apigw/evo-brm/%s/user/{}";
  /** 用户有权限的菜单获取 */
  public static final String BRM_URL_USER_PRIVILEGE_MENUS_GET = "/evo-apigw/evo-brm/%s/user/privilege-menus";
  /** 用户分页查询 */
  public static final String BRM_URL_USER_PAGE_POST = "/evo-apigw/evo-brm/%s/user/subsystem/page";

  /** 用户保活 */
  public static final String BRM_URL_USER_KEEP_ALIVE_POST = "/evo-apigw/evo-brm/%s/user/keepalive";
  /** 用户全量数据同步（全量数据同步） */
  public static final String BRM_URL_USER_LIST_PAGE_POST = "/evo-apigw/evo-brm/%s/user/list-page";
  /*----------------------------部门-------------------------*/
  /** 组织添加 */
  public static final String BRM_URL_DEPT_ADD_POST = "/evo-apigw/evo-brm/%s/department/add";
  /** 批量添加 */
  public static final String BRM_URL_DEPT_BATCH_ADD_POST =
          "/evo-apigw/evo-brm/%s/department/batch-add";

  /** 部门更新 */
  public static final String BRM_URL_DEPT_UPDATE_PUT = "/evo-apigw/evo-brm/%s/department/update";

  /** 部门删除 */
  public static final String BRM_URL_DEPT_DEL_DELETE = "/evo-apigw/evo-brm/%s/department/delete";
  /** 部门全量数据同步 */
  public static final String BRM_URL_DEPT_PAGE_POST = "/evo-apigw/evo-brm/%s/department/page";
  /** 部门详情查看 */
  public static final String BRM_URL_DEPT_DETAIL_REST_GET = "/evo-apigw/evo-brm/%s/department/{}";
  /** 部门ID生成 */
  public static final String BRM_URL_DEPT_BATCH_GEN_ID_GET =
          "/evo-apigw/evo-brm/%s/department/batch-generate-id";

  /** 查询部门树 */
  public static final String BRM_URL_DEPT_TREE_POST = "/evo-apigw/evo-brm/%s/department/tree";

  /*----------------------------角色-------------------------*/
  /** 新增角色 */
  public static final String BRM_URL_ROLE_ADD_POST = "/evo-apigw/evo-brm/%s/role";
  /** 删除角色 */
  public static final String BRM_URL_ROLE_DEL_POST = "/evo-apigw/evo-brm/%s/role/delete";
  /** 更新角色 */
  public static final String BRM_URL_ROLE_UPDATE_PUT = "/evo-apigw/evo-brm/%s/role";

  /** 查询角色详情,rest接口 */
  public static final String BRM_URL_ROLE_DETAIL_REST_GET = "/evo-apigw/evo-brm/%s/role/detail/{}";
  /** 角色分页查询 */
  public static final String BRM_URL_ROLE_PAGE_POST = "/evo-apigw/evo-brm/%s/role/subsystem/page";

  /** 角色全量数据同步（全量数据同步） */
  public static final String BRM_URL_ROLE_LIST_PAGE_POST = "/evo-apigw/evo-brm/%s/role/list-page";

  /*----------------------------车辆-------------------------*/
  /** 车辆新增 */
  public static final String BRM_URL_CAR_ADD_POST = "/evo-apigw/evo-brm/%s/car/add";
  /** 车辆更新 */
  public static final String BRM_URL_CAR_UPDATE_PUT = "/evo-apigw/evo-brm/%s/car/update";

  /** 车辆删除 */
  public static final String BRM_URL_CAR_DELETE_POST = "/evo-apigw/evo-brm/%s/car/delete";
  /** 车辆详情查看 */
  public static final String BRM_URL_CAR_DETAIL_REST_GET = "/evo-apigw/evo-brm/%s/car/{}";

  /** 车辆批量新增 */
  public static final String BRM_URL_CAR_BATCH_ADD_POST = "/evo-apigw/evo-brm/%s/car/add-batch";
  /** 车辆分页查询 */
  public static final String BRM_URL_CAR_PAGE_POST = "/evo-apigw/evo-brm/%s/car/subsystem/page";
  /** 车辆全量数据同步 */
  public static final String BRM_URL_CAR_SYNC_POST = "/evo-apigw/evo-brm/%s/car/page";

  /*----------------------------人员-------------------------*/
  /** 人员新增 */
  public static final String BRM_URL_PERSON_ADD_POST = "/evo-apigw/evo-brm/%s/person/subsystem/add";
  /** 人员批量新增 */
  public static final String BRM_URL_PERSON_BATCH_ADD_POST =
          "/evo-apigw/evo-brm/%s/person/subsystem/batch-add";
  /** 人员更新 */
  public static final String BRM_URL_PERSON_UPDATE_PUT =
          "/evo-apigw/evo-brm/%s/person/subsystem/update";

  /** 人员详情 */
  public static final String BRM_URL_PERSON_DETAIL_REST_GET =
          "/evo-apigw/evo-brm/%s/person/subsystem/{}";
  /** 人员删除 */
  public static final String BRM_URL_PERSON_DEL_POST = "/evo-apigw/evo-brm/%s/person/delete";
  /** 生成人员全局id */
  public static final String BRM_URL_PERSON_GEN_ID_GET = "/evo-apigw/evo-brm/%s/person/generate-id";
  /** 生成人员全局唯一id */
  public static final String BRM_URL_PERSON_BATCH_GEN_ID_GET = "/evo-apigw/evo-brm/%s/person/subsystem/batch-generate-id";
  /** 人员头像批量更新 */
  public static final String BRM_URL_PERSON_FACE_BATCH_UPDATE_PUT =
          "/evo-apigw/evo-brm/%s/person/subsystem/update-biosignature-face";
  /** 新增人员信息(包含车辆、卡片信息) */
  public static final String BRM_URL_PERSON_ADD_ONCE_POST =
          "/evo-apigw/evo-brm/%s/person/subsystem/save-person-all";
  /** 根据人员证件号信息获取人员详情 */
  public static final String BRM_URL_PERSON_QUERY_BY_ID_CARD_GET =
          "/evo-apigw/evo-brm/%s/person/subsystem/get-by-paper-number";
  /** 分页获取人员信息 */
  public static final String BRM_URL_PERSON_PAGE_POST =
          "/evo-apigw/evo-brm/%s/person/subsystem/page";
  /** 全量同步人员数据 */
  public static final String BRM_URL_PERSON_SYNC_POST =
          "/evo-apigw/evo-brm/%s/person/subsystem/list-page";
  /** 上传人员图片 */
  public static final String BRM_URL_PERSON_UPLOAD_IMG_POST =
          "/evo-apigw/evo-brm/%s/person/upload/img";
  /*----------------------------卡片-------------------------*/
  /** 批量开卡 */
  public static final String BRM_URL_CARD_BATCH_ADD_POST = "/evo-apigw/evo-brm/%s/card/batch-add";
  /** 新增卡片信息 */
  public static final String BRM_URL_CARD_ADD_POST = "/evo-apigw/evo-brm/%s/card/add";
  /** 更新卡片信息 */
  public static final String BRM_URL_CARD_UPDATE_PUT = "/evo-apigw/evo-brm/%s/card/update";
  /** 查询卡片详情 */
  public static final String BRM_URL_CARD_DETAIL_REST_GET = "/evo-apigw/evo-brm/%s/card/{}";
  /** 卡片激活 */
  public static final String BRM_URL_CARD_ACTIVE_PUT = "/evo-apigw/evo-brm/%s/card/active";
  /** 卡片换卡 */
  public static final String BRM_URL_CARD_REPLACE_PUT = "/evo-apigw/evo-brm/%s/card/replace";
  /** 卡片换卡 */
  public static final String BRM_URL_CARD_RETURN_PUT = "/evo-apigw/evo-brm/%s/card/return";
  /** 卡片删除 */
  public static final String BRM_URL_CARD_DEL_DELETE = "/evo-apigw/evo-brm/%s/card/delete";
  /** 批量挂失卡片 -- 适用于激活卡 */
  public static final String BRM_URL_CARD_LOSE_PUT = "/evo-apigw/evo-brm/%s/card/lose";
  /** 批量解挂卡片 -- 适用于挂失卡 */
  public static final String BRM_URL_CARD_RELIEVE_PUT = "/evo-apigw/evo-brm/%s/card/relieve";
  /** 批量回收卡片 -- 适用于注销卡 */
  public static final String BRM_URL_CARD_RECYCLE_PUT = "/evo-apigw/evo-brm/%s/card/recycle";
  /** 生成卡片全局id */
  public static final String BRM_URL_CARD_GEN_ID_GET = "/evo-apigw/evo-brm/%s/card/generate-id";
  /** 批量生成卡片全局id */
  public static final String BRM_URL_CARD_BATCH_GEN_ID_GET =
          "/evo-apigw/evo-brm/%s/card/batch-generate-id";
  /** 分页查询卡片信息 */
  public static final String BRM_URL_CARD_PAGE_POST = "/evo-apigw/evo-brm/%s/card/subsystem/page";
  /** 同步全量的卡片数据 */
  public static final String BRM_URL_CARD_SYNC_POST = "/evo-apigw/evo-brm/%s/card/page";
  /*----------------------------设备-------------------------*/
  /** 查询设备详细信息 */
  public static final String BRM_URL_DEVICE_DETAIL_GET = "/evo-apigw/evo-brm/%s/device/{}";
  /** 分页查询设备信息 请求说明(必看) : 设备大类和设备小类不能同时作为查询条件，会优先根据设备大类查询，如果设备大类传入参数为空，则根据设备小类查询，设备小类的格式是 大类_小类 */
  public static final String BRM_URL_DEVICE_PAGE_POST =
          "/evo-apigw/evo-brm/%s/device/subsystem/page";
  /** 查询设备树 */
  public static final String BRM_URL_DEVICE_TREE_POST = "/evo-apigw/evo-brm/%s/tree";
  /** 分页查询设备通道信息 */
  public static final String BRM_URL_DEVICE_CHANNEL_PAGE_POST =
          "/evo-apigw/evo-brm/%s/device/channel/subsystem/page";
  /** 全量同步设备数据 */
  public static final String BRM_URL_DEVICE_SYNC_POST = "/evo-apigw/evo-brm/%s/device/list-page";

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
