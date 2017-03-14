package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserConCardMessageHandler;
import com.googlecode.easyec.wechat.card.handler.event.UserPassCheckMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserConCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserPassCheckMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserPassCheckMessageHandler extends UserPassCheckMessageHandler {


    public MyUserPassCheckMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserPassCheckMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserPassCheckMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserPassCheckMessage obj) throws Exception {
        System.out.println(obj.isUserPassCheck());
        System.out.println(obj.getCardId());
        return null;
    }

}
