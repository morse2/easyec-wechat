package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券中的代金券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCash extends AbstractWeChatCard<WeChatCashInfo> {

    private static final long serialVersionUID = -2725900555722066952L;

    public WeChatCash() {
        super(new WeChatCashInfo());
        setCardType("CASH");
    }

    @Override
    @JsonProperty("cash")
    public WeChatCashInfo getCardInfo() {
        return this.cardInfo;
    }
}
