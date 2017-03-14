package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.cards.WeChatCardNameType;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信会员卡 自定义会员信息类目
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomField implements Serializable {

    private static final long serialVersionUID = 4722324702860362368L;
    @JsonIgnore
    private WeChatCardNameType cardNameType;              // 会员信息类目半自定义名称，当开发者变更这类类目信息的value值时可以选择触发系统模板消息通知用户
    @JsonProperty(value = "name", required = true)
    private String name;                                  // 会员信息类目自定义名称，当开发者变更这类类目信息的value值时不会触发系统模板消息通知用户

    @JsonProperty(value = "url")
    private String url;                                      //点击类目跳转外链url

    @JsonProperty("name_type")
    public String getNameType() {
        return cardNameType != null ? cardNameType.getValue() : null;
    }

    public WeChatCardNameType getCardNameType() {
        return cardNameType;
    }

    public void setCardNameType(WeChatCardNameType cardNameType) {
        this.cardNameType = cardNameType;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
