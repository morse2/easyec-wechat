package com.googlecode.easyec.wechat.material.model;

/**
 * 新增微信其他类型的永久素材的实体类
 *
 * @author JunJie
 */
public class AddMaterial extends AddTempMaterial {

    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
