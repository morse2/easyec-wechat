package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties("credential")
public class SendTemplateMessage extends AbstractCredentialCtrl {

    @JsonProperty("touser")
    private String toUser;
    @JsonProperty("template_id")
    private String templateId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("data")
    private Map<String, TemplateData> values = new HashMap<>();
    @JsonProperty("miniprogram")
    private TemplateMessageMP miniprogram;

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

    public TemplateMessageMP getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(String appId, String pagePath) {
        Assert.notNull(appId, "Miniprogram appid is null.");
        Assert.notNull(pagePath, "Miniprogram page path is null.");

        this.miniprogram = new TemplateMessageMP();
        this.miniprogram.setPagePath(pagePath);
        this.miniprogram.setAppId(appId);
    }

    /**
     * 添加一个模板参数的值
     *
     * @param key   参数键
     * @param value 参数值
     */
    public void addValue(String key, String value) {
        values.put(key, create(value));
    }

    /**
     * 添加一个模板参数的值
     *
     * @param key   参数键
     * @param value 参数值
     * @param color 参数值的颜色
     */
    public void addValue(String key, String value, String color) {
        values.put(key, create(value, color));
    }

    /**
     * 判断模板参数是否已经存在
     *
     * @param key 参数键
     * @return 存在返回TRUE, 否则返回FALSE
     */
    public boolean hasValue(String key) {
        return values.containsKey(key);
    }

    /**
     * 删除模板的参数
     *
     * @param key 参数键
     */
    public void removeValue(String key) {
        values.remove(key);
    }

    /**
     * 获取模板参数数据的对象
     *
     * @param key 参数键
     * @return 模板数据对象
     */
    public TemplateData getValue(String key) {
        return values.get(key);
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
