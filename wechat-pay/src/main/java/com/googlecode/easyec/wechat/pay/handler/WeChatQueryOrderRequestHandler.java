package com.googlecode.easyec.wechat.pay.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.pay.model.WeChatTransactionQuery;
import com.googlecode.easyec.wechat.pay.model.WeChatTransactionQueryResult;

/**
 * 微信查询订单的请求处理的实现类
 *
 * @author JunJie
 */
public class WeChatQueryOrderRequestHandler extends AbstractWeChatPaymentPostRequestHandler<WeChatTransactionQueryResult, WeChatTransactionQuery> {

    public WeChatQueryOrderRequestHandler(StreamObjectFactory objectFactory, String baseUri, WeChatTransactionQuery bean, String apiKey) {
        super(objectFactory, baseUri, bean, apiKey);
    }

    @Override
    protected String getBusinessUri() {
        return "/pay/orderquery";
    }
}
