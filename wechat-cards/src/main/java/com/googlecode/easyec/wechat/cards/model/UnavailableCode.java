package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 卡券管理 设置卡券失效
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class UnavailableCode extends AbstractCredentialCtrl {

    private String code;                //设置卡券失效的code码

    private String cardId;              //卡券ID

    @JsonProperty(value = "code",required = true)
    public String getCode() {
        return code;
    }

    @JsonProperty(value = "card_id",required = true)
    public String getCardId() {
        return cardId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
