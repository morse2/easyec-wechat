package com.googlecode.easyec.wechat.oauth2.model;

import com.googlecode.easyec.wechat.base.model.WeChatApp;

/**
 * 网页授权对象类
 *
 * @author JunJie
 */
public class WebAuthority extends WeChatApp {

    private String code;
    private String grantType;

    public WebAuthority() {
        setGrantType("authorization_code");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
