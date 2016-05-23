package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

import java.util.HashMap;
import java.util.Map;


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
    private Map<String, TemplateData> values = new HashMap<String, TemplateData>();

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

    public void addValue(String key, String value) {
        values.put(key, create(value));
    }

    public void addValue(String key, String value, String color) {
        values.put(key, create(value, color));
    }

    /**
     * 创建一个模板数据对象
     *
     * @param value 参数值
     * @return 模板数据对象实例
     */
    protected TemplateData create(String value) {
        return new TemplateData(value);
    }

    /**
     * 创建一个模板数据对象
     *
     * @param value 参数值
     * @param color 参数值的颜色
     * @return 模板数据对象实例
     */
    protected TemplateData create(String value, String color) {
        return new TemplateData(value, color);
    }
}
