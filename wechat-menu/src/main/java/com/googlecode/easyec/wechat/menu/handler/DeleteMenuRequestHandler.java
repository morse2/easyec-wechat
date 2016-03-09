package com.googlecode.easyec.wechat.menu.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.base.model.WeChatCredential;

import java.io.IOException;

/**
 * 微信删除自定义菜单的请求处理类
 *
 * @author JunJie
 */
public class DeleteMenuRequestHandler extends AbstractWeChatHttpGetRequestHandler<Void, WeChatCredential> {

    public DeleteMenuRequestHandler(StreamObjectFactory objectFactory, String baseUri, WeChatCredential bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        return new StringBuffer()
            .append("access_token=")
            .append(getBean().getAccessToken())
            .toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/menu/delete";
    }
}
