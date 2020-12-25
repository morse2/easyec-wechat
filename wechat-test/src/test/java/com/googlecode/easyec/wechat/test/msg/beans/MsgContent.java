package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.xml.annotation.XmlObjectMapping;

public class MsgContent {

    private Msg msg;

    public Msg getMsg() {
        return msg;
    }

    @XmlObjectMapping(name = "Msg", value = Msg.class)
    public void setMsg(Msg msg) {
        this.msg = msg;
    }
}
