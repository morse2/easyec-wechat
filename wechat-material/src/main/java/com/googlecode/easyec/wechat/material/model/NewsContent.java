package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.utils.WeChatUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JunJie on 4/13/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsContent {

    private Date createTime;
    private Date updateTime;
    private List<Article> articles = new ArrayList<Article>();

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("create_time")
    public void setCreateTime(String str) {
        setCreateTime(
            WeChatUtils.parseDate(str)
        );
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @JsonProperty("update_time")
    public void setUpdateTime(String str) {
        setUpdateTime(
            WeChatUtils.parseDate(str)
        );
    }

    public List<Article> getArticles() {
        return articles;
    }

    @JsonProperty("news_item")
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
