package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 表示微信卡券中的会员卡类型的对象类
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatVipMember implements Serializable {

    private static final long serialVersionUID = -4730596562717210554L;

    @JsonProperty(value = "member_card", required = true)
    private WeChatVipMemberCard memberCard;

    private String cardType;

    public WeChatVipMember() {
        this.cardType = "MEMBER_CARD";
    }

    @JsonProperty("card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public WeChatVipMemberCard getMemberCard() {
        return memberCard;
    }

    public void setMemberCard(WeChatVipMemberCard memberCard) {
        this.memberCard = memberCard;
    }
}
