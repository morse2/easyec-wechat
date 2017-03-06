package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;

/**
 * 卡券管理 更改Code
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class UpdateCode extends AbstractCredentialCtrl {

    private String cardId;                      //卡券ID

    private String code;                        //需要改变的code码

    private String newCode;                     //变更后有效的code码

    @JsonProperty(value = "card_id")
    public String getCardId() {
        return cardId;
    }

    @JsonProperty(value = "code", required = true)
    public String getCode() {
        return code;
    }

    @JsonProperty(value = "new_code", required = true)
    public String getNewCode() {
        return newCode;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }

}
