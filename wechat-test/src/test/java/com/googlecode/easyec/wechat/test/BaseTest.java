package com.googlecode.easyec.wechat.test;

import com.googlecode.easyec.spirit.web.httpcomponent.HttpRequest;
import com.googlecode.easyec.spirit.web.httpcomponent.HttpRequestHandler;
import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import com.googlecode.easyec.wechat.WeChatBusinessException;
import com.googlecode.easyec.wechat.base.model.WeChatCredential;
import com.googlecode.easyec.wechat.base.model.WeChatError;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration(locations = "classpath*:spring/test/applicationContext-*.xml")
public class BaseTest extends AbstractJUnit4SpringContextTests {

    @Resource
    protected HttpRequest httpRequest;
    @Resource
    protected StreamObjectFactory jsonObjectFactory;
    @Resource(name = "jaxbObjectFactory")
    protected StreamObjectFactory jaxbObjectFactory;

    @Value("#{p_env['wechat.api.baseUri']}")
    protected String baseUri;
    @Value("#{p_env['wechat.acc.token']}")
    protected String token;

    @BeforeClass
    public static void beforeClass() {
        org.apache.log4j.BasicConfigurator.configure();
    }

    @Before
    public void beforeRun() throws Exception {
    }

    /**
     * 获取当前微信的凭证信息
     */
    protected WeChatCredential getCredential() {
        WeChatCredential c = new WeChatCredential();
        c.setAccessToken(token);

        return c;
    }

    /**
     * 处理HTTP调用请求的方法
     *
     * @param handler <code>HttpRequestHandler</code>实例
     * @throws Exception
     */
    protected <T> T handleRequest(HttpRequestHandler<T> handler) throws Exception {
        try {
            return httpRequest.request(handler);
        } catch (Exception e) {
            if (e instanceof WeChatBusinessException) {
                WeChatError err = ((WeChatBusinessException) e).getError();
                logger.debug("WeChat ERROR. Code [" + err.getCode() + "], message: ["
                    + err.getMessage() + "].");
            }

            throw e;
        }
    }
}
