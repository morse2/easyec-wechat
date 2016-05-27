package com.googlecode.easyec.wechat.msg.model.event;

/**
 * 表示关注或取消关注的消息对象
 *
 * @author JunJie
 */
public class SubscriptionMessage extends WeChatEventMessage {

    public static final String EVENT_SUBSCRIBE = "subscribe";
    public static final String EVENT_UNSUBSCRIBE = "unsubscribe";

    public boolean isSubscribed() {
        return EVENT_SUBSCRIBE.equalsIgnoreCase(getEvent());
    }
}
