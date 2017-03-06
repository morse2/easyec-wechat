package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 拉取卡券概况数据 返回数据
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class GetCardProfileInfoResult implements Serializable {

    private static final long serialVersionUID = -1282247919523659205L;

    private List<CardProfileInfo> cardProfileInfos = new ArrayList<CardProfileInfo>();

    @JsonProperty("list")
    public void setCardProfileInfos(List<CardProfileInfo> cardProfileInfos) {
        this.cardProfileInfos = cardProfileInfos;
    }

    public List<CardProfileInfo> getCardProfileInfos() {
        return cardProfileInfos;
    }
}
