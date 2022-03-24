package com.wasu.model.v202010.card;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 卡片回收
 *
 * @author 237417
 * @since 1.0.0 2021/03/01
 */
public class BrmCardReturnRequest extends AbstractIccRequest<BrmCardReturnResponse> {

    private List<Long> cardIds;
    private List<String> cardNumbers;

    public BrmCardReturnRequest() throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_CARD_RETURN_PUT), Method.PUT);
    }

    @Override
    public Class<BrmCardReturnResponse> getResponseClass() {
        return BrmCardReturnResponse.class;
    }

    public List<Long> getCardIds() {
        return cardIds;
    }

    public void setCardIds(List<Long> cardIds) {
        this.cardIds = cardIds;
        putBodyParameter("cardIds", cardIds);
    }

    public List<String> getCardNumbers() {
        return cardNumbers;
    }

    public void setCardNumbers(List<String> cardNumbers) {
        this.cardNumbers = cardNumbers;
        putBodyParameter("cardNumbers", cardNumbers);
    }
}
