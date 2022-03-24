package com.wasu.model.v202010.role;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;
import java.util.Set;

/**
 * 角色新增
 *
 * @author 237417
 * @since 2021/02/22
 */
public class BrmRoleAddRequest extends AbstractIccRequest<BrmRoleAddResponse> {

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
    /** 菜单信息 */
    private List<MenuInfo> menus;
    /** 是否全量菜单 */
    private Boolean allMenus;
    /** 当前角色有权限的组织节点 */
    private Set<String> organizations;
    /** 当前角色有权限的部门节点 */
    private Set<Long> departments;

    public BrmRoleAddRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_ROLE_ADD_POST), Method.POST);
        this.roleName = builder.roleName;
        this.roleGrade = builder.roleGrade;
        this.memo = builder.memo;
        this.ownerCode = builder.ownerCode;
        this.defaultRole = builder.defaultRole;
        this.menus = builder.menus;
        this.allMenus = builder.allMenus;
        this.organizations = builder.organizations;
        this.departments = builder.departments;

        putBodyParameter("roleName",roleName);
        putBodyParameter("roleGrade",roleGrade);
        putBodyParameter("memo",memo);
        putBodyParameter("ownerCode",ownerCode);
        putBodyParameter("defaultRole",defaultRole);
        putBodyParameter("menus",menus);
        putBodyParameter("allMenus",allMenus);
        putBodyParameter("organization",organizations);
        putBodyParameter("departments",departments);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<BrmRoleAddResponse> getResponseClass() {
        return BrmRoleAddResponse.class;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
        putBodyParameter("roleName",roleName);
    }

    public Integer getRoleGrade() {
        return roleGrade;
    }

    public void setRoleGrade(Integer roleGrade) {
        this.roleGrade = roleGrade;
        putBodyParameter("roleGrade",roleGrade);
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
        putBodyParameter("ownerCode",ownerCode);
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
        putBodyParameter("memo",memo);
    }

    public Integer getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Integer defaultRole) {
        this.defaultRole = defaultRole;
        putBodyParameter("defaultRole",defaultRole);
    }

    public List<MenuInfo> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuInfo> menus) {
        this.menus = menus;
        putBodyParameter("menus",menus);
    }

    public Boolean getAllMenus() {
        return allMenus;
    }

    public void setAllMenus(Boolean allMenus) {
        this.allMenus = allMenus;
        putBodyParameter("allMenus",allMenus);
    }

    public Set<String> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<String> organizations) {
        this.organizations = organizations;
        putBodyParameter("organization",organizations);
    }

    public Set<Long> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Long> departments) {
        this.departments = departments;
        putBodyParameter("departments",departments);
    }

    @Override
    public String toString() {
        return "BrmRoleAddRequest{" +
                "roleName='" + roleName + '\'' +
                ", roleGrade=" + roleGrade +
                ", ownerCode='" + ownerCode + '\'' +
                ", memo='" + memo + '\'' +
                ", defaultRole=" + defaultRole +
                ", menus=" + menus +
                ", allMenus=" + allMenus +
                ", organizations=" + organizations +
                ", departments=" + departments +
                '}';
    }

    public static class MenuInfo {
        private List<String> menuCode;
        private Integer terminal;

        public List<String> getMenuCode() {
            return menuCode;
        }

        public void setMenuCode(List<String> menuCode) {
            this.menuCode = menuCode;
        }

        public Integer getTerminal() {
            return terminal;
        }

        public void setTerminal(Integer terminal) {
            this.terminal = terminal;
        }
    }

    public static class Builder {
        private String roleName;
        private Integer roleGrade;
        private String ownerCode;
        /*--------以上必填-----*/

        private String memo;
        private Integer defaultRole;
        private List<MenuInfo> menus;
        private Boolean allMenus;
        private Set<String> organizations;
        private Set<Long> departments;

        public Builder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder roleGrade(Integer roleGrade) {
            this.roleGrade = roleGrade;
            return this;
        }

        public Builder owenCode(String ownerCode) {
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

        public Builder menus(List<MenuInfo> menus) {
            this.menus = menus;
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

        public Builder departments(Set<Long> departments) {
            this.departments = departments;
            return this;
        }

        public BrmRoleAddRequest build() throws ClientException {
            return new BrmRoleAddRequest(this);
        }
    }

}
