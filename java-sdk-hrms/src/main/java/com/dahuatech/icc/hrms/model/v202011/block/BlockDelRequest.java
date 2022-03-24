package com.dahuatech.icc.hrms.model.v202011.block;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 小区删除
 *
 * @author 237417
 */
public class BlockDelRequest extends AbstractIccRequest<BlockDelResponse> {

    /** 小区ID */
    private List<String> ids;


    public BlockDelRequest(Builder builder) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_BLOCK_DELETE_POST),Method.POST);
        this.ids = builder.ids;
        putBodyParameter("ids",ids);
    }

    @Override
    public Class<BlockDelResponse> getResponseClass() {
        return BlockDelResponse.class;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
        putBodyParameter("ids",ids);
    }

    public static class Builder {
        /** 小区ID */
        private List<String> ids;

        public Builder ids(List<String> ids) {
            this.ids = ids;
            return this;
        }

        public BlockDelRequest build() throws ClientException {
            return new BlockDelRequest(this);
        }
    }
}
