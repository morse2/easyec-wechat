package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券中的兑换券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatGift extends AbstractWeChatCard<WeChatGiftCardInfo> {

    private static final long serialVersionUID = 1098675901504909627L;

    public WeChatGift() {
        super(new WeChatGiftCardInfo());
        setCardType("GIFT");
    }

    @Override
    @JsonProperty("gift")
    public WeChatGiftCardInfo getCardInfo() {
        return this.cardInfo;
    }
}
