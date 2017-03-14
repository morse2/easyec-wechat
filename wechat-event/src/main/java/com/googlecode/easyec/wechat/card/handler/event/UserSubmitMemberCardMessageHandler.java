package com.googlecode.easyec.wechat.card.handler.event;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.card.model.event.UserPayMessage;
import com.googlecode.easyec.wechat.card.model.event.UserSubmitMemberCardMessage;
import com.googlecode.easyec.wechat.msg.handler.event.WeChatEventMessageHandler;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;

import static com.googlecode.easyec.wechat.card.model.event.UserPayMessage.EVENT_USERPAY;
import static com.googlecode.easyec.wechat.card.model.event.UserSubmitMemberCardMessage.EVENT_SUBMITCARD;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 当用户通过一键激活的方式提交信息并点击激活或者用户修改会员卡信息后，商户会收到用户激活的事件推送 处理类
 */
public abstract class UserSubmitMemberCardMessageHandler extends WeChatEventMessageHandler<UserSubmitMemberCardMessage> {

    public UserSubmitMemberCardMessageHandler(StreamObjectFactory streamObjectFactory) {
        super(streamObjectFactory);
    }

    @Override
    protected boolean accept(WeChatMessage obj) {
        boolean accept = super.accept(obj);
        if (!accept) return false;

        String val = ((WeChatEventMessage) obj).getEvent();

        return isNotBlank(val)
            && (EVENT_SUBMITCARD.equals(val));
    }

}
