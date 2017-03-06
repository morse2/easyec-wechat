package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 微信卡券的高级信息的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatCardAdvancedInfo implements Serializable {

    /* 外卖服务 */
    public static final String BIZ_SERVICE_DELIVER = "BIZ_SERVICE_DELIVER";
    /* 停车位 */
    public static final String BIZ_SERVICE_FREE_PARK = "BIZ_SERVICE_FREE_PARK";
    /* 可带宠物 */
    public static final String BIZ_SERVICE_WITH_PET = "BIZ_SERVICE_WITH_PET";
    /* 免费wifi */
    public static final String BIZ_SERVICE_FREE_WIFI = "BIZ_SERVICE_FREE_WIFI";
    private static final long serialVersionUID = 8639979802813833568L;

    @JsonProperty("use_condition")
    private UseCondition useCondition;     // 使用门槛（条件）
    @JsonProperty("abstract")
    private CoverAbstract coverAbstract;   // 封面摘要结构体名称
    @JsonProperty("text_image_list")
    private List<ImageText> imageTextList = new ArrayList<ImageText>();        // 图文列表，显示在详情内页
    @JsonProperty("business_service")
    private List<String> businessServices = new ArrayList<String>();   // 商家服务类型
    @JsonProperty("time_limit")
    private List<TimeLimit> timeLimits = new ArrayList<TimeLimit>();   // 使用时段限制

    public UseCondition getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(UseCondition useCondition) {
        this.useCondition = useCondition;
    }

    public CoverAbstract getCoverAbstract() {
        return coverAbstract;
    }

    public void setCoverAbstract(CoverAbstract coverAbstract) {
        this.coverAbstract = coverAbstract;
    }

    public List<ImageText> getImageTextList() {
        return imageTextList;
    }

    public void setImageTextList(List<ImageText> imageTextList) {
        this.imageTextList = imageTextList;
    }

    public List<String> getBusinessServices() {
        return businessServices;
    }

    public void setBusinessServices(List<String> businessServices) {
        this.businessServices = businessServices;
    }

    public List<TimeLimit> getTimeLimits() {
        return timeLimits;
    }

    public void setTimeLimits(List<TimeLimit> timeLimits) {
        this.timeLimits = timeLimits;
    }
}
