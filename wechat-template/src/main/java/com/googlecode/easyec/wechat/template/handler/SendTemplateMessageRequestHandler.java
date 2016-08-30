package com.googlecode.easyec.wechat.template.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.template.model.SendTemplateMessage;
import com.googlecode.easyec.wechat.template.model.TemplateMessageResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

/**
 * Created by 平功元 on 2016/4/25.
 */
public class SendTemplateMessageRequestHandler extends AbstractWeChatHttpPostRequestHandler<TemplateMessageResult, SendTemplateMessage> {
    public SendTemplateMessageRequestHandler(StreamObjectFactory objectFactory, String baseUri, SendTemplateMessage bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() {
        return new StringBuffer()
                .append("access_token=")
                .append(getBean().getCredential().getAccessToken()).toString();

    }


    @Override
    protected HttpEntity createPostEntity() throws Exception {
        return new ByteArrayEntity(
                getObjectFactory().writeValue(getBean()),
                ContentType.APPLICATION_JSON
        );
    }

    @Override
    protected String getBusinessUri() {
        return "/cgi-bin/message/template/send";
    }
}
