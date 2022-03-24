package com.wasu.model.v202010.role;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 角色删除
 *
 * @author 237417
 * @since 2021/02/23
 */
public class BrmRoleDeleteRequest extends AbstractIccRequest<BrmRoleDeleteResponse> {

    /** 需要删除的角色ID集合 */
    private List<Long> ids;
    /*--------以上必填-----*/


    public BrmRoleDeleteRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_ROLE_DEL_POST), Method.POST);
        this.ids = builder.ids;
        putBodyParameter("ids",ids);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<BrmRoleDeleteResponse> getResponseClass() {
        return BrmRoleDeleteResponse.class;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
        putBodyParameter("ids",ids);
    }

    @Override
    public String toString() {
        return "BrmRoleDeleteRequest{" +
                "ids=" + ids +
                '}';
    }

    public static class Builder {
        /** 需要删除的角色ID集合 */
        private List<Long> ids;
        /*--------以上必填-----*/

        public Builder ids(List<Long> ids) {
            this.ids = ids;
            return this;
        }

        public BrmRoleDeleteRequest build() throws ClientException {
            return new BrmRoleDeleteRequest(this);
        }
    }
}
