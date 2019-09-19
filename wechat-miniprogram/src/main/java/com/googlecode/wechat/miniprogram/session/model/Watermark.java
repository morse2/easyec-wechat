package com.googlecode.wechat.miniprogram.session.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Watermark implements Serializable {

    private static final long serialVersionUID = 5537503626464865373L;
    private String appId;
    private String timestamp;

    public String getAppId() {
        return appId;
    }

    @JsonProperty("appid")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
