package com.googlecode.easyec.wechat.xml.annotation;

import com.googlecode.easyec.wechat.xml.converter.impl.DefaultXmlElementConverter;
import com.googlecode.easyec.wechat.xml.converter.XmlElementConverter;

import java.lang.annotation.*;

/**
 * XML元素映射的注解类
 *
 * @author JunJie
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElementMapping {

    /**
     * 表示XML元素的名称
     */
    String name();

    /**
     * 指定一个XML数据转换的类
     */
    Class<? extends XmlElementConverter<?>> converter() default DefaultXmlElementConverter.class;
}
