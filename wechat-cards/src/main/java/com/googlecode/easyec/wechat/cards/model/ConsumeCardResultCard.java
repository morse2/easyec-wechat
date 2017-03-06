package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 核销code 返回信息中 card类
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsumeCardResultCard implements Serializable {

    private String cardId;      //卡券ID

    @JsonProperty("card_id")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}
