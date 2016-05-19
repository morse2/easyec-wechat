package com.googlecode.easyec.wechat.template.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.template.model.GetTemplateIdEntity;
import com.googlecode.easyec.wechat.template.model.GetTemplateIdResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

/**
 * Created by 平功元 on 2016/4/29.
 * 获取模板ID处理类
 */
public class GetTemplateIdRequestHandler extends AbstractWeChatHttpPostRequestHandler<GetTemplateIdResult, GetTemplateIdEntity> {
    public GetTemplateIdRequestHandler(StreamObjectFactory objectFactory, String baseUri, GetTemplateIdEntity bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected HttpEntity createPostEntity() throws Exception {
        return new ByteArrayEntity(getObjectFactory().writeValue(getBean()),
                ContentType.APPLICATION_JSON);
    }

    @Override
    protected String getBusinessUri() {
        return "/template/api_add_template";
    }
}
