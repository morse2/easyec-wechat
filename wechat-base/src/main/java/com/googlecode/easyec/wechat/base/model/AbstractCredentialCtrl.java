package com.googlecode.easyec.wechat.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 微信信用凭证的抽象实现类
 *
 * @author JunJie
 */
public abstract class AbstractCredentialCtrl implements CredentialCtrl {

    @JsonIgnore
    private WeChatCredential credential;

    protected AbstractCredentialCtrl() { /* no op */ }

    @Override
    public WeChatCredential getCredential() {
        return credential;
    }

    @Override
    public void setCredential(WeChatCredential credential) {
        this.credential = credential;
    }
}
