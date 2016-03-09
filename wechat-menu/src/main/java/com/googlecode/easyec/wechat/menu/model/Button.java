package com.googlecode.easyec.wechat.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.menu.enums.ButtonTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.googlecode.easyec.wechat.utils.WeChatUtils.parseJsonArray;

/**
 * 微信自定义菜单按钮的实体类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Button {

    private ButtonTypes type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("key")
    private String key;
    @JsonProperty("url")
    private String url;
    @JsonProperty("value")
    private String value;
    @JsonProperty("news_info")
    private NewsInfo newsInfo;

    private List<Button> subButtons = new ArrayList<Button>();

    @JsonProperty("type")
    public ButtonTypes getType() {
        return type;
    }

    public void setType(ButtonTypes type) {
        this.type = type;
    }

    @JsonProperty("type")
    public void setType(String typeStr) {
        try {
            setType(ButtonTypes.valueOf(typeStr));
        } catch (IllegalArgumentException e) {
            // no op
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Button> getSubButtons() {
        return subButtons;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("sub_button")
    public void setSubButtons(Object subButtons) {
        if (subButtons instanceof Map) {
            Object list = ((Map) subButtons).get("list");
            if (list instanceof List) {
                this.subButtons.addAll(
                    parseJsonArray((List) list, Button.class)
                );
            }
        } else if (subButtons instanceof List) {
            this.subButtons.addAll(
                ((List) subButtons)
            );
        }
    }

    public void addSubButton(Button button) {
        if (button != null) this.subButtons.add(button);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NewsInfo getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(NewsInfo newsInfo) {
        this.newsInfo = newsInfo;
    }
}
