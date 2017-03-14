package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券模块中的团购券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatGroupon extends AbstractWeChatCard<WeChatGrouponCardInfo> {

    private static final long serialVersionUID = -2953384204705746830L;


    public WeChatGroupon() {
        super(new WeChatGrouponCardInfo());
        setCardType("GROUPON");
    }

    @Override
    @JsonProperty("groupon")
    public WeChatGrouponCardInfo getCardInfo() {
        return this.cardInfo;
    }
}
