package com.googlecode.easyec.wechat.cards.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.cards.model.CheckCode;
import com.googlecode.easyec.wechat.cards.model.CheckCodeResult;
import com.googlecode.easyec.wechat.cards.model.QueryCode;
import com.googlecode.easyec.wechat.cards.model.QueryCodeResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 核销卡券 查询卡券是否可使用的请求处理类
 */
public class QueryCodeRequestHandler extends AbstractWeChatHttpPostRequestHandler<QueryCodeResult, QueryCode> {

    public QueryCodeRequestHandler(StreamObjectFactory objectFactory, String baseUri, QueryCode bean) {
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
            ContentType.create("text/json", Charset.forName("utf-8"))
        );
    }

    @Override
    protected String getBusinessUri() {
        return "/card/code/get";
    }
}
