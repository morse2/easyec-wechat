package com.googlecode.easyec.wechat.base.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.spirit.web.webservice.handler.AbstractHttpPostRequestHandler;
import com.googlecode.easyec.spirit.web.webservice.support.HttpResponseContent;
import com.googlecode.easyec.wechat.WeChatBusinessException;
import com.googlecode.easyec.wechat.base.model.WeChatError;

import java.io.IOException;

/**
 * 基于微信HTTP POST调用方式的基础抽象类
 *
 * @author JunJie
 */
public abstract class AbstractWeChatHttpPostRequestHandler<T, B> extends AbstractHttpPostRequestHandler<T, B> {

    public AbstractWeChatHttpPostRequestHandler(StreamObjectFactory objectFactory, String baseUri, B bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected T doIn200(HttpResponseContent content) throws IOException {
        T ret = super.doIn200(content);
        if (ret == null) {
            doInOtherCode(content, 200);
        }

        return ret;
    }

    @Override
    protected void doInOtherCode(HttpResponseContent content, int code) throws IOException {
        byte[] bs = content.getContent();
        if (new String(bs).contains("errcode")) {
            throw new WeChatBusinessException(
                getObjectFactory().readValue(bs, WeChatError.class)
            );
        }
    }
}
