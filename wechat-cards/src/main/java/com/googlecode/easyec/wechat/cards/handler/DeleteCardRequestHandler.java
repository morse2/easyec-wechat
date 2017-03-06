package com.googlecode.easyec.wechat.cards.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.cards.model.BaseResult;
import com.googlecode.easyec.wechat.cards.model.DeleteCard;
import com.googlecode.easyec.wechat.cards.model.DeleteCardResult;
import com.googlecode.easyec.wechat.cards.model.ModifyStock;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 卡券管理 删除卡券
 */
public class DeleteCardRequestHandler extends AbstractWeChatHttpPostRequestHandler<DeleteCardResult, DeleteCard> {

    public DeleteCardRequestHandler(StreamObjectFactory objectFactory, String baseUri, DeleteCard bean) {
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
        return "/card/delete";
    }
}
