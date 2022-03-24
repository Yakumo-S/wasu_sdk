package com.dahuatech.icc.hrms.model.v202011.block;

import com.dahuatech.icc.oauth.http.IccResponse;

/**
 * 小区删除
 *
 * @author 237417
 * @since 1.0.0 2021-04-06
 */
public class BlockDelResponse extends IccResponse {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BlockDelResponse{" + "data='" + data + '\'' + '}';
    }
}

