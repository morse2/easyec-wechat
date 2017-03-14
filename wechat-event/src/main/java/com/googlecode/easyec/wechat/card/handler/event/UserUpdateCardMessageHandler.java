package com.googlecode.easyec.wechat.card.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.model.event.UserDelCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserUpdateCardMessage;
import com.googlecode.easyec.wechat.msg.handler.event.WeChatEventMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;

import static com.googlecode.easyec.wechat.card.model.event.UserDelCardMessage.EVENT_USERDELCARD;
import static com.googlecode.easyec.wechat.card.model.event.UserUpdateCardMessage.EVENT_USERUPDCARD;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 会员卡内容更新事件
 */
public abstract class UserUpdateCardMessageHandler extends WeChatEventMessageHandler<UserUpdateCardMessage> {

    public UserUpdateCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_USERUPDCARD.equals(val));
    }

}
