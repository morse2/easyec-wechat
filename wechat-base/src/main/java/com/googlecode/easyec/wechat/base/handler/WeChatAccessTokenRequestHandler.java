package com.googlecode.easyec.wechat.base.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.model.WeChatApp;
import com.googlecode.easyec.wechat.base.model.WeChatCredential;

/**
 * 微信获取Access Token的请求处理类
 *
 * @author JunJie
 */
public class WeChatAccessTokenRequestHandler extends AbstractWeChatHttpGetRequestHandler<WeChatCredential, WeChatApp> {

    public WeChatAccessTokenRequestHandler(StreamObjectFactory objectFactory, String baseUri, WeChatApp bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    public String createQueryString() {
        return new StringBuffer()
            .append("grant_type=client_credential")
            .append("&appid=")
            .append(getBean().getAppId())
            .append("&secret=")
            .append(getBean().getSecret())
            .toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/token";
    }
}
