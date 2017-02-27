package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 微信卡券管理中查询导入code的数目的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryCodeCount extends AbstractCredentialCtrl {

    @JsonProperty("card_id")
    private String cardId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
