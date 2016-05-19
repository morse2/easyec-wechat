package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by 平功元 on 2016/5/19.
 */
public class GetTemplateListResult {

    private List<GetTemplateListEntity> getTemplateListEntityList;

    public List<GetTemplateListEntity> getGetTemplateListEntityList() {
        return getTemplateListEntityList;
    }
    @JsonProperty("template_list")
    public void setGetTemplateListEntityList(List<GetTemplateListEntity> getTemplateListEntityList) {
        this.getTemplateListEntityList = getTemplateListEntityList;
    }
}
