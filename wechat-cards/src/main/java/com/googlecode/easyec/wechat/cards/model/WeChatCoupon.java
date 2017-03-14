package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示卡券中的优惠券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCoupon extends AbstractWeChatCard<WeChatCouponInfo> {

    private static final long serialVersionUID = -6711721170040430326L;


    protected WeChatCoupon() {
        super(new WeChatCouponInfo());
        setCardType("GENERAL_COUPON");
    }

    @Override
    @JsonProperty("general_coupon")
    public WeChatCouponInfo getCardInfo() {
        return this.cardInfo;
    }
}
