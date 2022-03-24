package com.wasu.model.v202010.user;

import com.wasu.http.IccResponse;

import java.util.List;

public class BrmUserBatchAddResponse extends IccResponse {
    private UserBatchData data;

    public UserBatchData getData() {
        return data;
    }

    public void setData(UserBatchData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BrmUserBatchAddResponse{" +
                "data=" + data +
                '}';
    }

    private static class UserBatchData {
        private List<UserBatchResult> successList;

        public List<UserBatchResult> getSuccessList() {
            return successList;
        }

        public void setSuccessList(List<UserBatchResult> successList) {
            this.successList = successList;
        }

        @Override
        public String toString() {
            return "UserBatchData{" +
                    "successList=" + successList +
                    '}';
        }
    }

    public static class UserBatchResult {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "UserBatchResult{" +
                    "id=" + id +
                    '}';
        }
    }
}
