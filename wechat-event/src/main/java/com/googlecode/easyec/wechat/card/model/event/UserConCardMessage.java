package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 核销卡券事件
 */
public class UserConCardMessage extends WeChatEventMessage {

    public static final String EVENT_USERCONCARD = "user_consume_card";

    private String cardId;

    private String userCardCode;

    private String consumeSource;

    private String locationId;

    private String staffOpenId;

    public boolean isUserConCard() {
        return EVENT_USERCONCARD.equalsIgnoreCase(getEvent());
    }


    @XmlElementMapping(name = "CardId")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @XmlElementMapping(name = "UserCardCode")
    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    @XmlElementMapping(name = "ConsumeSource")
    public void setConsumeSource(String consumeSource) {
        this.consumeSource = consumeSource;
    }

    @XmlElementMapping(name = "LocationId")
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @XmlElementMapping(name = "StaffOpenId")
    public void setStaffOpenId(String staffOpenId) {
        this.staffOpenId = staffOpenId;
    }

    public String getCardId() {
        return cardId;
    }


    public String getUserCardCode() {
        return userCardCode;
    }

    public String getConsumeSource() {
        return consumeSource;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getStaffOpenId() {
        return staffOpenId;
    }
}
