package com.googlecode.easyec.wechat.base.model;

/**
 * 表示微信令牌凭证的对象类
 *
 * @author JunJie
 */
public interface CredentialCtrl {

    /**
     * 返回当前微信凭证对象
     */
    WeChatCredential getCredential();

    /**
     * 设置微信凭证对象
     *
     * @param credential 凭证对象实例
     */
    void setCredential(WeChatCredential credential);
}
