package com.googlecode.easyec.wechat.test.cards;

import com.googlecode.easyec.wechat.cards.WeChatCardCodeType;
import com.googlecode.easyec.wechat.cards.handler.*;
import com.googlecode.easyec.wechat.cards.model.*;
import com.googlecode.easyec.wechat.msg.handler.WeChatMessageHandler;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeChatCardsTest extends BaseTest {


    @Resource
    private WeChatMessageHandler weChatMessageHandler;

    @Test
    @Rollback(false)
    public void createGroupon() throws Exception {
        WeChatGroupon groupon = new WeChatGroupon();
        WeChatCardBaseInfoImpl baseInfo = (WeChatCardBaseInfoImpl) groupon.getCardInfo().getBaseInfo();
        baseInfo.setBindOpenId(false);
        baseInfo.setBrandName("团购券");
        baseInfo.setLogoUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibicTDQLRhpqSyVICX0HcDbFgT2y005B3udk1FibjmUYEFEicBOEpfX6x3A/0");
        baseInfo.setTitle("团购券");
        baseInfo.setColor("Color010");
        baseInfo.setNotice("此优惠券只能单独使用");
        baseInfo.setDescription("该优惠券所有门店都可以使用");
        baseInfo.setCardCodeType(WeChatCardCodeType.QrCode);
        CardSku sku = new CardSku();
        sku.setQuantity(100000);
        baseInfo.setSku(sku);
        CardDateInfo dateInfo = new CardDateInfo();
        dateInfo.setDateType(CardDateInfo.DateType.FixTerm);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-03-13 15:24:30");
        dateInfo.setEndTime(_getTimeStamp(date));
        dateInfo.setFixedTerm(15l);
        dateInfo.setFixedBeginTerm(0l);
        baseInfo.setDateInfo(dateInfo);
        groupon.getCardInfo().setGrouponDetail("所有商品都为9折");


        CreateWeChatCard card = new CreateWeChatCard(groupon);
        card.setCredential(getCredential());
        CreateWeChatCardResult result = handleRequest(new CreateWeChatCardRequestHandler(jsonObjectFactory, baseUri, card));
        Assert.assertNotNull(result);
    }

    @Test
    @Rollback(false)
    public void createGift() throws Exception {

        WeChatGift gift = new WeChatGift();
        WeChatCardBaseInfoImpl baseInfo = (WeChatCardBaseInfoImpl) gift.getCardInfo().getBaseInfo();
        baseInfo.setBindOpenId(false);
        baseInfo.setBrandName("兑换券");
        baseInfo.setLogoUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibicTDQLRhpqSyVICX0HcDbFgT2y005B3udk1FibjmUYEFEicBOEpfX6x3A/0");
        baseInfo.setTitle("兑换券");
        baseInfo.setColor("Color010");
        baseInfo.setNotice("此优惠券只能单独使用");
        baseInfo.setDescription("该优惠券所有门店都可以使用");
        baseInfo.setCardCodeType(WeChatCardCodeType.QrCode);
        CardSku sku = new CardSku();
        sku.setQuantity(100000);
        baseInfo.setSku(sku);
        CardDateInfo dateInfo = new CardDateInfo();
        dateInfo.setDateType(CardDateInfo.DateType.FixTerm);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-03-28 23:59:59");
        dateInfo.setEndTime(_getTimeStamp(date));
        dateInfo.setFixedTerm(15l);
        dateInfo.setFixedBeginTerm(0l);
        baseInfo.setDateInfo(dateInfo);
        gift.getCardInfo().setGift("可以兑换一个鼠标");

        CreateWeChatCard card = new CreateWeChatCard(gift);
        card.setCredential(getCredential());
        CreateWeChatCardResult result = handleRequest(new CreateWeChatCardRequestHandler(jsonObjectFactory, baseUri, card));
        Assert.assertNotNull(result);

    }

    @Test
    @Rollback(false)
    public void createCash() throws Exception {

        WeChatCash cash = new WeChatCash();
        cash.getCardInfo().setLeastCost(100);
        cash.getCardInfo().setReduceCost(10);
        WeChatCardBaseInfoImpl baseInfo = (WeChatCardBaseInfoImpl) cash.getCardInfo().getBaseInfo();
        baseInfo.setBindOpenId(false);
        baseInfo.setBrandName("代金券");
        baseInfo.setLogoUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibicTDQLRhpqSyVICX0HcDbFgT2y005B3udk1FibjmUYEFEicBOEpfX6x3A/0");
        baseInfo.setTitle("代金券");
        baseInfo.setColor("Color010");
        baseInfo.setNotice("此代金券只能单独使用");
        baseInfo.setDescription("该代金券所有门店都可以使用");
        baseInfo.setCardCodeType(WeChatCardCodeType.QrCode);
        CardSku sku = new CardSku();
        sku.setQuantity(100000);
        baseInfo.setSku(sku);
        CardDateInfo dateInfo = new CardDateInfo();
        dateInfo.setDateType(CardDateInfo.DateType.FixTerm);
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-03-28 23:59:59");
        dateInfo.setEndTime(_getTimeStamp(date));
        dateInfo.setFixedTerm(15l);
        dateInfo.setFixedBeginTerm(0l);
        baseInfo.setDateInfo(dateInfo);

        CreateWeChatCard card = new CreateWeChatCard(cash);
        card.setCredential(getCredential());
        CreateWeChatCardResult result = handleRequest(new CreateWeChatCardRequestHandler(jsonObjectFactory, baseUri, card));
        Assert.assertNotNull(result);
    }


    @Test
    @Rollback(false)
    public void createLandingPage() throws Exception {
        LandingPage page = new LandingPage();
        page.setCredential(getCredential());
        page.setBannerUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibE9eViarbwCXIRd68OYe1AXzcsHuExF2ITPpt8TxK5jcHqj6ON6OkaWw/0");
        page.setTitle("SEPHORA");
        page.setCanShare(false);
        page.setScene(LandingPage.Scene.H5);

        LandingPage.Card card1 = new LandingPage.Card();
        card1.setCardId("pM-Fjw4vkVna1PRj014uOicJG7MM");
        card1.setThumbUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibBJsFkyIrGahWrysiaJeaWwXtL1hOibovw5EgegfibZ9n0KtFUaYppsnPw/0");

       /* LandingPage.Card card2 = new LandingPage.Card();
        card2.setCardId("pM-FjwxvhaN9JmWb01JJ0NmraYCk");
        card2.setThumbUrl("http://mmbiz.qpic.cn/mmbiz_jpg/5KnFxMCGhEKv7NFLkIv3kgnXa1hCTf3ibyNZjicTf2UnWicLOyqEmgMNDfoXKNQsQFkX2zvKSpC0orSLTMticAhdcg/0");*/

        page.addCard(card1);
      /*  page.addCard(card2);*/

        CreateLandingPageResult result = handleRequest(new CreateLandingPageRequestHandler(jsonObjectFactory, baseUri, page));
        Assert.assertNotNull(result);

    }

    @Test
    public void queryCode() throws Exception {

        QueryCode queryCode = new QueryCode();
        queryCode.setCredential(getCredential());
        // queryCode.setCardId("pM-Fjw6ORuqe8LuIrnAGg8X-Z6Gk");
        queryCode.setCode("097966952328");
        //queryCode.setCheckConsume(true);

        QueryCodeResult result = handleRequest(new QueryCodeRequestHandler(jsonObjectFactory, baseUri, queryCode));
        Assert.assertNotNull(result);
    }

    @Test
    public void consumeCode() throws Exception {
        ConsumeCard consumeCard = new ConsumeCard();
        consumeCard.setCredential(getCredential());
        consumeCard.setCode("12312313");
        consumeCard.setCardId("pFS7Fjg8kV1IdDz01r4SQwMkuCKc");
        ConsumeCardResult result = handleRequest(new ConsumeCardRequestHandler(jsonObjectFactory, baseUri, consumeCard));
        Assert.assertNotNull(result);
    }

    @Test
    public void decryptCode() throws Exception {
        DecryptCode code = new DecryptCode();
        code.setCredential(getCredential());
        code.setEncryptCode("XXIzTtMqCxwOaawoE91+VJdsFmv7b8g0VZIZkqf4GWA60Fzpc8ksZ/5ZZ0DVkXdE");

        DecryptCodeResult result = handleRequest(new DecryptCodeRequestHandler(jsonObjectFactory, baseUri, code));
        Assert.assertNotNull(result);

    }

    @Test
    public void modifyStock() throws Exception {

        ModifyStock modifyStock = new ModifyStock();
        modifyStock.setCredential(getCredential());
        modifyStock.setCardId("pM-Fjw7CqFiGjwyqVCEYEd6BGySI");
        modifyStock.setIncreaseStockValue(10);

        ModifyStockResult result = handleRequest(new ModifyStockRequestHandler(jsonObjectFactory, baseUri, modifyStock));
        Assert.assertNotNull(result);
    }

    @Test
    public void updateCode() throws Exception {
        UpdateCode code = new UpdateCode();
        code.setCredential(getCredential());
        code.setCardId("pFS7Fjg8kV1IdDz01r4SQwMkuCKc");
        code.setCode("12345678");
        code.setNewCode("3495739475");

        UpdateCodeResult result = handleRequest(new UpdateCodeRequestHandler(jsonObjectFactory, baseUri, code));
        Assert.assertNotNull(result);
    }

    @Test
    @Rollback(false)
    public void deleteCard() throws Exception {
        DeleteCard card = new DeleteCard();
        card.setCredential(getCredential());
        card.setCardId("pM-Fjw7CqFiGjwyqVCEYEd6BGySI");
        DeleteCardResult result = handleRequest(new DeleteCardRequestHandler(jsonObjectFactory, baseUri, card));
        Assert.assertNotNull(result);
    }

    @Test
    public void unavailableCode() throws Exception {
        UnavailableCode code = new UnavailableCode();
        code.setCredential(getCredential());
        code.setCode("12312431");
        code.setCardId("dsada");

        UnavailableCodeResult result = handleRequest(new UnavaliableCodeRequestHandler(jsonObjectFactory, baseUri, code));
        Assert.assertNotNull(result);

    }

    @Test
    public void getCardProfileInfo() throws Exception {

        GetCardProfileInfo info = new GetCardProfileInfo();
        info.setCredential(getCredential());
        info.setBeginDate("2017-01-01");
        info.setEndDate("2017-02-01");
        info.setCondSource(0);

        GetCardProfileInfoResult result = handleRequest(new GetCardProfileInfoRequestHandler(jsonObjectFactory, baseUri, info));
        Assert.assertNotNull(result);
    }

    @Test
    public void getFreeCardInfo() throws Exception {

        GetFreeCardInfo info = new GetFreeCardInfo();
        info.setCredential(getCredential());
        info.setCondSource(0);
        info.setBeginDate("2015-06-15");
        info.setEndDate("2015-06-30");
        info.setCardId("po8pktyDLmakNY2fn2VyhkiEPqGE");

        GetFreeCardInfoResult result = handleRequest(new GetFreeCardInfoRequestHandler(jsonObjectFactory, baseUri, info));
        Assert.assertNotNull(result);

    }

    @Test
    public void getMemberCardInfo() throws Exception {

        GetMemberCardInfo info = new GetMemberCardInfo();
        info.setCredential(getCredential());
        info.setCondSource(0);
        info.setBeginDate("2015-06-15");
        info.setEndDate("2015-06-30");

        GetMemberCardInfoResult result = handleRequest(new GetMemberCardInfoRequestHandler(jsonObjectFactory, baseUri, info));
        Assert.assertNotNull(result);
    }

    @Test
    @Rollback(false)
    public void queryCardInfo() throws Exception {

        QueryCardInfo cardInfo = new QueryCardInfo();
        cardInfo.setCredential(getCredential());
        cardInfo.setCardId("pM-Fjw2afUGEFNLoRH10DvlUCiao");
        QueryWeChatCardResult result = handleRequest(new QueryCardInfoRequestHandler(jsonObjectFactory, baseUri, cardInfo));
        Assert.assertNotNull(result);

    }

    @Test
    @Rollback(false)
    public void queryMemberCardInfo() throws Exception {

        QueryCardInfo cardInfo = new QueryCardInfo();
        cardInfo.setCredential(getCredential());
        cardInfo.setCardId("pM-Fjw7CqFiGjwyqVCEYEd6BGySI");

        QueryWeChatMemberCardResult result = handleRequest(new QueryMemberCardInfoRequestHandler(jsonObjectFactory, baseUri, cardInfo));
        Assert.assertNotNull(result);
    }


    @Test
    public void queryCardInfoFromJsonText() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\test.json");
        byte[] json = IOUtils.toByteArray(fis);
        fis.close();

        QueryWeChatMemberCardResult result = jsonObjectFactory.readValue(json, QueryWeChatMemberCardResult.class);
        Assert.assertNotNull(result);
    }

    private Long _getTimeStamp(Date date) {
        return Long.valueOf(DateFormatUtils.format(date, "yyyyMMddHHmmss"));
    }


    @Test
    public void loadXmlObject() throws Exception {
        InputStream fis = new ClassPathResource("xml/cardTest.xml").getInputStream();
        try {
            byte[] bs = IOUtils.toByteArray(fis);
            weChatMessageHandler.process(bs);
        } finally {
            IOUtils.closeQuietly(fis);
        }
    }
}
