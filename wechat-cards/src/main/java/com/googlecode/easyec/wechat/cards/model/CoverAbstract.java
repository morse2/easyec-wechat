package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 卡券高级封面摘要的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoverAbstract implements Serializable {

    private static final long serialVersionUID = -343270674557564675L;
    @JsonProperty("abstract")
    private String summary;                                           // 封面摘要简介
    @JsonProperty("icon_url_list")
    private List<String> iconUrlList = new ArrayList<String>();       // 封面图片列表，仅支持填入一个封面图片链接

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getIconUrlList() {
        return iconUrlList;
    }

    public void setIconUrlList(List<String> iconUrlList) {
        if (CollectionUtils.isNotEmpty(iconUrlList)) {
            this.iconUrlList.addAll(iconUrlList);
        }
    }

    public void addIconUrl(String iconUrl) {
        if (StringUtils.isNotBlank(iconUrl)) {
            this.iconUrlList.add(iconUrl);
        }
    }
}
