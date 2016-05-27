package com.googlecode.easyec.wechat.test.msg;

import com.googlecode.easyec.wechat.msg.handler.WeChatMessageHandler;
import com.googlecode.easyec.wechat.test.BaseTest;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * Created by JunJie on 5/27/16.
 */
public class WeChatMessageTestCase extends BaseTest {

    @Resource
    private WeChatMessageHandler weChatMessageHandler;

    @Test
    public void loadXmlObject() throws Exception {
        InputStream fis = new ClassPathResource("xml/test.xml").getInputStream();
        try {
            byte[] bs = IOUtils.toByteArray(fis);
            weChatMessageHandler.process(bs);
        } finally {
            IOUtils.closeQuietly(fis);
        }
    }
}
