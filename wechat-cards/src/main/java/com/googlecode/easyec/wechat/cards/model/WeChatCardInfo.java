package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 卡券管理中的卡券的基本信息和高级信息的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCardInfo extends AbstractWeChatCardInfo<WeChatCardBaseInfoImpl> {

    private static final long serialVersionUID = -5838494928307579946L;
    @JsonProperty("deal_detail")                        //团购券专用 团购详情 团购券时填写
    private String grouponDetail;

    @JsonProperty("gift")
    private String gift;                                //填写兑换内容的名称 兑换券时填写

    @JsonProperty("default_detail")
    private String couponDetail;                        //创建优惠券券时  填写优惠详情

    @JsonProperty("least_cost")
    private int leastCost;                              //创建代金券时使用 表示起用金额（单位为分）

    @JsonProperty("reduce_cost")
    private int reduceCost;                             //创建代金券时使用 表示减免金额。（单位为分）

    @JsonProperty("discount")
    private int discount;                               //创建折扣券时使用 表示打折额度（百分比）。填30就是七折


    public WeChatCardInfo() {
        super(new WeChatCardBaseInfoImpl(), new WeChatCardAdvancedInfo());
    }

    public String getGrouponDetail() {
        return grouponDetail;
    }

    public void setGrouponDetail(String grouponDetail) {
        this.grouponDetail = grouponDetail;
    }

    public String getCouponDetail() {
        return couponDetail;
    }

    public void setCouponDetail(String couponDetail) {
        this.couponDetail = couponDetail;
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

    public String getGift() {
        return gift;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }
}
