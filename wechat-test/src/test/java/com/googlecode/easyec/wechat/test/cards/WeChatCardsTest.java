package com.googlecode.easyec.wechat.test.cards;

import com.googlecode.easyec.wechat.cards.handler.QueryCodeRequestHandler;
import com.googlecode.easyec.wechat.cards.model.*;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class WeChatCardsTest extends BaseTest {

    @Test
    public void createGroupon() throws Exception {
        WeChatGroupon groupon = new WeChatGroupon();
        groupon.getCardInfo().getBaseInfo().setBindOpenId(false);
        groupon.getCardInfo().getBaseInfo().setBrandName("AABBCC");

        CreateWeChatCard card = new CreateWeChatCard(groupon);
        System.out.println(new String(jsonObjectFactory.writeValue(card), "utf-8"));
    }

    @Test
    public void createLandingPage() throws Exception {
        LandingPage page = new LandingPage();
        page.setBannerUrl("http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZJkmG8xXhiaHqkKSVMMWeN3hLut7X7hicFN");
        page.setTitle("惠城优惠大派送");
        page.setCanShare(false);
        page.setScene(LandingPage.Scene.Menu);

        LandingPage.Card card1 = new LandingPage.Card();
        card1.setCardId("pXch-jnOlGtbuWwIO2NDftZeynRE");
        card1.setThumbUrl("www.qq.com/a.jpg");

        LandingPage.Card card2 = new LandingPage.Card();
        card2.setCardId("pXch-jnAN-ZBoRbiwgqBZ1RV60fI");
        card2.setThumbUrl("www.qq.com/b.jpg");

        page.addCard(card1);
        page.addCard(card2);

        byte[] bs = jsonObjectFactory.writeValue(page);
        System.out.println(new String(bs, "utf-8"));
    }

    @Test
    public void queryCode() throws Exception {

        QueryCode queryCode = new QueryCode();
        queryCode.setCredential(getCredential());
        queryCode.setCardId("card_id_123+");
        queryCode.setCode("123456789");
        queryCode.setCheckConsume(true);

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
        modifyStock.setCardId("pFS7Fjg8kV1IdDz01r4SQwMkuCKc");
        modifyStock.setIncreaseStockValue(123456);
        modifyStock.setReduceStockValue(111111);

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
    public void deleteCard() throws Exception {
        DeleteCard card = new DeleteCard();
        card.setCredential(getCredential());
        card.setCardId("1231241");
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

}
