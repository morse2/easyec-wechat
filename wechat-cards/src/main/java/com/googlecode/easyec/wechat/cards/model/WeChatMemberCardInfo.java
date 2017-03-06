package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 微信卡券管理中会员卡的基本信息和高级信息的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatMemberCardInfo extends AbstractWeChatCardInfo {

    private static final long serialVersionUID = 628555773313565456L;

    public WeChatMemberCardInfo() {
        super(new WeChatMemberCardBaseInfo(), new WeChatCardAdvancedInfo());
    }
}
