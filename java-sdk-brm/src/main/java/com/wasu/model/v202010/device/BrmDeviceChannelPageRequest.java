package com.wasu.model.v202010.device;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 卡片分页查询
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeviceChannelPageRequest extends AbstractIccRequest<BrmDeviceChannelPageResponse> {

  private int pageNum;
  private int pageSize;
  /**
   * 排序属性
   * 支持排序属性：id、updateTime、ownerCode、deviceCode、channelCode、unitType、channelType、cameraType、channelSn
   */
  private String sort;
  /** 排序方式 ：ASC-升序， DESC-降序(默认) */
  private String sortType;
  /** 所属组织编码 */
  private String ownerCode;
  /** 设备编码列表 */
  private List<String> deviceCodeList;
  /** 通道编码列表 */
  private List<String> channelCodeList;
  /** 单元类型列表 */
  private List<String> unitTypeList;
  /** 通道类型列表 */
  private List<String> channelTypeList;

  /** isOnline */
  private Integer isOnline;

  private Integer access;
  private Integer isVirtual;
  private Integer stat;
  /** 是否包含子节点,默认false,不展示下级通道 */
  private boolean includeSubOwnerCodeFlag;

  public BrmDeviceChannelPageRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEVICE_CHANNEL_PAGE_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
    putBodyParameter("pageNum", 1);
    putBodyParameter("pageSize", 10);
  }

  @Override
  public Class<BrmDeviceChannelPageResponse> getResponseClass() {
    return BrmDeviceChannelPageResponse.class;
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    putBodyParameter("pageNum", pageNum);
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    putBodyParameter("pageSize", pageSize);
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
    putBodyParameter("sort", sort);
  }

  public String getSortType() {
    return sortType;
  }

  public void setSortType(String sortType) {
    this.sortType = sortType;
    putBodyParameter("sortType", sortType);
  }

  public String getOwnerCode() {
    return ownerCode;
  }

  public void setOwnerCode(String ownerCode) {
    this.ownerCode = ownerCode;
    putBodyParameter("ownerCode", ownerCode);
  }

  public List<String> getDeviceCodeList() {
    return deviceCodeList;
  }

  public void setDeviceCodeList(List<String> deviceCodeList) {
    this.deviceCodeList = deviceCodeList;
    putBodyParameter("deviceCodeList", deviceCodeList);
  }

  public List<String> getChannelCodeList() {
    return channelCodeList;
  }

  public void setChannelCodeList(List<String> channelCodeList) {
    this.channelCodeList = channelCodeList;
    putBodyParameter("channelCodeList", channelCodeList);
  }

  public List<String> getUnitTypeList() {
    return unitTypeList;
  }

  public void setUnitTypeList(List<String> unitTypeList) {
    this.unitTypeList = unitTypeList;
    putBodyParameter("unitTypeList", unitTypeList);
  }

  public List<String> getChannelTypeList() {
    return channelTypeList;
  }

  public void setChannelTypeList(List<String> channelTypeList) {
    this.channelTypeList = channelTypeList;
    putBodyParameter("channelTypeList", channelTypeList);
  }

  public Integer getIsOnline() {
    return isOnline;
  }

  public void setIsOnline(Integer isOnline) {
    this.isOnline = isOnline;
    putBodyParameter("isOnline", isOnline);
  }

  public Integer getAccess() {
    return access;
  }

  public void setAccess(Integer access) {
    this.access = access;
    putBodyParameter("access", access);
  }

  public Integer getIsVirtual() {
    return isVirtual;
  }

  public void setIsVirtual(Integer isVirtual) {
    this.isVirtual = isVirtual;
    putBodyParameter("isVirtual", isVirtual);
  }

  public Integer getStat() {
    return stat;
  }

  public void setStat(Integer stat) {
    this.stat = stat;
    putBodyParameter("stat", stat);
  }

  public boolean isIncludeSubOwnerCodeFlag() {
    return includeSubOwnerCodeFlag;
  }

  public void setIncludeSubOwnerCodeFlag(boolean includeSubOwnerCodeFlag) {
    this.includeSubOwnerCodeFlag = includeSubOwnerCodeFlag;
    putBodyParameter("includeSubOwnerCodeFlag", includeSubOwnerCodeFlag);
  }

  @Override
  public String toString() {
    return "BrmDeviceChannelPageRequest{"
        + "pageNum="
        + pageNum
        + ", pageSize="
        + pageSize
        + ", sort='"
        + sort
        + '\''
        + ", sortType='"
        + sortType
        + '\''
        + ", ownerCode='"
        + ownerCode
        + '\''
        + ", deviceCodeList="
        + deviceCodeList
        + ", channelCodeList="
        + channelCodeList
        + ", unitTypeList="
        + unitTypeList
        + ", channelTypeList="
        + channelTypeList
        + ", isOnline="
        + isOnline
        + ", access="
        + access
        + ", isVirtual="
        + isVirtual
        + ", stat="
        + stat
        + ", includeSubOwnerCodeFlag="
        + includeSubOwnerCodeFlag
        + '}';
  }
}
