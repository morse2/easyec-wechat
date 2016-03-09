package com.googlecode.easyec.wechat.material.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.material.model.AddMaterial;
import com.googlecode.easyec.wechat.material.model.AddMaterialResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 新增微信其他类型的永久素材的请求处理类
 *
 * @author JunJie
 */
public class AddMaterialRequestHandler extends AbstractWeChatHttpPostRequestHandler<AddMaterialResult, AddMaterial> {

    public AddMaterialRequestHandler(StreamObjectFactory objectFactory, String baseUri, AddMaterial bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        return new StringBuffer()
            .append("access_token=")
            .append(getBean().getCredential().getAccessToken())
            .append("&type=")
            .append(getBean().getType())
            .toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/material/add_material";
    }

    @Override
    protected HttpEntity createPostEntity() throws Exception {
        MultipartEntity multipartEntity = new MultipartEntity();
        multipartEntity.addPart(
            new FormBodyPart("media",
                new ByteArrayBody(
                    getBean().getContent(),
                    getBean().getName()
                )
            )
        );

        switch (getBean().getType()) {
            case video:
                Map<String, Object> descriptionMap = new HashMap<String, Object>();
                descriptionMap.put("introduction", getBean().getDescription());
                descriptionMap.put("title", getBean().getTitle());

                multipartEntity.addPart(
                    new FormBodyPart(
                        "description",
                        new StringBody(
                            new String(getObjectFactory().writeValue(descriptionMap)),
                            "text/json", Charset.forName("UTF-8")
                        )
                    )
                );
        }

        return multipartEntity;
    }
}
