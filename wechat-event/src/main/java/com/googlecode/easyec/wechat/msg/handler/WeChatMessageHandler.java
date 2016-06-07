package com.googlecode.easyec.wechat.msg.handler;

/**
 * 微信的事件处理类
 *
 * @author JunJie
 */
public interface WeChatMessageHandler {

    /**
     * 返回给微信的成功消息
     */
    String RETURN_SUCCESS = "success";

    /**
     * 处理微信推送到服务端的事件内容。
     * 该内容的格式为XML
     *
     * @param data XML数据内容
     * @return 返回到微信服务器的数据内容
     * @throws Exception 捕获并抛出的异常信息
     */
    byte[] process(byte[] data) throws Exception;
}
