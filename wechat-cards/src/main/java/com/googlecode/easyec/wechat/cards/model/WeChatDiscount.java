package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 表示微信卡券中的折扣券类型的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatDiscount extends AbstractWeChatCard {

    private static final long serialVersionUID = -3762540944882868863L;
    @JsonProperty
    private int discount;   // 表示打折额度（百分比）。填30就是七折

    public WeChatDiscount() {
        super("DISCOUNT");
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
