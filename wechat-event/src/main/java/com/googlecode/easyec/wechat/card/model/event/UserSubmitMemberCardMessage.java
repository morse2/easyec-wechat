package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 当用户通过一键激活的方式提交信息并点击激活或者用户修改会员卡信息后，商户会收到用户激活的事件推送
 */
public class UserSubmitMemberCardMessage extends WeChatEventMessage {

    public static final String EVENT_SUBMITCARD = "submit_membercard_user_info";

    private String cardId;

    private String userCardCode;

    public boolean isSubmitCard() {
        return EVENT_SUBMITCARD.equalsIgnoreCase(getEvent());
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
