package com.googlecode.easyec.wechat.msg.converter;

/**
 * XML元素内容的转换类
 *
 * @author JunJie
 */
public interface XmlContentConverter<T> {

    /**
     * 指定XML内容要转换为一个对象
     *
     * @param val XML数据内容
     * @return Bean对象
     */
    T from(String val);

    /**
     * 指定对象转换为XML数据内容
     *
     * @param val Bean对象
     * @return XML数据内容
     */
    String to(T val);
}
