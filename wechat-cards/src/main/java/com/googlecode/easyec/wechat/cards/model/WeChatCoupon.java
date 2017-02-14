package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 表示卡券中的优惠券类型的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCoupon extends AbstractWeChatCard {

    private static final long serialVersionUID = 1143626290552657425L;
    @JsonProperty("default_detail")
    private String detail;       // 填写优惠详情

    protected WeChatCoupon() {
        super("GENERAL_COUPON");
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
