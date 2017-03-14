package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserPayMessageHandler;
import com.googlecode.easyec.wechat.card.handler.event.UserViewCardMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserPayMessage;
import com.googlecode.easyec.wechat.card.model.event.UserViewCardMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserViewCardMessageHandler extends UserViewCardMessageHandler {


    public MyUserViewCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserViewCardMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserViewCardMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserViewCardMessage obj) throws Exception {
        System.out.println(obj.isUserViewCard());
        System.out.println(obj.getCardId());
        System.out.println(obj.getUserCardCode());
        return null;
    }
}
