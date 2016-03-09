package com.googlecode.easyec.wechat.material.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.spirit.web.webservice.support.HttpResponseContent;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.material.model.QueryTempMaterial;
import com.googlecode.easyec.wechat.material.model.QueryTempMaterialResult;

import java.io.IOException;

/**
 * 查询微信临时素材信息的请求处理类
 *
 * @author JunJie
 */
public class QueryTempMaterialRequestHandler extends AbstractWeChatHttpGetRequestHandler<QueryTempMaterialResult, QueryTempMaterial> {

    public QueryTempMaterialRequestHandler(StreamObjectFactory objectFactory, String baseUri, QueryTempMaterial bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        return new StringBuffer()
            .append("access_token=")
            .append(getBean().getCredential().getAccessToken())
            .append("&media_id=")
            .append(getBean().getMediaId())
            .toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/media/get";
    }

    @Override
    protected QueryTempMaterialResult doIn200(HttpResponseContent content) throws IOException {
        if (content.getContentType().startsWith("text/")) {
            super.doIn200(content);
        }

        QueryTempMaterialResult result = new QueryTempMaterialResult();
        result.setContentType(content.getContentType());
        result.setData(content.getContent());

        return result;
    }
}
