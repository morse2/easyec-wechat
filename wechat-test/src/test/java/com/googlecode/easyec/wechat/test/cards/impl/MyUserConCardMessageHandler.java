package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserConCardMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserConCardMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserConCardMessageHandler extends UserConCardMessageHandler {


    public MyUserConCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserConCardMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserConCardMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserConCardMessage obj) throws Exception {
        System.out.println(obj.isUserConCard());
        System.out.println(obj.getCardId());
        System.out.println(obj.getUserCardCode());
        System.out.println(obj.getConsumeSource());
        System.out.println(obj.getLocationId());
        System.out.println(obj.getStaffOpenId());       // TODO: 2017/3/10   放入xml中有错误

        System.out.println(obj.getTo());
        System.out.println(obj.getFrom());
        System.out.println(obj.getMsgType());
        System.out.println(obj.getEvent());
        System.out.println(obj.getCreateTime());
        return null;
    }

}
