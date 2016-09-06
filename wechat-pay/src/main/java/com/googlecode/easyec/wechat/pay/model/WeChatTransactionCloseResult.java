package com.googlecode.easyec.wechat.pay.model;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 微信支付中关闭交易的回传数据的对象类
 *
 * @author JunJie
 */
public class WeChatTransactionCloseResult extends BaseWeChatTransactionResult {

    private String resultMsg;

    @XmlElementMapping(name = "result_msg")
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}
