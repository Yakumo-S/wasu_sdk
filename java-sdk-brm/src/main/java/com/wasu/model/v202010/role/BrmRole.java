package com.wasu.model.v202010.role;

/**
 * @author 237417
 * @since 1.0.0 2021/02/23
 */
public class BrmRole {
    /** 角色ID */
    private Long id;
    /** 角色名称 */
    private String roleName;
    /** 角色等级 */
    private Integer roleGrade;
    /** 所属组织编码 */
    private String ownerCode;
    /** 是否是默认角色 */
    private Integer defaultRole;
    /** 是否勾选管理员端所有权限 */
    private Integer administerRootCheck;
    /** 是否勾选操作员端所有权限 */
    private Integer operationRootCheck;
    /** 是否勾选移动端所有权限 */
    private Integer appRootCheck;
    /** 是否显示 */
    private Integer status;

    /** 角色类型 */
    private Integer privilegeType;
    /** 描述 */
    private String memo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleGrade() {
        return roleGrade;
    }

    public void setRoleGrade(Integer roleGrade) {
        this.roleGrade = roleGrade;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public Integer getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Integer defaultRole) {
        this.defaultRole = defaultRole;
    }

    public Integer getAdministerRootCheck() {
        return administerRootCheck;
    }

    public void setAdministerRootCheck(Integer administerRootCheck) {
        this.administerRootCheck = administerRootCheck;
    }

    public Integer getOperationRootCheck() {
        return operationRootCheck;
    }

    public void setOperationRootCheck(Integer operationRootCheck) {
        this.operationRootCheck = operationRootCheck;
    }

    public Integer getAppRootCheck() {
        return appRootCheck;
    }

    public void setAppRootCheck(Integer appRootCheck) {
        this.appRootCheck = appRootCheck;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPrivilegeType() {
        return privilegeType;
    }

    public void setPrivilegeType(Integer privilegeType) {
        this.privilegeType = privilegeType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "BrmRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleGrade=" + roleGrade +
                ", ownerCode='" + ownerCode + '\'' +
                ", defaultRole=" + defaultRole +
                ", administerRootCheck=" + administerRootCheck +
                ", operationRootCheck=" + operationRootCheck +
                ", appRootCheck=" + appRootCheck +
                ", status=" + status +
                ", privilegeType=" + privilegeType +
                ", memo='" + memo + '\'' +
                '}';
    }
}
