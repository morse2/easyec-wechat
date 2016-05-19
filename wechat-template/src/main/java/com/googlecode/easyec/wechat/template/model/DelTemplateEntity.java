package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * Created by 平功元 on 2016/4/29.
 */
public class DelTemplateEntity extends AbstractCredentialCtrl {

    private  String templateId;
    @JsonProperty("template_id")
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
