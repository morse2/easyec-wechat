package com.googlecode.easyec.wechat.oauth2.utils;

import com.googlecode.easyec.wechat.oauth2.model.AuthorityEntry;
import org.springframework.util.Assert;

/**
 * 微信OAuth2.0的工具类
 *
 * @author JunJie
 */
public class WeChatOAuth2Utils {

    private WeChatOAuth2Utils() { /* no op */ }

    /**
     * 构建OAuth授权入口URL
     *
     * @param entry 授权入口对象
     * @return 入口URL
     */
    public static String buildEntryUrl(AuthorityEntry entry) {
        StringBuffer url = new StringBuffer();
        Assert.notNull(entry.getScope(), "Parameter 'scope' mustn't be null.");

        url.append("https://open.weixin.qq.com/connect");
        switch (entry.getScope()) {
            case snsapi_login:
                url.append("/qrconnect");
                break;
            default:
                url.append("/oauth2/authorize");
        }

        url.append("?appid=").append(entry.getAppId());
        url.append("&redirect_uri=").append(entry.getRedirectUri());
        url.append("&response_type=").append(entry.getResponseType());
        url.append("&scope=").append(entry.getScope());
        url.append("&state=").append(entry.getState());
        url.append("#wechat_redirect");

        return url.toString();
    }
}
