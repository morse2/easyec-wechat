package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 从卡券进入公众号会话事件推送
 */
public class UserEnterSessionMessage extends WeChatEventMessage {

    public static final String EVENT_USERENTERSESSION = "user_enter_session_from_card";

    private String cardId;

    private String userCardCode;

    public boolean isUserEnterSession() {
        return EVENT_USERENTERSESSION.equalsIgnoreCase(getEvent());
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
