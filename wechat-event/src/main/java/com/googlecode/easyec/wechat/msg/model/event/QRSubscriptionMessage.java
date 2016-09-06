package com.googlecode.easyec.wechat.msg.model.event;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 表示用户扫码关注的消息对象类
 *
 * @author JunJie
 */
public class QRSubscriptionMessage extends SubscriptionMessage {

    private String eventKey;
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    @XmlElementMapping(name = "EventKey")
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    @XmlElementMapping(name = "Ticket")
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
