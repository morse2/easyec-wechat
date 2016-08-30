package com.googlecode.easyec.wechat.template.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.template.model.DelTemplateEntity;
import com.googlecode.easyec.wechat.template.model.TemplateMessageResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

/**
 * Created by 平功元 on 2016/4/29.
 * 删除模板处理类
 */
public class DelTemplateRequestHandler extends AbstractWeChatHttpPostRequestHandler<TemplateMessageResult, DelTemplateEntity> {
    public DelTemplateRequestHandler(StreamObjectFactory objectFactory, String baseUri, DelTemplateEntity bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected HttpEntity createPostEntity() throws Exception {
        return new ByteArrayEntity(getObjectFactory().writeValue(getBean()),
                ContentType.APPLICATION_JSON);
    }

    @Override
    protected String getBusinessUri() {
        return "/cgi-bin/template/del_private_template";
    }
}
