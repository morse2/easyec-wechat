package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserConCardMessageHandler;
import com.googlecode.easyec.wechat.card.handler.event.UserPayMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserConCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserPayMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserPayMessageHandler extends UserPayMessageHandler {


    public MyUserPayMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserPayMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserPayMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserPayMessage obj) throws Exception {
        System.out.println(obj.isUserPay());
        System.out.println(obj.getCardId());
        System.out.println(obj.getUserCardCode());
        System.out.println(obj.getLocationId());
        System.out.println(obj.getFee());
        System.out.println(obj.getOriginalFee());
        System.out.println(obj.getTransId());
        return null;
    }
}
