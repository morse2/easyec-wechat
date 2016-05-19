package com.googlecode.easyec.wechat.template.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.template.model.SetIndustryEntity;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

/**
 * Created by 平功元 on 2016/4/25.
 */
public class SetIndustryRequestHandler extends AbstractWeChatHttpPostRequestHandler<Void, SetIndustryEntity> {
    public SetIndustryRequestHandler(StreamObjectFactory objectFactory, String baseUri, SetIndustryEntity bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() {
        return new StringBuffer()
                .append("access_token=")
                .append(getBean().getCredential()).toString();
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
        return "/template/api_set_industry";
    }
}
