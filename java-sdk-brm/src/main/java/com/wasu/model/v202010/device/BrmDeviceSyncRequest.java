package com.wasu.model.v202010.device;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 设备全量数据同步
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeviceSyncRequest extends AbstractIccRequest<BrmDeviceSyncResponse> {

  private int pageNum;
  private int pageSize;

  /** 单元类型,多个 */
  private List<Integer> unitTypes;
  /** 设备大类 */
  private List<Integer> categorys;
  /** 设备小类,设备小类的格式是:大类_小类 */
  private List<String> types;
  /** 是否同步级联设备数据 */
  private int syncCascadeData;
  /** 是否同步虚拟设备数据 */
  private int syncVirtualData;
  /** 同步边界值 */
  private Long maxRangeId;

  public BrmDeviceSyncRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEVICE_PAGE_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
    putBodyParameter("pageNum", 1);
    putBodyParameter("pageSize", 10);
  }

  @Override
  public Class<BrmDeviceSyncResponse> getResponseClass() {
    return BrmDeviceSyncResponse.class;
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

  public List<Integer> getUnitTypes() {
    return unitTypes;
  }

  public void setUnitTypes(List<Integer> unitTypes) {
    this.unitTypes = unitTypes;
    putBodyParameter("unitTypes", unitTypes);
  }

  public List<Integer> getCategorys() {
    return categorys;
  }

  public void setCategorys(List<Integer> categorys) {
    this.categorys = categorys;
    putBodyParameter("categorys", categorys);
  }

  public List<String> getTypes() {
    return types;
  }

  public void setTypes(List<String> types) {
    this.types = types;
    putBodyParameter("types", types);
  }

  public int getSyncCascadeData() {
    return syncCascadeData;
  }

  public void setSyncCascadeData(int syncCascadeData) {
    this.syncCascadeData = syncCascadeData;
    putBodyParameter("syncCascadeData", syncCascadeData);
  }

  public int getSyncVirtualData() {
    return syncVirtualData;
  }

  public void setSyncVirtualData(int syncVirtualData) {
    this.syncVirtualData = syncVirtualData;
    putBodyParameter("syncVirtualData", syncVirtualData);
  }

  public Long getMaxRangeId() {
    return maxRangeId;
  }

  public void setMaxRangeId(Long maxRangeId) {
    this.maxRangeId = maxRangeId;
    putBodyParameter("maxRangeId", maxRangeId);
  }
}
