package com.googlecode.easyec.wechat.material.model;

import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 查询微信临时素材的实体类
 *
 * @author JunJie
 */
public class QueryTempMaterial extends AbstractCredentialCtrl {

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
