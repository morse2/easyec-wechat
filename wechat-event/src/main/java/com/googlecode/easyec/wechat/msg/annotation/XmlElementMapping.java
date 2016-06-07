package com.googlecode.easyec.wechat.msg.annotation;

import com.googlecode.easyec.wechat.msg.converter.StringXmlContentConverter;
import com.googlecode.easyec.wechat.msg.converter.XmlContentConverter;

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
    Class<? extends XmlContentConverter> converter() default StringXmlContentConverter.class;
}
