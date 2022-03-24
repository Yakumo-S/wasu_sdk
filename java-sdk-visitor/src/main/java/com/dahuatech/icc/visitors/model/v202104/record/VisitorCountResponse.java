package com.dahuatech.icc.visitors.model.v202104.record;

import com.dahuatech.icc.oauth.http.IccResponse;

public class VisitorCountResponse extends IccResponse {

    private VisitorCountData data;

    public VisitorCountData getData() {
        return data;
    }

    public void setData(VisitorCountData data) {
        this.data = data;
    }

    private static class VisitorCountData {

        /** 时间段内来访人数 */
        private Long arrayVisitorCount;
        /** 时间段内离访人数 */
        private Long leaveVisitorCount;
        /** 当前在访人数 */
        private Long nowVisitorCount;
        /** 时间段内预约来访人数 */
        private Long appointmentVisitorCount;


        public Long getArrayVisitorCount() {
            return arrayVisitorCount;
        }

        public void setArrayVisitorCount(Long arrayVisitorCount) {
            this.arrayVisitorCount = arrayVisitorCount;
        }

        public Long getLeaveVisitorCount() {
            return leaveVisitorCount;
        }

        public void setLeaveVisitorCount(Long leaveVisitorCount) {
            this.leaveVisitorCount = leaveVisitorCount;
        }

        public Long getNowVisitorCount() {
            return nowVisitorCount;
        }

        public void setNowVisitorCount(Long nowVisitorCount) {
            this.nowVisitorCount = nowVisitorCount;
        }

        @Override
        public String toString() {
            return "VisitorCountData{" +
                    "arrayVisitorCount=" + arrayVisitorCount +
                    ", leaveVisitorCount=" + leaveVisitorCount +
                    ", nowVisitorCount=" + nowVisitorCount +
                    '}';
        }
    }
}
