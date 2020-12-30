package com.googlecode.easyec.wechat.test.msg.beans;

import com.googlecode.easyec.wechat.xml.annotation.XmlObjectMapping;

public class NlpResultLine {

    private Result result;

    public Result getResult() {
        return result;
    }

    @XmlObjectMapping(name = "Result", value = Result.class)
    public void setResult(Result result) {
        this.result = result;
    }
}
