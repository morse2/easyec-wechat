package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 创建二维码 基本信息
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public  class ActionInfo implements Serializable {

    @JsonProperty(value = "card")
    private ActionInfoCard card;

    public ActionInfoCard getCard() {
        return card;
    }

    public void setCard(ActionInfoCard card) {
        this.card = card;
    }
}
