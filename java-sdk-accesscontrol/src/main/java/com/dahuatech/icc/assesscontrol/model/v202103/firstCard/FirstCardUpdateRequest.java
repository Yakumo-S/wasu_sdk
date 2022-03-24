package com.dahuatech.icc.assesscontrol.model.v202103.firstCard;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 修改首卡
 *
 * @author 237417
 */
public class FirstCardUpdateRequest extends AbstractIccRequest<FirstCardUpdateResponse> {

    /** 首卡开门ID */
    private Long id;
    /** 首卡使能"0"-开启，"1"-关闭 */
    private String firstCardEnable;
    /*--------以上必填-----*/

    public FirstCardUpdateRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_FIRST_CARD_UPDATE_POST), Method.POST);
        this.id = builder.id;
        this.firstCardEnable = builder.firstCardEnable;
        putBodyParameter("id",id);
        putBodyParameter("firstCardEnable",firstCardEnable);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<FirstCardUpdateResponse> getResponseClass() {
        return FirstCardUpdateResponse.class;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        putBodyParameter("id",id);
    }

    public String getFirstCardEnable() {
        return firstCardEnable;
    }

    public void setFirstCardEnable(String firstCardEnable) {
        this.firstCardEnable = firstCardEnable;
        putBodyParameter("firstCardEnable",firstCardEnable);
    }

    public static class Builder {
        /** 首卡开门ID */
        private Long id;
        /** 首卡使能"0"-开启，"1"-关闭 */
        private String firstCardEnable;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstCardEnable(String firstCardEnable) {
            this.firstCardEnable = firstCardEnable;
            return this;
        }

        public FirstCardUpdateRequest build() throws ClientException {
            return new FirstCardUpdateRequest(this);
        }
    }
}
