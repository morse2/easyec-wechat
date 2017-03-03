package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 会员卡支付功能结构体
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayInfo implements Serializable {

    private static final long serialVersionUID = -4730596562717210554L;

    @JsonProperty(value = "swipe_card")
    private SwipeCard swipeCard;

    public SwipeCard getSwipeCard() {
        return swipeCard;
    }

    public void setSwipeCard(SwipeCard swipeCard) {
        this.swipeCard = swipeCard;
    }
}
