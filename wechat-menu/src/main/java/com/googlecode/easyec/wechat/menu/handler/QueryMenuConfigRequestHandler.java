package com.googlecode.easyec.wechat.menu.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.base.model.WeChatCredential;
import com.googlecode.easyec.wechat.menu.model.QueryMenuConfigResult;

import java.io.IOException;

/**
 * 微信查询自定义菜单配置信息的请求处理类
 *
 * @author JunJie
 */
public class QueryMenuConfigRequestHandler extends AbstractWeChatHttpGetRequestHandler<QueryMenuConfigResult, WeChatCredential> {

    public QueryMenuConfigRequestHandler(StreamObjectFactory objectFactory, String baseUri, WeChatCredential bean) {
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
        return "/get_current_selfmenu_info";
    }
}
