package com.googlecode.easyec.wechat.test.menu;

import com.googlecode.easyec.wechat.menu.enums.ButtonTypes;
import com.googlecode.easyec.wechat.menu.handler.AddMenuRequestHandler;
import com.googlecode.easyec.wechat.menu.handler.DeleteMenuRequestHandler;
import com.googlecode.easyec.wechat.menu.handler.QueryMenuConfigRequestHandler;
import com.googlecode.easyec.wechat.menu.handler.QueryMenuRequestHandler;
import com.googlecode.easyec.wechat.menu.model.Button;
import com.googlecode.easyec.wechat.menu.model.Menu;
import com.googlecode.easyec.wechat.menu.model.QueryMenuConfigResult;
import com.googlecode.easyec.wechat.menu.model.QueryMenuResult;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by JunJie on 2/19/16.
 */
public class WeChatMenuTestCase extends BaseTest {

    @Test
    public void queryMenu() throws Exception {
        QueryMenuResult result = handleRequest(
            new QueryMenuRequestHandler(jsonObjectFactory, baseUri, getCredential())
        );

        Assert.assertNotNull(result);
    }

    @Test
    public void addMenu() throws Exception {
        Menu menu = new Menu();
        menu.setCredential(getCredential());

        Button button1 = new Button();
        button1.setName("会员卡3");
        menu.addButton(button1);

        Button grouponBtn = new Button();
        grouponBtn.setName("领取会员卡");
        grouponBtn.setType(ButtonTypes.view);
        grouponBtn.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3be6367203f983ac&redirect_uri=https%3A%2F%2Fmp.weixin.qq.com%2Fbizmall%2Fcardlandingpage%3Fbiz%3DMzI3ODEwMjgzNQ%3D%3D%26page_id%3D9%26scene%3D11&response_type=code&scope=snsapi_base#wechat_redirect");

        button1.addSubButton(grouponBtn);

        byte[] bs = jsonObjectFactory.writeValue(menu);
        System.out.println(
            new String(bs)
        );

        handleRequest(
                new AddMenuRequestHandler(jsonObjectFactory, baseUri, menu)
        );
    }

    @Test
    public void deleteMenu() throws Exception {
        handleRequest(
            new DeleteMenuRequestHandler(jsonObjectFactory, baseUri, getCredential())
        );
    }

    @Test
    public void queryMenuConfig() throws Exception {
        QueryMenuConfigResult result = handleRequest(
            new QueryMenuConfigRequestHandler(jsonObjectFactory, baseUri, getCredential())
        );

        Assert.assertNotNull(result);
    }
}
