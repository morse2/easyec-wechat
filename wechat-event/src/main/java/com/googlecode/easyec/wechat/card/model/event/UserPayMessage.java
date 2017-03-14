package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 用户买单事件
 */
public class UserPayMessage extends WeChatEventMessage {

    public static final String EVENT_USERPAY = "user_pay_from_pay_cell";

    private String cardId;

    private String userCardCode;

    private String transId;

    private String locationId;

    private Integer fee;

    private Integer originalFee;

    public boolean isUserPay() {
        return EVENT_USERPAY.equalsIgnoreCase(getEvent());
    }


    @XmlElementMapping(name = "CardId")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @XmlElementMapping(name = "UserCardCode")
    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    @XmlElementMapping(name = "TransId")
    public void setTransId(String transId) {
        this.transId = transId;
    }

    @XmlElementMapping(name = "LocationId")
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @XmlElementMapping(name = "Fee")
    public void setFee(Integer fee) {
        this.fee = fee;
    }

    @XmlElementMapping(name = "OriginalFee")
    public void setOriginalFee(Integer originalFee) {
        this.originalFee = originalFee;
    }

    public String getCardId() {
        return cardId;
    }


    public String getUserCardCode() {
        return userCardCode;
    }

    public String getTransId() {
        return transId;
    }

    public String getLocationId() {
        return locationId;
    }

    public Integer getFee() {
        return fee;
    }

    public Integer getOriginalFee() {
        return originalFee;
    }
}
