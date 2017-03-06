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
public class WeChatCoupon extends AbstractWeChatCard<WeChatCardInfo> {

    private static final long serialVersionUID = -6711721170040430326L;
    @JsonProperty("default_detail")
    private String detail;       // 填写优惠详情

    protected WeChatCoupon() {
        super(new WeChatCardInfo());
        setCardType("GENERAL_COUPON");
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    @JsonProperty("general_coupon")
    public WeChatCardInfo getCardInfo() {
        return this.cardInfo;
    }
}
