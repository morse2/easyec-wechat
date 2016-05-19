package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Created by 平功元 on 2016/4/29.
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties("credential")
public class GetTemplateListEntity extends AbstractCredentialCtrl {


    private String templateId;


    private String title;


    private String primaryIndustry;


    private String deputyIndustry;


    private String content;

    public String getTemplateId() {
        return templateId;
    }
    @JsonProperty("template_id")
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    @JsonProperty("primary_industry")
    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public String getDeputyIndustry() {
        return deputyIndustry;
    }

    @JsonProperty("deputy_industry")
    public void setDeputyIndustry(String deputyIndustry) {
        this.deputyIndustry = deputyIndustry;
    }

    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    @JsonProperty("example")
    public void setExample(String example) {
        this.example = example;
    }

    private String example;
}
