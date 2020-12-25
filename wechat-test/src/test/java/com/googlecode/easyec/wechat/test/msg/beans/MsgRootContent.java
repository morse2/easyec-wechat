package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.msg.model.WeChatMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlObjectMapping;

public class MsgRootContent extends WeChatMessage {

    private MsgContent content;

    public MsgContent getContent() {
        return content;
    }

    @XmlObjectMapping(name = "MsgContent", value = MsgContent.class)
    public void setContent(MsgContent content) {
        this.content = content;
    }
}
