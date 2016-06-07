package com.googlecode.easyec.wechat.msg.converter;

/**
 * 处理字符串格式的XML数据内容的转换类
 *
 * @author JunJie
 */
public class StringXmlContentConverter implements XmlContentConverter<String> {

    @Override
    public String from(String val) {
        return val;
    }

    @Override
    public String to(String val) {
        return val;
    }
}
