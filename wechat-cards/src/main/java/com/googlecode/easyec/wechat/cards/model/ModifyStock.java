package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 卡券管理 修改库存
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class ModifyStock extends AbstractCredentialCtrl {

    private String cardId;                      //卡券ID

    private int increaseStockValue;          //增加多少库存，支持不填或填0

    private int reduceStockValue;            //减少多少库存，可以不填或填0。

    @JsonProperty(value = "card_id",required = true)
    public String getCardId() {
        return cardId;
    }

    @JsonProperty("increase_stock_value")
    public int getIncreaseStockValue() {
        return increaseStockValue;
    }

    @JsonProperty("reduce_stock_value")
    public int getReduceStockValue() {
        return reduceStockValue;
    }

    public void setIncreaseStockValue(int increaseStockValue) {
        this.increaseStockValue = increaseStockValue;
    }

    public void setReduceStockValue(int reduceStockValue) {
        this.reduceStockValue = reduceStockValue;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
