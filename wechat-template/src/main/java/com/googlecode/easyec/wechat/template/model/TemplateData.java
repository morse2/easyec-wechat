package com.googlecode.easyec.wechat.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 表示模板数据的基类。
 * 具体子类继承自该类,
 * 并且定义自己的参数。
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class TemplateData {

}
