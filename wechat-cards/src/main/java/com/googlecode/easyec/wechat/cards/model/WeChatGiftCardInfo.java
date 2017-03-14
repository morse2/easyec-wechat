package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 卡券管理中的卡券的基本信息和高级信息的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatGiftCardInfo extends AbstractWeChatCardInfo<WeChatCardBaseInfoImpl> {

    private static final long serialVersionUID = 8934594200000370693L;
    @JsonProperty("gift")
    private String gift;                         //填写兑换内容的名称 兑换券时填写

    public WeChatGiftCardInfo() {
        super(new WeChatCardBaseInfoImpl(), new WeChatCardAdvancedInfo());
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }
}
