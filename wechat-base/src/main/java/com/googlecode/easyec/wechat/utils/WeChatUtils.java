package com.googlecode.easyec.wechat.utils;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static com.googlecode.easyec.spirit.web.utils.SpringContextUtils.getBean;
import static java.util.Collections.emptyList;
import static org.apache.http.Consts.UTF_8;

/**
 * 微信工具类
 *
 * @author JunJie
 */
public class WeChatUtils {

    private static final Logger logger = LoggerFactory.getLogger(WeChatUtils.class);

    private WeChatUtils() { /* no op */ }

    /**
     * 返回微信公众号的基础URI
     *
     * @return https开头的URI
     */
    public static String getBaseUri() {
        return "https://api.weixin.qq.com";
    }

    /**
     * 解析微信返回的时间戳内容
     *
     * @param dateStr 日期时间戳
     * @return 日期对象
     */
    public static Date parseDate(String dateStr) {
        if (StringUtils.isBlank(dateStr)) return null;

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(
            NumberUtils.toLong(dateStr + "000")
        );

        return calendar.getTime();
    }

    /**
     * 解析JSON格式的数组列表对象内容,
     * 并将其内容转换为目标对象类型.
     *
     * @param jsonList  JSON格式封装的列表对象
     * @param targetCls 目标对象类型
     */
    public static <T> List<T> parseJsonArray(List jsonList, Class<T> targetCls) {
        if (CollectionUtils.isEmpty(jsonList)) return emptyList();

        StreamObjectFactory jsonObjectFactory = _getJsonObjectFactory();
        List<T> result = new ArrayList<T>(jsonList.size());
        for (Object jsonObj : jsonList) {
            result.add(
                jsonObjectFactory.readValue(
                    jsonObjectFactory.writeValue(jsonObj),
                    targetCls
                )
            );
        }

        return result;
    }

    /**
     * 解析JSON格式的Map对象内容,
     * 并将其内容转换为目标对象类型.
     *
     * @param jsonMap   JSON格式封装的Map对象
     * @param targetCls 目标对象类型
     * @param <T>       泛型类型
     * @return 目标对象
     */
    public static <T> T parseJsonObject(Map jsonMap, Class<T> targetCls) {
        if (jsonMap == null) return null;

        StreamObjectFactory jsonObjectFactory = _getJsonObjectFactory();
        return jsonObjectFactory.readValue(
            jsonObjectFactory.writeValue(jsonMap),
            targetCls
        );
    }

    /**
     * 对参数字符串进行SHA-1加密
     *
     * @param original 原始参数字符串
     * @return SHA-1加密后的字符串
     */
    public static String sha1Hex(String original) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(original.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 将输入流的数据解析为json的map对象。
     *
     * @param in <code>InputStream</code>
     * @return <code>java.util.Map</code>
     */
    public static Map parseJsonToMap(InputStream in) {
        if (in == null) return null;

        byte[] bs = null;

        try {
            bs = IOUtils.toByteArray(in);
            return _getJsonObjectFactory().readValue(bs, HashMap.class);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        Map result = new HashMap(1);
        //noinspection ConstantConditions
        if (bs != null) {
            //noinspection unchecked
            result.put("origin", new String(bs, UTF_8));
        }

        return result;
    }

    /**
     * 从Spring上下文中获取Json工厂对象实例.
     * 实例名字为jsonObjectFactory
     */
    private static StreamObjectFactory _getJsonObjectFactory() {
        return getBean("jsonObjectFactory", StreamObjectFactory.class);
    }
}
