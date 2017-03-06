package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 管理卡券 拉取卡券概况数据 返回数据list
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class FreeCardInfo extends CardInfo {

    private String cardId;                 //卡券ID

    private String card_type;              //0：折扣券，1：代金券，2：礼品券，3：优惠券，4：团购券（暂不支持拉取特殊票券类型数据，电影票、飞机票、会议门票、景区门票）

    @JsonProperty("card_id")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    @JsonProperty("card_type")
    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCardId() {
        return cardId;
    }

    public String getCard_type() {
        return card_type;
    }
}
