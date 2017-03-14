package com.googlecode.easyec.wechat.card.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.model.event.UserGetCardMessage;
import com.googlecode.easyec.wechat.msg.handler.event.WeChatEventMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.QRSubscriptionMessage;
import com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

import static com.googlecode.easyec.wechat.card.model.event.UserGetCardMessage.EVENT_USERGETCARD;
import static com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage.EVENT_SUBSCRIBE;
import static com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage.EVENT_UNSUBSCRIBE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 用户领取卡券消息的处理类
 */
public abstract class UserGetCardMessageHandler extends WeChatEventMessageHandler<UserGetCardMessage> {

    public UserGetCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_USERGETCARD.equals(val));
    }

}
