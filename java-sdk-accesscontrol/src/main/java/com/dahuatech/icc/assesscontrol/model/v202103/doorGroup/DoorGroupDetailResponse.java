package com.dahuatech.icc.assesscontrol.model.v202103.doorGroup;

import com.dahuatech.icc.assesscontrol.model.v202103.channelControl.DoorGroup;
import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

/**
 * 门组详情
 *
 * @author 237417
 */
public class DoorGroupDetailResponse extends IccResponse {

    private  DoorGroupData data;

    public DoorGroupData getData() {
        return data;
    }

    public void setData(DoorGroupData data) {
        this.data = data;
    }

    public static class DoorGroupData {
        /** ID */
        private Number id;
        /** 名称 */
        private String name;
        /** 组织编码 */
        private String orgCode;
        /** 组织名称 */
        private String orgName;
        /** 是否有通道 */
        private String hasChildChannel;
        /** 备注 */
        private String memo;
        /** 通道详情 */
        private List<DoorGroup> doorGroupDetail;

        public Number getId() {
            return id;
        }

        public void setId(Number id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getHasChildChannel() {
            return hasChildChannel;
        }

        public void setHasChildChannel(String hasChildChannel) {
            this.hasChildChannel = hasChildChannel;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public List<DoorGroup> getDoorGroupDetail() {
            return doorGroupDetail;
        }

        public void setDoorGroupDetail(List<DoorGroup> doorGroupDetail) {
            this.doorGroupDetail = doorGroupDetail;
        }

        @Override
        public String toString() {
            return "DoorGroupData{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", orgCode='" + orgCode + '\'' +
                    ", orgName='" + orgName + '\'' +
                    ", hasChildChannel='" + hasChildChannel + '\'' +
                    ", memo='" + memo + '\'' +
                    ", doorGroupDetail=" + doorGroupDetail +
                    '}';
        }
    }
}
