package com.googlecode.easyec.wechat.test.jssdk;

import com.googlecode.easyec.wechat.jssdk.controller.JsapiTicketRequestController;
import com.googlecode.easyec.wechat.jssdk.handler.JsapiTicketRequestHandler;
import com.googlecode.easyec.wechat.jssdk.model.JsapiSignature;
import com.googlecode.easyec.wechat.jssdk.model.JsapiTicket;
import com.googlecode.easyec.wechat.jssdk.model.JsapiTicketRequest;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by JunJie on 8/30/16.
 */
public class JssdkTestCase extends BaseTest {

    @Test
    public void sign() throws Exception {
        JsapiTicketRequest req = new JsapiTicketRequest();
        req.setCredential(getCredential());

        JsapiTicket ticket = httpRequest.request(
            new JsapiTicketRequestHandler(jsonObjectFactory, baseUri, req)
        );

        Assert.assertNotNull(ticket);

        JsapiSignature sign = new JsapiTicketRequestController().sign(ticket, "http://mp.weixin.qq.com?params=value#wechat_sns");
        Assert.assertNotNull(sign.getSignature());
    }
}
