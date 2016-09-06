package com.googlecode.easyec.wechat.pay.model;

import com.googlecode.easyec.wechat.xml.annotation.XmlElementMapping;

/**
 * 微信支付的请求数据结果的对象类
 *
 * @author JunJie
 */
public abstract class BaseWeChatTransactionResult {

    private static final String SUCCESS_FLAG = "SUCCESS";

    private String returnCode;
    private String returnMsg;

    // --- 以下字段在return_code为SUCCESS的时候有返回
    private String appid;
    private String merchantId;
    private String nonceStr;
    private String signature;
    private String resultCode;
    private String errorCode;
    private String errorMsg;

    @XmlElementMapping(name = "return_code")
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    @XmlElementMapping(name = "return_msg")
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    @XmlElementMapping(name = "appid")
    public void setAppid(String appid) {
        this.appid = appid;
    }

    @XmlElementMapping(name = "mch_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @XmlElementMapping(name = "nonce_str")
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    @XmlElementMapping(name = "sign")
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @XmlElementMapping(name = "result_code")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @XmlElementMapping(name = "err_code")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @XmlElementMapping(name = "err_code_des")
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public String getAppid() {
        return appid;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public boolean isSuccess() {
        return SUCCESS_FLAG.equalsIgnoreCase(resultCode)
            && SUCCESS_FLAG.equalsIgnoreCase(returnCode);
    }
}
