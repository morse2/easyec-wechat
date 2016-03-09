package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 为微信图文消息上传图片的结果的实体类
 *
 * @author JunJie
 */
public class AddArticleImageResult {

    private String url;

    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }
}
