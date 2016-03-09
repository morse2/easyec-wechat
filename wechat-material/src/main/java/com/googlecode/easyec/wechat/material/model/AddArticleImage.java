package com.googlecode.easyec.wechat.material.model;

import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 添加微信中永久图文消息的图片的实体类
 *
 * @author JunJie
 */
public class AddArticleImage extends AbstractCredentialCtrl {

    private String name;
    private byte[] data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
