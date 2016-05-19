package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * Created by 平功元 on 2016/4/29.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTemplateIdEntity extends AbstractCredentialCtrl {

    private String templateIdShort;

    @JsonProperty("template_id_short")
    public String getTemplateIdShort() {
        return templateIdShort;
    }

    public void setTemplateIdShort(String templateIdShort) {
        this.templateIdShort = templateIdShort;
    }
}
