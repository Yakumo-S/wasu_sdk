package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.icc.oauth.http.IccResponse;

public class AppointmentCodeResponse extends IccResponse {

    private AppointmentCodeData data;

    public AppointmentCodeData getData() {
        return data;
    }

    public void setData(AppointmentCodeData data) {
        this.data = data;
    }

    private static class AppointmentCodeData {

        /** 预约码 */
        private String appointmentCode;
        /** 访客ID */
        private Integer id;
        /** 是否是客户端等级 */
        private Integer isClient;
        /** 被访人部门 */
        private String isv_deptName;
        /** 被访人ID */
        private Integer isv_id;
        /** 被访名称 */
        private String isv_name;
        /** 访客状态 */
        private Integer status;
        /** 被访人状态名称 */
        private String statusName;
        /** 邀请码 */
        private String v_barCode;
        /** 证件头像 */
        private String v_certificateHead;
        /** 证件号 */
        private String v_certificateNumber;
        /** 证件类型 */
        private String v_certificateType;
        /** 访客单元 */
        private String v_dw;
        /** 访客离访时间 */
        private Integer v_lvTime;
        /** 访客离访时间 yyyy-MM-dd HH:mm:ss */
        private String v_lvTimeStr;
        /** 访客姓名 */
        private String v_name;
        /** 来访人数 */
        private Integer v_personSum;
        /** 访客电话 */
        private String v_phone;
        /** 来访理由 */
        private String v_reason;
        /** 访客性别 */
        private String v_sex;
        /** 访客来访时间 */
        private Integer v_time;
        /** 访客来访时间 yyyy-MM-dd HH:mm:ss */
        private String v_timeStr;
        /** 访客类型 */
        private Integer visitorType;

    }
}
