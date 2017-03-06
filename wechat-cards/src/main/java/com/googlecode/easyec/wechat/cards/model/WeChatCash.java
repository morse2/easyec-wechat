package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券中的代金券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCash extends AbstractWeChatCard<WeChatCardInfo> {

    private static final long serialVersionUID = -2725900555722066952L;
    @JsonProperty("least_cost")
    private int leastCost;       // 表示起用金额（单位为分）
    @JsonProperty("reduce_cost")
    private int reduceCost;      // 表示减免金额。（单位为分）

    public WeChatCash() {
        super(new WeChatCardInfo());
        setCardType("CASH");
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

    @Override
    @JsonProperty("cash")
    public WeChatCardInfo getCardInfo() {
        return this.cardInfo;
    }
}
