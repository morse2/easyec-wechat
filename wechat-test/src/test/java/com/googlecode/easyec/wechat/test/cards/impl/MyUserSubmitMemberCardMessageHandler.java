package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserPayMessageHandler;
import com.googlecode.easyec.wechat.card.handler.event.UserSubmitMemberCardMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserPayMessage;
import com.googlecode.easyec.wechat.card.model.event.UserSubmitMemberCardMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserSubmitMemberCardMessageHandler extends UserSubmitMemberCardMessageHandler {


    public MyUserSubmitMemberCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserSubmitMemberCardMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserSubmitMemberCardMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserSubmitMemberCardMessage obj) throws Exception {
        System.out.println(obj.isSubmitCard());
        System.out.println(obj.getCardId());
        System.out.println(obj.getUserCardCode());
        return null;
    }


}
