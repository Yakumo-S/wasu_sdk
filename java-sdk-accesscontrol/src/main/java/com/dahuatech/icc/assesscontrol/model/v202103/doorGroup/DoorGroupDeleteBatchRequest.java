package com.dahuatech.icc.assesscontrol.model.v202103.doorGroup;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 删除门组
 *
 * @author 237417
 */
public class DoorGroupDeleteBatchRequest extends AbstractIccRequest<DoorGroupDeleteBatchResponse> {
    /** 门组ID数组 */
    private List<Long> doorGroupIds;

    public DoorGroupDeleteBatchRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_DOOR_GROUP_DELETE_BATCH_POST), Method.POST);
        this.doorGroupIds = builder.doorGroupIds;
        putBodyParameter("doorGroupIds",doorGroupIds);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<DoorGroupDeleteBatchResponse> getResponseClass() {
        return DoorGroupDeleteBatchResponse.class;
    }

    public List<Long> getDoorGroupIds() {
        return doorGroupIds;
    }

    public void setDoorGroupIds(List<Long> doorGroupIds) {
        this.doorGroupIds = doorGroupIds;
        putBodyParameter("doorGroupIds",doorGroupIds);
    }

    public static class Builder {
        /** 门组ID数组 */
        private List<Long> doorGroupIds;

        public Builder doorGroupIds(List<Long> doorGroupIds) {
            this.doorGroupIds = doorGroupIds;
            return this;
        }

        public DoorGroupDeleteBatchRequest build() throws ClientException {
            return new DoorGroupDeleteBatchRequest(this);
        }
    }    
}
