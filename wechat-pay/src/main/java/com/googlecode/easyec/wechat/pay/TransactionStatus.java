package com.googlecode.easyec.wechat.pay;

/**
 * 微信支付的订单的交易状态
 *
 * @author JunJie
 */
public enum TransactionStatus {

    /**
     * 支付成功
     */
    Success("SUCCESS"),
    /**
     * 转入退款
     */
    Refund("REFUND"),
    /**
     * 未支付
     */
    NotPay("NOTPAY"),
    /**
     * 已关闭
     */
    Closed("CLOSED"),
    /**
     * 已撤销（刷卡支付）
     */
    Revoked("REVOKED"),
    /**
     * 用户支付中
     */
    UserPaying("USERPAYING"),
    /**
     * 支付失败(其他原因，如银行返回失败)
     */
    PayError("PAYERROR");

    private String value;

    TransactionStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
