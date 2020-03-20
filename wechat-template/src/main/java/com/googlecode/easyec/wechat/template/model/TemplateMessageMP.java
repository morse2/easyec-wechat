package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplateMessageMP {

    @JsonProperty("appid")
    private String appId;
    @JsonProperty("pagepath")
    private String pagePath;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }
}
