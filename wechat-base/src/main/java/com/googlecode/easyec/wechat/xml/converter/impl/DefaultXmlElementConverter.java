package com.googlecode.easyec.wechat.xml.converter.impl;

import com.googlecode.easyec.wechat.xml.converter.XmlElementConverter;

/**
 * 默认的XML元素转换的实现类
 *
 * @author JunJie
 */
public class DefaultXmlElementConverter implements XmlElementConverter<String> {

    @Override
    public String from(String val) {
        return val;
    }

    @Override
    public String to(String val) {
        return val;
    }
}
