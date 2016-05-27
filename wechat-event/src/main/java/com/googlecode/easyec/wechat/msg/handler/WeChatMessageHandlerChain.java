package com.googlecode.easyec.wechat.msg.handler;

import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

/**
 * 可以处理一批的微信消息的处理链对象类
 *
 * @author JunJie
 */
public class WeChatMessageHandlerChain implements WeChatMessageHandler, InitializingBean {

    private List<WeChatMessageHandler> messageHandlers = new ArrayList<WeChatMessageHandler>();

    public void setMessageHandlers(List<WeChatMessageHandler> messageHandlers) {
        if (isNotEmpty(messageHandlers)) this.messageHandlers.addAll(messageHandlers);
    }

    public List<WeChatMessageHandler> getMessageHandlers() {
        return messageHandlers;
    }

    @Override
    public WeChatMessage process(byte[] data) throws Exception {
        for (WeChatMessageHandler messageHandler : messageHandlers) {
            WeChatMessage ret = messageHandler.process(data);
            if (ret != null) return ret;
        }

        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.isTrue(isNotEmpty(messageHandlers), "Parameter 'messageHandlers' cannot be empty.");
    }
}
