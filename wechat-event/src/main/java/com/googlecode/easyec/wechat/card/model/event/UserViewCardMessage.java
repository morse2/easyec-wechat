package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 进入会员卡事件推送
 */
public class UserViewCardMessage extends WeChatEventMessage {

    public static final String EVENT_USERVIEWCARD = "user_view_card";

    private String cardId;

    private String userCardCode;

    public boolean isUserViewCard() {
        return EVENT_USERVIEWCARD.equalsIgnoreCase(getEvent());
    }


    @XmlElementMapping(name = "CardId")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @XmlElementMapping(name = "UserCardCode")
    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }


    public String getCardId() {
        return cardId;
    }


    public String getUserCardCode() {
        return userCardCode;
    }


}
