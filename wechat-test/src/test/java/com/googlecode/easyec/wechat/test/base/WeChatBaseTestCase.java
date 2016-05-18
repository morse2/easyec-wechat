package com.googlecode.easyec.wechat.test.base;

import com.googlecode.easyec.wechat.base.handler.WeChatAccessTokenRequestHandler;
import com.googlecode.easyec.wechat.base.handler.WeChatGetCallbackIPRequestHandler;
import com.googlecode.easyec.wechat.base.model.WeChatApp;
import com.googlecode.easyec.wechat.base.model.WeChatCredential;
import com.googlecode.easyec.wechat.base.model.WeChatIP;
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
        app.setAppId("wx47903b80d5365301");
        app.setSecret("673fec052c52529a098619e1b754beef");
    }

    @Test
    public void requestAccessToken() throws Exception {
        WeChatCredential credential = httpRequest.request(
            new WeChatAccessTokenRequestHandler(jsonObjectFactory, baseUri, app)
        );

        Assert.assertNotNull(credential);
    }

    @Test
    public void getCallbackIPs() throws Exception {
        WeChatIP ip = httpRequest.request(
            new WeChatGetCallbackIPRequestHandler(jsonObjectFactory, baseUri,
                "acKqO5KPNvuE7YteqRFxEOh1cby2oul9UzIHB7tUooLc7r6Nz40e_DEKrPBgxk3ZCdKBlZzpE5tS-fDoUiq7fnpboOnwuwqK1-34UM1lXUgx8gXNCei0ZNfk7WMlOPG5GILgACATVY"
            )
        );

        Assert.assertNotNull(ip);
    }
}
