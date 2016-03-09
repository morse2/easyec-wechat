package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 新增微信永久图文素材的结果类
 *
 * @author JunJie
 */
public class AddArticlesResult {

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    @JsonProperty("media_id")
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
