package com.dahuatech.icc.visitors.model.v202104.authorize;

public class AccessChannel {

    /** 通道ID */
    private Integer id;
    /** 启用标志 */
    private String validFlag;
    /** 访客授权通道标志 0否1是 */
    private Integer visitorFLag;
    /** 设备编号 */
    private Integer deviceCode;
    /** 通道编号 */
    private String channelCode;
    /** 通道名称 */
    private String channelName;
    /** 通道序列号 */
    private Integer channelSeq;
    /** 通道所属组织 */
    private String orgCode;
    /** 通道状态 0离线1在线 */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public Integer getVisitorFLag() {
        return visitorFLag;
    }

    public void setVisitorFLag(Integer visitorFLag) {
        this.visitorFLag = visitorFLag;
    }

    public Integer getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(Integer deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getChannelSeq() {
        return channelSeq;
    }

    public void setChannelSeq(Integer channelSeq) {
        this.channelSeq = channelSeq;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccessChannel{" +
                "id=" + id +
                ", validFlag='" + validFlag + '\'' +
                ", visitorFLag=" + visitorFLag +
                ", deviceCode=" + deviceCode +
                ", channelCode='" + channelCode + '\'' +
                ", channelName='" + channelName + '\'' +
                ", channelSeq=" + channelSeq +
                ", orgCode='" + orgCode + '\'' +
                ", status=" + status +
                '}';
    }

}
