package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by 平功元 on 2016/4/29.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTemplateIdResult extends TemplateMessageResult {

    @JsonProperty("template_id")
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

}
