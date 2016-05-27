package com.googlecode.easyec.wechat.test.msg.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.handler.event.SubscriptionMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.QRSubscriptionMessage;
import com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage;

public class MySubscriptionMessageHandler extends SubscriptionMessageHandler {

    public MySubscriptionMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected WeChatMessage processMessage(SubscriptionMessage obj) throws Exception {
        System.out.println(obj.isSubscribed());
        System.out.println(obj.getEvent());
        System.out.println(obj.getMsgType());

        if (obj instanceof QRSubscriptionMessage) {
            System.out.println(((QRSubscriptionMessage) obj).getEventKey());
            System.out.println(((QRSubscriptionMessage) obj).getTicket());
        }

        return null;
    }
}
