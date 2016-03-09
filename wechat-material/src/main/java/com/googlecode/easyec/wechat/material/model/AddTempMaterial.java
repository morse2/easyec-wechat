package com.googlecode.easyec.wechat.material.model;

import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import com.googlecode.easyec.wechat.material.enums.MaterialTypes;

/**
 * 新增微信临时素材的实体类
 *
 * @author JunJie
 */
public class AddTempMaterial extends AbstractCredentialCtrl {

    private MaterialTypes type;
    private String mimeType;
    private String name;
    private byte[] content;

    public MaterialTypes getType() {
        return type;
    }

    public void setType(MaterialTypes type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
