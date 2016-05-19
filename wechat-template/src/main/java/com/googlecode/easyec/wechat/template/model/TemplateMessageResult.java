package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by 平功元 on 2016/4/25.
 */
public class TemplateMessageResult {

    @JsonProperty("errcode")
    private String errcode;
    @JsonProperty("errmsg")
    private String errmsg;
    @JsonProperty("msgid")
    private String msgid;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
}
