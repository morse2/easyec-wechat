package com.googlecode.easyec.wechat.cards.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.cards.model.CreateLandingPageResult;
import com.googlecode.easyec.wechat.cards.model.LandingPage;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.apache.http.entity.ContentType.create;

/**
 * 微信卡券管理中的创建货架数据的请求对象类
 *
 * @author JunJie
 */
public class CreateLandingPageRequestHandler extends AbstractWeChatHttpPostRequestHandler<CreateLandingPageResult, LandingPage> {

    public CreateLandingPageRequestHandler(StreamObjectFactory objectFactory, String baseUri, LandingPage bean) {
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
            create("text/json", Charset.forName("utf-8"))
        );
    }

    @Override
    protected String getBusinessUri() {
        return "/card/landingpage/create";
    }
}
