package com.googlecode.easyec.wechat.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 微信图文消息的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsInfo {

    private List<News> list = new ArrayList<News>();

    public List<News> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(List<News> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            this.list.addAll(list);
        }
    }
}
