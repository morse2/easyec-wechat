package com.googlecode.easyec;

import com.googlecode.easyec.spirit.web.utils.WebUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
        String appid = "MAGIC";
        String s = HmacUtils.hmacMd5Hex(appid, "_GSM_app_key_");
        Map<String, String[]> params = new TreeMap<>();
        params.put("noncestr", new String[] { "Wm3WZYTPz0wzccnW" });
        params.put("appid", new String[] { appid });
//        params.put("appkey", new String[]{s});
        params.put("customerid", new String[] { "1234567" });
        params.put("shipmentno", new String[] { "123456789" });
//        params.put("hscode", new String[]{"abc"});

        String string1 = WebUtils.encodeQueryString(params) + "&appkey=" + s;
        System.out.println(string1);
        String sha1 = DigestUtils.sha1Hex(string1);
        System.out.println(sha1);
    }
}
