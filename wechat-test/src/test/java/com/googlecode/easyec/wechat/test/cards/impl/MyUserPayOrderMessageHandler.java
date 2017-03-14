package com.googlecode.easyec.wechat.test.cards.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.handler.event.UserConCardMessageHandler;
import com.googlecode.easyec.wechat.card.handler.event.UserPayOrderMessageHandler;
import com.googlecode.easyec.wechat.card.model.event.UserConCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserPayOrderMessage;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyUserPayOrderMessageHandler extends UserPayOrderMessageHandler {


    public MyUserPayOrderMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected UserPayOrderMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(UserPayOrderMessage.class);
    }

    @Override
    protected WeChatMessage processMessage(UserPayOrderMessage obj) throws Exception {
        System.out.println(obj.isUserPayOrder());
        System.out.println(obj.getOrderId());
        System.out.println(obj.getStatus());
        System.out.println(obj.getPayFinishTime());
        System.out.println(obj.getDesc());
        System.out.println(obj.getFreeCoinCount());
        System.out.println(obj.getPayCoinCount());
        System.out.println(obj.getRefundFreeCoinCount());
        System.out.println(obj.getRefundPayCoinCount());
        System.out.println(obj.getOrderType());
        System.out.println(obj.getMemo());
        System.out.println(obj.getReceiptInfo());
        return null;
    }

}
