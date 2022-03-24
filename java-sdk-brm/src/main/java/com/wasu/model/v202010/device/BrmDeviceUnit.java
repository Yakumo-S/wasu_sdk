package com.wasu.model.v202010.device;

import java.util.List;
import java.util.Map;

/**
 * @author 232676
 * @since 1.0.0 2020/11/14 10:40
 */
public class BrmDeviceUnit {
  /** 单元类型 */
  private int unitType;
  /** 单元序号 */
  private int unitSeq;
  /** 排序码 */
  private int sort;
  /** 单元描述 */
  private String memo;
  /** 能力集 */
  private String capability;
  /** 单元扩展信息 */
  private Map<String, Object> unitExt;

  private List<BrmDeviceChannel> channels;

  public List<BrmDeviceChannel> getChannels() {
    return channels;
  }

  public void setChannels(List<BrmDeviceChannel> channels) {
    this.channels = channels;
  }

  public int getUnitType() {
    return unitType;
  }

  public void setUnitType(int unitType) {
    this.unitType = unitType;
  }

  public int getUnitSeq() {
    return unitSeq;
  }

  public void setUnitSeq(int unitSeq) {
    this.unitSeq = unitSeq;
  }

  public int getSort() {
    return sort;
  }

  public void setSort(int sort) {
    this.sort = sort;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getCapability() {
    return capability;
  }

  public void setCapability(String capability) {
    this.capability = capability;
  }

  public Map<String, Object> getUnitExt() {
    return unitExt;
  }

  public void setUnitExt(Map<String, Object> unitExt) {
    this.unitExt = unitExt;
  }

  @Override
  public String toString() {
    return "BrmDeviceUnit{"
        + "unitType="
        + unitType
        + ", unitSeq="
        + unitSeq
        + ", sort="
        + sort
        + ", memo='"
        + memo
        + '\''
        + ", capability='"
        + capability
        + '\''
        + ", unitExt="
        + unitExt
        + '}';
  }
}
