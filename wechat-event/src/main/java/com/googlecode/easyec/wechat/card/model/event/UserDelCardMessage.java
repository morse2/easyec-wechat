package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 用户删除卡券事件
 */
public class UserDelCardMessage extends WeChatEventMessage {

    public static final String EVENT_USERDELCARD= "user_del_card";

    private String cardId;

    private String userCardCode;

    public boolean isUserDelCard() {
        return EVENT_USERDELCARD.equalsIgnoreCase(getEvent());
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
