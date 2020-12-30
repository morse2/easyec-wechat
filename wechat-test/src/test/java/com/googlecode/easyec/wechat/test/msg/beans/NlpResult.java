package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.xml.annotation.XmlObjectMapping;

public class NlpResult {

    private NlpResultLine resultLine;

    public NlpResultLine getResultLine() {
        return resultLine;
    }

    @XmlObjectMapping(name = "NlpResultLine", value = NlpResultLine.class)
    public void setResultLine(NlpResultLine resultLine) {
        this.resultLine = resultLine;
    }
}
