package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserGetCardMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserGetCardMessage;
import com.googlecode.easyec.wechat.msg.handler.event.SubscriptionMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.QRSubscriptionMessage;
import com.googlecode.easyec.wechat.msg.model.event.SubscriptionMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserGetCardMessageHandler extends UserGetCardMessageHandler {


    public MyUserGetCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserGetCardMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserGetCardMessage.class);
    }


    @Override
    protected WeChatMessage processMessage(UserGetCardMessage obj) throws Exception {
        System.out.println(obj.isUserGetCard());
        System.out.println(obj.getTo());
        System.out.println(obj.getFrom());
        System.out.println(obj.getFriend());
        System.out.println(obj.getCreateTime());
        System.out.println(obj.getMsgType());
        System.out.println(obj.getEvent());
        System.out.println(obj.getCardId());
        System.out.println(obj.getIsGiveByFriend());
        System.out.println(obj.getUserCardCode());
        System.out.println(obj.getOuterId());
        return null;
    }


}
