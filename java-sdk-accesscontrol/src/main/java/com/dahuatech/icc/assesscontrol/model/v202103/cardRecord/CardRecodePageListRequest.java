package com.dahuatech.icc.assesscontrol.model.v202103.cardRecord;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 刷卡记录详情
 *
 * @author 237417
 */
public class CardRecodePageListRequest extends AbstractIccRequest<CardRecodePageListResponse> {

    /** 页码 */
    private Integer pageNum;

    /** 分页大小 */
    private String pageSize;

    /*--------以上必填-----*/
    /** 查询开始时间 */
    private String startSwingTime;

    /** 查询结束时间 */
    private String endSwingTime;

    /** 开门类型，详见开门类型字典 */
    private String openType;

    /** 卡片类型, null-全部, 0-IC卡, 1-有源RFID, 2-CPU卡 */
    private String category;

    /** 人员名称 */
    private String personName;

    /** 人员编号 */
    private String personCode;

    /** 通道编码 */
    private String channelCode;

    /** 部门ID, 部门间", "分隔 */
    private String deptIds;

    /** 卡号 */
    private String cardNumber;

    /** 事件类型, null-全部, 1-进门, 2出门, 3-进/出门 */
    private String enterOrExit;

    /** 开门结果, null-全部, 1-成功, 0-失败 */
    private Integer openResult;

    /** 是否超温 */
    private boolean overTemp;

    /** 体温低限 */
    private float curTempStart;

    /** 体温高限 */
    private float curTempEnd;

    /** 口罩状态(3-带口罩,2—没带口罩,1-未识别) */
    private Integer maskState;

    public CardRecodePageListRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_SWING_CARD_RECORD_PAGE_LIST_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        putBodyParameter("pageNum",pageNum);
        putBodyParameter("pageSize",pageSize);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<CardRecodePageListResponse> getResponseClass() {
        return CardRecodePageListResponse.class;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        putBodyParameter("pageNum",pageNum);
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
        putBodyParameter("pageSize",pageSize);
    }

    public String getStartSwingTime() {
        return startSwingTime;
    }

    public void setStartSwingTime(String startSwingTime) {
        this.startSwingTime = startSwingTime;
        putBodyParameter("startSwingTime",startSwingTime);
    }

    public String getEndSwingTime() {
        return endSwingTime;
    }

    public void setEndSwingTime(String endSwingTime) {
        this.endSwingTime = endSwingTime;
        putBodyParameter("endSwingTime",endSwingTime);
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
        putBodyParameter("openType",openType);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        putBodyParameter("category",category);
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
        putBodyParameter("personName",personName);
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
        putBodyParameter("personCode",personCode);
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        putBodyParameter("channelCode",channelCode);
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
        putBodyParameter("deptIds",deptIds);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        putBodyParameter("cardNumber",cardNumber);
    }

    public String getEnterOrExit() {
        return enterOrExit;
    }

    public void setEnterOrExit(String enterOrExit) {
        this.enterOrExit = enterOrExit;
        putBodyParameter("enterOrExit",enterOrExit);
    }

    public Integer getOpenResult() {
        return openResult;
    }

    public void setOpenResult(Integer openResult) {
        this.openResult = openResult;
        putBodyParameter("openResult",openResult);
    }

    public boolean isOverTemp() {
        return overTemp;
    }

    public void setOverTemp(boolean overTemp) {
        this.overTemp = overTemp;
        putBodyParameter("overTemp",overTemp);
    }

    public float getCurTempStart() {
        return curTempStart;
    }

    public void setCurTempStart(float curTempStart) {
        this.curTempStart = curTempStart;
        putBodyParameter("curTempStart",curTempStart);
    }

    public float getCurTempEnd() {
        return curTempEnd;
    }

    public void setCurTempEnd(float curTempEnd) {
        this.curTempEnd = curTempEnd;
        putBodyParameter("curTempEnd",curTempEnd);
    }

    public Integer getMaskState() {
        return maskState;
    }

    public void setMaskState(Integer maskState) {
        this.maskState = maskState;
        putBodyParameter("maskState",maskState);
    }

    public static class Builder {
        /** 页码 */
        private Integer pageNum;
        /** 分页大小 */
        private String pageSize;

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(String pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public CardRecodePageListRequest build() throws ClientException {
            return new CardRecodePageListRequest(this);
        }

    }
}
