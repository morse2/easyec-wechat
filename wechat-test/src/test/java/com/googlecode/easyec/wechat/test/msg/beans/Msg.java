package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.xml.annotation.XmlObjectMapping;

public class Msg {

    private NlpResult result;
    private String content;
    private String type;

    public NlpResult getResult() {
        return result;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    @XmlObjectMapping(name = "NlpResult", value = NlpResult.class)
    public void setResult(NlpResult result) {
        this.result = result;
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
