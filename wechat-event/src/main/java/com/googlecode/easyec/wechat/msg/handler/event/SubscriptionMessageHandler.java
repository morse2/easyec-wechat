package com.googlecode.easyec.wechat.msg.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.QRSubscriptionMessage;
import com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage;
import com.googlecode.easyec.wechat.msg.xml.WeChatXmlObject;

import static com.googlecode.easyec.wechat.msg.model.event.QRSubscriptionMessage.ELEMENT_EVENT_KEY;
import static com.googlecode.easyec.wechat.msg.model.event.QRSubscriptionMessage.ELEMENT_TICKET;
import static com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage.EVENT_SUBSCRIBE;
import static com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage.EVENT_UNSUBSCRIBE;
import static org.apache.commons.collections.CollectionUtils.size;
import static org.apache.commons.lang.StringUtils.isNotBlank;

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
    protected boolean accept(WeChatXmlObject obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = getEventValue(obj);

        return isNotBlank(val)
            && (EVENT_SUBSCRIBE.equals(val)
            || EVENT_UNSUBSCRIBE.equals(val));
    }

    @Override
    protected SubscriptionMessage cast(WeChatXmlObject obj) {
        SubscriptionMessage msg;

        if (size(obj.getElements()) > 1) {
            msg = new QRSubscriptionMessage();
        } else msg = new SubscriptionMessage();

        setCommonProperties(obj, msg);
        parseCustomProperties(obj, msg);

        return msg;
    }

    @Override
    protected void setCustomValue(WeChatMessage msg, String key, String value) {
        if (ELEMENT_EVENT_KEY.equals(key)) {
            ((QRSubscriptionMessage) msg).setEventKey(value);
        } else if (ELEMENT_TICKET.equals(key)) {
            ((QRSubscriptionMessage) msg).setTicket(value);
        } else {
            super.setCustomValue(msg, key, value);
        }
    }
}
