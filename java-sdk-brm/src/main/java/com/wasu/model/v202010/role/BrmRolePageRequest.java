package com.wasu.model.v202010.role;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 角色信息分页
 *
 * @author 237417
 * @since 1.0.0 2021/02/23
 */
public class BrmRolePageRequest extends AbstractIccRequest<BrmRolePageResponse> {

    /** 当前页 */
    private Integer pageNum;
    /** 每页记录数 */
    private Integer pageSize;
    /*--------以上必填-----*/

    /** 模糊查询参数 */
    private String searchKey;
    /** 排序属性（支持排序属性：id、createDate、updateDate、roleName、roleGrade）*/
    private String sort;
    /** 排序方式： ASC-升序， DESC-降序（默认） */
    private String sortType;
    /** 角色ID列表 过滤条件 */
    private List<Long> roleIdList;
    /** 角色名称列表 过滤条件 */
    private List<String> roleNameList;
    /** 角色等级 过滤条件 */
    private List<Long> roleGradeList;
    /** 所属组织 */
    private String ownerCode;

    public BrmRolePageRequest() throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_ROLE_PAGE_POST), Method.POST);
        // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
        httpRequest.contentType(ContentType.JSON.toString());
        // 设置个空置,防止Required request body is missing
        putBodyParameter("pageNum", 1);
        putBodyParameter("pageSize", 10);
    }

//    public static Builder builder() {
//        return new Builder();
//    }

    @Override
    public Class<BrmRolePageResponse> getResponseClass() {
        return BrmRolePageResponse.class;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        putBodyParameter("pageNum", 1);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        putBodyParameter("pageSize", 10);
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
        putBodyParameter("searchKey", searchKey);
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

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
        putBodyParameter("roleIdList", roleIdList);
    }

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
        putBodyParameter("roleNameList", roleNameList);
    }

    public List<Long> getRoleGradeList() {
        return roleGradeList;
    }

    public void setRoleGradeList(List<Long> roleGradeList) {
        this.roleGradeList = roleGradeList;
        putBodyParameter("roleGradeList", roleGradeList);
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
        putBodyParameter("ownerCode", ownerCode);
    }

    @Override
    public String toString() {
        return "BrmRolePageRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", searchKey='" + searchKey + '\'' +
                ", sort='" + sort + '\'' +
                ", sortType='" + sortType + '\'' +
                ", roleIdList=" + roleIdList +
                ", roleNameList=" + roleNameList +
                ", roleGradeList=" + roleGradeList +
                ", ownerCode='" + ownerCode + '\'' +
                '}';
    }



//    public static class Builder {
//        /** 当前页 */
//        private Integer pageNum;
//        /** 每页记录数 */
//        private Integer pageSize;
//        /*--------以上必填-----*/
//
//        /** 模糊查询参数 */
//        private String searchKey;
//        /** 排序属性（支持排序属性：id、createDate、updateDate、roleName、roleGrade）*/
//        private String sort;
//        /** 排序方式： ASC-升序， DESC-降序（默认） */
//        private String sortType;
//        /** 角色ID列表 过滤条件 */
//        private List<Long> roleIdList;
//        /** 角色名称列表 过滤条件 */
//        private List<String> roleNameList;
//        /** 角色等级 过滤条件 */
//        private List<Long> roleGradeList;
//        /** 所属组织 */
//        private String ownerCode;
//
//        public Builder pageNum(Integer pageNum) {
//            this.pageNum = pageNum;
//            return this;
//        }
//
//        public Builder pageSize(Integer pageSize) {
//            this.pageSize = pageSize;
//            return this;
//        }
//
//        public Builder searchKey(String searchKey) {
//            this.searchKey = searchKey;
//            return this;
//        }
//
//        public Builder sort(String sort) {
//            this.sort = sort;
//            return this;
//        }
//
//        public Builder sortType(String sortType) {
//            this.sortType = sortType;
//            return this;
//        }
//
//        public Builder roleIdList(List<Long> roleIdList) {
//            this.roleIdList = roleIdList;
//            return this;
//        }
//
//        public Builder roleNameList(List<String> roleNameList) {
//            this.roleNameList = roleNameList;
//            return this;
//        }
//
//        public Builder roleGradeList(List<Long> roleGradeList) {
//            this.roleGradeList = roleGradeList;
//            return this;
//        }
//
//        public Builder ownerCode(String ownerCode) {
//            this.ownerCode = ownerCode;
//            return this;
//        }
//    }
}
