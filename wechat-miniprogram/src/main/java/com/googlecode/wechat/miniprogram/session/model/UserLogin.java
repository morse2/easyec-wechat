package com.googlecode.wechat.miniprogram.session.model;

import com.googlecode.easyec.wechat.base.model.WeChatApp;

public class UserLogin extends WeChatApp {

    private String code;
    private String grantType;

    public UserLogin() {
        setGrantType("authorization_code");
    }

    public String getCode() {
        return code;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
