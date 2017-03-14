package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 积分规则
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public  class BonusRule implements Serializable {

    private static final long serialVersionUID = 6186687394542476430L;

    @JsonProperty(value = "cost_money_unit")
    private int costMoneyUnit;                                  //消费金额。以分为单位

    @JsonProperty(value = "increase_bonus")
    private int increaseBonus;                                  //对应增加的积分

    @JsonProperty(value = "max_increase_bonus")
    private int maxIncreaseBonus;                               //用户单次可获取的积分上限

    @JsonProperty(value = "init_increase_bonus")
    private int initIncreaseBonus;                              //初始设置积分

    @JsonProperty(value = "cost_bonus_unit")
    private int costBonusUnit;                                  //每使用5积分

    @JsonProperty(value = "reduce_money")
    private int reduceMoney;                                    //抵扣xx元，（这里以分为单位）

    @JsonProperty(value = "least_money_to_use_bonus")
    private int leastMoneyToUseBonus;                           //抵扣条件，满xx元（这里以分为单位）可用

    @JsonProperty(value = "max_reduce_bonus")
    private int maxReduceBonus;                                 //抵扣条件，单笔最多使用xx积分

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCostMoneyUnit() {
        return costMoneyUnit;
    }

    public void setCostMoneyUnit(int costMoneyUnit) {
        this.costMoneyUnit = costMoneyUnit;
    }

    public int getIncreaseBonus() {
        return increaseBonus;
    }

    public void setIncreaseBonus(int increaseBonus) {
        this.increaseBonus = increaseBonus;
    }

    public int getMaxIncreaseBonus() {
        return maxIncreaseBonus;
    }

    public void setMaxIncreaseBonus(int maxIncreaseBonus) {
        this.maxIncreaseBonus = maxIncreaseBonus;
    }

    public int getInitIncreaseBonus() {
        return initIncreaseBonus;
    }

    public void setInitIncreaseBonus(int initIncreaseBonus) {
        this.initIncreaseBonus = initIncreaseBonus;
    }

    public int getCostBonusUnit() {
        return costBonusUnit;
    }

    public void setCostBonusUnit(int costBonusUnit) {
        this.costBonusUnit = costBonusUnit;
    }

    public int getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(int reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    public int getLeastMoneyToUseBonus() {
        return leastMoneyToUseBonus;
    }

    public void setLeastMoneyToUseBonus(int leastMoneyToUseBonus) {
        this.leastMoneyToUseBonus = leastMoneyToUseBonus;
    }

    public int getMaxReduceBonus() {
        return maxReduceBonus;
    }

    public void setMaxReduceBonus(int maxReduceBonus) {
        this.maxReduceBonus = maxReduceBonus;
    }
}
