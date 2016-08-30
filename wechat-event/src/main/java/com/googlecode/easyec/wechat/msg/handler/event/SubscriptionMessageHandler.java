package com.googlecode.easyec.wechat.msg.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.QRSubscriptionMessage;
import com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.msg.xml.WeChatXmlObject;

import static com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage.EVENT_SUBSCRIBE;
import static com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage.EVENT_UNSUBSCRIBE;
import static org.apache.commons.collections4.CollectionUtils.size;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 关注/取消关注/扫码关注的消息的处理类
 *
 * @author JunJie
 */
public abstract class SubscriptionMessageHandler extends WeChatEventMessageHandler<SubscriptionMessage> {

    public SubscriptionMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_SUBSCRIBE.equals(val)
            || EVENT_UNSUBSCRIBE.equals(val));
    }

    @Override
    protected SubscriptionMessage createInstance(WeChatXmlObject obj) {
        SubscriptionMessage msg;

        if (size(obj.getElements()) > 1) {
            msg = new QRSubscriptionMessage();
        } else msg = new SubscriptionMessage();

        return msg;
    }
}
