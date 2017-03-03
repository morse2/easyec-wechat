package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 自定义会员信息类目，会员卡激活后显示
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class CustomCell implements Serializable {

    private static final long serialVersionUID = 6186687394542476430L;

    @JsonProperty(value = "name", required = true)
    private String name;                                    //入口名称.

    @JsonProperty(value = "tips", required = true)
    private String tips;                                    //入口右侧提示语，6个汉字内.

    @JsonProperty(value = "url", required = true)
    private String url;                                    //入口跳转链接


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
