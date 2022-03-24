package com.dahuatech.icc.assesscontrol.model.v202103.authPerson;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

/**
 * 人员权限分页查询
 *
 * @author 237417
 */
public class AuthPersonPageListRequest extends AbstractIccRequest<AuthPersonPageListResponse> {
    /** 授权状态: "-1" - 全部，"1" - 未授权，"2" - 已授权 */
    private String authorizeStatus;
    /** 部门id数组 */
    private List<String> deptIds;
    /** 任务状态。 "-1" 全部，"0" 已下发，"1" 下发中 */
    private Integer taskStatus;
    /** 页码 */
    private Integer pageNum;
    /** 分页大小 */
    private Integer pageSize;
    /*--------以上必填-----*/

    /** 人员编号 */
    private String personCode;
    /** 人员姓名 */
    private String personName;
    /** 卡号 */
    private String cardNumber;

    public AuthPersonPageListRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_AUTH_PERSON_PAGE_LIST_POST), Method.POST);
        this.authorizeStatus = builder.authorizeStatus;
        this.deptIds = builder.deptIds;
        this.taskStatus = builder.taskStatus;
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        putBodyParameter("authorizeStatus",authorizeStatus);
        putBodyParameter("deptIds",deptIds);
        putBodyParameter("taskStatus",taskStatus);
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<AuthPersonPageListResponse> getResponseClass() {
        return AuthPersonPageListResponse.class;
    }

    public String getAuthorizeStatus() {
        return authorizeStatus;
    }

    public void setAuthorizeStatus(String authorizeStatus) {
        this.authorizeStatus = authorizeStatus;
        putBodyParameter("authorizeStatus",authorizeStatus);
    }

    public List<String> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<String> deptIds) {
        this.deptIds = deptIds;
        putBodyParameter("deptIds",deptIds);
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
        putBodyParameter("taskStatus",taskStatus);
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        putBodyParameter("pageNum",pageNum);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        putBodyParameter("pageSize",pageSize);
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
        putBodyParameter("personCode",personCode);
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
        putBodyParameter("personName",personName);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        putBodyParameter("cardNumber",cardNumber);
    }

    public static class Builder {

        /** 授权状态: "-1" - 全部，"1" - 未授权，"2" - 已授权 */
        private String authorizeStatus;
        /** 部门id数组 */
        private List<String> deptIds;
        /** 任务状态。 "-1" 全部，"0" 已下发，"1" 下发中 */
        private Integer taskStatus;
        /** 页码 */
        private Integer pageNum;
        /** 分页大小 */
        private Integer pageSize;
        /*--------以上必填-----*/

        public Builder authorizeStatus(String authorizeStatus) {
            this.authorizeStatus = authorizeStatus;
            return this;
        }

        public Builder deptIds(List<String> deptIds) {
            this.deptIds = deptIds;
            return this;
        }

        public Builder taskStatus(Integer taskStatus) {
            this.taskStatus = taskStatus;
            return this;
        }

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public AuthPersonPageListRequest build() throws ClientException {
            return new AuthPersonPageListRequest(this);
        }
    }
}
