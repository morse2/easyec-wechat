package com.googlecode.easyec.wechat.msg.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.msg.handler.WeChatXmlMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;

import static com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage.MSG_TYPE_EVENT;

/**
 * 基于事件类型的消息处理类
 *
 * @author JunJie
 */
public abstract class WeChatEventMessageHandler<T extends WeChatEventMessage> extends WeChatXmlMessageHandler<T> {

    public WeChatEventMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        return obj != null
            && (obj instanceof WeChatEventMessage)
            && MSG_TYPE_EVENT.equals(obj.getMsgType());
    }
}
