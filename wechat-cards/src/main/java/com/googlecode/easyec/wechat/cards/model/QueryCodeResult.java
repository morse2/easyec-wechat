package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.cards.QueryCardStatus;

import java.io.Serializable;

/**
 * 核销 查询code 返回信息
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryCodeResult extends BaseResult implements Serializable {
    private String openId;                          //用户OPENID

    private QueryCodeResultCard codeResultCard;

    private boolean canConsume;                     //是否可以核销，true为可以核销，false为不可核销

    private QueryCardStatus userCardStatus;

    @JsonProperty("openid")
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @JsonProperty("card")
    public void setCodeResultCard(QueryCodeResultCard codeResultCard) {
        this.codeResultCard = codeResultCard;
    }

    @JsonProperty("can_consume")
    public void setCanConsume(boolean canConsume) {
        this.canConsume = canConsume;
    }

    @JsonProperty("user_card_status")
    public void setUserCardStatus(QueryCardStatus userCardStatus) {
        this.userCardStatus = userCardStatus;
    }

    public String getOpenId() {
        return openId;
    }

    public QueryCodeResultCard getCodeResultCard() {
        return codeResultCard;
    }

    public boolean isCanConsume() {
        return canConsume;
    }

    public QueryCardStatus getUserCardStatus() {
        return userCardStatus;
    }
}
