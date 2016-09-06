package com.googlecode.easyec.wechat.pay.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.pay.model.WeChatTransactionClose;
import com.googlecode.easyec.wechat.pay.model.WeChatTransactionCloseResult;

/**
 * 微信支付接口的关闭交易的请求处理的实现类
 *
 * @author JunJie
 */
public class WeChatCloseOrderRequestHandler extends AbstractWeChatPaymentPostRequestHandler<WeChatTransactionCloseResult, WeChatTransactionClose> {

    public WeChatCloseOrderRequestHandler(StreamObjectFactory objectFactory, String baseUri, WeChatTransactionClose bean, String apiKey) {
        super(objectFactory, baseUri, bean, apiKey);
    }

    @Override
    protected String getBusinessUri() {
        return "/pay/closeorder";
    }
}
