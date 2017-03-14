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
public class WeChatDiscount extends AbstractWeChatCard<WeChatDiscountInfo> {

    private static final long serialVersionUID = -3246789382530978394L;


    public WeChatDiscount() {
        super(new WeChatDiscountInfo());
        setCardType("DISCOUNT");
    }



    @Override
    @JsonProperty("discount")
    public WeChatDiscountInfo getCardInfo() {
        return this.cardInfo;
    }
}
