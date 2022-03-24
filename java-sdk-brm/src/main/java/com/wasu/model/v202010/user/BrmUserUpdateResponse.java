package com.wasu.model.v202010.user;

import com.wasu.http.IccResponse;

/**
 * 用户更新结果
 *
 * @author 237417
 * @since 1.0.0 2020-02-04
 */
public class BrmUserUpdateResponse extends IccResponse {
    private UserAddData data;

    @Override
    public String toString() {
        return "BrmUserAddResponse{" + "data=" + data + '}';
    }

    public BrmUserUpdateResponse.UserAddData getData() {
        return data;
    }

    public void setData(BrmUserUpdateResponse.UserAddData data) {
        this.data = data;
    }

    public static class UserAddData {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "UserAddData{" +
                    "id=" + id +
                    '}';
        }
    }
}
