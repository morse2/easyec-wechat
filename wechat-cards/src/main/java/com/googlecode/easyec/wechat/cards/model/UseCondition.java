package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 卡券高级信息的使用门槛（条件）的定义类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UseCondition implements Serializable {

    private static final long serialVersionUID = 7038358474461310944L;
    @JsonProperty("accept_category")
    private String acceptCategory;                        // 指定可用的商品类目，仅用于代金券类型
    @JsonProperty("reject_category")
    private String rejectCategory;                        // 指定不可用的商品类目，仅用于代金券类型
    @JsonProperty("least_cost")
    private Integer leastCost;                            // 满减门槛字段，可用于兑换券和代金券
    @JsonProperty("object_use_for")
    private String objectUseFor;                          // 购买xx可用类型门槛，仅用于兑换
    @JsonProperty("can_use_with_other_discount")
    private boolean canUseWithOtherDiscount = true;       // 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”

    public String getAcceptCategory() {
        return acceptCategory;
    }

    public void setAcceptCategory(String acceptCategory) {
        this.acceptCategory = acceptCategory;
    }

    public String getRejectCategory() {
        return rejectCategory;
    }

    public void setRejectCategory(String rejectCategory) {
        this.rejectCategory = rejectCategory;
    }

    public Integer getLeastCost() {
        return leastCost;
    }

    public void setLeastCost(Integer leastCost) {
        this.leastCost = leastCost;
    }

    public String getObjectUseFor() {
        return objectUseFor;
    }

    public void setObjectUseFor(String objectUseFor) {
        this.objectUseFor = objectUseFor;
    }

    public boolean isCanUseWithOtherDiscount() {
        return canUseWithOtherDiscount;
    }

    public void setCanUseWithOtherDiscount(boolean canUseWithOtherDiscount) {
        this.canUseWithOtherDiscount = canUseWithOtherDiscount;
    }
}
