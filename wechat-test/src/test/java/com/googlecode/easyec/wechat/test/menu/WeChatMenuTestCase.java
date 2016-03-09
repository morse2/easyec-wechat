package com.googlecode.easyec.wechat.test.menu;

import com.googlecode.easyec.wechat.menu.enums.ButtonTypes;
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
        button1.setName("测试1");
        menu.addButton(button1);

        Button button2 = new Button();
        button2.setName("测试2");
        button2.setType(ButtonTypes.click);
        button2.setKey("C001_ABC");

        button1.addSubButton(button2);

        byte[] bs = jsonObjectFactory.writeValue(menu);
        System.out.println(
            new String(bs)
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
