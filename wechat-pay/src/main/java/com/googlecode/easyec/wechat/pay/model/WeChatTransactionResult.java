package com.googlecode.easyec.wechat.pay.model;

import com.googlecode.easyec.wechat.pay.TransactionType;
import com.googlecode.easyec.wechat.pay.converter.TransactionTypeConverter;
import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 微信支付交易的结果对象类
 *
 * @author JunJie
 */
public class WeChatTransactionResult extends BaseWeChatTransactionResult {

    // --- 以下字段在return_code为SUCCESS的时候有返回
    private String deviceInfo;

    // --- 以下字段在return_code 和result_code都为SUCCESS的时候有返回
    private TransactionType type;
    private String prepayId;
    private String codeUrl;

    @XmlElementMapping(name = "device_info")
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    @XmlElementMapping(name = "trade_type", converter = TransactionTypeConverter.class)
    public void setType(TransactionType type) {
        this.type = type;
    }

    @XmlElementMapping(name = "prepay_id")
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    @XmlElementMapping(name = "code_url")
    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public TransactionType getType() {
        return type;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }
}
