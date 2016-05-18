package com.googlecode.easyec.wechat.test.oauth2;

import com.googlecode.easyec.wechat.oauth2.handler.WebAuthorityRequestHandler;
import com.googlecode.easyec.wechat.oauth2.model.AuthorityEntry;
import com.googlecode.easyec.wechat.oauth2.model.WebAuthority;
import com.googlecode.easyec.wechat.oauth2.model.WebAuthorityResult;
import com.googlecode.easyec.wechat.oauth2.utils.WeChatOAuth2Utils;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import static com.googlecode.easyec.wechat.oauth2.model.AuthorityEntry.Scope.snsapi_userinfo;

/**
 * Created by JunJie on 4/27/16.
 */
public class WeChatOAuthTestCase extends BaseTest {

    @Value("#{p_env['wechat.api.oauthUri']}")
    private String oauthUri;

    @Test
    public void buildAuthorityEntryUrl() {
        AuthorityEntry entry = new AuthorityEntry();
        entry.setAppId("wx67ebec433af5554f");
        entry.setRedirectUri("http://www.baidu.com");
        entry.setScope(snsapi_userinfo);
        entry.setState(String.valueOf(System.currentTimeMillis()));

        String url = WeChatOAuth2Utils.buildEntryUrl(entry);
        Assert.assertNotNull(url);
    }

    @Test
    public void requestWebAuthority() throws Exception {
        WebAuthority wa = new WebAuthority();
        wa.setAppId("wx67ebec433af5554f");
        wa.setSecret("d4624c36b6795d1d99dcf0547af5443d");
        wa.setCode("XXX");

        WebAuthorityResult result = handleRequest(
            new WebAuthorityRequestHandler(jsonObjectFactory, oauthUri, wa)
        );

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getOpenId());
    }
}
