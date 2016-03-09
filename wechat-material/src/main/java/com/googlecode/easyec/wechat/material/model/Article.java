package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.BooleanUtils;

import static org.apache.commons.lang.BooleanUtils.toBoolean;

/**
 * 微信永久素材图文内容的对象类
 *
 * @author JunJie
 */
public class Article {

    private String title;
    private String thumbMediaId;
    private String author;
    private String digest;
    private boolean showCover;
    private String content;
    private String sourceUrl;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("thumb_media_id")
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("digest")
    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public boolean isShowCover() {
        return showCover;
    }

    public void setShowCover(boolean showCover) {
        this.showCover = showCover;
    }

    @JsonProperty("show_cover_pic")
    public int getShowCover() {
        return BooleanUtils.toInteger(isShowCover());
    }

    public void setShowCover(String showCover) {
        setShowCover(toBoolean(showCover, "1", "0"));
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("content_source_url")
    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
