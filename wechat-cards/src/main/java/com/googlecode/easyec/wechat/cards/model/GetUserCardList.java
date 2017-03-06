package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 管理卡券 获取用户已领取的卡券
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class GetUserCardList extends AbstractCredentialCtrl {

    private String openId;

    private String cardId;

    @JsonProperty(value = "openid" , required = true)
    public String getOpenId() {
        return openId;
    }

    @JsonProperty("card_id")
    public String getCardId() {
        return cardId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
