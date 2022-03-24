package com.wasu.model.v202010.device;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 设备树查询
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmDeviceTreeRequest extends AbstractIccRequest<BrmDeviceTreeResponse> {
  /** 上级节点编码(组织编码/设备编码) */
  private String id;
  /**
   * type参数说明 type 参数格式： "组织节点类型;设备节点类型;通道单元类型"
   *
   * <p>组织节点类型：为树结构中根组织节点编码 如： 001 表示该树根节点是001的基础组织（其他非001的树为逻辑组织树，暂不支持（预留））
   *
   * <p>设备类型： 1,2 表示展示设备分类为1和2的设备 00 标识不展示设备节点 00_1，00_2
   * 标识不展示设备节点，但设备分类为1和2的设备下的通道有权限展示，具体是否展示通道及那些种类的通道还需要根据通道单元类型判断
   *
   * <p>通道单元类型： 1 表示可以展示单元类型为1的通道，即编码通道 1,2 标识可以展示单元类型为1和2的通道，及编码通道和解码通道
   */
  private String type;
  /** 操作类型，没有默认为根据上级节点查询下级节点;如果为search,表示按节点名称模糊搜索 */
  private String act;
  /** 上级组织/设备节点是否有权限，查询下级节点时该值取上级节点中checkStat属性值 */
  private int checkStat;
  /** act=search时模糊搜索的关键字 */
  private String searchKey;
  /** 通道能力集,取值为: "单元类型1_通道能力集,单元类型2_通道能力集", 如: ["1_0000000001000000","2_0000000000000001110"] */
  private List<String> chCapability;
  /** 设备能力集,取值为: "设备大类1_通道能力集,设备大类2_通道能力集", 如: ["1_0000000001000000","2_0000000000000001110"] */
  private List<String> devCapability;
  /** 初始化加载树时需要勾选的节点id列表 */
  private List<String> checkNodes;
  /** 是否展示级联节点,默认是1 */
  private int showCascadeNode;
  /** 是否展示虚拟设备、通道,默认0 */
  private int showVirtualNode;
  /** 是否展示出没有通道或设备的组织节点,默认0 */
  private int showEmptyOrgNode;

  public BrmDeviceTreeRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_DEVICE_TREE_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
  }

  @Override
  public Class<BrmDeviceTreeResponse> getResponseClass() {
    return BrmDeviceTreeResponse.class;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
    putBodyParameter("id", id);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
    putBodyParameter("type", type);
  }

  public String getAct() {
    return act;
  }

  public void setAct(String act) {
    this.act = act;
    putBodyParameter("act", act);
  }

  public int getCheckStat() {
    return checkStat;
  }

  public void setCheckStat(int checkStat) {
    this.checkStat = checkStat;
    putBodyParameter("checkStat", checkStat);
  }

  public String getSearchKey() {
    return searchKey;
  }

  public void setSearchKey(String searchKey) {
    this.searchKey = searchKey;
    putBodyParameter("searchKey", searchKey);
  }

  public List<String> getChCapability() {
    return chCapability;
  }

  public void setChCapability(List<String> chCapability) {
    this.chCapability = chCapability;
    putBodyParameter("chCapability", chCapability);
  }

  public List<String> getDevCapability() {
    return devCapability;
  }

  public void setDevCapability(List<String> devCapability) {
    this.devCapability = devCapability;
    putBodyParameter("devCapability", devCapability);
  }

  public List<String> getCheckNodes() {
    return checkNodes;
  }

  public void setCheckNodes(List<String> checkNodes) {
    this.checkNodes = checkNodes;
    putBodyParameter("checkNodes", checkNodes);
  }

  public int getShowCascadeNode() {
    return showCascadeNode;
  }

  public void setShowCascadeNode(int showCascadeNode) {
    this.showCascadeNode = showCascadeNode;
    putBodyParameter("showCascadeNode", showCascadeNode);
  }

  public int getShowVirtualNode() {
    return showVirtualNode;
  }

  public void setShowVirtualNode(int showVirtualNode) {
    this.showVirtualNode = showVirtualNode;
    putBodyParameter("showVirtualNode", showVirtualNode);
  }

  public int getShowEmptyOrgNode() {
    return showEmptyOrgNode;
  }

  public void setShowEmptyOrgNode(int showEmptyOrgNode) {
    this.showEmptyOrgNode = showEmptyOrgNode;
    putBodyParameter("showEmptyOrgNode", showEmptyOrgNode);
  }

  @Override
  public String toString() {
    return "BrmDeviceTreeRequest{"
        + "id='"
        + id
        + '\''
        + ", type='"
        + type
        + '\''
        + ", act='"
        + act
        + '\''
        + ", checkStat="
        + checkStat
        + ", searchKey='"
        + searchKey
        + '\''
        + ", chCapability="
        + chCapability
        + ", devCapability="
        + devCapability
        + ", checkNodes="
        + checkNodes
        + ", showCascadeNode="
        + showCascadeNode
        + ", showVirtualNode="
        + showVirtualNode
        + ", showEmptyOrgNode="
        + showEmptyOrgNode
        + '}';
  }
}
