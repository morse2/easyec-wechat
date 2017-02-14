package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 表示微信卡券中的兑换券类型的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatGift extends AbstractWeChatCard {

    private static final long serialVersionUID = 3715615337332258594L;
    @JsonProperty
    private String gift;  // 填写兑换内容的名称

    protected WeChatGift() {
        super("GIFT");
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }
}
