package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券中的折扣券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatDiscount extends AbstractWeChatCard<WeChatCardInfo> {

    private static final long serialVersionUID = -3246789382530978394L;
    @JsonProperty
    private int discount;   // 表示打折额度（百分比）。填30就是七折

    public WeChatDiscount() {
        super(new WeChatCardInfo());
        setCardType("DISCOUNT");
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    @JsonProperty("discount")
    public WeChatCardInfo getCardInfo() {
        return this.cardInfo;
    }
}
