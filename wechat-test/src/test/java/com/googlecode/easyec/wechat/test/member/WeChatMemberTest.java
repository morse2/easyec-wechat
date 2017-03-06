package com.googlecode.easyec.wechat.test.member;

import com.googlecode.easyec.wechat.cards.WeChatCardCodeType;
import com.googlecode.easyec.wechat.cards.handler.CreateWeChatCardRequestHandler;
import com.googlecode.easyec.wechat.cards.model.*;
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
            new QueryMemberListRequestHandler(jsonObjectFactory, baseUri, memberPageList)
        );
        Assert.assertNotNull(result);
    }


    @Test
    public void createMember() throws Exception {
        WeChatMemberCard memberCard = new WeChatMemberCard();

        WeChatMemberCardBaseInfo baseInfo = (WeChatMemberCardBaseInfo) memberCard.getCardInfo().getBaseInfo();
        baseInfo.setLogoUrl("http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZJkmG8xXhiaHqkKSVMMWeN3hLut7X7hicFNjakmxibMLGWpXrEXB33367o7zHN0CwngnQY7zb7g/0");
        baseInfo.setBrandName("商户名字");
        baseInfo.setCardCodeType(WeChatCardCodeType.Text);
        baseInfo.setTitle("卡券名123");
        baseInfo.setColor("Color010");
        baseInfo.setNotice("注意提示");
        baseInfo.setServicePhone("020-88888888");
        baseInfo.setDescription("不可与其他优惠共同享受");
        CardSku cardSku = new CardSku();
        cardSku.setQuantity(50000000);
        baseInfo.setSku(cardSku);
        baseInfo.setGetLimit(3);
        MemberCardDateInfo m = new MemberCardDateInfo();
        m.setDateType(MemberCardDateInfo.DateType.Permanent);
        baseInfo.setDateInfo(m);
        baseInfo.setUseCustomCode(true);
        baseInfo.setCanGiveFriend(true);
        baseInfo.setUseAllLocations(true);
        baseInfo.setCustomUrlName("立即试用");
        baseInfo.setCustomUrl("http://weixin.qq.com");
        baseInfo.setCustomUrlSubTitle("6个汉字tips");
        baseInfo.setPromotionUrlName("营销入口1");
        baseInfo.setPromotionUrl("http://www.qq.com");
        baseInfo.setNeedPushOnView(true);

        //member card
        memberCard.setBackgroundPicUrl("https://mmbiz.qlogo.cn/mmbiz/");
        memberCard.setPrerogative("test_prerogative");
        memberCard.setAutoActive(true);
        memberCard.setSupplyBonus(true);
        memberCard.setSupplyBalance(false);
        memberCard.setActivateUrl("http://www.qq.com");
        memberCard.setDiscount(10);

        CreateWeChatCard card = new CreateWeChatCard(memberCard);
        card.setCredential(getCredential());

        CreateWeChatCardResult result = handleRequest(
            new CreateWeChatCardRequestHandler(jsonObjectFactory, baseUri, card)
        );

        Assert.assertNotNull(result);
    }

    @Test
    public void getUserCardList() throws Exception {
        GetUserCardList list = new GetUserCardList();
        list.setCredential(getCredential());
        list.setCardId("12312313");
        list.setOpenId("Xxxxxxxxx");

        GetUserCardListResult result = handleRequest(new GetUserCardListRequestHandler(jsonObjectFactory, baseUri, list));
        Assert.assertNotNull(result);
    }

}
