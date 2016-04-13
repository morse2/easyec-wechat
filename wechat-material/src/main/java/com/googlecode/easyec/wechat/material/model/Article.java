package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.BooleanUtils;

import static org.apache.commons.lang.BooleanUtils.toBoolean;

/**
 * 微信永久素材图文内容的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    @JsonProperty("title")
    private String title;
    @JsonProperty("thumb_media_id")
    private String thumbMediaId;
    @JsonProperty("author")
    private String author;
    @JsonProperty("digest")
    private String digest;
    private boolean showCover;
    @JsonProperty("content")
    private String content;
    @JsonProperty("content_source_url")
    private String sourceUrl;
    @JsonProperty("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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

    @JsonProperty("show_cover_pic")
    public void setShowCover(String showCover) {
        setShowCover(toBoolean(showCover, "1", "0"));
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
