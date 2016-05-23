package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;


/**
 * Created by 平功元 on 2016/4/25.
 */
@JsonIgnoreProperties("credential")
public class SendTemplateMessage extends AbstractCredentialCtrl {

    @JsonProperty("touser")
    private String toUser;
    @JsonProperty("template_id")
    private String templateId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("data")
    private TemplateData data;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TemplateData getData() {
        return data;
    }

    public void setData(TemplateData data) {
        this.data = data;
    }
}
