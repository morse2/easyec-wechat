package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserDelCardMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserDelCardMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserDelCardMessageHandler extends UserDelCardMessageHandler {


    public MyUserDelCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserDelCardMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserDelCardMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserDelCardMessage obj) throws Exception {
        System.out.println(obj.isUserDelCard());
        System.out.println(obj.getCardId());
        System.out.println(obj.getUserCardCode());
        return null;
    }

}
