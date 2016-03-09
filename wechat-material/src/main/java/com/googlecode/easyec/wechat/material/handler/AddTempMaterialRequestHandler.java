package com.googlecode.easyec.wechat.material.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.material.model.AddTempMaterialResult;
import com.googlecode.easyec.wechat.material.model.AddTempMaterial;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;

import java.io.IOException;

/**
 * 微信添加临时素材的请求处理类
 *
 * @author JunJie
 */
public class AddTempMaterialRequestHandler extends AbstractWeChatHttpPostRequestHandler<AddTempMaterialResult, AddTempMaterial> {

    public AddTempMaterialRequestHandler(StreamObjectFactory objectFactory, String baseUri, AddTempMaterial bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    public String createQueryString() throws IOException {
        StringBuffer sf = new StringBuffer();
        sf.append("access_token=").append(
            getBean().getCredential().getAccessToken()
        );
        sf.append("&type=").append(getBean().getType());

        return sf.toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/media/upload";
    }

    @Override
    public HttpEntity createPostEntity() throws Exception {
        MultipartEntity multipartEntity = new MultipartEntity();
        multipartEntity.addPart(
            new FormBodyPart("file",
                new ByteArrayBody(
                    getBean().getContent(),
                    getBean().getName()
                )
            )
        );

        return multipartEntity;
    }
}
