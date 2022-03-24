package com.dahuatech.icc.assesscontrol.model.v202103.deviceTree;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 设备树
 *
 * @author 237417
 * @since 1.0.0 2021-03-18
 */
public class ResourceTreeSearchResponse extends IccResponse {
    private ResourceTreeData data;

    public ResourceTreeData getData() {
        return data;
    }

    public void setData(ResourceTreeData data) {
        this.data = data;
    }

    public static class ResourceTreeData {
        /** 返回数据 */
        private List<ChildrenList> children;

        /** 使能 */
        private Boolean enable;

        /** 节点编号 */
        private String id;

        /** 是否为父节点 */
        private Boolean isParent;

        /** 节点名称 */
        private String name;

        /** 在线状态 */
        private String online;

        /** 是否有父节点 */
        private Boolean parent;

        /** 父节点ID */
        private String parentId;

        public List<ChildrenList> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenList> children) {
            this.children = children;
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getParent() {
            return isParent;
        }

        public void setParent(Boolean parent) {
            isParent = parent;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOnline() {
            return online;
        }

        public void setOnline(String online) {
            this.online = online;
        }

        @Override
        public String toString() {
            return "ResourceTreeData{" +
                    "children=" + children +
                    ", enable=" + enable +
                    ", id='" + id + '\'' +
                    ", isParent=" + isParent +
                    ", name='" + name + '\'' +
                    ", online='" + online + '\'' +
                    ", parent=" + parent +
                    ", parentId='" + parentId + '\'' +
                    '}';
        }


    }

    public static class ChildrenList {
        /** 通道号 */
        private Integer channelSeq;

        /** 通道类型 */
        private Integer channelType;

        /** 设备类型 */
        private String deviceModel;

        /** 设备名称 */
        private String deviceName;

        /** 使能 */
        private boolean enable;

        /** 编号 */
        private String id;

        /** 是否为父节点 */
        private boolean isParent;

        /** 节点名称 */
        private String name;

        /** 是否在线 */
        private String online;

        /** 组织名称 */
        private String orgName;

        /** 无 */
        private Integer parent;

        public Integer getChannelSeq() {
            return channelSeq;
        }

        public void setChannelSeq(Integer channelSeq) {
            this.channelSeq = channelSeq;
        }

        public Integer getChannelType() {
            return channelType;
        }

        public void setChannelType(Integer channelType) {
            this.channelType = channelType;
        }

        public String getDeviceModel() {
            return deviceModel;
        }

        public void setDeviceModel(String deviceModel) {
            this.deviceModel = deviceModel;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isParent() {
            return isParent;
        }

        public void setParent(boolean parent) {
            isParent = parent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public Integer getParent() {
            return parent;
        }

        public void setParent(Integer parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "ChildrenList{" +
                    "channelSeq=" + channelSeq +
                    ", channelType=" + channelType +
                    ", deviceModel='" + deviceModel + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", enable=" + enable +
                    ", id='" + id + '\'' +
                    ", isParent=" + isParent +
                    ", name='" + name + '\'' +
                    ", online='" + online + '\'' +
                    ", orgName='" + orgName + '\'' +
                    ", parent=" + parent +
                    '}';
        }
    }
}
