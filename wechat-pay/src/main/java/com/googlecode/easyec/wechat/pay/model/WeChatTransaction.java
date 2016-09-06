package com.googlecode.easyec.wechat.pay.model;

import com.googlecode.easyec.wechat.pay.converter.TransactionAmountConverter;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 微信支付的订单对象类
 *
 * @author JunJie
 */
public class WeChatTransaction extends BaseWeChatTransaction {

    private String deviceInfo;    // 设备号
    private String goodsInfo;     // 商品描述，必填
    private String goodsDetail;   // 商品详情
    private String addOnData;     // 附加数据
    private String outOrderNo;    // 商户订单号，必填
    private String currencyType;  // 货币类型
    private int totalAmount;      // 总金额，必填
    private String terminalIp;    // 终端IP，必填
    private String startTime;     // 交易起始时间
    private String expireTime;    // 交易结束时间
    private String goodsTag;      // 商品标记
    private String callbackUrl;   // 通知回调URL，必填
    private String type;          // 交易类型，必填
    private String goodsId;       // 商品ID，交易类型为NATIVE，此参数必传
    private String limitPay;      // 指定支付方式，no_credit -- 不能使用信用卡支付
    private String openid;        // 用户标识，交易类型为JSAPI，此参数必传

    @XmlElementMapping(name = "device_info")
    public String getDeviceInfo() {
        return deviceInfo;
    }

    @XmlElementMapping(name = "body")
    public String getGoodsInfo() {
        return goodsInfo;
    }

    @XmlElementMapping(name = "detail")
    public String getGoodsDetail() {
        return goodsDetail;
    }

    @XmlElementMapping(name = "attach")
    public String getAddOnData() {
        return addOnData;
    }

    @XmlElementMapping(name = "out_trade_no")
    public String getOutOrderNo() {
        return outOrderNo;
    }

    @XmlElementMapping(name = "fee_type")
    public String getCurrencyType() {
        return currencyType;
    }

    @XmlElementMapping(name = "total_fee", converter = TransactionAmountConverter.class)
    public int getTotalAmount() {
        return totalAmount;
    }

    @XmlElementMapping(name = "spbill_create_ip")
    public String getTerminalIp() {
        return terminalIp;
    }

    @XmlElementMapping(name = "time_start")
    public String getStartTime() {
        return startTime;
    }

    @XmlElementMapping(name = "time_expire")
    public String getExpireTime() {
        return expireTime;
    }

    @XmlElementMapping(name = "goods_tag")
    public String getGoodsTag() {
        return goodsTag;
    }

    @XmlElementMapping(name = "notify_url")
    public String getCallbackUrl() {
        return callbackUrl;
    }

    @XmlElementMapping(name = "trade_type")
    public String getType() {
        return type;
    }

    @XmlElementMapping(name = "product_id")
    public String getGoodsId() {
        return goodsId;
    }

    @XmlElementMapping(name = "limit_pay")
    public String getLimitPay() {
        return limitPay;
    }

    @XmlElementMapping(name = "openid")
    public String getOpenid() {
        return openid;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public void setAddOnData(String addOnData) {
        this.addOnData = addOnData;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTerminalIp(String terminalIp) {
        this.terminalIp = terminalIp;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
