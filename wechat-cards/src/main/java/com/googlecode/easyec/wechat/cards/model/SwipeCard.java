package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 会员卡刷卡功能
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwipeCard implements Serializable {

    private static final long serialVersionUID = -4730596562717210554L;

    @JsonProperty(value = "is_swipe_card")
    private boolean isSwipeCard;                        //是否设置该会员卡支持拉出微信支付刷卡界面

    public boolean isSwipeCard() {
        return isSwipeCard;
    }

    public void setSwipeCard(boolean swipeCard) {
        isSwipeCard = swipeCard;
    }
}
