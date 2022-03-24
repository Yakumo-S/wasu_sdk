package com.dahuatech.icc.visitors.model.v202104.authorize;

import com.dahuatech.icc.oauth.http.IccResponse;

import java.util.List;

public class GetAccessChannelByLeaveResponse extends IccResponse {

    private AccessChannelData data;

    public AccessChannelData getData() {
        return data;
    }

    public void setData(AccessChannelData data) {
        this.data = data;
    }

    private static class AccessChannelData {

        private List<AccessChannel> accessChannelList;

        public List<AccessChannel> getAccessChannelList() {
            return accessChannelList;
        }

        public void setAccessChannelList(List<AccessChannel> accessChannelList) {
            this.accessChannelList = accessChannelList;
        }
    }
}
