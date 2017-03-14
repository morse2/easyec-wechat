package com.googlecode.easyec.wechat.test.member;

import com.googlecode.easyec.wechat.cards.WeChatCardCodeType;
import com.googlecode.easyec.wechat.cards.WeChatCardNameType;
import com.googlecode.easyec.wechat.cards.handler.*;
import com.googlecode.easyec.wechat.cards.model.*;
import com.googlecode.easyec.wechat.member.handler.QueryMemberInfoRequestHandler;
import com.googlecode.easyec.wechat.member.handler.QueryMemberListRequestHandler;
import com.googlecode.easyec.wechat.member.model.Member;
import com.googlecode.easyec.wechat.member.model.MemberPageList;
import com.googlecode.easyec.wechat.member.model.QueryMemberListResult;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    @Rollback(false)
    public void createMember() throws Exception {
        WeChatMemberCard memberCard = new WeChatMemberCard();

        WeChatCardAdvancedInfo advancedInfo = memberCard.getCardInfo().getAdvancedInfo();
        ImageText imageText = new ImageText();
        imageText.setImageUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibRSxuZhkBkjgL680dvqaV3Hibdibyop0rQFVSlkaiacMY1N95nTtzzBdrg/0");
        List<ImageText> imageTexts = new ArrayList<ImageText>();
        imageTexts.add(imageText);
        advancedInfo.setImageTextList(imageTexts);

        CoverAbstract coverAbstract = new CoverAbstract();
        List<String> i = new ArrayList<String>();
        i.add("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibE9eViarbwCXIRd68OYe1AXzcsHuExF2ITPpt8TxK5jcHqj6ON6OkaWw/0");
        coverAbstract.setIconUrlList(i);
        advancedInfo.setCoverAbstract(coverAbstract);

        WeChatMemberCardBaseInfo baseInfo = (WeChatMemberCardBaseInfo) memberCard.getCardInfo().getBaseInfo();
        baseInfo.setLogoUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibBJsFkyIrGahWrysiaJeaWwXtL1hOibovw5EgegfibZ9n0KtFUaYppsnPw/0");
        baseInfo.setBrandName("卡券商户助手");
        baseInfo.setCardCodeType(WeChatCardCodeType.QrCode);
        baseInfo.setTitle("微信会员卡体验8");
        baseInfo.setColor("Color010");
        baseInfo.setNotice("使用时，请先出示会员卡");
        baseInfo.setDescription("");
        baseInfo.setCenterTitle("立即使用");
        baseInfo.setCenterSubTitle("使用享受优惠");
        CardSku cardSku = new CardSku();
        cardSku.setQuantity(10);

        PayInfo payInfo = new PayInfo();
        SwipeCard swipeCard = new SwipeCard();
        swipeCard.setSwipeCard(true);
        payInfo.setSwipeCard(swipeCard);
        baseInfo.setPayInfo(payInfo);

        baseInfo.setSku(cardSku);
        baseInfo.setGetLimit(2);
        MemberCardDateInfo m = new MemberCardDateInfo();
        m.setDateType(MemberCardDateInfo.DateType.Permanent);
        baseInfo.setDateInfo(m);
        baseInfo.setUseCustomCode(false);
        baseInfo.setCanGiveFriend(true);
        baseInfo.setUseAllLocations(true);
        baseInfo.setNeedPushOnView(true);
        //baseInfo.setCustomCodeMode(baseInfo.CUSTOM_CODE_MODE_DEPOSIT);

        //member card
        WeChatMemberCardInfo cardInfo = memberCard.getCardInfo();
        cardInfo.setBackgroundPicUrl("http://mmbiz.qpic.cn/mmbiz_png/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibrClDo5akLslX2BsmG9Vd675oicicbVhrKn2gAuTibaPVicFq33ROPSzXzw/0");
        cardInfo.setPrerogative("请谨慎保管此卡");
        cardInfo.setAutoActive(false);
        cardInfo.setSupplyBonus(false);
        cardInfo.setSupplyBalance(false);
      /*  cardInfo.setActivateUrl("http://www.tuogo.com.cn");*/
        cardInfo.setDiscount(10);
        cardInfo.setAutoActive(false);
        cardInfo.setActivateUrl("www.baidu.com");

        CustomField customField = new CustomField();
        customField.setCardNameType(WeChatCardNameType.Coupon);
        customField.setName("优惠券");
        cardInfo.setCustomField1(customField);

        BonusRule rule = new BonusRule();
        rule.setReduceMoney(100);
        cardInfo.setBonusRule(rule);

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
        list.setCardId("pM-Fjw7CqFiGjwyqVCEYEd6BGySI");
        list.setOpenId("oM-Fjw9oyLvBKdkOH04Qe317rDLk");

        GetUserCardListResult result = handleRequest(new GetUserCardListRequestHandler(jsonObjectFactory, baseUri, list));
        Assert.assertNotNull(result);
    }


    @Test
    @Rollback(false)
    public void activateMemberCard() throws Exception {

        ActivateMemberCard card = new ActivateMemberCard();
        card.setCredential(getCredential());
        card.setMembershipNumber("875617726471");
        card.setCode("875617726471");
        card.setInitBalance(10000l);
        card.setCardId("pM-Fjw7CqFiGjwyqVCEYEd6BGySI");

        ActivateMemberCodeResult result = handleRequest(new ActivateMemberCardRequestHandler(jsonObjectFactory, baseUri, card));
        Assert.assertNotNull(result);
    }


    @Test
    @Rollback(false)
    public void importCardCode() throws Exception {

        ImportCode code = new ImportCode();
        code.setCredential(getCredential());
        Set<String> codes = new HashSet<String>();
        codes.add("868627621010");
        code.setCodes(codes);
        code.setCardId("pM-Fjw6pPlJfX3PxoKJBmHD508H0");

        ImportCodeResult result = handleRequest(new ImportCardCodeRequestHandler(jsonObjectFactory, baseUri, code));
        Assert.assertNotNull(result);

    }

    @Test
    @Rollback(false)
    public void QueryCodeCount() throws Exception {

        QueryCodeCount code = new QueryCodeCount();
        code.setCredential(getCredential());
        code.setCardId("pM-Fjw6pPlJfX3PxoKJBmHD508H0");

        QueryCodeCountResult result = handleRequest(new QueryCodeCountRequestHandler(jsonObjectFactory, baseUri, code));
        Assert.assertNotNull(result);
    }

    @Test
    @Rollback(false)
    public void checkCode() throws Exception {

        CheckCode code = new CheckCode();
        code.setCredential(getCredential());
        code.setCardId("pM-Fjw6pPlJfX3PxoKJBmHD508H0");
        Set<String> codes = new HashSet<String>();
        codes.add("888888888888");
        code.setCodes(codes);

        CheckCodeResult result = handleRequest(new CheckCodeRequestHandler(jsonObjectFactory, baseUri, code));
        Assert.assertNotNull(result);

    }

    @Test
    @Rollback(false)
    public void createQrCode() throws Exception {

        CreateQrCode code = new CreateQrCode();
        ActionInfoCard infoCard = new ActionInfoCard();

        infoCard.setCode("888888888888");
        infoCard.setCardId("pM-Fjw6pPlJfX3PxoKJBmHD508H0");
        ActionInfo info = new ActionInfo();
        info.setCard(infoCard);
        code.setActionInfo(info);
        code.setCredential(getCredential());
        code.setActionName("QR_CARD");
        code.setExpireSeconds(3600);

        CreateQrCodeResult result = handleRequest(new CreateQrCodeRequestHandler(jsonObjectFactory, baseUri, code));
        Assert.assertNotNull(result);
    }


    @Test
    @Rollback(false)
    public void updateMemberCard() throws Exception {
        UpdateWeChatMemberCardInfo memberCard = new UpdateWeChatMemberCardInfo();
        memberCard.setSupplyBalance(true);

        UpdateMemberWeChatMemberCardBaseInfo baseInfo = (UpdateMemberWeChatMemberCardBaseInfo) memberCard.getBaseInfo();
        baseInfo.setCenterTitle("立即使用");
        baseInfo.setCenterSubTitle("使用立享折扣");
        baseInfo.setCenterUrl("http://127.0.0.1:8080/service/web/pay.html");


        UpdateWeChatMemberCard chatCard = new UpdateWeChatMemberCard();
        chatCard.setCredential(getCredential());
        chatCard.setCardId("pM-Fjw7CqFiGjwyqVCEYEd6BGySI");
        chatCard.setChatMemberCardInfo(memberCard);


        UpdateWeChatCardResult result = handleRequest(new UpdateWeChatCardRequestHandler(jsonObjectFactory, baseUri, chatCard));
        Assert.assertNotNull(result);
    }

    @Test
    @Rollback(false)
    public void updateWeChatCard(){

        // TODO: 2017/3/13
        UpdateWeChatCash chatCash = new UpdateWeChatCash();
        UpdateWeChatCard chatCard = new UpdateWeChatCard(chatCash);
        chatCard.setCredential(getCredential());
        chatCard.setCardId("pM-Fjw7CqFiGjwyqVCEYEd6BGySI");







    }


}
