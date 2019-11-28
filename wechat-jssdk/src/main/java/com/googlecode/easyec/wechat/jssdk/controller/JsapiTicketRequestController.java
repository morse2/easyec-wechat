package com.googlecode.easyec.wechat.jssdk.controller;

import com.googlecode.easyec.spirit.web.utils.WebUtils;
import com.googlecode.easyec.wechat.jssdk.model.JsapiSignature;
import com.googlecode.easyec.wechat.jssdk.model.JsapiTicket;
import com.googlecode.easyec.wechat.utils.WeChatUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        timestamp = timestamp.substring(0, timestamp.length() - 3);

        Map<String, String[]> params = new HashMap<>();
        params.put("jsapi_ticket", new String[] { ticket.getTicket() });
        params.put("timestamp", new String[] { timestamp });
        params.put("noncestr", new String[] { nonce });

        String qs = WebUtils.encodeQueryString(params);
        List<String> arr
            = Stream.of(StringUtils.split(qs, "&"))
            .collect(Collectors.toList());
        arr.add(StringUtils.join(new String[] { "url", thisUrl }, "="));

        Collections.sort(arr);

        String signature = WeChatUtils.sha1Hex(join(arr, "&"));
        return new JsapiSignature(nonce, timestamp, signature);
    }
}
