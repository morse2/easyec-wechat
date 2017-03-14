package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserDelCardMessageHandler;
import com.googlecode.easyec.wechat.card.handler.event.UserUpdateCardMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserDelCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserUpdateCardMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserUpdateCardMessageHandler extends UserUpdateCardMessageHandler {


    public MyUserUpdateCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserUpdateCardMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserUpdateCardMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserUpdateCardMessage obj) throws Exception {
        System.out.println(obj.isUserUpdCard());
        System.out.println(obj.getCardId());
        System.out.println(obj.getUserCardCode());
        return null;
    }

}
