package com.googlecode.easyec.wechat.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 表示微信错误信息的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties("msgid")
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
