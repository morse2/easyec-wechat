package com.googlecode.easyec.wechat.pay.model;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 微信支付接口的请求数据的基类
 *
 * @author JunJie
 */
public abstract class BaseWeChatTransaction {

    private String appid;         // 公众账号ID，必填
    private String merchantId;    // 商户号，必填
    private String nonceStr;      // 随机字符串，必填
    private String signature;     // 签名，必填

    @XmlElementMapping(name = "appid")
    public String getAppid() {
        return appid;
    }

    @XmlElementMapping(name = "mch_id")
    public String getMerchantId() {
        return merchantId;
    }

    @XmlElementMapping(name = "nonce_str")
    public String getNonceStr() {
        return nonceStr;
    }

    @XmlElementMapping(name = "sign")
    public String getSignature() {
        return signature;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
