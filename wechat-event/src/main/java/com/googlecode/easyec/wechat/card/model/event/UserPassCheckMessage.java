package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 审核事件推送
 */
public class UserPassCheckMessage extends WeChatEventMessage {

    public static final String EVENT_USERPASSCHECK = "card_pass_check";
    public static final String EVENT_USERPNOTASSCHECK = "card_not_pass_check";

    private String cardId;

    public boolean isUserPassCheck() {
        return EVENT_USERPASSCHECK.equalsIgnoreCase(getEvent());
    }


    @XmlElementMapping(name = "CardId")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

}
