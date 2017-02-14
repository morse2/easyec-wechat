package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 创建微信卡券的响应结果类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateWeChatCardResult {

    @JsonProperty("card_id")
    private String cardId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
