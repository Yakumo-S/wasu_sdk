package com.wasu.model.v202010.role;

import com.wasu.http.IccResponse;

/**
 * 角色更新返回结果
 *
 * @author 237417
 * @since 1.0.0 2021/02/23
 */
public class BrmRoleUpdateResponse extends IccResponse {
    private RoleUpdateData data;

    public RoleUpdateData getData() {
        return data;
    }

    public void setData(RoleUpdateData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BrmRoleUpdateResponse{" + "data=" + data + '}';
    }

    public static class RoleUpdateData {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "RoleUpdateData{" + "id=" + id + '}';
        }
    }
}
