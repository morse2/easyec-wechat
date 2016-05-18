package com.googlecode.easyec.wechat.oauth2.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.oauth2.model.WebAuthority;
import com.googlecode.easyec.wechat.oauth2.model.WebAuthorityResult;

import java.io.IOException;

/**
 * 网页授权请求处理器类
 *
 * @author JunJie
 */
public class WebAuthorityRequestHandler extends AbstractWeChatHttpGetRequestHandler<WebAuthorityResult, WebAuthority> {

    public WebAuthorityRequestHandler(StreamObjectFactory objectFactory, String baseUri, WebAuthority bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("appid=").append(getBean().getAppId());
        sb.append("&secret=").append(getBean().getSecret());
        sb.append("&code=").append(getBean().getCode());
        sb.append("&grant_type=").append(getBean().getGrantType());

        return sb.toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/oauth2/access_token";
    }
}
