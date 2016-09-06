package com.googlecode.easyec.wechat.pay.model;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 微信查询订单接口的请求数据的对象类
 *
 * @author JunJie
 */
public class WeChatTransactionQuery extends BaseWeChatTransaction {

    private String transactionId;
    private String outOrderNo;

    @XmlElementMapping(name = "transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    @XmlElementMapping(name = "out_trade_no")
    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }
}
