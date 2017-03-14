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
public class UpdateWeChatCashInfo extends AbstractUpdateWeChatCardInfo {

    private static final long serialVersionUID = 4049451132063092732L;
    @JsonProperty("least_cost")
    private int leastCost;                 //代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0
    @JsonProperty("reduce_cost")
    private int reduceCost;                 //代金券专用，表示减免金额。（单位为分

    protected UpdateWeChatCashInfo(AbstractUpdateCardBaseInfo baseInfo) {
        super(baseInfo);
    }

    public int getReduceCost() {
        return reduceCost;
    }

    public void setReduceCost(int reduceCost) {
        this.reduceCost = reduceCost;
    }

    public int getLeastCost() {
        return leastCost;
    }

    public void setLeastCost(int leastCost) {
        this.leastCost = leastCost;
    }
}
