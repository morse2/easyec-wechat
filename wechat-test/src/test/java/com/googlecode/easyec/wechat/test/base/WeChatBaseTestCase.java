package com.googlecode.easyec.wechat.test.base;

import com.googlecode.easyec.wechat.base.handler.WeChatAccessTokenRequestHandler;
import com.googlecode.easyec.wechat.base.model.WeChatApp;
import com.googlecode.easyec.wechat.base.model.WeChatCredential;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by JunJie on 2/15/16.
 */
public class WeChatBaseTestCase extends BaseTest {

    private WeChatApp app;

    @Before
    public void beforeRun() {
        app = new WeChatApp();
        app.setAppId("wx67ebec433af5554f");
        app.setSecret("d4624c36b6795d1d99dcf0547af5443d");
    }

    @Test
    public void requestAccessToken() throws Exception {
        WeChatCredential credential = httpRequest.request(
            new WeChatAccessTokenRequestHandler(jsonObjectFactory, baseUri, app)
        );

        Assert.assertNotNull(credential);
    }
}
