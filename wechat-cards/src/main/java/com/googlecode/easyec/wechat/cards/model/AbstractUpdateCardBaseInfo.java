package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.cards.WeChatCardCodeType;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/3.
 */
public abstract class AbstractUpdateCardBaseInfo implements Serializable {


    private static final long serialVersionUID = -8329431362615290502L;


    @JsonProperty(value = "logo_url", required = true)
    private String logoUrl;                            // 卡券的商户logo
    private WeChatCardCodeType cardCodeType;           // 卡券代码类型
    @JsonProperty(required = true)
    private String color;                              // 券颜色
    @JsonProperty(required = true)
    private String notice;                             // 卡券使用提醒，字数上限为16个汉字
    @JsonProperty(required = true)
    private String description;                        // 卡券使用说明，字数上限为1024个汉字
    @JsonProperty(value = "date_info", required = true)
    private UpdateCardDateInfo cardDateInfo;                     // 使用日期

    // ----- 卡券非必填字段
    @JsonProperty("service_phone")
    private String servicePhone;                       // 客服电话
    @JsonProperty("location_id_list")
    private List<Integer> locationIds = new ArrayList<Integer>();     // 门店位置poiid
    @JsonProperty("custom_url_name")
    private String customUrlName;                      // 自定义跳转外链的入口名字
    @JsonProperty("center_title")
    private String centerTitle;                        // 卡券顶部居中的按钮
    @JsonProperty("center_sub_title")
    private String centerSubTitle;                     // 显示在入口下方的提示语
    @JsonProperty("center_url")
    private String centerUrl;                          // 顶部居中的url
    @JsonProperty("custom_url")
    private String customUrl;                          // 自定义跳转的URL
    @JsonProperty("custom_url_sub_title")
    private String customUrlSubTitle;                  // 显示在入口右侧的提示语
    @JsonProperty("promotion_url_name")
    private String promotionUrlName;                   // 营销场景的自定义入口名称
    @JsonProperty("promotion_url")
    private String promotionUrl;                       // 入口跳转外链的地址链接
    @JsonProperty("promotion_url_sub_title")
    private String promotionUrlSubName;                // 显示在营销入口右侧的提示语
    @JsonProperty("get_limit")
    private int getLimit = 50;                         // 每人可领券的数量限制,不填写默认为50
    @JsonProperty("can_share")
    private Boolean canShare;                          // 卡券领取页面是否可分享
    @JsonProperty("can_give_friend")
    private Boolean canGiveFriend;                     // 卡券是否可转赠

    @JsonProperty("code_type")
    public String getCodeType() {
        return cardCodeType != null ? cardCodeType.getValue() : null;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public WeChatCardCodeType getCardCodeType() {
        return cardCodeType;
    }


    public String getColor() {
        return color;
    }

    public String getNotice() {
        return notice;
    }

    public String getDescription() {
        return description;
    }

    public UpdateCardDateInfo getCardDateInfo() {
        return cardDateInfo;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public List<Integer> getLocationIds() {
        return locationIds;
    }

    public String getCustomUrlName() {
        return customUrlName;
    }

    public String getCenterTitle() {
        return centerTitle;
    }

    public String getCenterSubTitle() {
        return centerSubTitle;
    }

    public String getCenterUrl() {
        return centerUrl;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public String getCustomUrlSubTitle() {
        return customUrlSubTitle;
    }

    public String getPromotionUrlName() {
        return promotionUrlName;
    }

    public String getPromotionUrl() {
        return promotionUrl;
    }

    public String getPromotionUrlSubName() {
        return promotionUrlSubName;
    }

    public int getGetLimit() {
        return getLimit;
    }

    public Boolean getCanShare() {
        return canShare;
    }

    public Boolean getCanGiveFriend() {
        return canGiveFriend;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setCardCodeType(WeChatCardCodeType cardCodeType) {
        this.cardCodeType = cardCodeType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCardDateInfo(UpdateCardDateInfo cardDateInfo) {
        this.cardDateInfo = cardDateInfo;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public void setLocationIds(List<Integer> locationIds) {
        if (CollectionUtils.isNotEmpty(locationIds)) {
            this.locationIds.addAll(locationIds);
        }
    }

    public void addLocationId(Integer id) {
        if (id != null) this.locationIds.add(id);
    }

    public void setCustomUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
    }

    public void setCenterTitle(String centerTitle) {
        this.centerTitle = centerTitle;
    }

    public void setCenterSubTitle(String centerSubTitle) {
        this.centerSubTitle = centerSubTitle;
    }

    public void setCenterUrl(String centerUrl) {
        this.centerUrl = centerUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public void setCustomUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
    }

    public void setPromotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
    }

    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }

    public void setPromotionUrlSubName(String promotionUrlSubName) {
        this.promotionUrlSubName = promotionUrlSubName;
    }

    public void setGetLimit(int getLimit) {
        this.getLimit = getLimit;
    }

    public void setCanShare(Boolean canShare) {
        this.canShare = canShare;
    }

    public void setCanGiveFriend(Boolean canGiveFriend) {
        this.canGiveFriend = canGiveFriend;
    }
}
