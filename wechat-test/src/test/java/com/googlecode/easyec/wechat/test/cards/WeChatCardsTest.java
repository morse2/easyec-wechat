package com.googlecode.easyec.wechat.test.cards;

import com.googlecode.easyec.wechat.cards.handler.QueryCodeRequestHandler;
import com.googlecode.easyec.wechat.cards.model.LandingPage;
import com.googlecode.easyec.wechat.cards.model.QueryCode;
import com.googlecode.easyec.wechat.cards.model.QueryCodeResult;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class WeChatCardsTest extends BaseTest {

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
}
