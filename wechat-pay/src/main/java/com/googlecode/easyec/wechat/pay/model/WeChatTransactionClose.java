package com.googlecode.easyec.wechat.pay.model;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 微信支付中关闭交易的数据对象类
 *
 * @author JunJie
 */
public class WeChatTransactionClose extends BaseWeChatTransaction {

    private String outOrderNo;

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    @XmlElementMapping(name = "out_trade_no")
    public String getOutOrderNo() {
        return outOrderNo;
    }
}
