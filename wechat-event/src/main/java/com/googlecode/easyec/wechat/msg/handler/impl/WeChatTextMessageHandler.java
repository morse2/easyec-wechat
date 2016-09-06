package com.googlecode.easyec.wechat.msg.handler.impl;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.handler.WeChatXmlMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.impl.WeChatTextMessage;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;

/**
 * 处理微信文本消息的实现类
 *
 * @author JunJie
 */
public abstract class WeChatTextMessageHandler extends WeChatXmlMessageHandler<WeChatTextMessage> {

    public WeChatTextMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage msg) {
        return msg != null && "text".equals(msg.getMsgType());
    }

    @Override
    protected WeChatTextMessage createInstance(WeChatXmlData obj) {
        return obj.resolve(WeChatTextMessage.class);
    }
}
