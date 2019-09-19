package com.googlecode.easyec.wechat.oauth2.handler;

import com.googlecode.easyec.spirit.web.utils.WebUtils;
import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.oauth2.model.WebUserInfo;
import com.googlecode.easyec.wechat.oauth2.model.WebUserInfoRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取Web OAuth认证后调用用户信息的HTTP请求的处理类
 *
 * @author JunJie
 */
public class WebGetUserInfoRequestHandler extends AbstractWeChatHttpGetRequestHandler<WebUserInfo, WebUserInfoRequest> {

    public WebGetUserInfoRequestHandler(StreamObjectFactory objectFactory, String baseUri, WebUserInfoRequest bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        Map<String, String[]> qsMap = new HashMap<>();
        qsMap.put("access_token", new String[] { getBean().getAccessToken() });
        qsMap.put("openid", new String[] { getBean().getOpenid() });
        qsMap.put("lang", new String[] { getBean().getLanguage() });

        return WebUtils.encodeQueryString(qsMap);
    }

    @Override
    protected String getBusinessUri() {
        return "/sns/userinfo";
    }
}
