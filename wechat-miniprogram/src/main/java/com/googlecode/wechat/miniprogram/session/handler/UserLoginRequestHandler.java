package com.googlecode.wechat.miniprogram.session.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.utils.WeChatUtils;
import com.googlecode.wechat.miniprogram.session.model.UserLogin;
import com.googlecode.wechat.miniprogram.session.model.UserLoginResult;

import java.io.IOException;

/**
 * <h2>auth.code2Session</h2>
 *
 * @author junjie
 */
public class UserLoginRequestHandler extends AbstractWeChatHttpGetRequestHandler<UserLoginResult, UserLogin> {

    public UserLoginRequestHandler(StreamObjectFactory objectFactory, UserLogin bean) {
        super(objectFactory, WeChatUtils.getBaseUri(), bean);
    }

    @Override
    protected String createQueryString() throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("appid=").append(getBean().getAppId());
        sb.append("&secret=").append(getBean().getSecret());
        sb.append("&js_code=").append(getBean().getJsCode());
        sb.append("&grant_type=").append(getBean().getGrantType());

        return sb.toString();
    }

    @Override
    protected String getBusinessUri() {
        return "/sns/jscode2session";
    }
}
