package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 核销卡券接口 返回结果
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsumeCardResult extends BaseResult {


    private String openId;                          //用户在该公众号内的唯一身份标识

    private ConsumeCardResultCard card;

    public String getOpenId() {
        return openId;
    }

    public ConsumeCardResultCard getCard() {
        return card;
    }

    @JsonProperty("openid")
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @JsonProperty("card")
    public void setCard(ConsumeCardResultCard card) {
        this.card = card;
    }
}
