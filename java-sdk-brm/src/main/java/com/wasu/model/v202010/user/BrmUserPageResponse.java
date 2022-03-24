package com.wasu.model.v202010.user;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 用户全量同步
 *
 * @author 237417
 * @since 1.0.0 2020-02-04
 */
public class BrmUserPageResponse extends IccResponse {

    private UserPageData data;

    private int currentPage;

    private int totalPage;

    private int pageSize;

    private int totalRows;

    public UserPageData getData() {
        return data;
    }

    public void setData(UserPageData data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    @Override
    public String toString() {
        return "BrmUserPageResponse{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }

    public static class UserPageData {
        private List<UserPageList> pageData;

        public List<UserPageList> getPageData() {
            return pageData;
        }

        public void setPageData(List<UserPageList> pageData) {
            this.pageData = pageData;
        }

        @Override
        public String toString() {
            return "UserPageData{" +
                    "pageData=" + pageData +
                    '}';
        }
    }

    public static class UserPageList {
        private Long id;
        private String loginName;
        private String aesPass;
        private Integer encrypted;
        private String userType;
        private String userName;
        private Integer isReuse;
        private Integer isOnline;
        private Long personId;
        private String ownerCode;
        private Integer stat;
        private Integer isDefault;
        private String memo;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getAesPass() {
            return aesPass;
        }

        public void setAesPass(String aesPass) {
            this.aesPass = aesPass;
        }

        public Integer getEncrypted() {
            return encrypted;
        }

        public void setEncrypted(Integer encrypted) {
            this.encrypted = encrypted;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getIsReuse() {
            return isReuse;
        }

        public void setIsReuse(Integer isReuse) {
            this.isReuse = isReuse;
        }

        public Integer getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(Integer isOnline) {
            this.isOnline = isOnline;
        }

        public Long getPersonId() {
            return personId;
        }

        public void setPersonId(Long personId) {
            this.personId = personId;
        }

        public String getOwnerCode() {
            return ownerCode;
        }

        public void setOwnerCode(String ownerCode) {
            this.ownerCode = ownerCode;
        }

        public Integer getStat() {
            return stat;
        }

        public void setStat(Integer stat) {
            this.stat = stat;
        }

        public Integer getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(Integer isDefault) {
            this.isDefault = isDefault;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        @Override
        public String toString() {
            return "UserPageList{" +
                    "id=" + id +
                    ", loginName='" + loginName + '\'' +
                    ", aesPass='" + aesPass + '\'' +
                    ", encrypted=" + encrypted +
                    ", userType='" + userType + '\'' +
                    ", userName='" + userName + '\'' +
                    ", isReuse=" + isReuse +
                    ", isOnline=" + isOnline +
                    ", personId=" + personId +
                    ", ownerCode='" + ownerCode + '\'' +
                    ", stat=" + stat +
                    ", isDefault=" + isDefault +
                    ", memo='" + memo + '\'' +
                    '}';
        }
    }
}
