package com.googlecode.easyec.wechat.card;

/**
 * 本次订单号的状态
 */
public enum PayOrderStatus {

    /**
     * 等待支付
     */
    Waiting("ORDER_STATUS_WAITING"),
    /**
     * 支付成功
     */
    Success("ORDER_STATUS_SUCC"),
    /**
     *加代币成功
     */
    FinanceSuc("ORDER_STATUS_FINANCE_SUCC"),
    /**
     * 加库存成功
     */
    QuantitySuc("ORDER_STATUS_QUANTITY_SUCC"),
    /**
     * 已退币
     */
    HasRefund("ORDER_STATUS_HAS_REFUND"),
    /**
     * 等待退币确认
     */
    RefundWaiting("ORDER_STATUS_REFUND_WAITING"),
    /**
     * 已回退,系统失败
     */
    Rollback("ORDER_STATUS_ROLLBACK"),
    /**
     * 已开发票
     */
    HasReceipt("ORDER_STATUS_HAS_RECEIPT")
    ;

    private String value;

    PayOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
