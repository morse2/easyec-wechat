package com.googlecode.easyec.wechat.test.template;

import com.googlecode.easyec.wechat.template.handler.GetTemplateListRequestHandler;
import com.googlecode.easyec.wechat.template.handler.SendTemplateMessageRequestHandler;
import com.googlecode.easyec.wechat.template.handler.SetIndustryRequestHandler;
import com.googlecode.easyec.wechat.template.model.*;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 平功元 on 2016/4/25.
 */
public class WeChatTemplateTest extends BaseTest {

    //设置行业
    @Test
    public void setIndustry() throws Exception {
        SetIndustryEntity se = new SetIndustryEntity();
        se.setCredential(getCredential());
        se.setIndustryId1("1");
        se.setIndustryId2("4");
        handleRequest(
            new SetIndustryRequestHandler(jsonObjectFactory, baseUri, se)
        );
    }


    //获取模板列表
    @Test
    public void getTemplateList() throws Exception {
        GetTemplateListEntity ge = new GetTemplateListEntity();
        ge.setCredential(getCredential());
        GetTemplateListResult result = handleRequest(
            new GetTemplateListRequestHandler(jsonObjectFactory, baseUri, ge)
        );
        Assert.assertNotNull(result);
    }

    //发送消息
    @Test
    public void sendMessage() throws Exception {
        SendTemplateMessage sendTm = new SendTemplateMessage();
        sendTm.setCredential(getCredential());
        sendTm.setMiniprogram("wx57839c4052cf4a93", "pages/order/order");
        sendTm.setToUser("ochxZ06_tM5NPkRu4GmHwl2ZiN90");
        sendTm.setTemplateId("jMWscJpI9yxUBxD3UKumbWxamqs9PeZ33cMbCKVDJ_M");
//        sendTm.setUrl("http://baidu.com");

        sendTm.addValue("first", "亲，请尽快处理未付款的订单，超时会自动关闭哟~", "#173177");
        sendTm.addValue("keyword1", "2017-06-08 12:34:11");
        sendTm.addValue("keyword2", "39.8元");
        sendTm.addValue("keyword3", "良品铺子】臭豆腐 香辣味/蒜蓉味 80g *2 等*件商品");
        sendTm.addValue("remark", "感谢您对良品铺子自营商城的支持！点击【详情】支付~");

        byte[] bs = jsonObjectFactory.writeValue(sendTm);
        System.out.println(new String(bs, "utf-8"));

        TemplateMessageResult result = handleRequest(
            new SendTemplateMessageRequestHandler(jsonObjectFactory, baseUri, sendTm)
        );

        Assert.assertNotNull(result);
        System.out.print(result.getMsgId());
    }
}
