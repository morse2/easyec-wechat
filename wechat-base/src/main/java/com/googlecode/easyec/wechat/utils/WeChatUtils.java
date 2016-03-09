package com.googlecode.easyec.wechat.utils;

import com.googlecode.easyec.spirit.web.webservice.factory.StreamObjectFactory;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.util.*;

import static com.googlecode.easyec.spirit.web.utils.SpringContextUtils.getBean;
import static java.util.Collections.emptyList;

/**
 * 微信工具类
 *
 * @author JunJie
 */
public class WeChatUtils {

    private WeChatUtils() { /* no op */ }

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
     * 从Spring上下文中获取Json工厂对象实例.
     * 实例名字为jsonObjectFactory
     */
    private static StreamObjectFactory _getJsonObjectFactory() {
        return getBean("jsonObjectFactory", StreamObjectFactory.class);
    }
}
