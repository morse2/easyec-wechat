package com.googlecode.easyec.wechat.material.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.material.model.BatchGetMaterials;
import com.googlecode.easyec.wechat.material.model.BatchGetMaterialsResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;

import java.io.IOException;

/**
 * 获取永久素材列表的请求处理类
 *
 * @author JunJie
 */
public class BatchGetMaterialsRequestHandler extends AbstractWeChatHttpPostRequestHandler<BatchGetMaterialsResult, BatchGetMaterials> {

    public BatchGetMaterialsRequestHandler(StreamObjectFactory objectFactory, String baseUri, BatchGetMaterials bean) {
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
            ContentType.APPLICATION_JSON
        );
    }

    @Override
    protected String getBusinessUri() {
        return "/cgi-bin/material/batchget_material";
    }
}
