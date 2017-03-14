package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserEnterSessionMessageHandler;
import com.googlecode.easyec.wechat.card.handler.event.UserViewCardMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserEnterSessionMessage;
import com.googlecode.easyec.wechat.card.model.event.UserViewCardMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserEnterSessionMessageHandler extends UserEnterSessionMessageHandler {


    public MyUserEnterSessionMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserEnterSessionMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserEnterSessionMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserEnterSessionMessage obj) throws Exception {
        System.out.println(obj.isUserEnterSession());
        System.out.println(obj.getCardId());
        System.out.println(obj.getUserCardCode());
        return null;
    }
}
