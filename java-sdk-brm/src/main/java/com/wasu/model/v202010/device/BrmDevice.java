package com.wasu.model.v202010.device;

import java.util.List;
import java.util.Map;

/**
 * @author 232676
 * @since 1.0.0 2020/11/14 10:37
 */
public class BrmDevice {
  /** 设备名称 */
  private String deviceName;

  /** 设备编码 */
  private String deviceCode;

  /** 设备标识码 */
  private String deviceSn;

  /** 设备mac地址 */
  private String deviceMac;

  /** 设备种类 */
  private Integer deviceCategory;

  /** 设备类型 */
  private Integer deviceType;

  /** 设备厂商 */
  private String deviceManufacturer;

  /** 协议 */
  private String protocol;

  /** 设备型号 */
  private String deviceModel;

  /** 当前设备在其他子系统中的设备类型 */
  private List<String> otherType;

  /** 设备地址 */
  /*@Pattern(regexp = IP,message = DEV_IP_INVALID,groups = {AddGroup.class, UpdateGroup.class})*/
  private String deviceIp;

  /** 设备端口 */
  private Integer devicePort;

  /** 所属编码 */
  private String ownerCode;

  /** 所属组织名称 */
  private String orgName;

  private String oldOwnerCode;

  /** 登入类型 */
  private String loginType;

  /** 登录名称 */
  private String loginName;

  /** 登录密码 */
  private String loginPassword;

  /** 密码是否变更 */
  private boolean isPwdChange;

  /** 主动注册服务ID */
  private Long registServiceId;

  /** 主动注册服务器编码 */
  private String registServerCode;

  /** 主动注册代理端口 */
  private Integer registProxyPort;

  /** 主动注册设备编码 */
  private String registDeviceCode;

  /** mcd服务代理端口 */
  private Integer mcdProxyPort;

  /** mcd服务器编码 */
  private String mcdProxyServerCode;

  /** 描述 */
  private String memo;

  /** 在线状态 */
  private Integer isOnline;

  /** 离线原因 */
  private String offlineReason;

  /** 是否虚拟设备 */
  private Integer isVirtual;

  /** 经度 */
  private String gpsX;
  /** 纬度 */
  private String gpsY;

  /** 光栅图 */
  private Long mapId;

  /** 域id */
  private Long domainId;

  /** 设备能力集 */
  private String capability;

  /** 所属子系统 */
  private String subSystem;

  /** 设备扩展信息 */
  private Map<String, Object> devExt;

  /** 单元信息 */
  private List<BrmDeviceUnit> units;

  /****** 设备删除 *****/
  private List<String> deviceCodes;

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }

  public String getDeviceSn() {
    return deviceSn;
  }

  public void setDeviceSn(String deviceSn) {
    this.deviceSn = deviceSn;
  }

  public String getDeviceMac() {
    return deviceMac;
  }

  public void setDeviceMac(String deviceMac) {
    this.deviceMac = deviceMac;
  }

  public Integer getDeviceCategory() {
    return deviceCategory;
  }

  public void setDeviceCategory(Integer deviceCategory) {
    this.deviceCategory = deviceCategory;
  }

  public Integer getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(Integer deviceType) {
    this.deviceType = deviceType;
  }

  public String getDeviceManufacturer() {
    return deviceManufacturer;
  }

  public void setDeviceManufacturer(String deviceManufacturer) {
    this.deviceManufacturer = deviceManufacturer;
  }

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public String getDeviceModel() {
    return deviceModel;
  }

  public void setDeviceModel(String deviceModel) {
    this.deviceModel = deviceModel;
  }

  public List<String> getOtherType() {
    return otherType;
  }

  public void setOtherType(List<String> otherType) {
    this.otherType = otherType;
  }

  public String getDeviceIp() {
    return deviceIp;
  }

  public void setDeviceIp(String deviceIp) {
    this.deviceIp = deviceIp;
  }

  public Integer getDevicePort() {
    return devicePort;
  }

  public void setDevicePort(Integer devicePort) {
    this.devicePort = devicePort;
  }

  public String getOwnerCode() {
    return ownerCode;
  }

  public void setOwnerCode(String ownerCode) {
    this.ownerCode = ownerCode;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public String getOldOwnerCode() {
    return oldOwnerCode;
  }

  public void setOldOwnerCode(String oldOwnerCode) {
    this.oldOwnerCode = oldOwnerCode;
  }

  public String getLoginType() {
    return loginType;
  }

  public void setLoginType(String loginType) {
    this.loginType = loginType;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }

  public boolean isPwdChange() {
    return isPwdChange;
  }

  public void setPwdChange(boolean pwdChange) {
    isPwdChange = pwdChange;
  }

  public Long getRegistServiceId() {
    return registServiceId;
  }

  public void setRegistServiceId(Long registServiceId) {
    this.registServiceId = registServiceId;
  }

  public String getRegistServerCode() {
    return registServerCode;
  }

  public void setRegistServerCode(String registServerCode) {
    this.registServerCode = registServerCode;
  }

  public Integer getRegistProxyPort() {
    return registProxyPort;
  }

  public void setRegistProxyPort(Integer registProxyPort) {
    this.registProxyPort = registProxyPort;
  }

  public String getRegistDeviceCode() {
    return registDeviceCode;
  }

  public void setRegistDeviceCode(String registDeviceCode) {
    this.registDeviceCode = registDeviceCode;
  }

  public Integer getMcdProxyPort() {
    return mcdProxyPort;
  }

  public void setMcdProxyPort(Integer mcdProxyPort) {
    this.mcdProxyPort = mcdProxyPort;
  }

  public String getMcdProxyServerCode() {
    return mcdProxyServerCode;
  }

  public void setMcdProxyServerCode(String mcdProxyServerCode) {
    this.mcdProxyServerCode = mcdProxyServerCode;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Integer getIsOnline() {
    return isOnline;
  }

  public void setIsOnline(Integer isOnline) {
    this.isOnline = isOnline;
  }

  public String getOfflineReason() {
    return offlineReason;
  }

  public void setOfflineReason(String offlineReason) {
    this.offlineReason = offlineReason;
  }

  public Integer getIsVirtual() {
    return isVirtual;
  }

  public void setIsVirtual(Integer isVirtual) {
    this.isVirtual = isVirtual;
  }

  public String getGpsX() {
    return gpsX;
  }

  public void setGpsX(String gpsX) {
    this.gpsX = gpsX;
  }

  public String getGpsY() {
    return gpsY;
  }

  public void setGpsY(String gpsY) {
    this.gpsY = gpsY;
  }

  public Long getMapId() {
    return mapId;
  }

  public void setMapId(Long mapId) {
    this.mapId = mapId;
  }

  public Long getDomainId() {
    return domainId;
  }

  public void setDomainId(Long domainId) {
    this.domainId = domainId;
  }

  public String getCapability() {
    return capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }

  public String getSubSystem() {
    return subSystem;
  }

  public void setSubSystem(String subSystem) {
    this.subSystem = subSystem;
  }

  public Map<String, Object> getDevExt() {
    return devExt;
  }

  public void setDevExt(Map<String, Object> devExt) {
    this.devExt = devExt;
  }

  public List<BrmDeviceUnit> getUnits() {
    return units;
  }

  public void setUnits(List<BrmDeviceUnit> units) {
    this.units = units;
  }

  public List<String> getDeviceCodes() {
    return deviceCodes;
  }

  public void setDeviceCodes(List<String> deviceCodes) {
    this.deviceCodes = deviceCodes;
  }

  @Override
  public String toString() {
    return "BrmDevice{"
        + "deviceName='"
        + deviceName
        + '\''
        + ", deviceCode='"
        + deviceCode
        + '\''
        + ", deviceSn='"
        + deviceSn
        + '\''
        + ", deviceMac='"
        + deviceMac
        + '\''
        + ", deviceCategory="
        + deviceCategory
        + ", deviceType="
        + deviceType
        + ", deviceManufacturer='"
        + deviceManufacturer
        + '\''
        + ", protocol='"
        + protocol
        + '\''
        + ", deviceModel='"
        + deviceModel
        + '\''
        + ", otherType="
        + otherType
        + ", deviceIp='"
        + deviceIp
        + '\''
        + ", devicePort="
        + devicePort
        + ", ownerCode='"
        + ownerCode
        + '\''
        + ", orgName='"
        + orgName
        + '\''
        + ", oldOwnerCode='"
        + oldOwnerCode
        + '\''
        + ", loginType='"
        + loginType
        + '\''
        + ", loginName='"
        + loginName
        + '\''
        + ", loginPassword='"
        + loginPassword
        + '\''
        + ", isPwdChange="
        + isPwdChange
        + ", registServiceId="
        + registServiceId
        + ", registServerCode='"
        + registServerCode
        + '\''
        + ", registProxyPort="
        + registProxyPort
        + ", registDeviceCode='"
        + registDeviceCode
        + '\''
        + ", mcdProxyPort="
        + mcdProxyPort
        + ", mcdProxyServerCode='"
        + mcdProxyServerCode
        + '\''
        + ", memo='"
        + memo
        + '\''
        + ", isOnline="
        + isOnline
        + ", offlineReason='"
        + offlineReason
        + '\''
        + ", isVirtual="
        + isVirtual
        + ", gpsX='"
        + gpsX
        + '\''
        + ", gpsY='"
        + gpsY
        + '\''
        + ", mapId="
        + mapId
        + ", domainId="
        + domainId
        + ", capability='"
        + capability
        + '\''
        + ", subSystem='"
        + subSystem
        + '\''
        + ", devExt="
        + devExt
        + ", units="
        + units
        + ", deviceCodes="
        + deviceCodes
        + '}';
  }
}
