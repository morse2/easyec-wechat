package com.googlecode.easyec.wechat.pay.model;

import com.googlecode.easyec.wechat.pay.TransactionStatus;
import com.googlecode.easyec.wechat.pay.TransactionType;
import com.googlecode.easyec.wechat.pay.converter.TransactionAmountConverter;
import com.googlecode.easyec.wechat.pay.converter.TransactionStatusConverter;
import com.googlecode.easyec.wechat.pay.converter.TransactionTypeConverter;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;
import com.googlecode.easyec.wechat.xml.converter.impl.DatetimeElementConverter;

import java.util.Date;

/**
 * 微信支付查询交易接口的请求数据的结果对象类
 *
 * @author JunJie
 */
public class WeChatTransactionQueryResult extends BaseWeChatTransactionResult {

    // --- 以下字段在return_code 和result_code都为SUCCESS的时候有返回
    private String deviceInfo;
    private String openid;
    private String subscribed;
    private TransactionType type;
    private TransactionStatus status;
    private String bankType;
    private int totalAmount;
    private int settleTotalAmount;
    private String currencyType;
    private int cashAmount;
    private String cashCurrencyType;

    private String transactionId;
    private String outOrderNo;
    private String addOnData;
    private Date payTime;
    private String description;
    // TODO --- 代金券字段

    @XmlElementMapping(name = "device_info")
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    @XmlElementMapping(name = "openid")
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @XmlElementMapping(name = "is_subscribe")
    public void setSubscribed(String subscribed) {
        this.subscribed = subscribed;
    }

    @XmlElementMapping(name = "trade_type", converter = TransactionTypeConverter.class)
    public void setType(TransactionType type) {
        this.type = type;
    }

    @XmlElementMapping(name = "trade_state", converter = TransactionStatusConverter.class)
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @XmlElementMapping(name = "bank_type")
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    @XmlElementMapping(name = "total_fee", converter = TransactionAmountConverter.class)
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @XmlElementMapping(name = "settlement_total_fee", converter = TransactionAmountConverter.class)
    public void setSettleTotalAmount(int settleTotalAmount) {
        this.settleTotalAmount = settleTotalAmount;
    }

    @XmlElementMapping(name = "fee_type")
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    @XmlElementMapping(name = "cash_fee", converter = TransactionAmountConverter.class)
    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    @XmlElementMapping(name = "cash_fee_type")
    public void setCashCurrencyType(String cashCurrencyType) {
        this.cashCurrencyType = cashCurrencyType;
    }

    @XmlElementMapping(name = "transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @XmlElementMapping(name = "out_trade_no")
    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    @XmlElementMapping(name = "attach")
    public void setAddOnData(String addOnData) {
        this.addOnData = addOnData;
    }

    @XmlElementMapping(name = "time_end", converter = DatetimeElementConverter.class)
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @XmlElementMapping(name = "trade_state_desc")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public String getOpenid() {
        return openid;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public TransactionType getType() {
        return type;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public String getBankType() {
        return bankType;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getSettleTotalAmount() {
        return settleTotalAmount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    public String getCashCurrencyType() {
        return cashCurrencyType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public String getAddOnData() {
        return addOnData;
    }

    public Date getPayTime() {
        return payTime;
    }

    public String getDescription() {
        return description;
    }
}
