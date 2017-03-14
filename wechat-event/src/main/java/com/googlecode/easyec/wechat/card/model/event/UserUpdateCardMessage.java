package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 会员卡内容更新事件
 */
public class UserUpdateCardMessage extends WeChatEventMessage {

    public static final String EVENT_USERUPDCARD = "update_member_card";

    private String cardId;

    private String userCardCode;

    private Integer modifyBonus;

    private Integer modifyBalance;

    public boolean isUserUpdCard() {
        return EVENT_USERUPDCARD.equalsIgnoreCase(getEvent());
    }

    @XmlElementMapping(name = "CardId")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @XmlElementMapping(name = "UserCardCode")
    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    @XmlElementMapping(name = "ModifyBonus")
    public void setModifyBonus(Integer modifyBonus) {
        this.modifyBonus = modifyBonus;
    }

    @XmlElementMapping(name = "ModifyBalance")
    public void setModifyBalance(Integer modifyBalance) {
        this.modifyBalance = modifyBalance;
    }


    public Integer getModifyBonus() {
        return modifyBonus;
    }

    public Integer getModifyBalance() {
        return modifyBalance;
    }

    public String getCardId() {
        return cardId;
    }

    public String getUserCardCode() {
        return userCardCode;
    }


}
