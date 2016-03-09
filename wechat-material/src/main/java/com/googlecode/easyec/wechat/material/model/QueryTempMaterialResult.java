package com.googlecode.easyec.wechat.material.model;

/**
 * 查询微信临时素材的结果类
 *
 * @author JunJie
 */
public class QueryTempMaterialResult {

    private String contentType;
    private byte[] data;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
