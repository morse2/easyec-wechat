package com.googlecode.easyec.wechat.card.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.model.event.UserConCardMessage;
import com.googlecode.easyec.wechat.card.model.event.UserSkuRemindMessage;
import com.googlecode.easyec.wechat.msg.handler.event.WeChatEventMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;

import static com.googlecode.easyec.wechat.card.model.event.UserConCardMessage.EVENT_USERCONCARD;
import static com.googlecode.easyec.wechat.card.model.event.UserSkuRemindMessage.EVENT_USERSKUREMIND;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 库存报警事件
 */
public abstract class UserSkuRemindMessageHandler extends WeChatEventMessageHandler<UserSkuRemindMessage> {

    public UserSkuRemindMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_USERSKUREMIND.equals(val));
    }

}
