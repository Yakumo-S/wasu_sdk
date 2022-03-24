package com.dahuatech.icc.visitors.model.v202104.appointment;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.visitors.constant.VisitorConstant;


/***
 * 根据预约码查询访客信息
 * @author 237417
 * @since 20210421
 */
public class AppointmentCodeRequest extends AbstractIccRequest<AppointmentCodeResponse> {

    //TODO:接口文档未完善
    /** 页数 */
    private Integer pageNum;
    /** 每页数量 */
    private Integer pageSize;
    /** 昵称 */
    private String isv_id;

    public AppointmentCodeRequest(Builder builder) throws ClientException {
        super(VisitorConstant.url(VisitorConstant.VISITOR_URL_CARD_VISITOR_APPOINTMENT_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        this.isv_id = builder.isv_id;
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
        putBodyParameter("isv_id",isv_id);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AppointmentCodeResponse> getResponseClass() {
        return AppointmentCodeResponse.class;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        putBodyParameter("pageNum",pageNum);
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        putBodyParameter("pageSize",pageSize);
        this.pageSize = pageSize;
    }

    public String getIsv_id() {
        return isv_id;
    }

    public void setIsv_id(String isv_id) {
        putBodyParameter("isv_id",isv_id);
        this.isv_id = isv_id;
    }

    @Override
    public String toString() {
        return "AppointmentCodeRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", isv_id='" + isv_id + '\'' +
                '}';
    }

    public static class Builder {

        /** 页数 */
        private Integer pageNum;
        /** 每页数量 */
        private Integer pageSize;
        /** 昵称 */
        private String isv_id;

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder isv_id(String isv_id) {
            this.isv_id = isv_id;
            return this;
        }

        public AppointmentCodeRequest build() throws ClientException {
            return new AppointmentCodeRequest(this);
        }
    }
}
