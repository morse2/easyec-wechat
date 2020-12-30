package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.xml.annotation.XmlObjectMapping;

public class Result {

    private ValueLine valueLine;

    public ValueLine getValueLine() {
        return valueLine;
    }

    @XmlObjectMapping(name = "ValueLine", value = ValueLine.class)
    public void setValueLine(ValueLine valueLine) {
        this.valueLine = valueLine;
    }
}
