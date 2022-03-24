package com.wasu.model.v202010.device;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 设备分页查询结果
 *
 * @author 232676
 * @since 1.0.0 2020-11-03 09:59:11
 */
public class BrmDeviceChannelPageResponse extends IccResponse {
  private DeviceChannelPageData data;

  public DeviceChannelPageData getData() {
    return data;
  }

  public void setData(DeviceChannelPageData data) {
    this.data = data;
  }

  public static class DeviceChannelPageData {
    private List<DeviceChannelPage> pageData;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalRows;

    public List<DeviceChannelPage> getPageData() {
      return pageData;
    }

    public void setPageData(List<DeviceChannelPage> pageData) {
      this.pageData = pageData;
    }

    public int getTotalPage() {
      return totalPage;
    }

    public void setTotalPage(int totalPage) {
      this.totalPage = totalPage;
    }

    public int getPageSize() {
      return pageSize;
    }

    public void setPageSize(int pageSize) {
      this.pageSize = pageSize;
    }

    public int getTotalRows() {
      return totalRows;
    }

    public void setTotalRows(int totalRows) {
      this.totalRows = totalRows;
    }

    public int getCurrentPage() {
      return currentPage;
    }

    public void setCurrentPage(int currentPage) {
      this.currentPage = currentPage;
    }
  }

  public static class DeviceChannelPage {
    private Long id;
    private Integer unitType;
    private Integer unitSeq;
    private String cameraType;
    /** 通道名称 */
    private String channelName;

    private String ownerCode;
    private String channelCode;
    private int isVirtual;
    private int isOnline;
    /** 通道序号 */
    private int channelSeq;
    /** 通道唯一标识码 */
    private String channelSn;
    /** 通道类型 */
    private String channelType;
    /** 是否已接入：0-未接入， 1-接入 */
    private int access;
    /** 通道能力集 */
    private String capability;
    /** 经度 */
    private String gpsX;
    /** 纬度 */
    private String gpsY;
    /** Z轴 */
    private String gpsZ;
    /** 通道描述 */
    private String memo;
    /** 状态： 0-不启用，1-启用 */
    private int stat;
    /** 通道扩展属性 自定义 */
    //    private Map<String, Object> chExt;

    private String chExt;

    private Long mapId;

    private Long domainId;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Integer getUnitType() {
      return unitType;
    }

    public void setUnitType(Integer unitType) {
      this.unitType = unitType;
    }

    public Integer getUnitSeq() {
      return unitSeq;
    }

    public void setUnitSeq(Integer unitSeq) {
      this.unitSeq = unitSeq;
    }

    public String getCameraType() {
      return cameraType;
    }

    public void setCameraType(String cameraType) {
      this.cameraType = cameraType;
    }

    public String getChExt() {
      return chExt;
    }

    public void setChExt(String chExt) {
      this.chExt = chExt;
    }

    public String getChannelName() {
      return channelName;
    }

    public void setChannelName(String channelName) {
      this.channelName = channelName;
    }

    public String getOwnerCode() {
      return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
      this.ownerCode = ownerCode;
    }

    public String getChannelCode() {
      return channelCode;
    }

    public void setChannelCode(String channelCode) {
      this.channelCode = channelCode;
    }

    public int getIsVirtual() {
      return isVirtual;
    }

    public void setIsVirtual(int isVirtual) {
      this.isVirtual = isVirtual;
    }

    public int getIsOnline() {
      return isOnline;
    }

    public void setIsOnline(int isOnline) {
      this.isOnline = isOnline;
    }

    public int getChannelSeq() {
      return channelSeq;
    }

    public void setChannelSeq(int channelSeq) {
      this.channelSeq = channelSeq;
    }

    public String getChannelSn() {
      return channelSn;
    }

    public void setChannelSn(String channelSn) {
      this.channelSn = channelSn;
    }

    public String getChannelType() {
      return channelType;
    }

    public void setChannelType(String channelType) {
      this.channelType = channelType;
    }

    public int getAccess() {
      return access;
    }

    public void setAccess(int access) {
      this.access = access;
    }

    public String getCapability() {
      return capability;
    }

    public void setCapability(String capability) {
      this.capability = capability;
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

    public String getGpsZ() {
      return gpsZ;
    }

    public void setGpsZ(String gpsZ) {
      this.gpsZ = gpsZ;
    }

    public String getMemo() {
      return memo;
    }

    public void setMemo(String memo) {
      this.memo = memo;
    }

    public int getStat() {
      return stat;
    }

    public void setStat(int stat) {
      this.stat = stat;
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

    @Override
    public String toString() {
      return "DeviceChannelPage{"
          + "id="
          + id
          + ", unitType="
          + unitType
          + ", unitSeq="
          + unitSeq
          + ", cameraType='"
          + cameraType
          + '\''
          + ", channelName='"
          + channelName
          + '\''
          + ", ownerCode='"
          + ownerCode
          + '\''
          + ", channelCode='"
          + channelCode
          + '\''
          + ", isVirtual="
          + isVirtual
          + ", isOnline="
          + isOnline
          + ", channelSeq="
          + channelSeq
          + ", channelSn='"
          + channelSn
          + '\''
          + ", channelType='"
          + channelType
          + '\''
          + ", access="
          + access
          + ", capability='"
          + capability
          + '\''
          + ", gpsX='"
          + gpsX
          + '\''
          + ", gpsY='"
          + gpsY
          + '\''
          + ", gpsZ='"
          + gpsZ
          + '\''
          + ", memo='"
          + memo
          + '\''
          + ", stat="
          + stat
          + ", chExt="
          + ", mapId="
          + mapId
          + ", domainId="
          + domainId
          + '}';
    }
  }
}
