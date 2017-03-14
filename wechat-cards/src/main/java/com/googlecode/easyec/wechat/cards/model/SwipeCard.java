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


    private static final long serialVersionUID = -9192534604241644841L;

    @JsonProperty(value = "is_swipe_card")
    private boolean isSwipeCard;                        //是否设置该会员卡支持拉出微信支付刷卡界面
    @JsonProperty(value = "is_pay_and_qrcode")
    private boolean isPayAndQrcode;                     //是否设置该会员卡中部的按钮同时支持微信支付刷卡和会员卡二维码


    public boolean isSwipeCard() {
        return isSwipeCard;
    }

    public void setSwipeCard(boolean swipeCard) {
        isSwipeCard = swipeCard;
    }

    public boolean isPayAndQrcode() {
        return isPayAndQrcode;
    }

    public void setPayAndQrcode(boolean payAndQrcode) {
        isPayAndQrcode = payAndQrcode;
    }
}
