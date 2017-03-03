package com.googlecode.easyec.wechat.cards;

/**
 * 核销卡券时 卡券的状态
 */
public enum QueryCardStatus {

    /**
     * 正常
     */
    Normal("NORMAL"),
    /**
     * 已核销
     */
    Consumed("CONSUMED"),
    /**
     * 已过期
     */
    Expire("EXPIRE"),
    /**
     * 转赠中
     */
    Gifting("GIFTING"),
    /**
     * 转赠超时
     */
    GiftTimeout("GIFT_TIMEOUT"),
    /**
     * 已删除
     */
    Delete("DELETE"),
    /**
     * 已失效
     */
    Unavailable("UNAVAILABLE")
    ;

    private String value;

    QueryCardStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
