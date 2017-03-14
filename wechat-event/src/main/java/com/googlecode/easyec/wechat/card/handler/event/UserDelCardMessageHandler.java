package com.googlecode.easyec.wechat.card.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.model.event.UserDelCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserGetCardMessage;
import com.googlecode.easyec.wechat.msg.handler.event.WeChatEventMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;

import static com.googlecode.easyec.wechat.card.model.event.UserDelCardMessage.EVENT_USERDELCARD;
import static com.googlecode.easyec.wechat.card.model.event.UserGetCardMessage.EVENT_USERGETCARD;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 用户删除卡券消息的处理类
 */
public abstract class UserDelCardMessageHandler extends WeChatEventMessageHandler<UserDelCardMessage> {

    public UserDelCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_USERDELCARD.equals(val));
    }

}
