package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券中的优惠券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCouponInfo extends AbstractWeChatCardInfo<WeChatCardBaseInfoImpl> {

    private static final long serialVersionUID = -8461037858254456802L;
    @JsonProperty("default_detail")
    private String couponDetail;            //优惠券专用，填写优惠详情。

    public WeChatCouponInfo() {
        super(new WeChatCardBaseInfoImpl(), new WeChatCardAdvancedInfo());
    }

    public String getCouponDetail() {
        return couponDetail;
    }

    public void setCouponDetail(String couponDetail) {
        this.couponDetail = couponDetail;
    }
}
