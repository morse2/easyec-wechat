package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by 平功元 on 2016/4/25.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateMessageResult {

    @JsonProperty("msgid")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
