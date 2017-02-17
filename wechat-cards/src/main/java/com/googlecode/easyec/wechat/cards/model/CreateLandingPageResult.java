package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateLandingPageResult implements Serializable {

    private static final long serialVersionUID = 8358862453041574731L;
    @JsonProperty("page_id")
    private String pageId;
    @JsonProperty("url")
    private String pageUrl;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
}
