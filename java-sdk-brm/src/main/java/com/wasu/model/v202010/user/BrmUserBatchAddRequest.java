package com.wasu.model.v202010.user;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

public class BrmUserBatchAddRequest
        extends AbstractIccRequest<BrmUserBatchAddResponse> {

    private List<UserBatch> userAddList;

    public BrmUserBatchAddRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_USER_BATCH_ADD_POST), Method.POST);
        this.userAddList = builder.userAddList;
        putBodyParameter("userAddList", userAddList);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<BrmUserBatchAddResponse> getResponseClass() {
        return BrmUserBatchAddResponse.class;
    }

    public List<UserBatch> getUserAddList() {
        return userAddList;
    }

    public void setUserAddList(List<UserBatch> userAddList) {
        this.userAddList = userAddList;
        putBodyParameter("userAddList", userAddList);
    }

    @Override
    public String toString() {
        return "BrmUserBatchAddRequest{" +
                "userAddList=" + userAddList +
                '}';
    }

    public static class UserBatch {

        /** 登录用户名 */
        private String loginName;
        /** 所属组织编码 */
        private String ownerCode;
        /** 是否复用 */
        private Integer isReuse;
        /** 关联人员ID */
        private Long personId;
        /** 用户关联角色 */
        private List<Long> roleIdList;
        /*--------以上必填-----*/

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getOwnerCode() {
            return ownerCode;
        }

        public void setOwnerCode(String ownerCode) {
            this.ownerCode = ownerCode;
        }

        public Integer getIsReuse() {
            return isReuse;
        }

        public void setIsReuse(Integer isReuse) {
            this.isReuse = isReuse;
        }

        public Long getPersonId() {
            return personId;
        }

        public void setPersonId(Long personId) {
            this.personId = personId;
        }

        public List<Long> getRoleIdList() {
            return roleIdList;
        }

        public void setRoleIdList(List<Long> roleIdList) {
            this.roleIdList = roleIdList;
        }
    }

    public static class Builder {
        private List<UserBatch> userAddList;

        public Builder userAddList(List<UserBatch> userAddList) {
            this.userAddList = userAddList;
            return this;
        }

        public BrmUserBatchAddRequest build() throws ClientException {
            return new BrmUserBatchAddRequest(this);
        }
    }
}
