package com.googlecode.easyec.wechat.member.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.member.model.Member;

/**
 * Created by 平功元 on 2016/3/14.
 */
public class QueryMemberInfoRequestHandler extends AbstractWeChatHttpGetRequestHandler<Member,Member> {


    public QueryMemberInfoRequestHandler(StreamObjectFactory objectFactory, String baseUri, Member bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    public String createQueryString()  {
        StringBuffer sf = new StringBuffer();
        sf.append("access_token=").append(getBean().getCredential().getAccessToken());
        sf.append("&");
        sf.append("openid=").append(getBean().getOpenId());
        sf.append("&").append("lang=").append("zh_CN");
        return sf.toString();
    }

    @Override
    protected String getBusinessUri() {
         return "/user/info";
    }
}
