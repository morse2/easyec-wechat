package com.googlecode.easyec.wechat.jssdk.model;

import java.io.Serializable;

/**
 * JS-SDK签名算法的对象类
 *
 * @author JunJie
 */
public class JsapiSignature implements Serializable {

    private static final long serialVersionUID = 5302837505769889982L;
    private String appid;
    private String nonceStr;
    private String timestamp;
    private String signature;

    public JsapiSignature(String nonceStr, String timestamp, String signature) {
        this.nonceStr = nonceStr;
        this.timestamp = timestamp;
        this.signature = signature;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
