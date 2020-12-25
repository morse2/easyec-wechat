package com.googlecode.easyec.wechat.xml.annotation;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlListMapping {

    String name();

    Class<?> value();

    Class<? extends List> listType() default ArrayList.class;
}
