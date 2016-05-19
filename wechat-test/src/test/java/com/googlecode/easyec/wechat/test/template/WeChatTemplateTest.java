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
                new SetIndustryRequestHandler(jsonObjectFactory,baseUri,se)
        );
    }


    //获取模板列表
    @Test
    public  void getTemplateList() throws Exception {
        GetTemplateListEntity ge = new GetTemplateListEntity();
        ge.setCredential(getCredential());
        GetTemplateListResult result = handleRequest(
          new GetTemplateListRequestHandler(jsonObjectFactory,baseUri,ge)
        );
        Assert.assertNotNull(ge);
    }

    //发送消息
    @Test
    public  void sendMessage() throws Exception {
        SendTemplateMessage sendTm = new SendTemplateMessage();
        sendTm.setCredential(getCredential());
        sendTm.setToUser("osxcMxIoHjRWg4C2cMbNpaupyPpk");
        sendTm.setTemplateId("bn80TpHR9WzUUarhNQlLOppMRq9pqINwAhnzVUM3usk");
        sendTm.setUrl("http://baidu.com");
        TemplateEntityValue tv = new TemplateEntityValue();
        tv.setFirst("#173177", "恭喜你购买成功！");
        tv.setKeynote1("#173177", "巧克力");
        tv.setKeynote2("#173177", "39.8元");
        tv.setKeynote3("#173177", "2016年5月18日");
        tv.setRemark("#173177", "欢迎再次购买!");
        sendTm.setData(tv);
        TemplateMessageResult result = handleRequest(
                new SendTemplateMessageRequestHandler(jsonObjectFactory, baseUri,sendTm)
        );
        Assert.assertNotNull(result);
        System.out.print(result.getErrmsg());
    }
}
