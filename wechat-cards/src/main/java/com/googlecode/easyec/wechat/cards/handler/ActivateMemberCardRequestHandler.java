package com.googlecode.easyec.wechat.cards.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.cards.model.ActivateMemberCard;
import com.googlecode.easyec.wechat.cards.model.ActivateMemberCodeResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 激活微信会员卡请求处理类
 *
 * @author JunJie
 */
public class ActivateMemberCardRequestHandler extends AbstractWeChatHttpPostRequestHandler<ActivateMemberCodeResult, ActivateMemberCard> {

    public ActivateMemberCardRequestHandler(StreamObjectFactory objectFactory, String baseUri, ActivateMemberCard bean) {
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
        return "/card/membercard/activate";
    }
}
