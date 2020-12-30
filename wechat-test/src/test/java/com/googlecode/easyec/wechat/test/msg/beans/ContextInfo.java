package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

import java.util.List;

public class ContextInfo {

    private List<String> context;

    public List<String> getContext() {
        return context;
    }

    @XmlElementMapping(name = "context")
    public void setContext(List<String> context) {
        this.context = context;
    }
}
