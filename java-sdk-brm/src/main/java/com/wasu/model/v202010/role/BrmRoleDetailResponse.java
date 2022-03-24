package com.wasu.model.v202010.role;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 角色详情返回数据
 *
 * @author 237417
 * @since 1.0.0 2021/02/23
 */

public class BrmRoleDetailResponse  extends IccResponse {

    private RoleDetailData data;

    public RoleDetailData getData() {
        return data;
    }

    public void setData(RoleDetailData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BrmRoleDetailResponse{" +
                "data=" + data +
                '}';
    }

    public static class RoleDetailData {
        private BrmRole role;
        private List<MenuPrivileges> menuPrivileges;
        private List<Long> departments;
        private List<String> organizations;

        public BrmRole getRole() {
            return role;
        }

        public void setRole(BrmRole role) {
            this.role = role;
        }

        public List<MenuPrivileges> getMenuPrivileges() {
            return menuPrivileges;
        }

        public void setMenuPrivileges(List<MenuPrivileges> menuPrivileges) {
            this.menuPrivileges = menuPrivileges;
        }

        public List<Long> getDepartments() {
            return departments;
        }

        public void setDepartments(List<Long> departments) {
            this.departments = departments;
        }

        public List<String> getOrganizations() {
            return organizations;
        }

        public void setOrganizations(List<String> organizations) {
            this.organizations = organizations;
        }

        @Override
        public String toString() {
            return "RoleDetailData{" +
                    "role=" + role +
                    ", menuPrivileges=" + menuPrivileges +
                    ", departments=" + departments +
                    ", organizations=" + organizations +
                    '}';
        }
    }

    private static class MenuPrivileges {
        private List<String> menuCode;
        private String terminal;

        public List<String> getMenuCode() {
            return menuCode;
        }

        public void setMenuCode(List<String> menuCode) {
            this.menuCode = menuCode;
        }

        public String getTerminal() {
            return terminal;
        }

        public void setTerminal(String terminal) {
            this.terminal = terminal;
        }

        @Override
        public String toString() {
            return "MenuPrivileges{" +
                    "menuCode=" + menuCode +
                    ", terminal='" + terminal + '\'' +
                    '}';
        }
    }
}
