package com.googlecode.easyec.wechat.template.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.template.model.GetTemplateListEntity;
import com.googlecode.easyec.wechat.template.model.GetTemplateListResult;

/**
 * Created by 平功元 on 2016/4/29.
 * 获取模板列表
 */
public class GetTemplateListRequestHandler extends AbstractWeChatHttpGetRequestHandler<GetTemplateListResult, GetTemplateListEntity> {
    public GetTemplateListRequestHandler(StreamObjectFactory objectFactory, String baseUri, GetTemplateListEntity bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() {
        return new StringBuffer().append("access_token=")
                .append(getBean().getCredential().getAccessToken())
                .toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/template/get_all_private_template";
    }
}
