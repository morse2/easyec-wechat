package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 创建微信会员返回信息
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateVipCardResult implements Serializable {

    private String errcode;


    private String errmsg;


    private String cardId;

    @JsonProperty("errcode")
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    @JsonProperty("errmsg")
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @JsonProperty("card_id")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public String getCardId() {
        return cardId;
    }
}
