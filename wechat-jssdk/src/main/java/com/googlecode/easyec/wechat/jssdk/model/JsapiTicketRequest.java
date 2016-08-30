package com.googlecode.easyec.wechat.jssdk.model;

import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * jsapi_ticket请求获取的对象类
 *
 * @author JunJie
 */
public class JsapiTicketRequest extends AbstractCredentialCtrl {

    public String getType() {
        return "jsapi";
    }
}
