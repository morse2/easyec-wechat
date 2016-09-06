package com.googlecode.easyec.wechat.xml.converter.impl;

import com.googlecode.easyec.wechat.utils.WeChatUtils;
import com.googlecode.easyec.wechat.xml.converter.XmlElementConverter;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * 日期时间元素内容的转换实现类
 *
 * @author JunJie
 */
public class DatetimeElementConverter implements XmlElementConverter<Date> {

    @Override
    public Date from(String val) {
        return WeChatUtils.parseDate(val);
    }

    @Override
    public String to(Date val) {
        return val != null ? DateFormatUtils.format(val, "yyyyMMddHHmmss") : "";
    }
}
