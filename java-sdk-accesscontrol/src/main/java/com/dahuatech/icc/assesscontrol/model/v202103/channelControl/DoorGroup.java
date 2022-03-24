package com.dahuatech.icc.assesscontrol.model.v202103.channelControl;

/**
 * 门组
 *
 * @author 237417
 */
public class DoorGroup {

    /** ID */
    private Number id;
    /** 通道编码 */
    private String channelCode;
    /** 通道名称 */
    private String channelName;
    /** 设备编码 */
    private String deviceCode;
    /** 设备名称 */
    private String deviceName;
    /** 设备在离线状态 */
    private String deviceStatus;
    /** 门组ID */
    private Number groupId;
    /** 是否在线 */
    private String online;
    /** 组织名称 */
    private String orgName;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
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

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Number getGroupId() {
        return groupId;
    }

    public void setGroupId(Number groupId) {
        this.groupId = groupId;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "DoorGroupList{" +
                "id=" + id +
                ", channelCode='" + channelCode + '\'' +
                ", channelName='" + channelName + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", groupId=" + groupId +
                ", online='" + online + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
