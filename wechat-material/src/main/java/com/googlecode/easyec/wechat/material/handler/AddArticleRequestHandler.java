package com.googlecode.easyec.wechat.material.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.material.model.AddArticles;
import com.googlecode.easyec.wechat.material.model.AddArticlesResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

import java.io.IOException;

/**
 * 添加微信永久素材的请求处理类
 *
 * @author JunJie
 */
public class AddArticleRequestHandler extends AbstractWeChatHttpPostRequestHandler<AddArticlesResult, AddArticles> {

    public AddArticleRequestHandler(StreamObjectFactory objectFactory, String baseUri, AddArticles bean) {
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
        return "/material/add_news";
    }
}
