package com.googlecode.easyec.wechat.menu.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.menu.model.Menu;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

import java.io.IOException;

/**
 * 微信添加自定义菜单的请求处理类
 *
 * @author JunJie
 */
public class AddMenuRequestHandler extends AbstractWeChatHttpPostRequestHandler<Void, Menu> {

    public AddMenuRequestHandler(StreamObjectFactory objectFactory, String baseUri, Menu bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        return new StringBuffer()
            .append("access_token=")
            .append(getBean().getCredential().getAccessToken())
            .toString();
    }

    @Override
    protected HttpEntity createPostEntity() throws Exception {
        return new ByteArrayEntity(
            getObjectFactory().writeValue(getBean()),
            ContentType.create("text/json", "UTF-8")
        );
    }

    @Override
    protected String getBusinessUri() {
        return "/menu/create";
    }
}
