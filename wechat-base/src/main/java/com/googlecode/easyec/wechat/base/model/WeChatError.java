package com.googlecode.easyec.wechat.base.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeChatError {

    @JsonProperty("errcode")
    private String code;
    @JsonProperty("errmsg")
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
