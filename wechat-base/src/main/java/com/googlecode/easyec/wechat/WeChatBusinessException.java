package com.googlecode.easyec.wechat;

import com.googlecode.easyec.wechat.base.model.WeChatError;

import java.io.IOException;

/**
 * 微信业务异常类
 *
 * @author JunJie
 */
public class WeChatBusinessException extends IOException {

    private static final long serialVersionUID = 1481656998815664560L;
    private WeChatError error;

    public WeChatBusinessException(WeChatError error) {
        this.error = error;
    }

    public WeChatError getError() {
        return error;
    }
}
