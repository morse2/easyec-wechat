package com.googlecode.easyec.wechat.msg.model.event;

/**
 * 表示用户扫码关注的消息对象类
 *
 * @author JunJie
 */
public class QRSubscriptionMessage extends SubscriptionMessage {

    public static final String ELEMENT_EVENT_KEY = "EventKey";
    public static final String ELEMENT_TICKET = "Ticket";

    private String eventKey;
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
