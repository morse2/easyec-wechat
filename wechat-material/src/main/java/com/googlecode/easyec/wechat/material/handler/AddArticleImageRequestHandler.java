package com.googlecode.easyec.wechat.material.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.material.model.AddArticleImage;
import com.googlecode.easyec.wechat.material.model.AddArticleImageResult;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;

import java.io.IOException;

/**
 * 为微信永久图文消息添加图片的请求处理类
 *
 * @author JunJie
 */
public class AddArticleImageRequestHandler extends AbstractWeChatHttpPostRequestHandler<AddArticleImageResult, AddArticleImage> {

    public AddArticleImageRequestHandler(StreamObjectFactory objectFactory, String baseUri, AddArticleImage bean) {
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
        MultipartEntity multipartEntity = new MultipartEntity();
        multipartEntity.addPart(
            new FormBodyPart("file",
                new ByteArrayBody(
                    getBean().getData(),
                    getBean().getName()
                )
            )
        );

        return multipartEntity;
    }

    @Override
    protected String getBusinessUri() {
        return "/media/uploadimg";
    }
}
