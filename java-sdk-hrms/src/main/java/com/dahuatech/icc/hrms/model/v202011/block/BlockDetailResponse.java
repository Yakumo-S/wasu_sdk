package com.dahuatech.icc.hrms.model.v202011.block;

import com.dahuatech.icc.oauth.http.IccResponse;

/**
 * 小区查看
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class BlockDetailResponse extends IccResponse {
    /** 小区ID */
    private BlockDetail data;

    public BlockDetail getData() {
        return data;
    }

    public void setData(BlockDetail data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BlockDelResponse{" + "data='" + data + '\'' + '}';
    }
}

