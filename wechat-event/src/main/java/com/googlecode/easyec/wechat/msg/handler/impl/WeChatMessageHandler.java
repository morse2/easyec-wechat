package com.googlecode.easyec.wechat.msg.handler.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.handler.WeChatXmlMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.impl.WeChatTextMessage;
import com.googlecode.easyec.wechat.msg.xml.WeChatXmlObject;

/**
 * 处理微信文本消息的实现类
 *
 * @author JunJie
 */
public abstract class WeChatMessageHandler extends WeChatXmlMessageHandler<WeChatTextMessage> {

    public WeChatMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage msg) {
        return msg != null && "text".equals(msg.getMsgType());
    }

    @Override
    protected WeChatTextMessage createInstance(WeChatXmlObject obj) {
        return new WeChatTextMessage();
    }
}
