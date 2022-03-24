package com.dahuatech.icc.assesscontrol.model.v202103.doorGroup;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 添加门组
 *
 * @author 237417
 */
public class DoorGroupAddRequest extends AbstractIccRequest<DoorGroupAddResponse> {
    /** 名称 */
    private String name;
    /** 组织编码 */
    private String orgCode;
    /** 备注（不能带%或者_） */
    private String memo;
    /** 门组详情 */
    private List<ChannelGroupList> channelGroupDetail;
    /*--------以上必填-----*/

    public DoorGroupAddRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_DOOR_GROUP_ADD_POST), Method.POST);
        this.name = builder.name;
        this.orgCode = builder.orgCode;
        this.memo = builder.memo;
        this.channelGroupDetail = builder.channelGroupDetail;
        putBodyParameter("name",name);
        putBodyParameter("orgCode",orgCode);
        putBodyParameter("memo",memo);
        putBodyParameter("channelGroupDetail",channelGroupDetail);
    }

    @Override
    public Class<DoorGroupAddResponse> getResponseClass() {
        return DoorGroupAddResponse.class;
    }

    public static Builder builder() {
        return new Builder();
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

    public List<ChannelGroupList> getChannelGroupDetail() {
        return channelGroupDetail;
    }

    public void setChannelGroupDetail(List<ChannelGroupList> channelGroupDetail) {
        this.channelGroupDetail = channelGroupDetail;
        putBodyParameter("channelGroupDetail",channelGroupDetail);
    }

    public static class ChannelGroupList {
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
        /** 名称 */
        private String name;
        /** 组织编码 */
        private String orgCode;
        /** 备注（不能带%或者_） */
        private String memo;
        /** 门组详情 */
        private List<ChannelGroupList> channelGroupDetail;

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

        public Builder channelGroupDetail(List<ChannelGroupList> channelGroupDetail) {
            this.channelGroupDetail = channelGroupDetail;
            return this;
        }

        public DoorGroupAddRequest build() throws ClientException {
            return new DoorGroupAddRequest(this);
        }
    }
}
