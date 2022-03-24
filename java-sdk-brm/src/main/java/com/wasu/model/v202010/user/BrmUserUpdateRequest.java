package com.wasu.model.v202010.user;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

public class BrmUserUpdateRequest extends AbstractIccRequest<BrmUserUpdateResponse> {

    /** 用户ID */
    private Long id;
    private String ownerCode;
    private Integer isReuse;
    private Long personId;
    private List<Long> roleIdList;
    /** 登录用户名 */
    private String loginName;
    /*--------以上必填-----*/

    public  BrmUserUpdateRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_USER_UPDATE_PUT), Method.PUT);
        this.id = builder.id;
        this.ownerCode = builder.ownerCode;
        this.isReuse = builder.isReuse;
        this.personId = builder.personId;
        this.roleIdList = builder.roleIdList;
        this.loginName = builder.loginName;
        putBodyParameter("loginName", loginName);
        putBodyParameter("id", id);
        putBodyParameter("ownerCode", ownerCode);
        putBodyParameter("isReuse", isReuse);
        putBodyParameter("personId", personId);
        putBodyParameter("roleIdList", roleIdList);
    }

    public static BrmUserUpdateRequest.Builder builder() {
        return new BrmUserUpdateRequest.Builder();
    }

    @Override
    public Class<BrmUserUpdateResponse> getResponseClass() {
        return BrmUserUpdateResponse.class;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        putBodyParameter("id", id);
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
        putBodyParameter("ownerCode", ownerCode);
    }

    public Integer getIsReuse() {
        return isReuse;
    }

    public void setIsReuse(Integer isReuse) {
        this.isReuse = isReuse;
        putBodyParameter("isReuse", isReuse);
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
        putBodyParameter("personId", personId);
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
        putBodyParameter("roleIdList", roleIdList);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
        putBodyParameter("loginName", loginName);
    }

    @Override
    public String toString() {
        return "BrmUserUpdateRequest{" +
                "id=" + id +
                ", ownerCode='" + ownerCode + '\'' +
                ", isReuse=" + isReuse +
                ", personId=" + personId +
                ", roleIdList=" + roleIdList +
                '}';
    }

    public static class Builder {
        private Long id;
        private String ownerCode;
        private Integer isReuse;
        private Long personId;
        private List<Long> roleIdList;
        /** 登录用户名 */
        private String loginName;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder ownerCode(String ownerCode) {
            this.ownerCode = ownerCode;
            return this;
        }

        public Builder isReuse(Integer isReuse) {
            this.isReuse = isReuse;
            return this;
        }

        public Builder personId(Long personId) {
            this.personId = personId;
            return this;
        }

        public Builder roleIdList(List<Long> roleIdList) {
            this.roleIdList = roleIdList;
            return this;
        }

        public Builder loginName(String loginName) {
            this.loginName = loginName;
            return this;
        }

        public BrmUserUpdateRequest build() throws ClientException {
            return new BrmUserUpdateRequest(this);
        }
    }
}
