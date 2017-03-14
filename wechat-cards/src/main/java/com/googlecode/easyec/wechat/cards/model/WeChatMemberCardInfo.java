package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 微信卡券管理中会员卡的基本信息和高级信息的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatMemberCardInfo extends AbstractWeChatCardInfo<WeChatMemberCardBaseInfo> {

    private static final long serialVersionUID = 628555773313565456L;

    @JsonProperty(value = "discount")
    private int discount;                                   //折扣，该会员卡享受的折扣优惠,填10就是九折

    @JsonProperty(value = "prerogative", required = true)
    private String prerogative;                             //会员卡说明

    @JsonProperty(value = "background_pic_url", required = true)
    private String backgroundPicUrl;                        //商家自定义会员卡背景图

    @JsonProperty(value = "auto_activate")
    private boolean autoActive;                             //设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口

    @JsonProperty(value = "wx_activate")
    private boolean wxActive;                               //设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，否则设置wx_activate失效。

    @JsonProperty(value = "supply_bonus", required = true)
    private boolean supplyBonus;                            //显示积分，填写true或false，如填写true，积分相关字段均为必填

    @JsonProperty(value = "bonus_url")
    private String bonusUrl;                                //设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段

    @JsonProperty(value = "supply_balance", required = true)
    private boolean supplyBalance;                          //是否支持储值，填写true或false。如填写true，储值相关字段均为必填

    @JsonProperty(value = "balance_url")
    private String balanceUrl;                              //设置跳转外链查看余额详情。仅适用于余额无法通过激活接口同步的情况下使用该字段

    @JsonProperty(value = "custom_field1")
    private CustomField customField1;

    @JsonProperty(value = "custom_field2")
    private CustomField customField2;

    @JsonProperty(value = "custom_field3")
    private CustomField customField3;

    @JsonProperty(value = "bonus_cleared")
    private String bonusCleared;                             //积分清零规则

    @JsonProperty(value = "bonus_rules")
    private String bonusRules;                               //积分规则

    @JsonProperty(value = "balance_rules")
    private String balanceRules;                             //储值说明

    @JsonProperty(value = "activate_url", required = true)
    private String activateUrl;                              //激活会员卡的url

    @JsonProperty(value = "custom_cell1")
    private CustomCell customCell;                           //自定义会员信息类目，会员卡激活后显示

    @JsonProperty(value = "bonus_rule")
    private BonusRule bonusRule;                             //积分规则

    public WeChatMemberCardInfo() {
        super(new WeChatMemberCardBaseInfo(), new WeChatCardAdvancedInfo());
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getPrerogative() {
        return prerogative;
    }

    public void setPrerogative(String prerogative) {
        this.prerogative = prerogative;
    }

    public String getBackgroundPicUrl() {
        return backgroundPicUrl;
    }

    public void setBackgroundPicUrl(String backgroundPicUrl) {
        this.backgroundPicUrl = backgroundPicUrl;
    }

    public boolean isAutoActive() {
        return autoActive;
    }

    public void setAutoActive(boolean autoActive) {
        this.autoActive = autoActive;
    }

    public boolean isWxActive() {
        return wxActive;
    }

    public void setWxActive(boolean wxActive) {
        this.wxActive = wxActive;
    }

    public boolean isSupplyBonus() {
        return supplyBonus;
    }

    public void setSupplyBonus(boolean supplyBonus) {
        this.supplyBonus = supplyBonus;
    }

    public String getBonusUrl() {
        return bonusUrl;
    }

    public void setBonusUrl(String bonusUrl) {
        this.bonusUrl = bonusUrl;
    }

    public boolean isSupplyBalance() {
        return supplyBalance;
    }

    public void setSupplyBalance(boolean supplyBalance) {
        this.supplyBalance = supplyBalance;
    }

    public String getBalanceUrl() {
        return balanceUrl;
    }

    public void setBalanceUrl(String balanceUrl) {
        this.balanceUrl = balanceUrl;
    }

    public CustomField getCustomField1() {
        return customField1;
    }

    public void setCustomField1(CustomField customField1) {
        this.customField1 = customField1;
    }

    public CustomField getCustomField2() {
        return customField2;
    }

    public void setCustomField2(CustomField customField2) {
        this.customField2 = customField2;
    }

    public CustomField getCustomField3() {
        return customField3;
    }

    public void setCustomField3(CustomField customField3) {
        this.customField3 = customField3;
    }

    public String getBonusCleared() {
        return bonusCleared;
    }

    public void setBonusCleared(String bonusCleared) {
        this.bonusCleared = bonusCleared;
    }

    public String getBonusRules() {
        return bonusRules;
    }

    public void setBonusRules(String bonusRules) {
        this.bonusRules = bonusRules;
    }

    public String getBalanceRules() {
        return balanceRules;
    }

    public void setBalanceRules(String balanceRules) {
        this.balanceRules = balanceRules;
    }

    public String getActivateUrl() {
        return activateUrl;
    }

    public void setActivateUrl(String activateUrl) {
        this.activateUrl = activateUrl;
    }

    public CustomCell getCustomCell() {
        return customCell;
    }

    public void setCustomCell(CustomCell customCell) {
        this.customCell = customCell;
    }

    public BonusRule getBonusRule() {
        return bonusRule;
    }

    public void setBonusRule(BonusRule bonusRule) {
        this.bonusRule = bonusRule;
    }
}
