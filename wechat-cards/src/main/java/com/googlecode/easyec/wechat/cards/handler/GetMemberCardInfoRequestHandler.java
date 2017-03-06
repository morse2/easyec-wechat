package com.googlecode.easyec.wechat.cards.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.cards.model.GetFreeCardInfo;
import com.googlecode.easyec.wechat.cards.model.GetFreeCardInfoResult;
import com.googlecode.easyec.wechat.cards.model.GetMemberCardInfo;
import com.googlecode.easyec.wechat.cards.model.GetMemberCardInfoResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 拉取会员卡数据接口
 */
public class GetMemberCardInfoRequestHandler extends AbstractWeChatHttpPostRequestHandler<GetMemberCardInfoResult, GetMemberCardInfo> {

    public GetMemberCardInfoRequestHandler(StreamObjectFactory objectFactory, String baseUri, GetMemberCardInfo bean) {
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
        return "/datacube/getcardmembercardinfo";
    }
}
