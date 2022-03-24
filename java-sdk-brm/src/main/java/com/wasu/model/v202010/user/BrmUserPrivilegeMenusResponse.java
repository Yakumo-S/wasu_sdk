package com.wasu.model.v202010.user;

import com.wasu.http.IccResponse;

import java.util.List;

public class BrmUserPrivilegeMenusResponse extends IccResponse {
    private UserMenusData data;

    public UserMenusData getData() {
        return data;
    }

    public void setData(UserMenusData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BrmUserPrivilegeMenusResponse{" +
                "data=" + data +
                '}';
    }

    public static class UserMenusData {
        private List<MenuInfoList> menuInfoList;

        public List<MenuInfoList> getMenuInfoList() {
            return menuInfoList;
        }

        public void setMenuInfoList(List<MenuInfoList> menuInfoList) {
            this.menuInfoList = menuInfoList;
        }

        @Override
        public String toString() {
            return "UserMenusData{" +
                    "menuInfoList=" + menuInfoList +
                    '}';
        }
    }

    public static class MenuInfoList {
        private String menuCode;
        private String uniqueMenuCode;
        private String menuName;
        private String menuPath;

        public String getMenuCode() {
            return menuCode;
        }

        public void setMenuCode(String menuCode) {
            this.menuCode = menuCode;
        }

        public String getUniqueMenuCode() {
            return uniqueMenuCode;
        }

        public void setUniqueMenuCode(String uniqueMenuCode) {
            this.uniqueMenuCode = uniqueMenuCode;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }

        public String getMenuPath() {
            return menuPath;
        }

        public void setMenuPath(String menuPath) {
            this.menuPath = menuPath;
        }

        @Override
        public String toString() {
            return "MenuInfoList{" +
                    "menuCode='" + menuCode + '\'' +
                    ", uniqueMenuCode='" + uniqueMenuCode + '\'' +
                    ", menuName='" + menuName + '\'' +
                    ", menuPath='" + menuPath + '\'' +
                    '}';
        }
    }
}
