package com.wasu.model.v202010.user;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

public class BrmUserPageRequest extends AbstractIccRequest<BrmUserPageResponse> {
    private Integer pageNum;
    private Integer pageSize;
    private String sort;
    private String sortType;
    private String searchKey;
    private List<Long> userIdList;
    private List<String> ownerCodeList;
    private List<String> loginNameList;
    private List<Long> personIdList;
    private Integer isReuse;
    private Boolean includeSubOwnerCodeFlag;

    public BrmUserPageRequest() throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_USER_PAGE_POST), Method.POST);
        // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
        httpRequest.contentType(ContentType.JSON.toString());
        // 设置个空置,防止Required request body is missing
        putBodyParameter("pageNum", 1);
        putBodyParameter("pageSize", 10);
    }

    @Override
    public Class<BrmUserPageResponse> getResponseClass() {
        return BrmUserPageResponse.class;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        putBodyParameter("pageNum", pageNum);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        putBodyParameter("pageSize", pageSize);
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
        putBodyParameter("sort", sort);
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
        putBodyParameter("sortType", sortType);
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
        putBodyParameter("searchKey", searchKey);
    }

    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
        putBodyParameter("userIdList", userIdList);
    }

    public List<String> getOwnerCodeList() {
        return ownerCodeList;
    }

    public void setOwnerCodeList(List<String> ownerCodeList) {
        this.ownerCodeList = ownerCodeList;
        putBodyParameter("ownerCodeList", ownerCodeList);
    }

    public List<String> getLoginNameList() {
        return loginNameList;
    }

    public void setLoginNameList(List<String> loginNameList) {
        this.loginNameList = loginNameList;
        putBodyParameter("loginNameList", loginNameList);
    }

    public List<Long> getPersonIdList() {
        return personIdList;
    }

    public void setPersonIdList(List<Long> personIdList) {
        this.personIdList = personIdList;
        putBodyParameter("personIdList", personIdList);
    }

    public Integer getIsReuse() {
        return isReuse;
    }

    public void setIsReuse(Integer isReuse) {
        this.isReuse = isReuse;
        putBodyParameter("isReuse", isReuse);
    }

    public Boolean getIncludeSubOwnerCodeFlag() {
        return includeSubOwnerCodeFlag;
    }

    public void setIncludeSubOwnerCodeFlag(Boolean includeSubOwnerCodeFlag) {
        this.includeSubOwnerCodeFlag = includeSubOwnerCodeFlag;
        putBodyParameter("includeSubOwnerCodeFlag", includeSubOwnerCodeFlag);
    }

    @Override
    public String toString() {
        return "BrmUserPageRequest{" +
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
}
