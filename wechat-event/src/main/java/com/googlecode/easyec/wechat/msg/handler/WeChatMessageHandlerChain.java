package com.googlecode.easyec.wechat.msg.handler;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.Charset.forName;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

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
    public byte[] process(byte[] data) throws Exception {
        for (WeChatMessageHandler messageHandler : messageHandlers) {
            byte[] ret = messageHandler.process(data);
            if (ArrayUtils.isNotEmpty(ret)) return ret;
        }

        return RETURN_SUCCESS.getBytes(forName("utf-8"));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.isTrue(isNotEmpty(messageHandlers), "Parameter 'messageHandlers' cannot be empty.");
    }
}
