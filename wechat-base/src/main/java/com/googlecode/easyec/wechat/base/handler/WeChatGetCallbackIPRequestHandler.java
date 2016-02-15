package com.googlecode.easyec.wechat.base.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.model.WeChatIP;

import java.io.IOException;

/**
 * 微信回调获取服务器IP地址列表的请求处理类
 *
 * @author JunJie
 */
public class WeChatGetCallbackIPRequestHandler extends AbstractWeChatHttpGetRequestHandler<WeChatIP, String> {

    public WeChatGetCallbackIPRequestHandler(StreamObjectFactory objectFactory, String baseUri, String bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        return new StringBuffer().append("access_token=").append(getBean()).toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/getcallbackip";
    }
}
