package com.googlecode.easyec.wechat.card.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.model.event.UserEnterSessionMessage;
import com.googlecode.easyec.wechat.card.model.event.UserViewCardMessage;
import com.googlecode.easyec.wechat.msg.handler.event.WeChatEventMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;

import static com.googlecode.easyec.wechat.card.model.event.UserEnterSessionMessage.EVENT_USERENTERSESSION;
import static com.googlecode.easyec.wechat.card.model.event.UserViewCardMessage.EVENT_USERVIEWCARD;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 从卡券进入公众号会话事件推送
 */
public abstract class UserEnterSessionMessageHandler extends WeChatEventMessageHandler<UserEnterSessionMessage> {

    public UserEnterSessionMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_USERENTERSESSION.equals(val));
    }

}
