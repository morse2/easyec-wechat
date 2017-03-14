package com.googlecode.easyec.wechat.card.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.model.event.UserConCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserPayOrderMessage;
import com.googlecode.easyec.wechat.msg.handler.event.WeChatEventMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;

import static com.googlecode.easyec.wechat.card.model.event.UserConCardMessage.EVENT_USERCONCARD;
import static com.googlecode.easyec.wechat.card.model.event.UserPayOrderMessage.EVENT_USERPAYORDER;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 券点流水详情事件
 */
public abstract class UserPayOrderMessageHandler extends WeChatEventMessageHandler<UserPayOrderMessage> {

    public UserPayOrderMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_USERPAYORDER.equals(val));
    }

}
