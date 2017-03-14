package com.googlecode.easyec.wechat.card.model.event;

import com.googlecode.easyec.wechat.msg.model.event.WeChatEventMessage;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.xml.converter.impl.DatetimeElementConverter;

import java.util.Date;

/**
 * 券点流水详情事件
 * 当商户朋友的券券点发生变动时，微信服务器会推送消息给商户服务器。
 */
public class UserPayOrderMessage extends WeChatEventMessage {

    public static final String EVENT_USERPAYORDER = "card_pay_order";

    private String orderId;

    private String status;

    private Date payFinishTime;

    private String desc;

    private Integer freeCoinCount;

    private Integer payCoinCount;

    private Integer refundFreeCoinCount;

    private Integer refundPayCoinCount;

    private String orderType;

    private String memo;

    private String receiptInfo;


    public boolean isUserPayOrder() {
        return EVENT_USERPAYORDER.equalsIgnoreCase(getEvent());
    }


    @XmlElementMapping(name = "OrderId")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @XmlElementMapping(name = "Status")
    public void setStatus(String status) {
        this.status = status;
    }


    @XmlElementMapping(name = "PayFinishTime", converter = DatetimeElementConverter.class)
    public void setPayFinishTime(Date payFinishTime) {
        this.payFinishTime = payFinishTime;
    }

    @XmlElementMapping(name = "Desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @XmlElementMapping(name = "FreeCoinCount")
    public void setFreeCoinCount(Integer freeCoinCount) {
        this.freeCoinCount = freeCoinCount;
    }

    @XmlElementMapping(name = "PayCoinCount")
    public void setPayCoinCount(Integer payCoinCount) {
        this.payCoinCount = payCoinCount;
    }

    @XmlElementMapping(name = "RefundFreeCoinCount")
    public void setRefundFreeCoinCount(Integer refundFreeCoinCount) {
        this.refundFreeCoinCount = refundFreeCoinCount;
    }

    @XmlElementMapping(name = "RefundPayCoinCount")
    public void setRefundPayCoinCount(Integer refundPayCoinCount) {
        this.refundPayCoinCount = refundPayCoinCount;
    }

    @XmlElementMapping(name = "OrderType")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @XmlElementMapping(name = "Memo")
    public void setMemo(String memo) {
        this.memo = memo;
    }

    @XmlElementMapping(name = "ReceiptInfo")
    public void setReceiptInfo(String receiptInfo) {
        this.receiptInfo = receiptInfo;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public Date getPayFinishTime() {
        return payFinishTime;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getFreeCoinCount() {
        return freeCoinCount;
    }

    public Integer getPayCoinCount() {
        return payCoinCount;
    }

    public Integer getRefundFreeCoinCount() {
        return refundFreeCoinCount;
    }

    public Integer getRefundPayCoinCount() {
        return refundPayCoinCount;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getMemo() {
        return memo;
    }

    public String getReceiptInfo() {
        return receiptInfo;
    }
}
