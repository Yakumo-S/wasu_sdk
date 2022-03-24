package com.wasu.model.v202010.role;

import com.wasu.http.IccResponse;

/**
 * 角色新增返回结果
 *
 * @author 237417
 * @since 1.0.0 2021/02/22
 */
public class BrmRoleAddResponse extends IccResponse {
    private RoleAddData data;

    public RoleAddData getData() {
        return data;
    }

    public void setData(RoleAddData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BrmRoleAddResponse{" + "data=" + data + '}';
    }

    public static class RoleAddData {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "RoleAddData{" + "id=" + id + '}';
        }
    }
}
