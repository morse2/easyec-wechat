package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 基本 返回结果类
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public abstract class  BaseResult extends AbstractCredentialCtrl {

    private String errcode;                         //错误码

    private String errmsg;                          //错误信息


    public String getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    @JsonProperty("errcode")
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    @JsonProperty("errmsg")
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
