package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 核销 查询code 返回信息中 card类
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryCodeResultCard implements Serializable {

    private String beginTime;   //起始使用时间

    private String endTime;     //结束时间

    private String cardId;      //卡券ID


    @JsonProperty("begin_time")
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    @JsonProperty("end_time")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonProperty("card_id")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getCardId() {
        return cardId;
    }
}
