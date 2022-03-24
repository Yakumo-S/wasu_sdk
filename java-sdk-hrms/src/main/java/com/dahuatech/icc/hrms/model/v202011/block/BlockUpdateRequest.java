package com.dahuatech.icc.hrms.model.v202011.block;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * @author 232676
 * @since 1.0.0 2020/11/2 16:07
 */
public class BlockUpdateRequest extends AbstractIccRequest<BlockAddResponse> {
  /** 小区地址 */
  private String blockAddress;
  /** 小区组织编码 */
  private String blockCode;
  /** 小区名称 */
  private String blockName;
  /** 小区类型 */
  private String blockType;
  /** 城市编码-非必填 */
  private String cityCode;
  /** 业委会id-非必填 */
  private String committeeId;
  /** 物业单位id-非必填 */
  private String companyId;
  /** 所选区\县编码 */
  private String countyCode;
  /** 描述-非必填 */
  private String description;
  /** 经度-非必填 */
  private String mapX;
  /** 维度-非必填 */
  private String mapY;
  /** 小区负责人姓名，非必填 */
  private String emergencyPerson;
  /** 小区负责人id-非必填 */
  private String emergencyPersonId;
  /** 组织类型 */
  private String orgType;
  /** 父节点id */
  private String parentId;
  /** 所属派出所id-非必填 */
  private String policeId;
  /** 所选省编码 */
  private String provinceCode;

  public BlockUpdateRequest() throws ClientException {
    super(HrmsConstant.BRM_URL_BLOCK_ADD_POST, Method.POST);
  }

  public String getBlockAddress() {
    return blockAddress;
  }

  public void setBlockAddress(String blockAddress) {
    putBodyParameter("blockAddress", blockAddress);
    this.blockAddress = blockAddress;
  }

  public String getBlockCode() {
    return blockCode;
  }

  public void setBlockCode(String blockCode) {
    putBodyParameter("blockCode", blockCode);
    this.blockCode = blockCode;
  }

  public String getBlockName() {
    return blockName;
  }

  public void setBlockName(String blockName) {
    putBodyParameter("blockName", blockName);
    this.blockName = blockName;
  }

  public String getBlockType() {
    return blockType;
  }

  public void setBlockType(String blockType) {
    putBodyParameter("blockType", blockType);
    this.blockType = blockType;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    putBodyParameter("cityCode", cityCode);
    this.cityCode = cityCode;
  }

  public String getCommitteeId() {
    return committeeId;
  }

  public void setCommitteeId(String committeeId) {
    putBodyParameter("committeeId", committeeId);
    this.committeeId = committeeId;
  }

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    putBodyParameter("companyId", companyId);
    this.companyId = companyId;
  }

  public String getCountyCode() {
    return countyCode;
  }

  public void setCountyCode(String countyCode) {
    putBodyParameter("countyCode", countyCode);
    this.countyCode = countyCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    putBodyParameter("description", description);
    this.description = description;
  }

  public String getMapX() {
    return mapX;
  }

  public void setMapX(String mapX) {
    putBodyParameter("mapX", mapX);
    this.mapX = mapX;
  }

  public String getMapY() {
    return mapY;
  }

  public void setMapY(String mapY) {
    putBodyParameter("mapY", mapY);
    this.mapY = mapY;
  }

  public String getEmergencyPerson() {
    return emergencyPerson;
  }

  public void setEmergencyPerson(String emergencyPerson) {
    putBodyParameter("emergencyPerson", emergencyPerson);
    this.emergencyPerson = emergencyPerson;
  }

  public String getEmergencyPersonId() {
    return emergencyPersonId;
  }

  public void setEmergencyPersonId(String emergencyPersonId) {
    putBodyParameter("emergencyPersonId", emergencyPersonId);
    this.emergencyPersonId = emergencyPersonId;
  }

  public String getOrgType() {
    return orgType;
  }

  public void setOrgType(String orgType) {
    putBodyParameter("orgType", orgType);
    this.orgType = orgType;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    putBodyParameter("parentId", parentId);
    this.parentId = parentId;
  }

  public String getPoliceId() {
    return policeId;
  }

  public void setPoliceId(String policeId) {
    putBodyParameter("policeId", policeId);
    this.policeId = policeId;
  }

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    putBodyParameter("provinceCode", provinceCode);
    this.provinceCode = provinceCode;
  }

  @Override
  public Class<BlockAddResponse> getResponseClass() {
    return BlockAddResponse.class;
  }
}
