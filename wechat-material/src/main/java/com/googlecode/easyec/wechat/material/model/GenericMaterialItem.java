package com.googlecode.easyec.wechat.material.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by JunJie on 4/13/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericMaterialItem extends MaterialItem {

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
