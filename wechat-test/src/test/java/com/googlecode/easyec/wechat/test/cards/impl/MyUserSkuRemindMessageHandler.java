package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserConCardMessageHandler;
import com.googlecode.easyec.wechat.card.handler.event.UserSkuRemindMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserConCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserSkuRemindMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserSkuRemindMessageHandler extends UserSkuRemindMessageHandler {


    public MyUserSkuRemindMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserSkuRemindMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserSkuRemindMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserSkuRemindMessage obj) throws Exception {
        System.out.println(obj.isUserSkuRemind());
        System.out.println(obj.getCardId());
        System.out.println(obj.getDetail());
        return null;
    }

}
