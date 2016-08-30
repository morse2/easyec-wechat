package com.googlecode.easyec.wechat.jssdk.handler;

import com.googlecode.easyec.spirit.web.utils.WebUtils;
import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.jssdk.model.JsapiTicket;
import com.googlecode.easyec.wechat.jssdk.model.JsapiTicketRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取jsapi_ticket参数值的请求处理器类
 *
 * @author JunJie
 */
public class JsapiTicketRequestHandler extends AbstractWeChatHttpGetRequestHandler<JsapiTicket, JsapiTicketRequest> {

    public JsapiTicketRequestHandler(StreamObjectFactory objectFactory, String baseUri, JsapiTicketRequest bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        Map<String, String> qsMap = new HashMap<String, String>();
        qsMap.put("access_token", getBean().getCredential().getAccessToken());
        qsMap.put("type", getBean().getType());

        return WebUtils.encodeQueryString(qsMap);
    }

    @Override
    protected String getBusinessUri() {
        return "/cgi-bin/ticket/getticket";
    }
}
