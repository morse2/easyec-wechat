package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理卡券 获取用户已领取的卡券 返回结果对象
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class GetUserCardListResult extends BaseResult {

    private List<CardList> lists = new ArrayList<CardList>();       //卡券列表

    private boolean hasShareCard;                                   //是否有可用的朋友的券

    @JsonProperty("card_list")
    public void setLists(List<CardList> lists) {
        this.lists = lists;
    }

    @JsonProperty("has_share_card")
    public void setHasShareCard(boolean hasShareCard) {
        this.hasShareCard = hasShareCard;
    }

    public List<CardList> getLists() {
        return lists;
    }

    public boolean isHasShareCard() {
        return hasShareCard;
    }
}
