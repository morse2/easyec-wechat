package com.googlecode.easyec.wechat.test;

import com.googlecode.easyec.spirit.web.httpcomponent.HttpRequest;
import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
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

    @Value("#{p_env['wechat.api.baseUri']}")
    protected String baseUri;

    @BeforeClass
    public static void beforeClass() {
        org.apache.log4j.BasicConfigurator.configure();
    }

    @Before
    public void beforeRun() throws Exception {
    }
}
