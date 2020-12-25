package com.googlecode.easyec.wechat.test.msg.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.handler.WeChatXmlMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.test.msg.beans.MsgRootContent;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

public class MyMsgContentMessageHandler extends WeChatXmlMessageHandler<MsgRootContent> {

    public MyMsgContentMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage msg) {
        return msg instanceof MsgRootContent;
    }

    @Override
    protected MsgRootContent createInstance(WeChatXmlData obj) {
        return obj.resolve(MsgRootContent.class);
    }

    @Override
    protected WeChatMessage processMessage(MsgRootContent obj) throws Exception {
        return null;
    }
}
