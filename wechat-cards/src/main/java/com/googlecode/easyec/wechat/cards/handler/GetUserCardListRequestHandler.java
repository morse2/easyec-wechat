package com.googlecode.easyec.wechat.cards.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.cards.model.ConsumeCard;
import com.googlecode.easyec.wechat.cards.model.ConsumeCardResult;
import com.googlecode.easyec.wechat.cards.model.GetUserCardList;
import com.googlecode.easyec.wechat.cards.model.GetUserCardListResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 获取用户已领取的卡券的请求处理类
 */
public class GetUserCardListRequestHandler extends AbstractWeChatHttpPostRequestHandler<GetUserCardListResult, GetUserCardList> {

    public GetUserCardListRequestHandler(StreamObjectFactory objectFactory, String baseUri, GetUserCardList bean) {
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
                ContentType.create(
                        "text/json", Charset.forName("utf-8")
                )
        );
    }

    @Override
    protected String getBusinessUri() {
        return "/card/user/getcardlist";
    }
}
