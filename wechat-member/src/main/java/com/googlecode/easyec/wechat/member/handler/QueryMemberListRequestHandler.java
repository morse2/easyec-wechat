package com.googlecode.easyec.wechat.member.handler;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.base.handler.AbstractWeChatHttpGetRequestHandler;
import com.googlecode.easyec.wechat.member.model.MemberPageList;
import com.googlecode.easyec.wechat.member.model.QueryMemberListResult;

import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * Created by 平功元 on 2016/3/14.
 */
public class QueryMemberListRequestHandler extends AbstractWeChatHttpGetRequestHandler<QueryMemberListResult,MemberPageList> {
    public QueryMemberListRequestHandler(StreamObjectFactory objectFactory, String baseUri, MemberPageList bean) {
        super(objectFactory, baseUri, bean);
    }

    @Override
    public String createQueryString() {
        StringBuffer sf = new StringBuffer();
        sf.append("access_token=").append(getBean().getCredential().getAccessToken());

        if (isNotBlank(getBean().getNextOpenId())) {
            if (sf.length() > 0) sf.append("&");
            sf.append("next_openid=");
            sf.append(getBean().getNextOpenId());
        }

        return sf.toString();
    }
    @Override
    protected String getBusinessUri() {
        return "/user/get";
    }
}
