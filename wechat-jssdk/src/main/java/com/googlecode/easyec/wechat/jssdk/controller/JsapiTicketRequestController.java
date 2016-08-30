package com.googlecode.easyec.wechat.jssdk.controller;

import com.googlecode.easyec.spirit.web.utils.WebUtils;
import com.googlecode.easyec.wechat.jssdk.model.JsapiSignature;
import com.googlecode.easyec.wechat.jssdk.model.JsapiTicket;
import com.googlecode.easyec.wechat.utils.WeChatUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.join;

/**
 * 对于<code>JsapiTicket</code>对象操作的控制器类
 *
 * @author JunJie
 */
public class JsapiTicketRequestController {

    /**
     * 对<code>JsapiTicket</code>对象及
     * 参数URL进行JS签名,并且返回
     * <code>JsapiSignature</code>对象
     *
     * @param ticket <code>JsapiTicket</code>对象
     * @param url    用户访问的当前网页地址
     * @return <code>JsapiSignature</code>对象
     */
    public JsapiSignature sign(JsapiTicket ticket, String url) {
        if (ticket == null || StringUtils.isBlank(url)) return null;

        String thisUrl = url;
        int i = StringUtils.indexOf(thisUrl, "#");
        if (i > -1) thisUrl = thisUrl.substring(0, i);

        // 生成16位随机数
        String nonce = RandomStringUtils.random(16, true, true);
        String timestamp = String.valueOf(System.currentTimeMillis());

        Map<String, String> params = new HashMap<String, String>();
        params.put("jsapi_ticket", ticket.getTicket());
        params.put("timestamp", timestamp);
        params.put("noncestr", nonce);
        params.put("url", thisUrl);

        String[] objects = StringUtils.split(
            WebUtils.encodeQueryString(params), "&"
        );

        List<String> arr = Arrays.asList(objects);
        Collections.sort(arr);

        String signature = WeChatUtils.sha1Hex(join(arr, ""));
        return new JsapiSignature(nonce, timestamp, signature);
    }
}
