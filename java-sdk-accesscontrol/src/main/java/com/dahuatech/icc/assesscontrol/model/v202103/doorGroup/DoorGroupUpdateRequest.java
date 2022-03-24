package com.dahuatech.icc.assesscontrol.model.v202103.doorGroup;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 修改门组
 *
 * @author 237417
 */
public class DoorGroupUpdateRequest extends AbstractIccRequest<DoorGroupUpdateResponse> {
    /** ID */
    private Number id;
    /** 名称 */
    private String name;
    /** 组织编码 */
    private String orgCode;
    /** 备注（不能带%或者_） */
    private String memo;
    /** 新增通道列表 */
    private List<AddDoorGroupRelDoorData> addDoorGroupRelDoorList;
    /** 删除通道列表 */
    private List<DeleteDoorGroupRelDoorData> deleteDoorGroupRelDoorList;
    /*--------以上必填-----*/

    public DoorGroupUpdateRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_DOOR_GROUP_UPDATE_POST), Method.POST);
        this.id = builder.id;
        this.name = builder.name;
        this.orgCode = builder.orgCode;
        this.memo = builder.memo;
        this.addDoorGroupRelDoorList = builder.addDoorGroupRelDoorList;
        this.deleteDoorGroupRelDoorList = builder.deleteDoorGroupRelDoorList;
        putBodyParameter("id",id);
        putBodyParameter("name",name);
        putBodyParameter("orgCode",orgCode);
        putBodyParameter("memo",memo);
        putBodyParameter("addDoorGroupRelDoorList",addDoorGroupRelDoorList);
        putBodyParameter("deleteDoorGroupRelDoorList",deleteDoorGroupRelDoorList);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<DoorGroupUpdateResponse> getResponseClass() {
        return DoorGroupUpdateResponse.class;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
        putBodyParameter("id",id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        putBodyParameter("name",name);
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        putBodyParameter("orgCode",orgCode);
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
        putBodyParameter("memo",memo);
    }

    public List<AddDoorGroupRelDoorData> getAddDoorGroupRelDoorList() {
        return addDoorGroupRelDoorList;
    }

    public void setAddDoorGroupRelDoorList(List<AddDoorGroupRelDoorData> addDoorGroupRelDoorList) {
        this.addDoorGroupRelDoorList = addDoorGroupRelDoorList;
        putBodyParameter("addDoorGroupRelDoorList",addDoorGroupRelDoorList);
    }

    public List<DeleteDoorGroupRelDoorData> getDeleteDoorGroupRelDoorList() {
        return deleteDoorGroupRelDoorList;
    }

    public void setDeleteDoorGroupRelDoorList(List<DeleteDoorGroupRelDoorData> deleteDoorGroupRelDoorList) {
        this.deleteDoorGroupRelDoorList = deleteDoorGroupRelDoorList;
        putBodyParameter("deleteDoorGroupRelDoorList",deleteDoorGroupRelDoorList);
    }

    public static class AddDoorGroupRelDoorData {
        /** 通道编码 */
        private String channelCode;

        public String getChannelCode() {
            return channelCode;
        }

        public void setChannelCode(String channelCode) {
            this.channelCode = channelCode;
        }
    }

    public static class DeleteDoorGroupRelDoorData {
        /** 通道编码 */
        private String channelCode;

        public String getChannelCode() {
            return channelCode;
        }

        public void setChannelCode(String channelCode) {
            this.channelCode = channelCode;
        }
    }

    public static class Builder {
        /** ID */
        private Number id;
        /** 名称 */
        private String name;
        /** 组织编码 */
        private String orgCode;
        /** 备注（不能带%或者_） */
        private String memo;
        /** 新增通道列表 */
        private List<AddDoorGroupRelDoorData> addDoorGroupRelDoorList;
        /** 删除通道列表 */
        private List<DeleteDoorGroupRelDoorData> deleteDoorGroupRelDoorList;

        public Builder id(Number id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder orgCode(String orgCode) {
            this.orgCode = orgCode;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public Builder addDoorGroupRelDoorList(List<AddDoorGroupRelDoorData> addDoorGroupRelDoorList) {
            this.addDoorGroupRelDoorList = addDoorGroupRelDoorList;
            return this;
        }

        public Builder deleteDoorGroupRelDoorList(List<DeleteDoorGroupRelDoorData> deleteDoorGroupRelDoorList) {
            this.deleteDoorGroupRelDoorList = deleteDoorGroupRelDoorList;
            return this;
        }

        public DoorGroupUpdateRequest build() throws ClientException {
            return new DoorGroupUpdateRequest(this);
        }
    }
}
