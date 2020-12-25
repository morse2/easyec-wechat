package com.googlecode.easyec.wechat.xml.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlObjectMapping {

    String name();

    Class<?> value();
}
