package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

import java.util.List;

/***
 * 访客预约
 * @author 237417
 * @since 20210421
 */
public class VisitorAppointmentRequest extends AbstractIccRequest<VisitorAppointmentResponse> {

    /** 用户名 */
    private Integer isv_id;
    /** 密码 */
    private String v_name;
    /** 昵称 */
    private String v_phone;
    /** 爱好 */
    private Object v_certificateNumber;
    /** 访客单位 */
    private String v_dw;
    /** 来访人数 */
    private String v_personSum;
    /** 来访事由 */
    private String v_reason;
    /** 来访时间 yyyy-MM-dd HH:mm:ss */
    private String v_timeStr;
    /** 预约离访时间 yyyy-MM-dd HH:mm:ss */
    private String v_lvTimeStr;
    /** 车牌号 */
    private String v_plateNumber;
    /** 人脸图片 base64 */
    private String faceFile;
    /** 随访人员列表 */
    private List<FollowVisitors> followVisitors;
    /** 访客类型：1 VIP，0 普通 */
    private Integer visitorType;

    public VisitorAppointmentRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_VISITOR_APPOINTMENT_POST), Method.POST);
        this.isv_id = builder.isv_id;
        this.v_name = builder.v_name;
        this.v_phone = builder.v_phone;
        this.v_certificateNumber = builder.v_certificateNumber;
        this.v_dw = builder.v_dw;
        this.v_personSum = builder.v_personSum;
        this.v_reason = builder.v_reason;
        this.v_timeStr = builder.v_timeStr;
        this.v_lvTimeStr = builder.v_lvTimeStr;
        this.v_plateNumber = builder.v_plateNumber;
        this.faceFile = builder.faceFile;
        this.followVisitors = builder.followVisitors;
        this.visitorType = builder.visitorType;
        putBodyParameter("isv_id",isv_id);
        putBodyParameter("v_name",v_name);
        putBodyParameter("v_phone",v_phone);
        putBodyParameter("v_certificateNumber",v_certificateNumber);
        putBodyParameter("v_dw",v_dw);
        putBodyParameter("v_personSum",v_personSum);
        putBodyParameter("v_reason",v_reason);
        putBodyParameter("v_timeStr",v_timeStr);
        putBodyParameter("v_lvTimeStr",v_lvTimeStr);
        putBodyParameter("v_plateNumber",v_plateNumber);
        putBodyParameter("faceFile",faceFile);
        putBodyParameter("followVisitors",followVisitors);
        putBodyParameter("visitorType",visitorType);

    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<VisitorAppointmentResponse> getResponseClass() {
        return VisitorAppointmentResponse.class;
    }

    public Integer getIsv_id() {
        return isv_id;
    }

    public void setIsv_id(Integer isv_id) {
        putBodyParameter("isv_id",isv_id);
        this.isv_id = isv_id;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        putBodyParameter("v_name",v_name);
        this.v_name = v_name;
    }

    public String getV_phone() {
        return v_phone;
    }

    public void setV_phone(String v_phone) {
        putBodyParameter("v_phone",v_phone);
        this.v_phone = v_phone;
    }

    public Object getV_certificateNumber() {
        return v_certificateNumber;
    }

    public void setV_certificateNumber(Object v_certificateNumber) {
        putBodyParameter("v_certificateNumber",v_certificateNumber);
        this.v_certificateNumber = v_certificateNumber;
    }

    public String getV_dw() {
        return v_dw;
    }

    public void setV_dw(String v_dw) {
        putBodyParameter("v_dw",v_dw);
        this.v_dw = v_dw;
    }

    public String getV_personSum() {
        return v_personSum;
    }

    public void setV_personSum(String v_personSum) {
        putBodyParameter("v_personSum",v_personSum);
        this.v_personSum = v_personSum;
    }

    public String getV_reason() {
        return v_reason;
    }

    public void setV_reason(String v_reason) {
        putBodyParameter("v_reason",v_reason);
        this.v_reason = v_reason;
    }

    public String getV_timeStr() {
        return v_timeStr;
    }

    public void setV_timeStr(String v_timeStr) {
        putBodyParameter("v_timeStr",v_timeStr);
        this.v_timeStr = v_timeStr;
    }

    public String getV_lvTimeStr() {
        return v_lvTimeStr;
    }

    public void setV_lvTimeStr(String v_lvTimeStr) {
        putBodyParameter("v_lvTimeStr",v_lvTimeStr);
        this.v_lvTimeStr = v_lvTimeStr;
    }

    public String getV_plateNumber() {
        return v_plateNumber;
    }

    public void setV_plateNumber(String v_plateNumber) {
        putBodyParameter("v_plateNumber",v_plateNumber);
        this.v_plateNumber = v_plateNumber;
    }

    public String getFaceFile() {
        return faceFile;
    }

    public void setFaceFile(String faceFile) {
        putBodyParameter("faceFile",faceFile);
        this.faceFile = faceFile;
    }

    public List<FollowVisitors> getFollowVisitors() {
        return followVisitors;
    }

    public void setFollowVisitors(List<FollowVisitors> followVisitors) {
        putBodyParameter("followVisitors",followVisitors);
        this.followVisitors = followVisitors;
    }

    public Integer getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(Integer visitorType) {
        putBodyParameter("visitorType",visitorType);
        this.visitorType = visitorType;
    }

    @Override
    public String toString() {
        return "VisitorAppointmentRequest{" +
                "isv_id=" + isv_id +
                ", v_name='" + v_name + '\'' +
                ", v_phone='" + v_phone + '\'' +
                ", v_certificateNumber=" + v_certificateNumber +
                ", v_dw='" + v_dw + '\'' +
                ", v_personSum='" + v_personSum + '\'' +
                ", v_reason='" + v_reason + '\'' +
                ", v_timeStr='" + v_timeStr + '\'' +
                ", v_lvTimeStr='" + v_lvTimeStr + '\'' +
                ", v_plateNumber='" + v_plateNumber + '\'' +
                ", faceFile='" + faceFile + '\'' +
                ", followVisitors=" + followVisitors +
                ", visitorType=" + visitorType +
                '}';
    }

    public static class Builder {

        /** 用户名 */
        private Integer isv_id;
        /** 密码 */
        private String v_name;
        /** 昵称 */
        private String v_phone;
        /** 爱好 */
        private Object v_certificateNumber;
        /** 访客单位 */
        private String v_dw;
        /** 来访人数 */
        private String v_personSum;
        /** 来访事由 */
        private String v_reason;
        /** 来访时间 yyyy-MM-dd HH:mm:ss */
        private String v_timeStr;
        /** 预约离访时间 yyyy-MM-dd HH:mm:ss */
        private String v_lvTimeStr;
        /** 车牌号 */
        private String v_plateNumber;
        /** 人脸图片 base64 */
        private String faceFile;
        /** 随访人员列表 */
        private List<FollowVisitors> followVisitors;
        /** 访客类型：1 VIP，0 普通 */
        private Integer visitorType;

        public Builder isv_id(Integer isv_id) {
            this.isv_id = isv_id;
            return this;
        }

        public Builder v_name(String v_name) {
            this.v_name = v_name;
            return this;
        }

        public Builder v_phone(String v_phone) {
            this.v_phone = v_phone;
            return this;
        }

        public Builder v_certificateNumber(Object v_certificateNumber) {
            this.v_certificateNumber = v_certificateNumber;
            return this;
        }

        public Builder v_dw(String v_dw) {
            this.v_dw = v_dw;
            return this;
        }

        public Builder v_personSum(String v_personSum) {
            this.v_personSum = v_personSum;
            return this;
        }

        public Builder reason(String v_reason) {
            this.v_reason = v_reason;
            return this;
        }

        public Builder v_timeStr(String v_timeStr) {
            this.v_timeStr = v_timeStr;
            return this;
        }

        public Builder v_lvTimeStr(String v_lvTimeStr) {
            this.v_lvTimeStr = v_lvTimeStr;
            return this;
        }

        public Builder v_plateNumber(String v_plateNumber) {
            this.v_plateNumber = v_plateNumber;
            return this;
        }

        public Builder faceFile(String faceFile) {
            this.faceFile = faceFile;
            return this;
        }

        public Builder followVisitors(List<FollowVisitors> followVisitors) {
            this.followVisitors = followVisitors;
            return this;
        }

        public Builder visitorType(Integer visitorType) {
            this.visitorType = visitorType;
            return this;
        }

        public VisitorAppointmentRequest build() throws ClientException {
            return new VisitorAppointmentRequest(this);
        }
    }

    public static class FollowVisitors {
        /** 姓名 */
        private String v_name;
        /** 电话 */
        private String v_phone;
        /** 证件号 */
        private String v_certificateNumber;
        /** 车牌号 */
        private String v_plateNumber;
        /** 图片 */
        private String faceFile;

        public String getV_name() {
            return v_name;
        }

        public void setV_name(String v_name) {
            this.v_name = v_name;
        }

        public String getV_phone() {
            return v_phone;
        }

        public void setV_phone(String v_phone) {
            this.v_phone = v_phone;
        }

        public String getV_certificateNumber() {
            return v_certificateNumber;
        }

        public void setV_certificateNumber(String v_certificateNumber) {
            this.v_certificateNumber = v_certificateNumber;
        }

        public String getV_plateNumber() {
            return v_plateNumber;
        }

        public void setV_plateNumber(String v_plateNumber) {
            this.v_plateNumber = v_plateNumber;
        }

        public String getFaceFile() {
            return faceFile;
        }

        public void setFaceFile(String faceFile) {
            this.faceFile = faceFile;
        }
    }
}