package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import com.googlecode.easyec.wechat.cards.WeChatVipCardNameType;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 表示微信会员卡 自定义会员信息类目
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class CustomField implements Serializable {

    private static final long serialVersionUID = 6186687394542476430L;

    private WeChatVipCardNameType weChatVipCardNameType;    //会员信息类目半自定义名称，当开发者变更这类类目信息的value值时可以选择触发系统模板消息通知用户
    @JsonProperty(value = "name", required = true)
    private String name;                                    //会员信息类目自定义名称，当开发者变更这类类目信息的value值时不会触发系统模板消息通知用户

    @JsonProperty("name_type")
    public WeChatVipCardNameType getWeChatVipCardNameType() {
        return weChatVipCardNameType;
    }

    public void setWeChatVipCardNameType(WeChatVipCardNameType weChatVipCardNameType) {
        this.weChatVipCardNameType = weChatVipCardNameType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
