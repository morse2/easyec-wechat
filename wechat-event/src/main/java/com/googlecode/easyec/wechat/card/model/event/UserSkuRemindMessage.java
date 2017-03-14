package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 *库存报警事件
 */
public class UserSkuRemindMessage extends WeChatEventMessage {

    public static final String EVENT_USERSKUREMIND = "card_sku_remind";

    private String cardId;

    private String detail;

    public boolean isUserSkuRemind() {
        return EVENT_USERSKUREMIND.equalsIgnoreCase(getEvent());
    }

    @XmlElementMapping(name = "CardId")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getDetail() {
        return detail;
    }
    @XmlElementMapping(name = "Detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCardId() {
        return cardId;
    }


}
