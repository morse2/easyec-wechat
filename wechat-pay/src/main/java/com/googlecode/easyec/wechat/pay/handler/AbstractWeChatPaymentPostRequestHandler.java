package com.googlecode.easyec.wechat.pay.handler;

import com.googlecode.easyec.spirit.web.utils.BeanUtils;
import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.spirit.web.webservice.support.HttpResponseContent;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpPostRequestHandler;
import com.googlecode.easyec.wechat.pay.model.BaseWeChatTransaction;
import com.googlecode.easyec.wechat.pay.model.BaseWeChatTransactionResult;
import com.googlecode.easyec.wechat.pay.utils.TransactionUtils;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_XML;

/**
 * 微信支付 POST方式请求处理的基类
 *
 * @author JunJie
 */
public abstract class AbstractWeChatPaymentPostRequestHandler<T extends BaseWeChatTransactionResult, B extends BaseWeChatTransaction> extends AbstractWeChatHttpPostRequestHandler<T, B> {

    private String apiKey;

    public AbstractWeChatPaymentPostRequestHandler(StreamObjectFactory objectFactory, String baseUri, B bean, String apiKey) {
        super(objectFactory, baseUri, bean);
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    @Override
    protected HttpEntity createPostEntity() throws Exception {
        beforePostEntity();

        WeChatXmlData reqXml = new WeChatXmlData();
        reqXml.merge(getBean());

        byte[] bs = getObjectFactory().writeValue(reqXml);
        ByteArrayEntity entity = new ByteArrayEntity(bs, 0, bs.length, APPLICATION_XML);
        entity.setContentEncoding("UTF-8");

        return entity;
    }

    @Override
    protected T doIn200(HttpResponseContent content) throws IOException {
        Class<?> cls = BeanUtils.findGenericType(this, 0);
        if (Void.class.isAssignableFrom(cls)) return null;

        WeChatXmlData xml = getObjectFactory().readValue(
            content.getContent(),
            WeChatXmlData.class
        );

        //noinspection unchecked
        return xml != null ? (T) xml.resolve(cls) : null;
    }

    /**
     * 在{@link #createPostEntity()}之前调用的方法
     */
    protected void beforePostEntity() {
        TransactionUtils.sign(getBean(), getApiKey());
    }
}
