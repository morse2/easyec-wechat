package com.googlecode.easyec.wechat.oauth2.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * OAuth授权入口对象类
 *
 * @author JunJie
 */
public class AuthorityEntry {

    public enum Scope {
        /**
         * 静默授权,不弹出授权页面
         */
        snsapi_base,
        /**
         * 显示授权,弹出授权页面
         */
        snsapi_userinfo,
        /**
         * 网页授权
         */
        snsapi_login
    }

    public AuthorityEntry() {
        this.responseType = "code";
    }

    private String appId;
    private String redirectUri;
    private String responseType;
    private Scope scope;
    private String state;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        try {
            this.redirectUri = URLEncoder.encode(redirectUri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // ignore
        }
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
