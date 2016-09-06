package com.googlecode.easyec.wechat.pay.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.pay.model.WeChatTransaction;
import com.googlecode.easyec.wechat.pay.model.WeChatTransactionResult;

/**
 * 微信统一下单的请求处理的实现类
 *
 * @author JunJie
 */
public class WeChatPlaceUnifiedOrderRequestHandler extends AbstractWeChatPaymentPostRequestHandler<WeChatTransactionResult, WeChatTransaction> {

    private boolean sign;

    public WeChatPlaceUnifiedOrderRequestHandler(StreamObjectFactory objectFactory, String baseUri, WeChatTransaction bean, String apiKey) {
        this(objectFactory, baseUri, bean, apiKey, true);
    }

    public WeChatPlaceUnifiedOrderRequestHandler(StreamObjectFactory objectFactory, String baseUri, WeChatTransaction bean, String apiKey, boolean sign) {
        super(objectFactory, baseUri, bean, apiKey);
        this.sign = sign;
    }

    @Override
    protected void beforePostEntity() {
        if (sign) super.beforePostEntity();
    }

    @Override
    protected String getBusinessUri() {
        return "/pay/unifiedorder";
    }
}
