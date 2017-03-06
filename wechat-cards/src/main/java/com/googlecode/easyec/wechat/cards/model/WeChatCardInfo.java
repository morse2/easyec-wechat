package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 卡券管理中的卡券的基本信息和高级信息的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCardInfo extends AbstractWeChatCardInfo {

    private static final long serialVersionUID = -7950441107058916299L;

    public WeChatCardInfo() {
        super(new WeChatCardBaseInfoImpl(), new WeChatCardAdvancedInfo());
    }
}
