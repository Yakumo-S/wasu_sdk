package com.dahuatech.icc.assesscontrol.constant;

import com.dahuatech.hutool.core.util.StrUtil;
import com.dahuatech.icc.oauth.profile.IccProfile;

/**
 * @author 237417
 * @since 1.0.0 2021-03-17
 */
public class AccessControlConstant {

    /** 模块名称 */
    public static final String SYSTEM_NAME = "evo-assesscontrol";


    /** 设备树 */
    public static final String ASSESS_CONTROL_URL_RESOURCE_TREE_SEARCH_POST =
            "/evo-apigw/evo-accesscontrol/%s/resource/tree/search";

    /*---------------------------门通道控制-------------------------*/
    /** 开门*/
    public static final String ASSESS_CONTROL_URL_OPEN_DOOR_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/openDoor";
    /** 关门 */
    public static final String ASSESS_CONTROL_URL_CLOSE_DOOR_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/closeDoor";
    /** 常开 */
    public static final String ASSESS_CONTROL_URL_STAY_OPEN_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/stayOpen";
    /** 常闭 */
    public static final String ASSESS_CONTROL_URL_STAY_CLOSE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/stayClose";

    /** 正常 */
    public static final String ASSESS_CONTROL_URL_NORMAL_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/normal";
    /** 获取门状态 */
    public static final String ASSESS_CONTROL_URL_GET_DOOR_STATUS_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelControl/getDoorStatus";

    /*----------------------------门组分配-------------------------*/
    /** 添加门组 */
    public static final String ASSESS_CONTROL_URL_DOOR_GROUP_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup";
    /** 修改门组 */
    public static final String ASSESS_CONTROL_URL_DOOR_GROUP_UPDATE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/update";

    /** 删除门组 */
    public static final String ASSESS_CONTROL_URL_DOOR_GROUP_DELETE_BATCH_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/delete/batch";

    /** 门组详情 */
    public static final String ASSESS_CONTROL_URL_DOOR_GROUP_DETAIL_GET =
            "/card/accessControl/doorGroup/${id}";
    /** 门组列表 */
    public static final String ASSESS_CONTROL_URL_DOOR_GROUP_PAGE_LIST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorGroup/bycondition/combined";

    /*----------------------------首卡开门-------------------------*/
    /** 添加首卡 */
    public static final String ASSESS_CONTROL_URL_FIRST_CARD_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/add";
    /** 修改首卡 */
    public static final String ASSESS_CONTROL_URL_FIRST_CARD_UPDATE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/update";
    /** 删除首卡 */
    public static final String ASSESS_CONTROL_URL_FIRST_CARD_DEL_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCard/delete";
    /** 首卡列表 */
    public static final String ASSESS_CONTROL_URL_FIRST_CARD_PAGE_LIST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByFirstCardRest/bycondition/combined";

    /*----------------------------多卡开门-------------------------*/
    /** 添加人员组 */
    public static final String ASSESS_CONTROL_URL_PERSON_GROUP_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/personGroup/add";
    /** 删除人员组 */
    public static final String ASSESS_CONTROL_URL_PERSON_GROUP_DEL_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/personGroup/delete";
    /** 添加多卡开门 */
    public static final String ASSESS_CONTROL_URL_OPEN_BY_MULTI_CARD_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/rest/openByMultiCard/add";
    /** 修改多卡开门 */
    public static final String ASSESS_CONTROL_URL_OPEN_BY_MULTI_CARD_UPDATE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCard/update";
    /** 删除多卡开门 */
    public static final String ASSESS_CONTROL_URL_OPEN_BY_MULTI_CARD_DEL_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCard/delete";
    /** 多卡开门列表 */
    public static final String ASSESS_CONTROL_URL_OPEN_BY_MULTI_CARD_REST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channelAuthManage/openByMultiCardRest/bycondition/combined";

    /*----------------------------开门计划-------------------------*/
    /** 添加开门计划 */
    public static final String ASSESS_CONTROL_URL_TIME_QUANTUM_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum";
    /** 修改开门计划 */
    public static final String ASSESS_CONTROL_URL_TIME_QUANTUM_UPDATE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/update";
    /** 删除开门计划 */
    public static final String ASSESS_CONTROL_URL_TIME_QUANTUM_DEL_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/delete";
    /** 开门计划列表 */
    public static final String ASSESS_CONTROL_URL_TIME_QUANTUM_PAGE_LIST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/{type}/page";
    /** 开门计划详情 */
    public static final String ASSESS_CONTROL_URL_TIME_QUANTUM_DETAIL_GET =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/timeQuantum/getByIndex/{index}";

    /*----------------------------常开常闭计划-------------------------*/
    /** 添加常开常闭计划 */
    public static final String ASSESS_CONTROL_URL_OPEN_NORMALLY_SETTING_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/add";
    /** 修改常开常闭计划 */
    public static final String ASSESS_CONTROL_URL_OPEN_NORMALLY_SETTING_UPDATE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/update";
    /** 删除常开常闭计划 */
    public static final String ASSESS_CONTROL_URL_OPEN_NORMALLY_SETTING_DELETE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySetting/delete";
    /** 常开常闭计划列表 */
    public static final String ASSESS_CONTROL_URL_OPEN_NORMALLY_SETTING_PAGE_LIST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/channel/openNormallySettingRest/bycondition/coe";

    /*----------------------------按（卡）人授权-------------------------*/
    /** 按人授权新增 */
    public static final String ASSESS_CONTROL_URL_AUTH_PERSON_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority";
    /** 按人授权更新 */
    public static final String ASSESS_CONTROL_URL_AUTH_PERSON_UPDATE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/update";
    /** 按人授权删除 */
    public static final String ASSESS_CONTROL_URL_AUTH_PERSON_DELETE_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/delete/batch";
    /** 人员权限分页查询 */
    public static final String ASSESS_CONTROL_URL_AUTH_PERSON_PAGE_LIST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/bycondition/combined";

    /*----------------------------刷卡记录-------------------------*/
    /** 刷卡记录分页 */
    public static final String ASSESS_CONTROL_URL_SWING_CARD_RECORD_PAGE_LIST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/swingCardRecord/bycondition/combined";
    /** 刷卡记录详情 */
    public static final String ASSESS_CONTROL_URL_SWING_CARD_RECORD_DETAIL_GET =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/swingCardRecord/{id}";

    /*----------------------------按门授权-------------------------*/
    /** 按人授权新增 */
    public static final String ASSESS_CONTROL_URL_AUTH_PERSON_BY_CHANNEL_CODE_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/authorizeAllPersonByChannelCode";
    /** 按门组授权新增 */
    public static final String ASSESS_CONTROL_URL_AUTH_DOOR_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/authorizeAllPersonByChannelCode";
    /** 按人授权删除 */
    public static final String ASSESS_CONTROL_URL_AUTH_PERSON_BY_CHANNEL_CODE_DEL_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/removeAuthorizeAllCardNumberByChannelCode";
    /** 按门组授权删除 */
    public static final String ASSESS_CONTROL_URL_AUTH_DOOR_DEL_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/removeAuthorizeAllCardNumberByDoorGroups";
    /** 人员权限分页查询 */
    public static final String ASSESS_CONTROL_URL_AUTH_DOOR_PAGE_LIST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/ChannelWithAuthorizeStatus/bycondition/combined";

    /*----------------------------按部门授权-------------------------*/
    /** 按人授权新增 */
    public static final String ASSESS_CONTROL_URL_AUTH_DEPT_BY_CHANNEL_CODE_ADD_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/authorizeAllDeptByChannelCode";
  /** 按门组授权 */
    public static final String ASSESS_CONTROL_URL_AUTH_DOOR_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/authorizeAllDeptByDoorGroups";
    /** 按部门授权 */
    public static final String ASSESS_CONTROL_URL_AUTH_DEPT_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/removeAuthorizeAllByChannelCode";
    /** 按部门授权删除 */
    public static final String ASSESS_CONTROL_URL_AUTH_DEPT_DEL_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/removeAuthorizeAllByDoorGroups";
    /** 部门权限分页查询 */
    public static final String ASSESS_CONTROL_URL_AUTH_DEPT_PAGE_LIST_POST =
            "/evo-apigw/evo-accesscontrol/%s/card/accessControl/doorAuthority/authorizedDepartment/bycondition/";





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
