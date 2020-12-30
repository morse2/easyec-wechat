package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.xml.annotation.XmlObjectMapping;

public class ValueLine {

    private ContextInfo contextInfo;

    public ContextInfo getContextInfo() {
        return contextInfo;
    }

    @XmlObjectMapping(name = "context_info", value = ContextInfo.class)
    public void setContextInfo(ContextInfo contextInfo) {
        this.contextInfo = contextInfo;
    }
}
