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
public class WeChatDiscountInfo extends AbstractWeChatCardInfo<WeChatCardBaseInfoImpl> {

    private static final long serialVersionUID = -1218512098024977145L;

    @JsonProperty("discount")
    private int discount;                   //折扣券专用，表示打折额度（百分比）。填30就是七折

    public WeChatDiscountInfo() {
        super(new WeChatCardBaseInfoImpl(), new WeChatCardAdvancedInfo());
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
