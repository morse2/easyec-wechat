package com.googlecode.easyec.wechat.msg.handler;

import com.googlecode.easyec.wechat.msg.model.WeChatMessage;

/**
 * 微信的事件处理类
 *
 * @author JunJie
 */
public interface WeChatMessageHandler {

    /**
     * 处理微信推送到服务端的事件内容。
     * 该内容的格式为XML
     *
     * @param data XML数据内容
     * @return 返回的消息对象
     * @throws Exception 捕获并抛出的异常信息
     */
    WeChatMessage process(byte[] data) throws Exception;
}
