package com.googlecode.easyec.wechat.base.model;

/**
 * 表示微信应用信息的对象类
 *
 * @author JunJie
 */
public class WeChatApp {

    private String appId;
    private String secret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
