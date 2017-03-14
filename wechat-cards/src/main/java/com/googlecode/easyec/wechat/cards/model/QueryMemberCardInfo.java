package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券中的代金券类型的对象类
 *
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryMemberCardInfo {

    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("member_card")
    private WeChatMemberCardInfo cardInfo;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public WeChatMemberCardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(WeChatMemberCardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }
}
