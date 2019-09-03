package com.googlecode.wechat.miniprogram.session.model;

import com.googlecode.easyec.wechat.base.model.WeChatApp;

public class UserLogin extends WeChatApp {

    private String jsCode;
    private String grantType;

    public UserLogin() {
        setGrantType("authorization_code");
    }

    public String getJsCode() {
        return jsCode;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
