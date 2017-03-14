package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券中的代金券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryCashInfo  {

    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("cash")
    private WeChatCashInfo chatCashInfo;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public WeChatCashInfo getChatCashInfo() {
        return chatCashInfo;
    }

    public void setChatCashInfo(WeChatCashInfo chatCashInfo) {
        this.chatCashInfo = chatCashInfo;
    }
}
