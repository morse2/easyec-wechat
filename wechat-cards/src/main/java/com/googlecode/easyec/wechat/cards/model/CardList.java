package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 管理卡券 获取用户已领取的卡券的集合
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class CardList extends AbstractCredentialCtrl {

    private String code;

    private String cardId;

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }
    @JsonProperty("card_id")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCode() {
        return code;
    }

    public String getCardId() {
        return cardId;
    }
}
