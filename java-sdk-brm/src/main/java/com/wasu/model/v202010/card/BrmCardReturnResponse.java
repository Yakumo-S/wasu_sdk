package com.wasu.model.v202010.card;

import com.wasu.http.IccResponse;

import java.util.Map;

/**
 * 卡片回收结果
 *
 * @author 237417
 * @since 1.0.0 2021/03/01
 */
public class BrmCardReturnResponse extends IccResponse {
    private CardReturnData data;

    @Override
    public String toString() {
        return "BrmCardDelResponse{" + "data=" + data + '}';
    }

    public static class CardReturnData {
        private int failCount;
        private int successNum;
        private Map<String, Object> errorInfo;

        public int getFailCount() {
            return failCount;
        }

        public void setFailCount(int failCount) {
            this.failCount = failCount;
        }

        public Map<String, Object> getErrorInfo() {
            return errorInfo;
        }

        public void setErrorInfo(Map<String, Object> errorInfo) {
            this.errorInfo = errorInfo;
        }

        public int getSuccessNum() {
            return successNum;
        }

        public void setSuccessNum(int successNum) {
            this.successNum = successNum;
        }

        @Override
        public String toString() {
            return "CardDelData{"
                    + "failCount="
                    + failCount
                    + ", successNum="
                    + successNum
                    + ", errorInfo="
                    + errorInfo
                    + '}';
        }
    }
}