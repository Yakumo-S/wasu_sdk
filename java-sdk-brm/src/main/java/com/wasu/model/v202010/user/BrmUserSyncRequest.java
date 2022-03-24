package com.wasu.model.v202010.user;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 用户全量同步
 *
 * @author 237417
 * @since 1.0.0 2020-02-04
 */
public class BrmUserSyncRequest extends AbstractIccRequest<BrmUserSyncResponse> {

    private Integer pageNum;
    private Integer pageSize;
    private String sort;
    private String sortType;
    private Integer searchKey;
    private List<String> userIdList;
    private List<String> ownerCodeList;
    private List<String> loginNameList;
    private List<Long> personIdList;
    private Integer isReuse;
    private boolean includeSubOwnerCodeFlag;

    public BrmUserSyncRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_USER_LIST_PAGE_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        this.sort = builder.sort;
        this.sortType = builder.sortType;
        this.searchKey = builder.searchKey;
        this.userIdList = builder.userIdList;
        this.ownerCodeList = builder.ownerCodeList;
        this.loginNameList = builder.loginNameList;
        this.personIdList = builder.personIdList;
        this.isReuse = builder.isReuse;
        this.includeSubOwnerCodeFlag = builder.includeSubOwnerCodeFlag;
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
        putBodyParameter("sort",sort);
        putBodyParameter("sortType",sortType);
        putBodyParameter("searchKey",searchKey);
        putBodyParameter("userIdList",userIdList);
        putBodyParameter("ownerCodeList",ownerCodeList);
        putBodyParameter("loginNameList",loginNameList);
        putBodyParameter("personIdList",personIdList);
        putBodyParameter("isReuse",isReuse);
        putBodyParameter("includeSubOwnerCodeFlag", includeSubOwnerCodeFlag);

    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<BrmUserSyncResponse> getResponseClass() {
        return BrmUserSyncResponse.class;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        putBodyParameter("pageNum",pageNum);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        putBodyParameter("pageSize",pageSize);
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
        putBodyParameter("sort",sort);
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
        putBodyParameter("sortType",sortType);
    }

    public Integer getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(Integer searchKey) {
        this.searchKey = searchKey;
        putBodyParameter("searchKey",searchKey);
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
        putBodyParameter("userIdList",userIdList);
    }

    public List<String> getOwnerCodeList() {
        return ownerCodeList;
    }

    public void setOwnerCodeList(List<String> ownerCodeList) {
        this.ownerCodeList = ownerCodeList;
        putBodyParameter("ownerCodeList",ownerCodeList);
    }

    public List<String> getLoginNameList() {
        return loginNameList;
    }

    public void setLoginNameList(List<String> loginNameList) {
        this.loginNameList = loginNameList;
        putBodyParameter("loginNameList",loginNameList);
    }

    public List<Long> getPersonIdList() {
        return personIdList;
    }

    public void setPersonIdList(List<Long> personIdList) {
        this.personIdList = personIdList;
        putBodyParameter("personIdList",personIdList);
    }

    public Integer getIsReuse() {
        return isReuse;
    }

    public void setIsReuse(Integer isReuse) {
        this.isReuse = isReuse;
        putBodyParameter("isReuse",isReuse);
    }

    public boolean isIncludeSubOwnerCodeFlag() {
        return includeSubOwnerCodeFlag;
    }

    public void setIncludeSubOwnerCodeFlag(boolean includeSubOwnerCodeFlag) {
        this.includeSubOwnerCodeFlag = includeSubOwnerCodeFlag;
        putBodyParameter("includeSubOwnerCodeFlag", includeSubOwnerCodeFlag);
    }

    @Override
    public String toString() {
        return "BrmUserSyncRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", sort='" + sort + '\'' +
                ", sortType='" + sortType + '\'' +
                ", searchKey=" + searchKey +
                ", userIdList=" + userIdList +
                ", ownerCodeList=" + ownerCodeList +
                ", loginNameList=" + loginNameList +
                ", personIdList=" + personIdList +
                ", isReuse=" + isReuse +
                ", includeSubOwnerCodeFlag=" + includeSubOwnerCodeFlag +
                '}';
    }

    public static class Builder {
        /** 第几页 默认1 */
        private Integer pageNum;
        /** 一页几条 默认10 */
        private Integer pageSize;
        /** 排序字符：id（默认） */
        private String sort;
        /** 排序规则：正序-ASC，倒叙-DESC（默认） */
        private String sortType;
        /** 模糊搜索关键字 */
        private Integer searchKey;
        /** 用户ID列表 列表最大支持500 */
        private List<String> userIdList;
        /** 所属组织编码列表 列表最大支持500 */
        private List<String> ownerCodeList;
        /** 登录名称列表 列表最大支持500 */
        private List<String> loginNameList;
        /** 绑定人员ID列表 列表最大支持500 */
        private List<Long> personIdList;
        /** 是否复用 */
        private Integer isReuse;
        /** 是否包含下级组织节点，所属组织编码列表存在时生效默认false */
        private boolean includeSubOwnerCodeFlag;

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder sort(String sort) {
            this.sort = sort;
            return this;
        }

        public Builder sortType(String sortType) {
            this.sortType = sortType;
            return this;
        }

        public Builder searchKey(Integer searchKey) {
            this.searchKey = searchKey;
            return this;
        }

        public Builder userIdList(List<String> userIdList) {
            this.userIdList = userIdList;
            return this;
        }

        public Builder ownerCodeList(List<String> ownerCodeList) {
            this.ownerCodeList = ownerCodeList;
            return this;
        }

        public Builder loginNameList(List<String> loginNameList) {
            this.loginNameList = loginNameList;
            return this;
        }

        public Builder isReuse(Integer isReuse) {
            this.isReuse = isReuse;
            return this;
        }

        public Builder includeSubOwnerCodeFlag(Boolean includeSubOwnerCodeFlag) {
            this.includeSubOwnerCodeFlag = includeSubOwnerCodeFlag;
            return this;
        }

        public BrmUserSyncRequest build() throws ClientException {
            return new BrmUserSyncRequest(this);
        }
    }
}
