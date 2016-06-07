package com.googlecode.easyec.wechat.msg.model.impl;

import com.googlecode.easyec.wechat.msg.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.msg.model.WeChatMessage;

/**
 * 微信纯文本消息对象类
 *
 * @author JunJie
 */
public class WeChatTextMessage extends WeChatMessage {

    private String msgId;
    private String content;

    public WeChatTextMessage() {
        setMsgType("text");
    }

    public String getMsgId() {
        return msgId;
    }

    @XmlElementMapping(name = "MsgId")
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @XmlElementMapping(name = "Content")
    public String getContent() {
        return content;
    }

    @XmlElementMapping(name = "Content")
    public void setContent(String content) {
        this.content = content;
    }
}
