package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

public class Msg {

    private String content;
    private String type;

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    @XmlElementMapping(name = "Content")
    public void setContent(String content) {
        this.content = content;
    }

    @XmlElementMapping(name = "Type")
    public void setType(String type) {
        this.type = type;
    }
}
