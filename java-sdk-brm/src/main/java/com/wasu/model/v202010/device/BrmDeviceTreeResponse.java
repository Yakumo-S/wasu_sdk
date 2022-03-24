package com.wasu.model.v202010.device;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 设备分页查询结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-03 09:59:11
 */
public class BrmDeviceTreeResponse extends IccResponse {
  private DeviceTreeValue data;

  @Override
  public String toString() {
    return "BrmDeviceTreeResponse{" + "data=" + data + '}';
  }

  public DeviceTreeValue getData() {
    return data;
  }

  public void setData(DeviceTreeValue data) {
    this.data = data;
  }

  public static class DeviceTreeValue {
    private List<DeviceTreeData> value;

    public List<DeviceTreeData> getValue() {
      return value;
    }

    public void setValue(List<DeviceTreeData> value) {
      this.value = value;
    }
  }

  public static class DeviceTreeData {
    private String id;
    private String name;
    private String pid;
    private String type;
    private String nodeType;
    private String iconType;
    private boolean isParent;
    private boolean isCheck;
    private int deviceCategory;
    private String deviceModel;
    private int deviceType;
    private String deviceCode;
    private int unitType;
    private String ownerCode;
    private String cameraType;
    private String capability;
    private String sn;
    private int isVirtual;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPid() {
      return pid;
    }

    public void setPid(String pid) {
      this.pid = pid;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getNodeType() {
      return nodeType;
    }

    public void setNodeType(String nodeType) {
      this.nodeType = nodeType;
    }

    public String getIconType() {
      return iconType;
    }

    public void setIconType(String iconType) {
      this.iconType = iconType;
    }

    public boolean isParent() {
      return isParent;
    }

    public void setParent(boolean parent) {
      isParent = parent;
    }

    public boolean isCheck() {
      return isCheck;
    }

    public void setCheck(boolean check) {
      isCheck = check;
    }

    public int getDeviceCategory() {
      return deviceCategory;
    }

    public void setDeviceCategory(int deviceCategory) {
      this.deviceCategory = deviceCategory;
    }

    public String getDeviceModel() {
      return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
      this.deviceModel = deviceModel;
    }

    public int getDeviceType() {
      return deviceType;
    }

    public void setDeviceType(int deviceType) {
      this.deviceType = deviceType;
    }

    public String getDeviceCode() {
      return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
      this.deviceCode = deviceCode;
    }

    public int getUnitType() {
      return unitType;
    }

    public void setUnitType(int unitType) {
      this.unitType = unitType;
    }

    public String getOwnerCode() {
      return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
      this.ownerCode = ownerCode;
    }

    public String getCameraType() {
      return cameraType;
    }

    public void setCameraType(String cameraType) {
      this.cameraType = cameraType;
    }

    public String getCapability() {
      return capability;
    }

    public void setCapability(String capability) {
      this.capability = capability;
    }

    public String getSn() {
      return sn;
    }

    public void setSn(String sn) {
      this.sn = sn;
    }

    public int getIsVirtual() {
      return isVirtual;
    }

    public void setIsVirtual(int isVirtual) {
      this.isVirtual = isVirtual;
    }

    @Override
    public String toString() {
      return "DevicePageData{"
          + "id='"
          + id
          + '\''
          + ", name='"
          + name
          + '\''
          + ", pid='"
          + pid
          + '\''
          + ", type='"
          + type
          + '\''
          + ", nodeType='"
          + nodeType
          + '\''
          + ", iconType='"
          + iconType
          + '\''
          + ", isParent="
          + isParent
          + ", isCheck="
          + isCheck
          + ", deviceCategory="
          + deviceCategory
          + ", deviceModel='"
          + deviceModel
          + '\''
          + ", deviceType="
          + deviceType
          + ", deviceCode='"
          + deviceCode
          + '\''
          + ", unitType="
          + unitType
          + ", ownerCode='"
          + ownerCode
          + '\''
          + ", cameraType='"
          + cameraType
          + '\''
          + ", capability='"
          + capability
          + '\''
          + ", sn='"
          + sn
          + '\''
          + ", isVirtual="
          + isVirtual
          + '}';
    }
  }
}
