package com.wasu.model.v202010.role;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.Set;

/**
 * 角色删除
 *
 * @author 237417
 * @since 2021/02/23
 */
public class BrmRoleUpdateRequest extends AbstractIccRequest<BrmRoleUpdateResponse> {

    /** 角色ID */
    private Long id;
    /** 角色名称 */
    private String roleName;
    /** 角色等级 */
    private Integer roleGrade;
    /** 所属组织 */
    private String ownerCode;
    /*--------以上必填-----*/

    /** 角色描述 */
    private String memo;
    /** 默认角色 */
    private Integer defaultRole;
    /** 是否全量菜单 */
    private Boolean allMenus;
    /** 当前角色有权限的组织节点 */
    private Set<String> organizations;
    /** 当前角色有权限的部门节点 */
    private Set<String> departments;

    public BrmRoleUpdateRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_ROLE_UPDATE_PUT), Method.PUT);
        this.id = builder.id;
        this.roleName = builder.roleName;
        this.roleGrade = builder.roleGrade;
        this.ownerCode = builder.ownerCode;
        this.memo = builder.memo;
        this.defaultRole = builder.defaultRole;
        this.allMenus = builder.allMenus;
        this.organizations = builder.organizations;
        this.departments = builder.departments;

        putBodyParameter("id", id);
        putBodyParameter("roleName", roleName);
        putBodyParameter("roleGrade", roleGrade);
        putBodyParameter("ownerCode", ownerCode);
        putBodyParameter("memo", memo);
        putBodyParameter("defaultRole", defaultRole);
        putBodyParameter("allMenus", allMenus);
        putBodyParameter("organizations", organizations);
        putBodyParameter("departments", departments);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        putBodyParameter("id", id);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
        putBodyParameter("roleName", roleName);
    }

    public Integer getRoleGrade() {
        return roleGrade;
    }

    public void setRoleGrade(Integer roleGrade) {
        this.roleGrade = roleGrade;
        putBodyParameter("roleGrade", roleGrade);
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
        putBodyParameter("ownerCode", ownerCode);
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
        putBodyParameter("memo", memo);
    }

    public Integer getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Integer defaultRole) {
        this.defaultRole = defaultRole;
        putBodyParameter("defaultRole", defaultRole);
    }

    public Boolean getAllMenus() {
        return allMenus;
    }

    public void setAllMenus(Boolean allMenus) {
        this.allMenus = allMenus;
        putBodyParameter("allMenus", allMenus);
    }

    public Set<String> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<String> organizations) {
        this.organizations = organizations;
        putBodyParameter("organizations", organizations);
    }

    public Set<String> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<String> departments) {
        this.departments = departments;
        putBodyParameter("departments", departments);
    }

    @Override
    public String toString() {
        return "BrmRoleUpdateRequest{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleGrade='" + roleGrade + '\'' +
                ", ownerCode='" + ownerCode + '\'' +
                ", memo='" + memo + '\'' +
                ", defaultRole=" + defaultRole +
                ", allMenus=" + allMenus +
                ", organizations=" + organizations +
                ", departments=" + departments +
                '}';
    }

    @Override
    public Class<BrmRoleUpdateResponse> getResponseClass() {
        return BrmRoleUpdateResponse.class;
    }

    public static class Builder {
        /** 角色ID */
        private Long id;
        /** 角色名称 */
        private String roleName;
        /** 角色等级 */
        private Integer roleGrade;
        /** 所属组织 */
        private String ownerCode;
        /*--------以上必填-----*/

        /** 角色描述 */
        private String memo;
        /** 默认角色 */
        private Integer defaultRole;
        /** 是否全量菜单 */
        private Boolean allMenus;
        /** 当前角色有权限的组织节点 */
        private Set<String> organizations;
        /** 当前角色有权限的部门节点 */
        private Set<String> departments;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder roleGrade(Integer roleGrade) {
            this.roleGrade = roleGrade;
            return this;
        }

        public Builder ownerCode(String ownerCode) {
            this.ownerCode = ownerCode;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public Builder defaultRole(Integer defaultRole) {
            this.defaultRole = defaultRole;
            return this;
        }

        public Builder allMenus(Boolean allMenus) {
            this.allMenus = allMenus;
            return this;
        }

        public Builder organizations(Set<String> organizations) {
            this.organizations = organizations;
            return this;
        }

        public Builder departments(Set<String> departments) {
            this.departments = departments;
            return this;
        }

        public BrmRoleUpdateRequest build() throws ClientException {
            return new BrmRoleUpdateRequest(this);
        }
    }
}
