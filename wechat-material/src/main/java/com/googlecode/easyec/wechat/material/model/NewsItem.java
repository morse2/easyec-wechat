package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by JunJie on 4/13/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsItem extends MaterialItem {

    private NewsContent content;

    public NewsContent getContent() {
        return content;
    }

    public void setContent(NewsContent content) {
        this.content = content;
    }
}
