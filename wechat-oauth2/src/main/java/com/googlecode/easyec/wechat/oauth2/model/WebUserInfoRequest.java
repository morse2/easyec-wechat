package com.googlecode.easyec.wechat.oauth2.model;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 在snsapi_userinfo获取类型下的获取用户信息的模型类
 *
 * @author JunJie
 */
public class WebUserInfoRequest implements Serializable {

    private static final long serialVersionUID = 264755016825281808L;
    private WebAuthorityResult webAuthorityResult;
    private String language;

    public WebUserInfoRequest(WebAuthorityResult webAuthorityResult) {
        Assert.notNull(webAuthorityResult);
        this.webAuthorityResult = webAuthorityResult;
    }

    public String getOpenid() {
        return webAuthorityResult.getOpenId();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAccessToken() {
        return webAuthorityResult.getAccessToken();
    }
}
