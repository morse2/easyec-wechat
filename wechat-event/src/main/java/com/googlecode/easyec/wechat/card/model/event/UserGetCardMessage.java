package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 用户领取卡券事件
 */
public class UserGetCardMessage extends WeChatEventMessage {

    public static final String EVENT_USERGETCARD= "user_get_card";

    private String friend;

    private String cardId;

    private Integer isGiveByFriend;

    private String userCardCode;

    private String oldUserCardCode;

    private Long outerId;

    public boolean isUserGetCard() {
        return EVENT_USERGETCARD.equalsIgnoreCase(getEvent());
    }

    @XmlElementMapping(name = "FriendUserName")
    public void setFriend(String friend) {
        this.friend = friend;
    }
    @XmlElementMapping(name = "CardId")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    @XmlElementMapping(name = "IsGiveByFriend")
    public void setIsGiveByFriend(Integer isGiveByFriend) {
        this.isGiveByFriend = isGiveByFriend;
    }
    @XmlElementMapping(name = "UserCardCode")
    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }
    @XmlElementMapping(name = "OldUserCardCode")
    public void setOldUserCardCode(String oldUserCardCode) {
        this.oldUserCardCode = oldUserCardCode;
    }
    @XmlElementMapping(name = "OuterId")
    public void setOuterId(Long outerId) {
        this.outerId = outerId;
    }

    public String getFriend() {
        return friend;
    }

    public String getCardId() {
        return cardId;
    }

    public Integer getIsGiveByFriend() {
        return isGiveByFriend;
    }

    public String getUserCardCode() {
        return userCardCode;
    }

    public String getOldUserCardCode() {
        return oldUserCardCode;
    }

    public Long getOuterId() {
        return outerId;
    }
}
