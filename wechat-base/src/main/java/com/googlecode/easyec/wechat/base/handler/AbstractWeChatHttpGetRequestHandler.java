package com.googlecode.easyec.wechat.base.handler;

import com.googlecode.easyec.spirit.web.utils.BeanUtils;
import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.spirit.web.webservice.handler.AbstractHttpGetRequestHandler;
import com.googlecode.easyec.spirit.web.webservice.support.HttpResponseContent;
import com.googlecode.easyec.wechat.WeChatBusinessException;
import com.googlecode.easyec.wechat.base.model.WeChatError;

import java.io.IOException;

/**
 * 基于微信HTTP GET调用方式的基础抽象类
 *
 * @author JunJie
 */
public abstract class AbstractWeChatHttpGetRequestHandler<T, B> extends AbstractHttpGetRequestHandler<T, B> {

    public AbstractWeChatHttpGetRequestHandler(StreamObjectFactory objectFactory, String baseUri, B bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected T doIn200(HttpResponseContent content) throws IOException {
        doInOtherCode(content, 200);

        Class cls = BeanUtils.findGenericType(this, 0);
        if (Void.class.isAssignableFrom(cls)) return null;

        return (T) getObjectFactory().readValue(
            content.getContent(), cls
        );
    }

    @Override
    protected void doInOtherCode(HttpResponseContent content, int code) throws IOException {
        byte[] bs = content.getContent();
        if (new String(bs).contains("errcode")) {
            WeChatError err = getObjectFactory().readValue(
                bs, WeChatError.class
            );

            if (!"0".equals(err.getCode())) {
                throw new WeChatBusinessException(err);
            }
        }
    }
}
