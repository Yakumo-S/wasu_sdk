package com.dahuatech.icc.visitors.constant;

import com.dahuatech.hutool.core.util.StrUtil;
import com.dahuatech.icc.oauth.profile.IccProfile;

/**
 * @author 237417
 * @since 1.0.0 2021-04-12
 */
public class VisitorConstant {

    /** 模块名称 */
    public static final String SYSTEM_NAME = "evo-brm";


    /*----------------------------访客授权-------------------------*/
    /** 配置自动授权通道 */
    public static final String VISITOR_URL_UPDATE_ACCESS_CHANNEL_BY_VISIT_POST =
            "/evo-apigw/evo-brm/%s/card/accessControl/channel/updateAccessChannelByVisit";
    /** 查询已经配置的自动授权通道 */
    public static final String VISITOR_URL_GET_ACCESS_CHANNEL_BY_VISIT_GET =
            "/evo-apigw/evo-brm/%s/card/accessControl/channel/getAccessChannelByVisit";
    /** 配置自动签离通道 */
    public static final String VISITOR_URL_UPDATE_ACCESS_CHANNEL_BY_LEAVE_POST =
            "/evo-apigw/evo-brm/%s/card/accessControl/channel/updateAccessChannelByLeave";
    /** 查询已经配置的自动签离通道 */
    public static final String VISITOR_URL_GET_ACCESS_CHANNEL_BY_LEAVE_GET =
            "/evo-apigw/evo-brm/%s/card/accessControl/channel/getAccessChannelByLeave";


    /*----------------------------访客预约-------------------------*/
    /** 内部人员登录接口 */
    public static final String VISITOR_URL_CARD_PERSON_LOGIN_POST =
            "/evo-apigw/evo-brm/%s/card/person/login";
    /** 内部人员登出接口 */
    public static final String VISITOR_URL_CARD_PERSON_LOGOUT_POST =
            "/evo-apigw/evo-brm/%s/card/person/logout";
    /** 修改密码接口 */
    public static final String VISITOR_URL_CARD_PERSON_MODIFY_PASSWORD_POST =
            "/evo-apigw/evo-brm/%s/card/person/modifyPassword";
    /** 访客预约 */
    public static final String VISITOR_URL_CARD_VISITOR_APPOINTMENT_POST =
            "/evo-apigw/evo-brm/%s/card/brm/appointment";
    /** 根据预约码查询访客信息 */
    public static final String VISITOR_URL_CARD_VISITOR_GET_APPOINTMENT_BY_CODE_GET =
            "/evo-apigw/evo-brm/%s/card/brm/getAppointmentByCode/{appointmemntCode}";
    /** 根据身份证查询访客信息 */
    public static final String VISITOR_URL_CARD_VISITOR_GET_APPOINTMENT_BY_CERTIFICATE_NUMBER_GET =
            "/evo-apigw/evo-brm/%s/card/brm/getAppointmentByCertificateNumber/{certificateNumber}";
    /** H5访客列表接口 */
    public static final String VISITOR_URL_CARD_VISITOR_GET_REVIEW_LIST_POST =
            "/evo-apigw/evo-brm/%s/card/brm/getReviewList";
    /** 访客审批接口 */
    public static final String VISITOR_URL_CARD_VISITOR_REVIEW_POST =
            "/evo-apigw/evo-brm/%s/card/brm/review";
    /** 访客信息分页查询接口 */
    public static final String VISITOR_URL_CARD_VISITOR_GET_VISITOR_DATA_POST =
            "/evo-apigw/evo-brm/%s/card/brm/getVisitorData";
    /** 社区云预约访客 */
    public static final String VISITOR_URL_CARD_VISITOR_COMMUNITY_APPOINTMENT_POST =
            "/evo-apigw/evo-brm/%s/card/brm/community/appointment";


    /*----------------------------访客记录-------------------------*/
    /** 访客刷卡记录分页查询接口 */
    public static final String VISITOR_URL_RECORD_PAGE_POST =
            "/evo-apigw/evo-brm/%s/card/accessControl/swingCardRecord/brm/bycondition/combined";
    /** 当日进出动态-在访人数/离访人数 */
    public static final String VISITOR_URL_VISITOR_COUNT_POST =
            "/evo-apigw/evo-brm/%s/card/brm/visitorCount";
    /** 统计当日进出动态 */
    public static final String VISITOR_URL_RECORD_COUNT_POST =
            "/evo-apigw/evo-brm/%s/card/accessControl/count";
    /** 访客超时对应来访人 */
    public static final String VISITOR_URL_GET_VISITOR_TIMEOUT_POST =
            "/evo-apigw/evo-brm/%s/card/brm/getVisitorTimeoutByDepartment";



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
