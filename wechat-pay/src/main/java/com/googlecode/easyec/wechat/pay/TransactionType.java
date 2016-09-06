package com.googlecode.easyec.wechat.pay;

/**
 * 交易类型的枚举类
 *
 * @author JunJie
 */
public enum TransactionType {

    /**
     * 公众号支付
     */
    JsApi("JSAPI"),
    /**
     * 原生扫码支付
     */
    Native("NATIVE"),
    /**
     * app支付
     */
    App("APP"),
    /**
     * 刷卡支付
     */
    MicroPay("MICROPAY");

    private String value;

    TransactionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
