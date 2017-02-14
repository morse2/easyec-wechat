package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 表示微信卡券中的代金券类型的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCash extends AbstractWeChatCard {

    private static final long serialVersionUID = 1095166589073511676L;
    @JsonProperty("least_cost")
    private int leastCost;       // 表示起用金额（单位为分）
    @JsonProperty("reduce_cost")
    private int reduceCost;      // 表示减免金额。（单位为分）

    public WeChatCash() {
        super("CASH");
    }

    public int getLeastCost() {
        return leastCost;
    }

    public void setLeastCost(int leastCost) {
        this.leastCost = leastCost;
    }

    public int getReduceCost() {
        return reduceCost;
    }

    public void setReduceCost(int reduceCost) {
        this.reduceCost = reduceCost;
    }
}
