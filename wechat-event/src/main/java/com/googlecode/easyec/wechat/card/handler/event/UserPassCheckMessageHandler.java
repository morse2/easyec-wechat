package com.googlecode.easyec.wechat.card.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.model.event.UserConCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserPassCheckMessage;
import com.googlecode.easyec.wechat.msg.handler.event.WeChatEventMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;

import static com.googlecode.easyec.wechat.card.model.event.UserConCardMessage.EVENT_USERCONCARD;
import static com.googlecode.easyec.wechat.card.model.event.UserPassCheckMessage.EVENT_USERPASSCHECK;
import static com.googlecode.easyec.wechat.card.model.event.UserPassCheckMessage.EVENT_USERPNOTASSCHECK;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 审核事件推送
 */
public abstract class UserPassCheckMessageHandler extends WeChatEventMessageHandler<UserPassCheckMessage> {

    public UserPassCheckMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_USERPASSCHECK.equals(val))||
                (EVENT_USERPNOTASSCHECK.equals(val)) ;
    }

}
