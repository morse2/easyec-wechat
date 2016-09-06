package com.googlecode.easyec.wechat.pay.utils;

import com.googlecode.easyec.wechat.pay.model.BaseWeChatTransaction;
import com.googlecode.easyec.wechat.xml.WeChatXmlData;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.w3c.dom.Element;

import java.math.BigDecimal;
import java.util.*;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.join;

/**
 * 微信支付的工具类
 *
 * @author JunJie
 */
public class TransactionUtils {

    private TransactionUtils() { /* no op */ }

    /**
     * 返回微信支付的基础URI
     *
     * @return https开头的URI
     */
    public static String getBaseUri() {
        return "https://api.mch.weixin.qq.com";
    }

    /**
     * 对微信支付交易进行签名操作的方法
     *
     * @param ts <code>WeChatTransaction</code>对象
     */
    public static void sign(BaseWeChatTransaction ts, String apiKey) {
        if (ts != null) {
            ts.setNonceStr(
                RandomStringUtils.random(24, true, true)
            );

            Map<String, String> params = new HashMap<String, String>();
            WeChatXmlData xml = new WeChatXmlData();
            xml.merge(ts);

            List<Element> elements = xml.getElements();
            for (Element ele : elements) {
                String name = ele.getLocalName();
                if (isBlank(name)) name = ele.getNodeName();

                params.put(name, ele.getTextContent());
            }

            List<String> arr = new ArrayList<String>();
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                arr.add(
                    new StringBuffer()
                        .append(key)
                        .append("=")
                        .append(params.get(key))
                        .toString()
                );
            }

            Collections.sort(arr);

            ts.setSignature(
                DigestUtils.md5Hex(
                    new StringBuffer()
                        .append(join(arr, "&"))
                        .append("&key=")
                        .append(apiKey)
                        .toString()
                ).toUpperCase()
            );
        }
    }

    /**
     * 获取交易的时间戳
     *
     * @param date <code>java.util.Date</code>对象
     * @return 时间戳字符串
     */
    public static String getTimestamp(Date date) {
        return DateFormatUtils.format(date, "yyyyMMddHHmmss");
    }

    /**
     * 获取微信约定格式的交易金额值。
     * 如果参数bd为null，则返回0
     *
     * @param bd 交易金额，不能为空
     * @return 微信格式的交易金额
     */
    public static int getTransactionAmount(BigDecimal bd) {
        if (bd == null) return 0;
        return bd.setScale(2, ROUND_HALF_UP)
            .multiply(new BigDecimal(100))
            .intValue();
    }
}
