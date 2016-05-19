package com.googlecode.easyec.wechat.test.member;

import com.googlecode.easyec.wechat.member.handler.QueryMemberInfoRequestHandler;
import com.googlecode.easyec.wechat.member.handler.QueryMemberListRequestHandler;
import com.googlecode.easyec.wechat.member.model.Member;
import com.googlecode.easyec.wechat.member.model.MemberPageList;
import com.googlecode.easyec.wechat.member.model.QueryMemberListResult;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by 平功元 on 2016/3/9.
 */
public class WeChatMemberTest extends BaseTest {

    @Test
    public void queryMemberInfo() throws Exception {
       Member member = new Member();
        member.setOpenId("osxcMxJyF-S481H4XYGp4EWAIvLQ");
        member.setCredential(getCredential());
        Member result = handleRequest(
                new QueryMemberInfoRequestHandler(jsonObjectFactory, baseUri, member)
        );
        Assert.assertNotNull(result);
    }

    @Test
    public void queryMemberList() throws Exception {
        MemberPageList memberPageList = new MemberPageList();
        //memberPageList.setNextOpenId("osxcMxJyF-S481H4XYGp4EWAIvLQ");
        memberPageList.setCredential(getCredential());
        QueryMemberListResult result = handleRequest(
                new QueryMemberListRequestHandler(jsonObjectFactory,baseUri,memberPageList)
        );
        Assert.assertNotNull(result);
    }
}
