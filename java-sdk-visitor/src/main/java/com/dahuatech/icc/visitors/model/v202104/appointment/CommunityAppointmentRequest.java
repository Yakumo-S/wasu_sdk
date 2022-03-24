package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;

import java.util.List;

/***
 * 社区云预约访客
 * @author 237417
 * @since 20210421
 */
public class CommunityAppointmentRequest extends AbstractIccRequest<CommunityAppointmentResponse> {

    /** 访客电话;必填 */
    private String v_phone;
    /** 访客证件类型：必填 */
    private String v_certificateType;
    /** 门禁通道名称；必填 */
    private String v_certificateNumber;
    /** 车牌 */
    private String v_plateNumber;
    /** 来访理由；必填 */
    private String v_reason;
    /** 来访人数；必填 */
    private String v_personSum;
    /** 访客姓名；必填 */
    private String v_name;
    /** 来访单位；必填 */
    private String v_dw;
    /** 预约来访时间; 必填 yyyy-MM-dd HH:mm:ss */
    private String v_timeStr;
    /** 预约离访时间; 必填 yyyy-MM-dd HH:mm:ss */
    private String v_lvTimeStr;
    /** 被访人编号；必填 */
    private String isvCode;
    /** 授权门禁通道 */
    private List<String> accessChannels;
    /** 授权对讲设备 */
    private List<String> videoTokeChannels;
    /** 授权场区编号 */
    private String parkingLotCode;

    public CommunityAppointmentRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_VISITOR_GET_REVIEW_LIST_POST), Method.POST);
        this.v_phone = builder.v_phone;
        this.v_certificateType = builder.v_certificateType;
        this.v_certificateNumber = builder.v_certificateNumber;
        this.v_plateNumber = builder.v_plateNumber;
        this.v_reason = builder.v_reason;
        this.v_personSum = builder.v_personSum;
        this.v_name = builder.v_name;
        this.v_dw = builder.v_dw;
        this.v_timeStr = builder.v_timeStr;
        this.v_lvTimeStr = builder.v_lvTimeStr;
        this.isvCode = builder.isvCode;
        this.accessChannels = builder.accessChannels;
        this.videoTokeChannels = builder.videoTokeChannels;
        this.parkingLotCode = builder.parkingLotCode;
        putBodyParameter("v_phone",v_phone);
        putBodyParameter("v_certificateType",v_certificateType);
        putBodyParameter("v_certificateNumber",v_certificateNumber);
        putBodyParameter("v_plateNumber",v_plateNumber);
        putBodyParameter("v_reason",v_reason);
        putBodyParameter("v_personSum",v_personSum);
        putBodyParameter("v_name",v_name);
        putBodyParameter("v_dw",v_dw);
        putBodyParameter("v_timeStr",v_timeStr);
        putBodyParameter("v_lvTimeStr",v_lvTimeStr);
        putBodyParameter("isvCode",isvCode);
        putBodyParameter("accessChannels",accessChannels);
        putBodyParameter("videoTokeChannels",videoTokeChannels);
        putBodyParameter("parkingLotCode",parkingLotCode);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<CommunityAppointmentResponse> getResponseClass() {
        return CommunityAppointmentResponse.class;
    }

    public String getV_phone() {
        return v_phone;
    }

    public void setV_phone(String v_phone) {
        this.v_phone = v_phone;
        putBodyParameter("v_phone",v_phone);
    }

    public String getV_certificateType() {
        return v_certificateType;
    }

    public void setV_certificateType(String v_certificateType) {
        putBodyParameter("v_certificateType",v_certificateType);
        this.v_certificateType = v_certificateType;
    }

    public String getV_certificateNumber() {
        return v_certificateNumber;
    }

    public void setV_certificateNumber(String v_certificateNumber) {
        putBodyParameter("v_certificateNumber",v_certificateNumber);
        this.v_certificateNumber = v_certificateNumber;
    }

    public String getV_plateNumber() {
        return v_plateNumber;
    }

    public void setV_plateNumber(String v_plateNumber) {
        putBodyParameter("v_plateNumber",v_plateNumber);
        this.v_plateNumber = v_plateNumber;
    }

    public String getV_reason() {
        return v_reason;
    }

    public void setV_reason(String v_reason) {
        putBodyParameter("v_reason",v_reason);
        this.v_reason = v_reason;
    }

    public String getV_personSum() {
        return v_personSum;
    }

    public void setV_personSum(String v_personSum) {
        putBodyParameter("v_personSum",v_personSum);
        this.v_personSum = v_personSum;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        putBodyParameter("v_name",v_name);
        this.v_name = v_name;
    }

    public String getV_dw() {
        return v_dw;
    }

    public void setV_dw(String v_dw) {
        putBodyParameter("v_dw",v_dw);
        this.v_dw = v_dw;
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

    public String getIsvCode() {
        return isvCode;
    }

    public void setIsvCode(String isvCode) {
        putBodyParameter("isvCode",isvCode);
        this.isvCode = isvCode;
    }

    public List<String> getAccessChannels() {
        return accessChannels;
    }

    public void setAccessChannels(List<String> accessChannels) {
        putBodyParameter("accessChannels",accessChannels);
        this.accessChannels = accessChannels;
    }

    public List<String> getVideoTokeChannels() {
        return videoTokeChannels;
    }

    public void setVideoTokeChannels(List<String> videoTokeChannels) {
        putBodyParameter("videoTokeChannels",videoTokeChannels);
        this.videoTokeChannels = videoTokeChannels;
    }

    public String getParkingLotCode() {
        return parkingLotCode;
    }

    public void setParkingLotCode(String parkingLotCode) {
        putBodyParameter("parkingLotCode",parkingLotCode);
        this.parkingLotCode = parkingLotCode;
    }

    @Override
    public String toString() {
        return "CommunityAppointmentRequest{" +
                "v_phone='" + v_phone + '\'' +
                ", v_certificateType='" + v_certificateType + '\'' +
                ", v_certificateNumber='" + v_certificateNumber + '\'' +
                ", v_plateNumber='" + v_plateNumber + '\'' +
                ", v_reason='" + v_reason + '\'' +
                ", v_personSum='" + v_personSum + '\'' +
                ", v_name='" + v_name + '\'' +
                ", v_dw='" + v_dw + '\'' +
                ", v_timeStr='" + v_timeStr + '\'' +
                ", v_lvTimeStr='" + v_lvTimeStr + '\'' +
                ", isvCode='" + isvCode + '\'' +
                ", accessChannels=" + accessChannels +
                ", videoTokeChannels=" + videoTokeChannels +
                ", parkingLotCode='" + parkingLotCode + '\'' +
                '}';
    }

    public static class Builder {

        /** 访客电话;必填 */
        private String v_phone;
        /** 访客证件类型：必填 */
        private String v_certificateType;
        /** 门禁通道名称；必填 */
        private String v_certificateNumber;
        /** 车牌 */
        private String v_plateNumber;
        /** 来访理由；必填 */
        private String v_reason;
        /** 来访人数；必填 */
        private String v_personSum;
        /** 访客姓名；必填 */
        private String v_name;
        /** 来访单位；必填 */
        private String v_dw;
        /** 预约来访时间; 必填 yyyy-MM-dd HH:mm:ss */
        private String v_timeStr;
        /** 预约离访时间; 必填 yyyy-MM-dd HH:mm:ss */
        private String v_lvTimeStr;
        /** 被访人编号；必填 */
        private String isvCode;
        /** 授权门禁通道 */
        private List<String> accessChannels;
        /** 授权对讲设备 */
        private List<String> videoTokeChannels;
        /** 授权场区编号 */
        private String parkingLotCode;

        public Builder v_phone(String v_phone) {
            this.v_phone = v_phone;
            return this;
        }

        public Builder v_certificateType(String v_certificateType) {
            this.v_certificateType = v_certificateType;
            return this;
        }

        public Builder v_certificateNumber(String v_certificateNumber) {
            this.v_certificateNumber = v_certificateNumber;
            return this;
        }

        public Builder v_plateNumber(String v_plateNumber) {
            this.v_plateNumber = v_plateNumber;
            return this;
        }

        public Builder v_reason(String v_reason) {
            this.v_reason = v_reason;
            return this;
        }

        public Builder v_personSum(String v_personSum) {
            this.v_personSum = v_personSum;
            return this;
        }

        public Builder v_name(String v_name) {
            this.v_name = v_name;
            return this;
        }

        public Builder v_dw(String v_dw) {
            this.v_dw = v_dw;
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

        public Builder isvCode(String isvCode) {
            this.isvCode = isvCode;
            return this;
        }

        public Builder accessChannels(List<String> accessChannels) {
            this.accessChannels = accessChannels;
            return this;
        }

        public Builder videoTokeChannels(List<String> videoTokeChannels) {
            this.videoTokeChannels = videoTokeChannels;
            return this;
        }

        public Builder parkingLotCode(String parkingLotCode) {
            this.parkingLotCode = parkingLotCode;
            return this;
        }

        public CommunityAppointmentRequest build() throws ClientException {
            return new CommunityAppointmentRequest(this);
        }
    }
}
