package com.wasu.model.v202010.person;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * @author 237417
 * @since 1.0.0 2020/03/02
 */
public class BrmPersonBatchGenIdResponse extends IccResponse {
    private BatchGenIdData data;

    public BatchGenIdData getData() {
        return data;
    }

    public void setData(BatchGenIdData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BrmPersonBatchGenIdResponse{" +
                "data=" + data +
                '}';
    }

    public static class BatchGenIdData {
        List<Long> idList;

        public List<Long> getIdList() {
            return idList;
        }

        public void setIdList(List<Long> idList) {
            this.idList = idList;
        }

        @Override
        public String toString() {
            return "BatchGenIdDate{" +
                    "idList=" + idList +
                    '}';
        }
    }
}
